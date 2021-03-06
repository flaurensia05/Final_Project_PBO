/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peminjamanperpustakaan.oop;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AkunPelajar extends Peminjam{
    StringProperty NamaSekolah;

    public AkunPelajar(Integer IDakun, String email, String password, String NamaSekolah, ArrayList<DataPinjam> data) {
        super(IDakun, email, password, data);
        this.NamaSekolah = new SimpleStringProperty(NamaSekolah);
    }

    public AkunPelajar(Integer IDakun, String email, String password, String NoKartuPelajar, DataPinjam dataa) {
        super(IDakun, email, password, dataa);
        this.NamaSekolah = new SimpleStringProperty(NoKartuPelajar);
    }

    public String getNamaSekolah() {
        return NamaSekolah.get();
    }

    public void setNamaSekolah(String NamaSekolah) {
        this.NamaSekolah.set(NamaSekolah);
    }
    
    public StringProperty getNamaSekolahProperty() {
        return NamaSekolah;
    }
}
