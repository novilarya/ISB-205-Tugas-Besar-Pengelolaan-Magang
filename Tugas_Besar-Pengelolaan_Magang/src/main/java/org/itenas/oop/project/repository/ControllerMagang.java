/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.oop.project.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.itenas.oop.project.connection.ConnectionManager;
import org.itenas.oop.project.model.Magang;

public class ControllerMagang {
    Scanner input = new Scanner(System.in);
    ConnectionManager conMan = new ConnectionManager();
    Connection con = conMan.connectDb();
    
    public boolean insertMagang(String judulMagang, String penyelenggara, String lokasi, String tipeMagang, String posisiMagang, String deskripsiMagang, String kualifikasiMagang){
        String query = "INSERT INTO daftarmagang "
                + "(judul, penyelenggara, lokasi, tipe, posisi, deksripsi, kualifikasi)"
                + "values ('" + judulMagang + "', '" + penyelenggara + "', '" + lokasi + "', '" + tipeMagang + "', '" + posisiMagang + "', '" + deskripsiMagang + "', '" + kualifikasiMagang + "')";
        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }  
    }

    public boolean updateMagang(String judulMagang, String penyelenggara, String lokasi, String tipeMagang, String posisiMagang, String deskripsiMagang, String kualifikasiMagang){
        String query = "UPDATE daftarmagang SET judul = '"
                + judulMagang + "', penyelenggara = '"
                + penyelenggara + "', lokasi = '"
                + lokasi + "', tipe = '"
                + tipeMagang + "', posisi = '"
                + posisiMagang + "', deskripsi = '"
                + deskripsiMagang + "', kualifikasi = '"
                + kualifikasiMagang + "'";
        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }    
    
    public boolean deleteMagang(String judulMagang){
        String query = "DELETE FROM daftarmagang WHERE judul = '" + judulMagang + "'";
        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }
    
    public Magang mencariBerdasarkanJudul(String judulMagang){
        Magang magang = new Magang();
        try{
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM magang WHERE judul = '" + judulMagang + "'");
            while (rs.next()){
                magang.setJudulMagang(rs.getString("judul"));
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }    
        return magang;
    }

    public List<Magang> showMagang(){
        List<Magang> listMagang = new ArrayList<Magang>();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM daftarmagang");
            while (rs.next()) {                
                Magang magang = new Magang();
                magang.setKodeMagang(rs.getString("kode"));
                magang.setJudulMagang(rs.getString("judul"));
                magang.setPenyelenggara(rs.getString("penyelenggara"));
                magang.setLokasi(rs.getString("lokasi"));
                magang.setTipeMagang(rs.getString("tipe"));
                magang.setPosisiMagang(rs.getString("posisi"));
                magang.setDeskripsiMagang(rs.getString("deskripsi"));
                magang.setKualifikasiMagang(rs.getString("kualifikasi"));

                listMagang.add(magang);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return listMagang;
    }    
}
