package org.example;

import org.example.dao.SarungDAO;

public class Main {
    public static void main(String[] args) {
        SarungDAO sarungDAO = new SarungDAO();
        sarungDAO.createTable();
    }
}