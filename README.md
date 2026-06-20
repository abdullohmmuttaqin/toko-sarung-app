# Sistem Manajemen Toko Sarung

Aplikasi desktop sederhana untuk mengelola data produk dan transaksi penjualan toko sarung.

## 🎯 Latar Belakang

Project ini dibuat untuk membantu operasional toko sarung milik keluarga, sekaligus sebagai media belajar pengembangan aplikasi Java dari dasar.

## 🛠️ Teknologi yang Digunakan

- **Java 17** — bahasa pemrograman utama
- **Swing** — library untuk membangun tampilan (GUI)
- **SQLite** — database lokal
- **Maven** — manajemen dependency
- **IntelliJ IDEA** — IDE pengembangan

## ✅ Progress

### Milestone 1 — Manajemen Data Produk (sedang dikembangkan)
- [x] Setup project & koneksi database
- [x] Model data `Sarung`
- [x] Pembuatan tabel database
- [ ] Tambah data sarung
- [ ] Lihat daftar sarung
- [ ] Edit data sarung
- [ ] Hapus data sarung

### Rencana Selanjutnya
- [ ] Milestone 2 — Transaksi penjualan
- [ ] Milestone 3 — Laporan penjualan

## 📁 Struktur Project
```
src/main/java/org/example/
├── Main.java                           # Entry point aplikasi
├── db/
│   └── DatabaseConnection.java         # Koneksi ke database SQLite
├── model/
│   └── Sarung.java                     # Model data sarung
└── dao/
└── SarungDAO.java                      # Operasi CRUD ke database
```

## 🚀 Cara Menjalankan

1. Clone repository ini
2. Buka project menggunakan IntelliJ IDEA
3. Pastikan JDK 17 sudah terpasang
4. Jalankan `Main.java`

## 👤 Author

Dibuat oleh **Avanti.Dev** — project pembelajaran sekaligus solusi nyata untuk toko sarung keluarga.