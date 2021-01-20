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
