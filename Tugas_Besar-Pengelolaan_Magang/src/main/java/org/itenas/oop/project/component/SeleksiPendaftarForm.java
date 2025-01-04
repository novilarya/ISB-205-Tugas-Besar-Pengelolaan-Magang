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
import org.itenas.oop.project.model.Pendaftar;
import org.itenas.oop.project.repository.ControllerMagang;
import org.itenas.oop.project.repository.ControllerPendaftar;

/**
 *
 * @author aryan
 */
public class SeleksiPendaftarForm extends javax.swing.JPanel {

    Boolean hasil;
    ControllerMagang conMagang = new ControllerMagang();
    ControllerPendaftar conPendaftar = new ControllerPendaftar();
    private DefaultTableModel model;
    private DefaultTableModel modelPendaftar;
    private ConnectionManager conMan;
    private Connection conn;
    
    public SeleksiPendaftarForm() {
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
        getDataPendaftar();
    }
    
    public final void getDataPendaftar(){
        DefaultTableModel dtm = (DefaultTableModel) tabelPendaftar.getModel();

        dtm.setRowCount(0);

        List<Pendaftar> listPendaftar = conPendaftar.showPendaftar();
        String[] data = new String[6];
        for (Pendaftar newPendaftar : listPendaftar){
            data[0] = newPendaftar.getUsername();
            data[1] = newPendaftar.getPassword();
            data[2] = newPendaftar.getNama();
            data[3] = newPendaftar.getJenisKelamin();
            data[4] = newPendaftar.getPendidikanSaatIni();
            
            data[5] = Integer.toString(newPendaftar.getUmur());
            
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

        List<Pendaftar> listPendaftar = conPendaftar.showPendaftar();
        String[] data = new String[6];
        for (Pendaftar newPendaftar : listPendaftar){
            data[0] = newPendaftar.getUsername();
            data[1] = newPendaftar.getPassword();
            data[2] = newPendaftar.getNama();
            data[3] = newPendaftar.getJenisKelamin();
            data[4] = newPendaftar.getPendidikanSaatIni();
            
            data[5] = Integer.toString(newPendaftar.getUmur());
            
            dtm.addRow(data);
        }         
    } 
     
    private void tampilkanDataPendaftar(String namaPendaftar){
        Pendaftar pendaftar = new Pendaftar();
        pendaftar = conPendaftar.mencariBerdasarkanNama(namaPendaftar);        
        
        DefaultTableModel dtm = (DefaultTableModel) tabelPendaftar.getModel();
        dtm.setRowCount(0);
        
        if (pendaftar != null){
            String[] data = new String[1];
            data[0] = pendaftar.getNama();
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

        textUsername6 = new javax.swing.JLabel();
        txtSearchJudulMagang = new javax.swing.JTextField();
        btnSearchJudul = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelMagang = new javax.swing.JTable();
        textUsername7 = new javax.swing.JLabel();
        txtSearchNamaPendaftar = new javax.swing.JTextField();
        btnSearchNama = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelPendaftar = new javax.swing.JTable();

        setBackground(new java.awt.Color(239, 236, 229));

        textUsername6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textUsername6.setForeground(new java.awt.Color(51, 51, 51));
        textUsername6.setText("Pencarian magang berdasarkan judul");

        txtSearchJudulMagang.setBackground(new java.awt.Color(239, 239, 239));
        txtSearchJudulMagang.setForeground(new java.awt.Color(51, 51, 51));
        txtSearchJudulMagang.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(191, 191, 191), 1, true));
        txtSearchJudulMagang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchJudulMagangActionPerformed(evt);
            }
        });

        btnSearchJudul.setBackground(new java.awt.Color(153, 153, 255));
        btnSearchJudul.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearchJudul.setForeground(new java.awt.Color(51, 51, 51));
        btnSearchJudul.setText("Search");
        btnSearchJudul.setBorder(null);
        btnSearchJudul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchJudulActionPerformed(evt);
            }
        });

        tabelMagang.setBackground(new java.awt.Color(239, 239, 239));
        tabelMagang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Judul", "Penyelenggara", "Lokasi", "Tipe", "Posisi", "Deskripsi", "Kualifikasi"
            }
        ));
        tabelMagang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMagangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelMagang);

        textUsername7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textUsername7.setForeground(new java.awt.Color(51, 51, 51));
        textUsername7.setText("Pencarian magang berdasarkan nama");

        txtSearchNamaPendaftar.setBackground(new java.awt.Color(239, 239, 239));
        txtSearchNamaPendaftar.setForeground(new java.awt.Color(51, 51, 51));
        txtSearchNamaPendaftar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(191, 191, 191), 1, true));
        txtSearchNamaPendaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchNamaPendaftarActionPerformed(evt);
            }
        });

        btnSearchNama.setBackground(new java.awt.Color(153, 153, 255));
        btnSearchNama.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearchNama.setForeground(new java.awt.Color(51, 51, 51));
        btnSearchNama.setText("Search");
        btnSearchNama.setBorder(null);
        btnSearchNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchNamaActionPerformed(evt);
            }
        });

        tabelPendaftar.setBackground(new java.awt.Color(239, 239, 239));
        tabelPendaftar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nama"
            }
        ));
        tabelPendaftar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPendaftarMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelPendaftar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearchJudulMagang, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearchJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textUsername6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textUsername7)
                                    .addComponent(txtSearchNamaPendaftar, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearchNama, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textUsername6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearchJudul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearchJudulMagang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textUsername7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearchNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearchNamaPendaftar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchJudulMagangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchJudulMagangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchJudulMagangActionPerformed

    private void btnSearchJudulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchJudulActionPerformed
        try {
            String judulMagang = txtSearchJudulMagang.getText();
            tampilkanDataMagang(judulMagang);

        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Anda Salah Memasukkan Judul!");
        }
    }//GEN-LAST:event_btnSearchJudulActionPerformed

    private void tabelMagangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMagangMouseClicked
        int i = tabelMagang.getSelectedRow();

        TableModel model = tabelMagang.getModel();
/*
        txtJudulPenyelenggara.setText(model.getValueAt(i, 0).toString());
        txtLokasiPenyelenggara.setText(model.getValueAt(i, 2).toString());
        txtTipeMagang.setSelectedItem(model.getValueAt(i, 3).toString());
        txtPosisiPenyelenggara.setText(model.getValueAt(i, 4).toString());
        txtDeskripsiPenyelenggara.setText(model.getValueAt(i, 5).toString());
        txtKualifikasiPenyelenggara.setText(model.getValueAt(i, 6).toString()); */
    }//GEN-LAST:event_tabelMagangMouseClicked

    private void txtSearchNamaPendaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchNamaPendaftarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchNamaPendaftarActionPerformed

    private void btnSearchNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchNamaActionPerformed
        try {
            String namaPendaftar = txtSearchNamaPendaftar.getText();
            tampilkanDataPendaftar(namaPendaftar);

        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Anda Salah Memasukkan Judul!");
        }        
    }//GEN-LAST:event_btnSearchNamaActionPerformed

    private void tabelPendaftarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPendaftarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelPendaftarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearchJudul;
    private javax.swing.JButton btnSearchNama;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelMagang;
    private javax.swing.JTable tabelPendaftar;
    private javax.swing.JLabel textUsername6;
    private javax.swing.JLabel textUsername7;
    private javax.swing.JTextField txtSearchJudulMagang;
    private javax.swing.JTextField txtSearchNamaPendaftar;
    // End of variables declaration//GEN-END:variables
}
