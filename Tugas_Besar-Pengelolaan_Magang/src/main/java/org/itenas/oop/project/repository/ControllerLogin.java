/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.oop.project.repository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.itenas.oop.project.connection.ConnectionManager;
/**
 *
 * @author aryan
 */
public class ControllerLogin {
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;
    
    public String Login(String user, String pwd) {
    String nama = null; 
    conMan = new ConnectionManager();
    conn = conMan.logOn();
    try {
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM admin WHERE username = '" + user + "' AND password = '" + pwd + "'");
        if (rs.next()) { 
            nama = rs.getString("nama"); 
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        conMan.logOff(); // Pastikan koneksi ditutup
    }
    return nama; // Jika login gagal, akan mengembalikan null
}
    
    public int register(String nama, String user, String pwd){
        int stat = 0;
        String query = "INSERT INTO admin (nama, username, password) VALUES ('"+nama+"', '"+user+"', '"+pwd+"');";
        conMan = new ConnectionManager();
        conn = conMan.logOn();
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            conMan.logOff();
        } catch (SQLException ex) {
            System.out.println("error: " + ex.getMessage());
    }
        return stat;
    }
}
