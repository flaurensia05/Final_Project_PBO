/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peminjamanperpustakaan.oop;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author achieto
 */
public class AkunMahasiswa extends Peminjam{
    StringProperty universitas;

    public AkunMahasiswa(Integer IDakun, String email, String password, String universitas, ArrayList<DataPinjam> data) {
        super(IDakun, email, password, data);
        this.universitas = new SimpleStringProperty(universitas);
    }

    public AkunMahasiswa(Integer IDakun, String email, String password, String universitas, DataPinjam dataa) {
        super(IDakun, email, password, dataa);
        this.universitas = new SimpleStringProperty(universitas);
    }

    public String getUniversitas() {
        return universitas.get();
    }

    public void setUniversitas(String universitas) {
        this.universitas.set(universitas);
    }
    
    public StringProperty getUniversitasProperty() {
        return universitas;
    }
}
