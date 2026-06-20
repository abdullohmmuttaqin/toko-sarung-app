package org.example.dao;

import org.example.db.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.example.model.Sarung;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class SarungDAO {

    // Membuat tabel 'sarung' di database, kalau belum ada
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS sarung (" +
                "kode TEXT PRIMARY KEY," +
                "nama TEXT NOT NULL," +
                "jenis_bahan TEXT," +
                "harga_beli REAL," +
                "harga_jual REAL," +
                "stok INTEGER" +
                ")";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabel 'sarung' siap digunakan.");
        } catch (SQLException e) {
            System.out.println("Gagal membuat tabel: " + e.getMessage());
        }
    }

    // Menambahkan satu data sarung baru ke database
    public void insert(Sarung sarung) {
        String sql = "INSERT INTO sarung (kode, nama, jenis_bahan, harga_beli, harga_jual, stok) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, sarung.getKode());
            pstmt.setString(2, sarung.getNama());
            pstmt.setString(3, sarung.getJenisBahan());
            pstmt.setDouble(4, sarung.getHargaBeli());
            pstmt.setDouble(5, sarung.getHargaJual());
            pstmt.setInt(6, sarung.getStok());

            pstmt.executeUpdate();
            System.out.println("Data sarung berhasil ditambahkan.");

        } catch (SQLException e) {
            System.out.println("Gagal menambahkan data: " + e.getMessage());
        }
    }

    // Mengambil semua data sarung dari database
    public List<Sarung> getAll() {
        List<Sarung> daftarSarung = new ArrayList<>();
        String sql = "SELECT * FROM sarung";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Sarung sarung = new Sarung(
                        rs.getString("kode"),
                        rs.getString("nama"),
                        rs.getString("jenis_bahan"),
                        rs.getDouble("harga_beli"),
                        rs.getDouble("harga_jual"),
                        rs.getInt("stok")
                );
                daftarSarung.add(sarung);
            }

        } catch (SQLException e) {
            System.out.println("Gagal mengambil data: " + e.getMessage());
        }

        return daftarSarung;
    }

    // Mengubah data sarung yang sudah ada, berdasarkan kode
    public void update(Sarung sarung) {
        String sql = "UPDATE sarung SET nama = ?, jenis_bahan = ?, harga_beli = ?, harga_jual = ?, stok = ? " +
                "WHERE kode = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, sarung.getNama());
            pstmt.setString(2, sarung.getJenisBahan());
            pstmt.setDouble(3, sarung.getHargaBeli());
            pstmt.setDouble(4, sarung.getHargaJual());
            pstmt.setInt(5, sarung.getStok());
            pstmt.setString(6, sarung.getKode());

            int baris = pstmt.executeUpdate();
            if (baris > 0) {
                System.out.println("Data sarung berhasil diupdate.");
            } else {
                System.out.println("Data dengan kode " + sarung.getKode() + " tidak ditemukan.");
            }

        } catch (SQLException e) {
            System.out.println("Gagal update data: " + e.getMessage());
        }
    }

    // Menghapus data sarung berdasarkan kode
    public void delete(String kode) {
        String sql = "DELETE FROM sarung WHERE kode = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, kode);

            int baris = pstmt.executeUpdate();
            if (baris > 0) {
                System.out.println("Data sarung berhasil dihapus.");
            } else {
                System.out.println("Data dengan kode " + kode + " tidak ditemukan.");
            }

        } catch (SQLException e) {
            System.out.println("Gagal menghapus data: " + e.getMessage());
        }
    }
}