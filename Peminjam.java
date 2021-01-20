/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peminjamanperpustakaan.oop;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author achieto
 */
public abstract class Peminjam {
    private IntegerProperty IDakun;
    private StringProperty email;
    private StringProperty password;
    private ArrayList<DataPinjam> data;

    public Peminjam(Integer IDakun, String email, String password, ArrayList<DataPinjam> data) {
        this.IDakun = new SimpleIntegerProperty(IDakun);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.data = data;
    }
    
    public Peminjam(Integer IDakun, String email, String password, DataPinjam dataa) {
        data = new ArrayList<>();
        this.IDakun = new SimpleIntegerProperty(IDakun);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.data.add(dataa);
    }
    
    
    public Integer getIDakun() {
        return IDakun.get();
    }

    public void setIDakun(Integer IDakun) {
        this.IDakun.set(IDakun);
    }
    

