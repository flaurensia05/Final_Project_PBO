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
        
        PreparedStatement stmtDataPinjam = conn.prepareStatement(insertDataPinjam);
        stmtDataPinjam.setInt(1, peminjam.getData().get(0).getIDBuku());
        stmtDataPinjam.setString(2, peminjam.getData().get(0).getNamaBuku());
        stmtDataPinjam.setString(3, peminjam.getData().get(0).getTanggalPinjam());
        stmtDataPinjam.setInt(4, peminjam.getIDakun());
        stmtDataPinjam.execute();
    }

    public ObservableList<AkunMahasiswa> getAkunMahasiswa() {
        ObservableList<AkunMahasiswa> data = FXCollections.observableArrayList();
        String sql = "SELECT `id_akun`, `email`, `password`, `universitas` "
                + "FROM `peminjam` NATURAL JOIN `akunmahasiswa` "
                + "ORDER BY `universitas`";
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                String sqlDataPinjam = "SELECT id_buku, nama_buku, tanggal_pinjam FROM datapinjam "
                        + "WHERE id_akun=" + rs.getInt(1);
                ResultSet rsDataPinjam = conn.createStatement().executeQuery(sqlDataPinjam);
                ArrayList<DataPinjam> dataPinjam = new ArrayList<>();
                while (rsDataPinjam.next()) {
                    dataPinjam.add(new DataPinjam(rsDataPinjam.getInt(1), rsDataPinjam.getString(2), rsDataPinjam.getString(3)));
                }
                data.add(new AkunMahasiswa(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), dataPinjam));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerpusDataModeller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }



        
        
        
