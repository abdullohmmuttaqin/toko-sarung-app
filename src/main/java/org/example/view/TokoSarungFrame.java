package org.example.view;

import org.example.dao.SarungDAO;
import org.example.model.Sarung;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TokoSarungFrame extends JFrame {

    private SarungDAO sarungDAO;
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField txtKode, txtNama, txtJenisBahan, txtHargaBeli, txtHargaJual, txtStok;
    private JButton btnTambah, btnUpdate, btnHapus, btnBersihkan;

    public TokoSarungFrame() {
        setTitle("Sistem Manajemen Toko Sarung");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        sarungDAO = new SarungDAO();

        // Setup tabel
        String[] kolom = {"Kode", "Nama", "Jenis Bahan", "Harga Beli", "Harga Jual", "Stok"};
        tableModel = new DefaultTableModel(kolom, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        JPanel panelBawah = new JPanel(new BorderLayout());
        panelBawah.add(buatPanelForm(), BorderLayout.CENTER);
        panelBawah.add(buatPanelTombol(), BorderLayout.SOUTH);
        add(panelBawah, BorderLayout.SOUTH);

        muatData();
        daftarkanTombol();
    }

    // Mendaftarkan aksi untuk setiap tombol
    private void daftarkanTombol() {

        // Tombol Tambah
        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kode = txtKode.getText().trim();
                String nama = txtNama.getText().trim();
                String jenisBahan = txtJenisBahan.getText().trim();
                String hargaBeliStr = txtHargaBeli.getText().trim();
                String hargaJualStr = txtHargaJual.getText().trim();
                String stokStr = txtStok.getText().trim();

                // Validasi: semua field wajib diisi
                if (kode.isEmpty() || nama.isEmpty() || hargaBeliStr.isEmpty()
                        || hargaJualStr.isEmpty() || stokStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Semua field wajib diisi!");
                    return;
                }

                // Validasi: harga & stok harus angka
                try {
                    double hargaBeli = Double.parseDouble(hargaBeliStr);
                    double hargaJual = Double.parseDouble(hargaJualStr);
                    int stok = Integer.parseInt(stokStr);

                    Sarung sarung = new Sarung(kode, nama, jenisBahan, hargaBeli, hargaJual, stok);
                    sarungDAO.insert(sarung);
                    muatData();
                    bersihkanForm();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Harga dan stok harus berupa angka!");
                }
            }
        });

        // Tombol Bersihkan
        btnBersihkan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bersihkanForm();
            }
        });

        // Klik baris tabel → isi form otomatis
        table.getSelectionModel().addListSelectionListener(e -> {
            int baris = table.getSelectedRow();
            if (baris != -1) {
                txtKode.setText(tableModel.getValueAt(baris, 0).toString());
                txtNama.setText(tableModel.getValueAt(baris, 1).toString());
                txtJenisBahan.setText(tableModel.getValueAt(baris, 2).toString());
                txtHargaBeli.setText(tableModel.getValueAt(baris, 3).toString());
                txtHargaJual.setText(tableModel.getValueAt(baris, 4).toString());
                txtStok.setText(tableModel.getValueAt(baris, 5).toString());
            }
        });

        // Tombol Update
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kode = txtKode.getText().trim();
                String nama = txtNama.getText().trim();
                String jenisBahan = txtJenisBahan.getText().trim();
                String hargaBeliStr = txtHargaBeli.getText().trim();
                String hargaJualStr = txtHargaJual.getText().trim();
                String stokStr = txtStok.getText().trim();

                if (kode.isEmpty() || nama.isEmpty() || hargaBeliStr.isEmpty()
                        || hargaJualStr.isEmpty() || stokStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Pilih data dari tabel dulu!");
                    return;
                }

                try {
                    double hargaBeli = Double.parseDouble(hargaBeliStr);
                    double hargaJual = Double.parseDouble(hargaJualStr);
                    int stok = Integer.parseInt(stokStr);

                    Sarung sarung = new Sarung(kode, nama, jenisBahan, hargaBeli, hargaJual, stok);
                    sarungDAO.update(sarung);
                    muatData();
                    bersihkanForm();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Harga dan stok harus berupa angka!");
                }
            }
        });

        // Tombol Hapus
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kode = txtKode.getText().trim();

                if (kode.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Pilih data dari tabel dulu!");
                    return;
                }

                int konfirmasi = JOptionPane.showConfirmDialog(null,
                        "Yakin mau hapus data kode: " + kode + "?",
                        "Konfirmasi Hapus",
                        JOptionPane.YES_NO_OPTION);

                if (konfirmasi == JOptionPane.YES_OPTION) {
                    sarungDAO.delete(kode);
                    muatData();
                    bersihkanForm();
                }
            }
        });
    }

    // Bikin panel form input (label + kotak teks)
    private JPanel buatPanelForm() {
        JPanel panel = new JPanel(new GridLayout(3, 4, 5, 5));

        panel.add(new JLabel("Kode:"));
        txtKode = new JTextField();
        panel.add(txtKode);

        panel.add(new JLabel("Nama:"));
        txtNama = new JTextField();
        panel.add(txtNama);

        panel.add(new JLabel("Jenis Bahan:"));
        txtJenisBahan = new JTextField();
        panel.add(txtJenisBahan);

        panel.add(new JLabel("Harga Beli:"));
        txtHargaBeli = new JTextField();
        panel.add(txtHargaBeli);

        panel.add(new JLabel("Harga Jual:"));
        txtHargaJual = new JTextField();
        panel.add(txtHargaJual);

        panel.add(new JLabel("Stok:"));
        txtStok = new JTextField();
        panel.add(txtStok);

        return panel;
    }

    // Mengosongkan semua field form
    private void bersihkanForm() {
        txtKode.setText("");
        txtNama.setText("");
        txtJenisBahan.setText("");
        txtHargaBeli.setText("");
        txtHargaJual.setText("");
        txtStok.setText("");
    }

    // Bikin panel tombol aksi
    private JPanel buatPanelTombol() {
        JPanel panel = new JPanel(new FlowLayout());

        btnTambah = new JButton("Tambah");
        btnUpdate = new JButton("Update");
        btnHapus = new JButton("Hapus");
        btnBersihkan = new JButton("Bersihkan");

        panel.add(btnTambah);
        panel.add(btnUpdate);
        panel.add(btnHapus);
        panel.add(btnBersihkan);

        return panel;
    }

    // Mengambil data terbaru dari database dan menampilkannya di tabel
    private void muatData() {
        tableModel.setRowCount(0); // kosongkan dulu isi tabel sebelum diisi ulang
        List<Sarung> daftarSarung = sarungDAO.getAll();
        for (Sarung sarung : daftarSarung) {
            Object[] baris = {
                    sarung.getKode(),
                    sarung.getNama(),
                    sarung.getJenisBahan(),
                    sarung.getHargaBeli(),
                    sarung.getHargaJual(),
                    sarung.getStok()
            };
            tableModel.addRow(baris);
        }
    }
}