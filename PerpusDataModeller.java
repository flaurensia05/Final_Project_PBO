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
        
        PreparedStatement stmtPeminjam = conn.prepareStatement(insertPeminjam);
        stmtPeminjam.setInt(1, peminjam.getIDakun());
        stmtPeminjam.setString(2, peminjam.getEmail());
        stmtPeminjam.setString(3, peminjam.getPassword());
        stmtPeminjam.execute();
                
        PreparedStatement stmtAkunMahasiswa = conn.prepareStatement(insertAkunMahasiswa);
        stmtAkunMahasiswa.setInt(1, peminjam.getIDakun());
        stmtAkunMahasiswa.setString(2, peminjam.getUniversitas());
        stmtAkunMahasiswa.execute();
        
        PreparedStatement stmtDataPinjam = conn.prepareStatement(insertDataPinjam);
        stmtDataPinjam.setInt(1, peminjam.getData().get(0).getIDBuku());
        stmtDataPinjam.setString(2, peminjam.getData().get(0).getNamaBuku());
        stmtDataPinjam.setString(3, peminjam.getData().get(0).getTanggalPinjam());
        stmtDataPinjam.setInt(4, peminjam.getIDakun());
        stmtDataPinjam.execute();
    }
    
    public void Tambah_Peminjaman(AkunPelajar peminjam) throws SQLException {
        String insertPeminjam = "INSERT INTO peminjam (id_akun, email, password)" 
                + " VALUES (?, ?, ?)";
        String insertAkunPelajar = "INSERT INTO akunpelajar (id_akun, nama_sekolah)"
                + " VALUES (?, ?)";
        String insertDataPinjam = "INSERT INTO datapinjam (id_buku, nama_buku, tanggal_pinjam, id_akun)"
                + " VALUES (?, ?, ?, ?)";

    
        PreparedStatement stmtPeminjam = conn.prepareStatement(insertPeminjam);
        stmtPeminjam.setInt(1, peminjam.getIDakun());
        stmtPeminjam.setString(2, peminjam.getEmail());
        stmtPeminjam.setString(3, peminjam.getPassword());
        stmtPeminjam.execute();
        
        PreparedStatement stmtAkunPelajar = conn.prepareStatement(insertAkunPelajar);
        stmtAkunPelajar.setInt(1, peminjam.getIDakun());
        stmtAkunPelajar.setString(2, peminjam.getNamaSekolah());
        stmtAkunPelajar.execute();



        
        
        
