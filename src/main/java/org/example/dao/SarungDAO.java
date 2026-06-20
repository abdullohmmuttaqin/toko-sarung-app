package org.example.dao;

import org.example.db.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
}