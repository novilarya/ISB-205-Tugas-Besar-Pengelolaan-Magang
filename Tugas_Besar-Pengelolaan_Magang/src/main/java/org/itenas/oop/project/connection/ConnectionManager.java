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
    private Connection con;
    private final String url = "jdbc:mysql://localhost:3306/isb-205-tugas_akhir-pengelolaan_magang";
    private final String username = "root";
    private final String password = "basdat2024";
    private final String driver = "com.mysql.cj.jdbc.Driver";
    
    public Connection logOn(){
        if(con == null){
            try {
                Class.forName(driver).newInstance();
                con = DriverManager.getConnection(url, username, password);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return con;
    }
    
    public Connection logOff(){
        try {
            con.close();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return con;
    }
    

}
