package org.example;

import org.example.dao.SarungDAO;
import org.example.model.Sarung;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SarungDAO sarungDAO = new SarungDAO();
        sarungDAO.createTable();

        System.out.println("=== Sebelum Update ===");
        tampilkanSemua(sarungDAO);

        // Update data SRG001: harga jual & stok berubah
        Sarung sarungUpdate = new Sarung("SRG001", "Sarung Songket Palembang", "Sutra", 85000, 130000, 10);
        sarungDAO.update(sarungUpdate);

        System.out.println("\n=== Setelah Update ===");
        tampilkanSemua(sarungDAO);

        // Hapus data SRG001
        sarungDAO.delete("SRG001");

        System.out.println("\n=== Setelah Delete ===");
        tampilkanSemua(sarungDAO);
    }

    private static void tampilkanSemua(SarungDAO sarungDAO) {
        List<Sarung> daftarSarung = sarungDAO.getAll();
        for (Sarung sarung : daftarSarung) {
            System.out.println(sarung.getKode() + " | " + sarung.getNama() + " | " +
                    sarung.getJenisBahan() + " | Rp" + sarung.getHargaJual() + " | Stok: " + sarung.getStok());
        }
    }
}