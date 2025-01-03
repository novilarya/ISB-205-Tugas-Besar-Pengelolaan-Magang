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
}
