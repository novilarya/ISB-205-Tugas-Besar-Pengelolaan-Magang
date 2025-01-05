/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.oop.project.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aryan
 */
public class ConnectionManager {

    private final String url = "jdbc:mysql://localhost:3306/isb-205-tugas_akhir-pengelolaan_magang";
    private final String username = "root";
    private final String password = "basdat2024";
    private final String driver = "com.mysql.cj.jdbc.Driver";
    
    public ConnectionManager(){
        try{
            Class.forName(driver);
            System.out.println("Driver berhasil dimuat");
        } catch (ClassNotFoundException e) {
            System.err.println("Error saat memuat driver: " + e.getMessage());
        }
    }
    
    public Connection connectDb(){
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.err.println("Error saat membuka koneksi: " + e.getMessage());
            return null;
        }
    }
    
    public void disconnectDb(Connection connection){
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Koneksi berhasil ditutup");
            } catch (SQLException e) {
                System.err.println("Error saat menutup koneksi: " + e.getMessage());
            }
        }
    }
}
