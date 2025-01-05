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
    conn = conMan.connectDb();
    try {
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM admin WHERE username = '" + user + "' AND password = '" + pwd + "'");
        if (rs.next()) { 
            nama = rs.getString("nama"); 
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        conMan.disconnectDb(conn);// Pastikan koneksi ditutup
    }
    return nama; // Jika login gagal, akan mengembalikan null
}
    public int LoginPenyelenggara(String user, String pwd){
        int stat = 0;
        conMan = new ConnectionManager();
        conn = conMan.connectDb();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM daftarpenyelenggara where username = '" + user + "' and password = '" + pwd + "'");
            while (rs.next()) {
                if (user.equals(rs.getString("username")) && pwd.equals(rs.getString("password"))) {
                    stat = 1;
                } else {
                    stat = 0;
                }
                
                String instansi = rs.getString("instansi");

                String insertQuery = "INSERT INTO tempinstansi (instansi) VALUES ('" + instansi + "')";
                stm.executeUpdate(insertQuery);

            }
            return stat;
        }catch(SQLException ex){
            return stat;
        }
    }

    public int register(String nama, String user, String pwd){
        int stat = 0;
        String query = "INSERT INTO daftar_akun (jenis_akun, nama, username, password) VALUES ('Admin', '"+nama+"', '"+user+"', '"+pwd+"');";
        conMan = new ConnectionManager();
        conn = conMan.connectDb();
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            conMan.disconnectDb(conn);
        } catch (SQLException ex) {
            System.out.println("error: " + ex.getMessage());
    }
        return stat;
    }

    public int registerPenyelenggara(String nama, String instansi, String user, String pwd){
        int stat = 0;
        String query = "INSERT INTO daftarpenyelenggara (nama, instansi, username, password) VALUES ('" + nama + "', '" + instansi + "', '" + user + "', '" + pwd + "');";
        String query2 = "INSERT INTO tempinstansi values ('" + instansi + "')"; 
        conMan = new ConnectionManager();
        conn = conMan.connectDb();
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            stmt.executeUpdate(query2);
            conMan.disconnectDb(conn);
        } catch (SQLException ex){
            System.out.println("error: " + ex.getMessage());
        }

        return stat;
    }
        
    public int registerUtama(String jenisAkun, String nama, String user, String pwd){
        int stat = 0;
        String query = "INSERT INTO daftar_akun (jenis_akun, username, password, nama) VALUES ('" + jenisAkun + "', '" + user + "', '" + pwd + "', '" + nama + "');"; 
        conMan = new ConnectionManager();
        conn = conMan.connectDb();
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            conMan.disconnectDb(conn);
        } catch (SQLException ex){
            System.out.println("error: " + ex.getMessage());
        }

        return stat;
    }   
    
    public int LoginUtama(String user, String pwd){
        int stat = 0;
        conMan = new ConnectionManager();
        conn = conMan.connectDb();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM daftar_akun where username = '" + user + "' and password = '" + pwd + "'");
            while (rs.next()){
                if (user.equals(rs.getString("username")) && pwd.equals(rs.getString("password"))){
                    stat = 1;
                }else{
                    stat = 0;
                }
                
                int id = rs.getInt("id");
                String jenisAkun = rs.getString("jenis_akun");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String nama = rs.getString("nama");
                String jenisKelamin = rs.getString("jenis_kelamin");
                String pendidikanSaatIni = rs.getString("pendidikan_saat_ini");
                int umur = rs.getInt("umur");
                String instansi = rs.getString("instansi");
                
                if ("Admin".equals(jenisAkun)){
                    String insertQuery = "INSERT INTO temp_daftar_akun (id, jenis_akun, username, password, nama) VALUES ('"
                            + id + "', '"
                            + jenisAkun + "', '"
                            + username + "', '"
                            + password + "', '"
                            + nama + "');";
                    stm.executeUpdate(insertQuery);
                }else if("Penyelenggara".equals(jenisAkun)){
                    String insertQuery = "INSERT INTO temp_daftar_akun (id, jenis_akun, username, password, nama, instansi) VALUES ('"
                            + id + "', '"
                            + jenisAkun + "', '"
                            + username + "', '"
                            + password + "', '"
                            + nama + "', '"
                            + instansi + "');";
                    stm.executeUpdate(insertQuery);                
                }else if("Pendaftar".equals(jenisAkun)){
                    String insertQuery = "INSERT INTO temp_daftar_akun (id, jenis_akun, username, password, nama, jenis_kelamin, pendidikan_saat_ini, umur) VALUES ('"
                            + id + "', '"
                            + jenisAkun + "', '"
                            + username + "', '"
                            + password + "', '"
                            + nama + "', '"
                            + jenisKelamin + "', '"
                            + pendidikanSaatIni + "', '"
                            + umur + "');";
                    stm.executeUpdate(insertQuery);                    
                }
                
            }
            return stat;
        }catch(SQLException ex){
            return stat;
        }
    }
    
    public String TipeAkunLogin(String user, String pwd){
        int stat = 0;
        conMan = new ConnectionManager();
        conn = conMan.connectDb();
        String tipeAkun = null;
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT jenis_akun FROM daftar_akun where username = '" + user + "' and password = '" + pwd + "'");
            while (rs.next()){
                tipeAkun = rs.getString("jenis_akun");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return tipeAkun;
    }  
}
