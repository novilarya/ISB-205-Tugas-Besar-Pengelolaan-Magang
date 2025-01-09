/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.itenas.oop.project.component;

import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.itenas.oop.project.connection.ConnectionManager;
import org.itenas.oop.project.model.Magang;
import org.itenas.oop.project.model.MagangPendaftar;
import org.itenas.oop.project.model.Pendaftar;
import org.itenas.oop.project.repository.ControllerMagang;
import org.itenas.oop.project.repository.ControllerPendaftar;

/**
 *
 * @author aryan
 */
public class SeleksiPendaftarForm2 extends javax.swing.JPanel {

    Boolean hasil;
    ControllerMagang conMagang = new ControllerMagang();
    ControllerPendaftar conPendaftar = new ControllerPendaftar();
    private DefaultTableModel model;
    private DefaultTableModel modelPendaftar;
    private ConnectionManager conMan;
    private Connection conn;
    private String judulMagang = null ;
    
    public SeleksiPendaftarForm2(boolean par) {
        initComponents();
        
        model = new DefaultTableModel();
        tabelMagang.setModel(model);
        model.addColumn("Judul");
        model.addColumn("Penyelenggara");
        model.addColumn("Lokasi");
        model.addColumn("Tipe");
        model.addColumn("Posisi");
        model.addColumn("Deskripsi");
        model.addColumn("Kualifikasi");
        getDataMagang();  
        
        modelPendaftar = new DefaultTableModel();
        tabelPendaftar.setModel(modelPendaftar);
        modelPendaftar.addColumn("Nama");
        //getDataPendaftar();
    }
    
    public final void getDataPendaftar(){
        DefaultTableModel dtm = (DefaultTableModel) tabelPendaftar.getModel();

        dtm.setRowCount(0);

        List<MagangPendaftar> listPendaftar = conPendaftar.showPendaftarBerdasarkanMagang(judulMagang);
        String[] data = new String[6];
        for (MagangPendaftar newPendaftar : listPendaftar){
            data[0] = Integer.toString(newPendaftar.getKodeSeleksi());
            data[1] = newPendaftar.getNama();
            data[2] = newPendaftar.getJenisKelamin();
            data[3] = newPendaftar.getPendidikanSaatIni();
            data[4] = Integer.toString(newPendaftar.getUmur());
            data[5] = newPendaftar.getJudulMagang();
            
            dtm.addRow(data);
        }       
    }
    
    public final void getDataMagang(){
        DefaultTableModel dtm = (DefaultTableModel) tabelMagang.getModel();

        dtm.setRowCount(0);

        List<Magang> listMagang = conMagang.showMagang();
        String[] data = new String[8];
        for (Magang newMagang : listMagang){
            data[0] = newMagang.getJudulMagang();
            data[1] = newMagang.getPenyelenggara();
            data[2] = newMagang.getLokasi();
            data[3] = newMagang.getTipeMagang();
            data[4] = newMagang.getPosisiMagang();
            data[5] = newMagang.getDeskripsiMagang();
            data[6] = newMagang.getKualifikasiMagang();
            dtm.addRow(data);
        }
    }
    
     private void tampilkanDataMagang(String judulMagang){
        Magang magang = new Magang();
        magang = conMagang.mencariBerdasarkanJudul(judulMagang);
        
        
        DefaultTableModel dtm = (DefaultTableModel) tabelMagang.getModel();
        dtm.setRowCount(0);
        
        if (magang != null){
            String[] data = new String[7];
            data[0] = magang.getJudulMagang();
            data[1] = magang.getPenyelenggara();
            data[2] = magang.getLokasi();
            data[3] = magang.getTipeMagang();
            data[4] = magang.getPosisiMagang();
            data[5] = magang.getDeskripsiMagang();
            data[6] = magang.getKualifikasiMagang();
            dtm.addRow(data);
        }else{
            JOptionPane.showMessageDialog(null,"Barang dengan judul " + judulMagang + " tidak ditemukan!");
        }
    }  
    
    private void tampilkanDataPendaftarBerdasarkanMagang(String judulMagang){
        DefaultTableModel dtm = (DefaultTableModel) tabelPendaftar.getModel();

        dtm.setRowCount(0);

        List<MagangPendaftar> listMagangPendaftar = conPendaftar.showPendaftarBerdasarkanMagang(judulMagang);
        String[] data = new String[1];
        for (MagangPendaftar newPendaftar : listMagangPendaftar){
            //data[0] = Integer.toString(newPendaftar.getKodeSeleksi());
            data[0] = newPendaftar.getNama();
            /*data[2] = newPendaftar.getJenisKelamin();
            data[3] = newPendaftar.getPendidikanSaatIni();
            data[4] = Integer.toString(newPendaftar.getUmur());
            data[5] = newPendaftar.getJudulMagang();*/
            
            dtm.addRow(data);
        }         
    } 
     
    private void tampilkanDataPendaftar(String namaPendaftar){
        MagangPendaftar magangPendaftar = new MagangPendaftar();
        magangPendaftar = conPendaftar.mencariMagangPendaftarBerdasarkanNama(namaPendaftar);        
        
        DefaultTableModel dtm = (DefaultTableModel) tabelPendaftar.getModel();
        dtm.setRowCount(0);
        
        if (magangPendaftar != null){
            String[] data = new String[1];
            data[0] = magangPendaftar.getNama();
            dtm.addRow(data);
        }else{
            JOptionPane.showMessageDialog(null,"Pendaftar dengan nama " + namaPendaftar + " tidak ditemukan!");
        }
    } 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textNama = new javax.swing.JLabel();
        jTextArea4 = new javax.swing.JTextArea();
        textNama1 = new javax.swing.JLabel();
        jTextArea5 = new javax.swing.JTextArea();
        textNama2 = new javax.swing.JLabel();
        jTextArea6 = new javax.swing.JTextArea();
        jTextArea7 = new javax.swing.JTextArea();
        textNama3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(239, 236, 229));

        textNama.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textNama.setForeground(new java.awt.Color(51, 51, 51));
        textNama.setText("Nama");

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);

        textNama1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textNama1.setForeground(new java.awt.Color(51, 51, 51));
        textNama1.setText("Jenis Kelamin");

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);

        textNama2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textNama2.setForeground(new java.awt.Color(51, 51, 51));
        textNama2.setText("Pendidikan Saat Ini");

        jTextArea6.setColumns(20);
        jTextArea6.setRows(5);

        jTextArea7.setColumns(20);
        jTextArea7.setRows(5);

        textNama3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textNama3.setForeground(new java.awt.Color(51, 51, 51));
        textNama3.setText("Umur");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextArea4, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                    .addComponent(jTextArea5, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                    .addComponent(jTextArea6, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                    .addComponent(jTextArea7, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textNama1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textNama3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textNama2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textNama)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextArea4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textNama1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextArea5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textNama2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextArea6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textNama3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextArea7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(413, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JLabel textNama;
    private javax.swing.JLabel textNama1;
    private javax.swing.JLabel textNama2;
    private javax.swing.JLabel textNama3;
    // End of variables declaration//GEN-END:variables
}
