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
    public ObservableList<AkunPelajar> getAkunPelajar() {
        ObservableList<AkunPelajar> data = FXCollections.observableArrayList();
        String sql = "SELECT `id_akun`, `email`, `password`, `nama_sekolah` "
                + "FROM `peminjam` NATURAL JOIN `akunpelajar` "
                + "ORDER BY `nama_sekolah`";
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
                data.add(new AkunPelajar(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), dataPinjam));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerpusDataModeller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    public ObservableList<DataPinjam> getDataPinjam(int IDakun){
        ObservableList<DataPinjam> data = FXCollections.observableArrayList();
        String sqlStock = "SELECT id_buku, nama_buku, tanggal_pinjam FROM datapinjam "
                        + "WHERE id_akun=" + IDakun;
        try {
            ResultSet rs = conn.createStatement().executeQuery(sqlStock);
            while(rs.next()){
                data.add(new DataPinjam(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerpusDataModeller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
    public int nextIDAkun() throws SQLException{
        String sql = "SELECT MAX(id_akun) from peminjam";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while(rs.next()){
                return rs.getInt(1)==0?10000001:rs.getInt(1)+1;
            }
        return 10000001;
    }
    public int nextIDBuku(int IDakun) throws SQLException{
        String sql = "SELECT MAX(id_buku) from datapinjam WHERE id_akun="+IDakun;
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while(rs.next()){
                return rs.getInt(1)+1;
            }
        return 0;
    }
    public void tambahDataPinjam(int IDakun, DataPinjam data) throws SQLException {
        String insertPeminjam = "INSERT INTO datapinjam (id_akun, id_buku, "
                + "nama_buku, tanggal_pinjam)" 
                + " VALUES (?, ?, ?, ?)";

        PreparedStatement stmtPerlengkapan = conn.prepareStatement(insertPeminjam);
        stmtPerlengkapan.setInt(1, IDakun);
        stmtPerlengkapan.setInt(2, data.getIDBuku());
        stmtPerlengkapan.setString(3, data.getNamaBuku());
        stmtPerlengkapan.setString(4, data.getTanggalPinjam());
        stmtPerlengkapan.execute();
    }
}
