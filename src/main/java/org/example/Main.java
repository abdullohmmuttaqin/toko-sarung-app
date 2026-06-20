package org.example;

import org.example.dao.SarungDAO;
import org.example.model.Sarung;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SarungDAO sarungDAO = new SarungDAO();
        sarungDAO.createTable();

        List<Sarung> daftarSarung = sarungDAO.getAll();

        System.out.println("=== Daftar Sarung ===");
        for (Sarung sarung : daftarSarung) {
            System.out.println(sarung.getKode() + " | " + sarung.getNama() + " | " +
                    sarung.getJenisBahan() + " | Rp" + sarung.getHargaJual() + " | Stok: " + sarung.getStok());
        }
    }
}