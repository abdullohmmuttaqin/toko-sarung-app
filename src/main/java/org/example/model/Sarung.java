package org.example.model;

public class Sarung {
    // Atribut/field — data yang dimiliki setiap objek Sarung
    private String kode;
    private String nama;
    private String jenisBahan;
    private double hargaBeli;
    private double hargaJual;
    private int stok;

    public Sarung(String kode, String nama, String jenisBahan, double hargaBeli, double hargaJual, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.jenisBahan = jenisBahan;
        this.hargaBeli = hargaBeli;
        this.hargaJual = hargaJual;
        this.stok = stok;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisBahan() {
        return jenisBahan;
    }

    public void setJenisBahan(String jenisBahan) {
        this.jenisBahan = jenisBahan;
    }

    public double getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(double hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    public double getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(double hargaJual) {
        this.hargaJual = hargaJual;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}