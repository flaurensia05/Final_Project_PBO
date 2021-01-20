/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peminjamanperpustakaan.oop;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FormController implements Initializable {
    
    @FXML
    private TextField tfidakun;

    @FXML
    private TextField tfemail;

    @FXML
    private TextField tfpassword;

    @FXML
    private TextField tfnamabuku;

    @FXML
    private TextField tfidbuku;

    @FXML
    private DatePicker dptanggalpinjam;

    @FXML
    private Button btnpinjambuku;

    @FXML
    private Button btnreload;

    @FXML
    private Button btnclear;

    @FXML
    private TextField tfuniv;

    @FXML
    private TableColumn<AkunMahasiswa, Integer> colidakun;

    @FXML
    private TableColumn<AkunMahasiswa, String> coluniv;

    @FXML
    private TableColumn<AkunMahasiswa, String> colemail;

    @FXML
    private TableView<AkunMahasiswa> tblpeminjam;

    @FXML
    private TableColumn<DataPinjam, Integer> colidbuku;

    @FXML
    private TableColumn<DataPinjam, String> colnamabuku;

    @FXML
    private TableColumn<DataPinjam, String> coltanggalpinjam;
    
    @FXML
    private TableView<DataPinjam> tbldatapinjam;
    
    @FXML
    private TextField tfnidbuku;

    @FXML
    private TextField tfnnamabuku;

    @FXML
    private DatePicker dpntanggalpinjam;

    @FXML
    private Button btntambah;
    
    @FXML
    private TextField tfnidakun;
    
    @FXML
    private TextField tfidakun1;

    @FXML
    private TextField tfemail1;

    @FXML
    private TextField tfpassword1;

    @FXML
    private TextField tfnamabuku1;

    @FXML
    private TextField tfidbuku1;

    @FXML
    private DatePicker dptanggalpinjam1;

    @FXML
    private Button btnpinjambuku1;

    @FXML
    private Button btnreload1;

    @FXML
    private Button btnclear1;

    @FXML
    private TextField tfuniv1;

    @FXML
    private TableView<AkunPelajar> tblpeminjam1;

    @FXML
    private TableColumn<AkunPelajar, Integer> colidakun1;

    @FXML
    private TableColumn<AkunPelajar, String> coluniv1;

    @FXML
    private TableColumn<AkunPelajar, String> colemail1;

    @FXML
    private TableView<DataPinjam> tbldatapinjam1;

    @FXML
    private TableColumn<DataPinjam, Integer> colidbuku1;

    @FXML
    private TableColumn<DataPinjam, String> colnamabuku1;

    @FXML
    private TableColumn<DataPinjam, String> coltanggalpinjam1;

    @FXML
    private TextField tfnidbuku1;

    @FXML
    private TextField tfnnamabuku1;

    @FXML
    private DatePicker dpntanggalpinjam1;

    @FXML
    private Button btntambah1;

    @FXML
    private TextField tfnidakun1;
    
    private PerpusDataModeller ppdm;
    
    public void viewDataPinjam(int IDakun){
        ObservableList<DataPinjam> data = ppdm.getDataPinjam(IDakun);
        colidbuku.setCellValueFactory(new PropertyValueFactory<>("IDBuku"));
        colnamabuku.setCellValueFactory(new PropertyValueFactory<>("NamaBuku"));
        coltanggalpinjam.setCellValueFactory((new PropertyValueFactory<>("TanggalPinjam")));
        tbldatapinjam.setItems(null);
        tbldatapinjam.setItems(data);
    }
    
    public void viewDataPinjam1(int IDakun){
        ObservableList<DataPinjam> data = ppdm.getDataPinjam(IDakun);
        colidbuku1.setCellValueFactory(new PropertyValueFactory<>("IDBuku"));
        colnamabuku1.setCellValueFactory(new PropertyValueFactory<>("NamaBuku"));
        coltanggalpinjam1.setCellValueFactory((new PropertyValueFactory<>("TanggalPinjam")));
        tbldatapinjam1.setItems(null);
        tbldatapinjam1.setItems(data);
    }

    @FXML
    void handleButtonClear(ActionEvent event) {
        try {
            tfidakun.setText(""+ppdm.nextIDAkun());
            tfidbuku.setText("");
            tfemail.setText("");
            tfpassword.setText("");
            tfuniv.setText("");
            tfnamabuku.setText("");
            tfnnamabuku.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(FormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonPinjamBuku(ActionEvent event) {
        LocalDate ld = dptanggalpinjam.getValue();
        String tglpinjam = String.format("%d-%02d-%02d", ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());
        AkunMahasiswa akun = new AkunMahasiswa(Integer.parseInt(tfidakun.getText()),
        tfemail.getText(), tfpassword.getText(), tfuniv.getText(), new DataPinjam(
        Integer.parseInt(tfidbuku.getText()), tfnamabuku.getText(), tglpinjam));
        try {
            ppdm.Tambah_Peminjaman(akun);
            btnreload.fire();
            btnclear.fire();
        } catch (SQLException ex) {
            Logger.getLogger(FormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    void handleButtonReload(ActionEvent event) {
        ObservableList<AkunMahasiswa> akun = ppdm.getAkunMahasiswa();
        colidakun.setCellValueFactory(new PropertyValueFactory<>("IDakun"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        coluniv.setCellValueFactory(new PropertyValueFactory<>("universitas"));
        //colidbuku.setCellValueFactory(new PropertyValueFactory<>("IDBuku"));
        tblpeminjam.setItems(null);
        tblpeminjam.setItems(akun);
        btntambah.setDisable(true);
    }

    @FXML
    void handleButtonTambahBuku(ActionEvent event) {
        LocalDate ld = dpntanggalpinjam.getValue();
        String ntanggalpinjam = String.format("%d-%02d-%02d", ld.getYear(),
                ld.getMonthValue(), ld.getDayOfMonth());
        DataPinjam dtpinjam = new DataPinjam(Integer.parseInt(tfnidbuku.getText()),tfnnamabuku.getText(),
        ntanggalpinjam);
        try {
            ppdm.tambahDataPinjam(Integer.parseInt(tfnidakun.getText()), dtpinjam);
            viewDataPinjam(Integer.parseInt(tfnidakun.getText()));
            btnreload.fire();
            btnclear.fire();
        } catch (SQLException ex) {
            Logger.getLogger(FormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void handleButtonClear1(ActionEvent event) {
        try {
            tfidakun1.setText(""+ppdm.nextIDAkun());
            tfidbuku1.setText("");
            tfemail1.setText("");
            tfpassword1.setText("");
            tfuniv1.setText("");
            tfnamabuku1.setText("");
            tfnnamabuku1.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(FormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleButtonPinjamBuku1(ActionEvent event) {
        LocalDate ld = dptanggalpinjam1.getValue();
        String tglpinjam = String.format("%d-%02d-%02d", ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());
        AkunPelajar akn = new AkunPelajar(Integer.parseInt(tfidakun1.getText()),
        tfemail1.getText(), tfpassword1.getText(), tfuniv1.getText(), new DataPinjam(
        Integer.parseInt(tfidbuku1.getText()), tfnamabuku1.getText(), tglpinjam));
        try {
            ppdm.Tambah_Peminjaman(akn);
            btnreload1.fire();
            btnclear1.fire();
        } catch (SQLException ex) {
            Logger.getLogger(FormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    void handleButtonReload1(ActionEvent event) {
        ObservableList<AkunPelajar> akn = ppdm.getAkunPelajar();
        colidakun1.setCellValueFactory(new PropertyValueFactory<>("IDakun"));
        colemail1.setCellValueFactory(new PropertyValueFactory<>("email"));
        coluniv1.setCellValueFactory(new PropertyValueFactory<>("NamaSekolah"));
//        colidbuku.setCellValueFactory(new PropertyValueFactory<>("IDBuku"));
        tblpeminjam1.setItems(null);
        tblpeminjam1.setItems(akn);
        btntambah1.setDisable(true);
    }

    @FXML
    void handleButtonTambahBuku1(ActionEvent event) {
        LocalDate ld = dpntanggalpinjam1.getValue();
        String ntanggalpinjam = String.format("%d-%02d-%02d", ld.getYear(),
                ld.getMonthValue(), ld.getDayOfMonth());
        DataPinjam dtpinjam = new DataPinjam(Integer.parseInt(tfnidbuku1.getText()),tfnnamabuku1.getText(),
        ntanggalpinjam);
        try {
            ppdm.tambahDataPinjam(Integer.parseInt(tfnidakun1.getText()), dtpinjam);
            viewDataPinjam1(Integer.parseInt(tfnidakun1.getText()));
            btnreload1.fire();
            btnclear1.fire();
        } catch (SQLException ex) {
            Logger.getLogger(FormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            ppdm = new PerpusDataModeller("MYSQL");
            btnclear.fire();
            btnreload.fire();
        } catch (SQLException ex) {
            Logger.getLogger(FormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tblpeminjam.getSelectionModel().selectedIndexProperty().addListener(listener->{
        if(tblpeminjam.getSelectionModel().getSelectedItem()!=null){
            AkunMahasiswa akun = tblpeminjam.getSelectionModel().getSelectedItem();
            viewDataPinjam(akun.getIDakun());
            btntambah.setDisable(false);
            tfnidakun.setText(""+akun.getIDakun());
        }
    });
        try {
            // TODO
            ppdm = new PerpusDataModeller("MYSQL");
            btnclear1.fire();
            btnreload1.fire();
        } catch (SQLException ex) {
            Logger.getLogger(FormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tblpeminjam1.getSelectionModel().selectedIndexProperty().addListener(listener->{
        if(tblpeminjam1.getSelectionModel().getSelectedItem()!=null){
            AkunPelajar akn = tblpeminjam1.getSelectionModel().getSelectedItem();
            viewDataPinjam1(akn.getIDakun());
            btntambah1.setDisable(false);
            tfnidakun1.setText(""+akn.getIDakun());
        }
    });
    }    
    
}
