package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Lokasi file database SQLite kita.
    // Kalau file ini belum ada, otomatis dibuat sendiri saat pertama kali konek.
    private static final String URL = "jdbc:sqlite:tokosarung.db";

    // Method buat buka koneksi ke database, dipanggil tiap kali kita mau akses data
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}