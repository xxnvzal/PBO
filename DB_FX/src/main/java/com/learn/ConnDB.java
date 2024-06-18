package com.learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ConnDB {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1/perpustakaan";
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    public static void main(String[] args) {
        try {
            
            Class.forName(JDBC_DRIVER);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Insert Buku");
            System.out.println("2. Edit Buku");
            System.out.println("3. Hapus Buku");
            System.out.println("4. Tampilkan Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tambahBuku(scanner);
                    break;
                case 2:
                    editBuku(scanner);
                    break;
                case 3:
                    hapusBuku(scanner);
                    break;
                case 4:
                    tampilkanBuku();
                    break;
                case 5:
                    System.out.println("Keluar dari program.");
                    closeConnection();
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void tambahBuku(Scanner scanner) {
        System.out.print("Masukkan judul buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan tahun terbit: ");
        int tahun = scanner.nextInt();
        System.out.print("Masukkan stok: ");
        int stok = scanner.nextInt();
        System.out.print("Masukkan ID penulis: ");
        int penulis = scanner.nextInt();

        try {
            String sql = "INSERT INTO buku (judul_buku, tahun_terbit, stok, penulis) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, judul);
                stmt.setInt(2, tahun);
                stmt.setInt(3, stok);
                stmt.setInt(4, penulis);
                stmt.executeUpdate();
                System.out.println("Buku berhasil ditambahkan.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void editBuku(Scanner scanner) {
        System.out.print("Masukkan ID buku yang akan diedit: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Masukkan judul buku baru: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan tahun terbit baru: ");
        int tahun = scanner.nextInt();
        System.out.print("Masukkan stok baru: ");
        int stok = scanner.nextInt();
        System.out.print("Masukkan ID penulis baru: ");
        int penulis = scanner.nextInt();

        try {
            String sql = "UPDATE buku SET judul_buku = ?, tahun_terbit = ?, stok = ?, penulis = ? WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, judul);
                stmt.setInt(2, tahun);
                stmt.setInt(3, stok);
                stmt.setInt(4, penulis);
                stmt.setInt(5, id);
                stmt.executeUpdate();
                System.out.println("Buku berhasil diupdate.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void hapusBuku(Scanner scanner) {
        System.out.print("Masukkan ID buku yang akan dihapus: ");
        int id = scanner.nextInt();

        try {
            String sql = "DELETE FROM buku WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
                System.out.println("Buku berhasil dihapus.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void tampilkanBuku() {
        try {
            String sql = "SELECT * FROM buku";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String judul = rs.getString("judul_buku");
                int tahun = rs.getInt("tahun_terbit");
                int stok = rs.getInt("stok");
                int penulis = rs.getInt("penulis");
                System.out.printf("ID: %d, Judul: %s, Tahun: %d, Stok: %d, Penulis: %d%n", id, judul, tahun, stok, penulis);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void closeConnection() {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

