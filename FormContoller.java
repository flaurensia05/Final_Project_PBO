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

