/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peminjamanperpustakaan.oop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import peminjamanperpustakaan.oop.db.DBHelper;

public class PerpusDataModeller {
    public final Connection conn;

    public PerpusDataModeller(String driver) throws SQLException {
        this.conn = DBHelper.getConnection(driver);
    }
    
    public void Tambah_Peminjaman(AkunMahasiswa peminjam) throws SQLException {
        String insertPeminjam = "INSERT INTO peminjam (id_akun, email, password)" 
                + " VALUES (?, ?, ?)";
        String insertAkunMahasiswa = "INSERT INTO akunmahasiswa (id_akun, universitas)"
                + " VALUES (?, ?)";
        String insertDataPinjam = "INSERT INTO datapinjam (id_buku, nama_buku, tanggal_pinjam, id_akun)"
                + " VALUES (?, ?, ?, ?)";
