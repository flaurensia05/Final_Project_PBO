/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peminjamanperpustakaan.oop;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author achieto
 */
public class DataPinjam {
    IntegerProperty IDBuku;
    StringProperty NamaBuku;
    StringProperty TanggalPinjam;
    public DataPinjam(Integer IDBuku, String NamaBuku, String TanggalPinjam) {
        this.IDBuku = new SimpleIntegerProperty(IDBuku);
        this.NamaBuku = new SimpleStringProperty(NamaBuku);
        this.TanggalPinjam = new SimpleStringProperty(TanggalPinjam);
    }
public Integer getIDBuku() {
        return IDBuku.get();
    }
    
public void setIDBuku(Integer IDBuku) {
        this.IDBuku.set(IDBuku);
    }
    
public String getNamaBuku() {
        return NamaBuku.get();
    }

public void setNamaBuku(String NamaBuku) {
        this.NamaBuku.set(NamaBuku);
    }

    public String getTanggalPinjam() {
        return TanggalPinjam.get();
    }

    public void setTanggalPinjam(String TanggalPinjam) {
        this.TanggalPinjam.set(TanggalPinjam);
    }
    
    public IntegerProperty getIDBukuProperty() {
        return IDBuku;
    }
    
    public String getNamaBukuProperty() {
        return NamaBuku.get();
    }
    
    public String getTanggalPinjamProperty() {
        return TanggalPinjam.get();
    }
}
