
package org.itenas.oop.project.view;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FlowLayout;
import org.itenas.oop.project.connection.ConnectionManager;
import org.itenas.oop.project.model.Magang;
import org.itenas.oop.project.repository.ControllerMagang;

/**
 *
 * @author ASUS
 */
public class MelihatDaftarMagangAdminDanPenyelenggara extends javax.swing.JFrame {
    private Boolean hasil;
    private ControllerMagang conMagang = new ControllerMagang();
    private DefaultTableModel model;
    private ConnectionManager conMan;
    private Connection conn;
    

    

    public final void getData() {
    jPanel3.removeAll();
    jPanel3.setLayout(new BoxLayout(jPanel3, BoxLayout.Y_AXIS));
    
    // Tambah spacing di awal panel
    jPanel3.add(Box.createRigidArea(new Dimension(0, 20)));
    
    List<Magang> listMagang = conMagang.showMagang();
    
    for (Magang magang : listMagang) {
        JPanel itemPanel = createInternshipPanel(magang);
        jPanel3.add(itemPanel);
        // Menambah jarak 20 pixel antara panel
        jPanel3.add(Box.createRigidArea(new Dimension(0, 20))); 
    }
    
    jPanel3.add(Box.createVerticalGlue());
    jPanel3.revalidate();
    jPanel3.repaint();
    }
   private JPanel createInternshipPanel(Magang magang) {
    // Main Panel
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout(10, 10));
    panel.setBackground(new Color(242, 242, 242));
    
    // Menambah padding yang berbeda untuk atas (25px) dan bawah (15px)
    panel.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
        BorderFactory.createEmptyBorder(25, 15, 15, 15) // atas:25, kiri:15, bawah:15, kanan:15
    ));
    
    // Content Panel (Left side)
    JPanel contentPanel = new JPanel();
    contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
    contentPanel.setBackground(new Color(242, 242, 242));
    contentPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
    
    // Title
    JLabel titleLabel = new JLabel(magang.getJudulMagang());
    titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
    titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
    
    // Organization
    JLabel penyelenggaraLabel = new JLabel(magang.getPenyelenggara());
    penyelenggaraLabel.setFont(new Font("Segoe UI", Font.ITALIC, 12));
    penyelenggaraLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
    
    // Description
    String desc = magang.getDeskripsiMagang();
    if (desc != null && desc.length() > 100) {
        desc = desc.substring(0, 97) + "...";
    }
    JTextArea descLabel = new JTextArea(desc != null ? desc : "");
    descLabel.setWrapStyleWord(true);
    descLabel.setLineWrap(true);
    descLabel.setOpaque(false);
    descLabel.setEditable(false);
    descLabel.setFocusable(false);
    descLabel.setBackground(new Color(242, 242, 242));
    descLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    descLabel.setBorder(null);
    descLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
    
    // Add components to content panel
    contentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
    contentPanel.add(titleLabel);
    contentPanel.add(Box.createRigidArea(new Dimension(0, 8)));
    contentPanel.add(penyelenggaraLabel);
    contentPanel.add(Box.createRigidArea(new Dimension(0, 8)));
    contentPanel.add(descLabel);
    
    // Bottom Panel for Button
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    buttonPanel.setBackground(new Color(242, 242, 242));
    
    // Mengurangi spacing atas tombol
    buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0)); // Dikurangi dari 10 menjadi 5
    
    // Detail Button
    JButton detailBtn = new JButton("Detail");
    detailBtn.setBackground(new Color(102, 102, 255)); // Warna biru seperti di gambar
    detailBtn.setForeground(Color.WHITE); // Text warna putih
    detailBtn.addActionListener(e -> showDetail(magang));
    buttonPanel.add(detailBtn);
    
    // Add panels to main panel
    panel.add(contentPanel, BorderLayout.CENTER);
    panel.add(buttonPanel, BorderLayout.SOUTH);
    
    // Set maximum size
    panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, panel.getPreferredSize().height));
    
    return panel;
    }
    private void showDetail(Magang magang) {
        if (magang != null) {
            jLabel1.setText(magang.getJudulMagang());
            jTextArea1.setText("Penyelenggara: " + magang.getPenyelenggara() + 
                             "\nTipe: " + magang.getTipeMagang() + 
                             "\n\nDeskripsi:\n" + magang.getDeskripsiMagang());
            jTextArea2.setText(magang.getKualifikasiMagang());
            jTextArea3.setText(magang.getLokasi());
            jTextArea4.setText(magang.getPosisiMagang());
            
            jTextArea1.setEditable(false);
            jTextArea2.setEditable(false);
            jTextArea3.setEditable(false);
            jTextArea4.setEditable(false);
        }
    }
    
    private void configureTextArea(JTextArea textArea) {
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(245, 245, 245));
        textArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    private void clearData() {
        jTextArea1.setText("");
        jTextArea2.setText("");
        jTextArea3.setText("");
        jTextArea4.setText("");
        jLabel1.setText("Judul");
    }
    public MelihatDaftarMagangAdminDanPenyelenggara() {
        initComponents();
        
        // Configure scroll pane
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        
        // Initialize text areas
        configureTextArea(jTextArea1);
        configureTextArea(jTextArea2);
        configureTextArea(jTextArea3);
        configureTextArea(jTextArea4);
        
        // Load initial data
        getData();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        Detail = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        KualifikasiMagang = new javax.swing.JLabel();
        LokasiMagang = new javax.swing.JLabel();
        DeskripsiMagang = new javax.swing.JLabel();
        DeskripsiMagang1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));

        Detail.setBackground(new java.awt.Color(102, 102, 255));
        Detail.setText("Detail");
        Detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetailActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Deskripsi");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(224, Short.MAX_VALUE)
                .addComponent(Detail)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(Detail)
                .addContainerGap())
        );
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(94, 104, 109));

        jPanel2.setBackground(new java.awt.Color(250, 255, 197));


        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(622, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel3);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Judul");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        KualifikasiMagang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        KualifikasiMagang.setForeground(new java.awt.Color(0, 0, 0));
        KualifikasiMagang.setText("Kualifikasi");

        LokasiMagang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LokasiMagang.setForeground(new java.awt.Color(0, 0, 0));
        LokasiMagang.setText("Lokasi");

        DeskripsiMagang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DeskripsiMagang.setForeground(new java.awt.Color(0, 0, 0));
        DeskripsiMagang.setText("Posisi");

        DeskripsiMagang1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DeskripsiMagang1.setForeground(new java.awt.Color(0, 0, 0));
        DeskripsiMagang1.setText("Deskripsi ");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane4.setViewportView(jTextArea3);

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane5.setViewportView(jTextArea4);


            .addGap(0, 548, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );


        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(DeskripsiMagang1)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(KualifikasiMagang)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LokasiMagang))
                                .addGap(66, 66, 66)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DeskripsiMagang)
                                    .addComponent(jScrollPane5))))))
                .addContainerGap(17, Short.MAX_VALUE))

            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(406, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())

        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()

                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel2)
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(DeskripsiMagang1)
                        .addGap(1, 1, 1)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KualifikasiMagang)
                    .addComponent(DeskripsiMagang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LokasiMagang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Profile");


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
=======
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
>>>>>>> 836a4a7310b4b46f75bbe5f8288227bc94602529
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DetailActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MelihatDaftarMagangAdminDanPenyelenggara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MelihatDaftarMagangAdminDanPenyelenggara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MelihatDaftarMagangAdminDanPenyelenggara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MelihatDaftarMagangAdminDanPenyelenggara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MelihatDaftarMagangAdminDanPenyelenggara().setVisible(true);
            }
        });
    }
    public class InternshipListItem extends javax.swing.JPanel {
    private Magang magang;
    private MelihatDaftarMagangAdminDanPenyelenggara parent;
    
    public InternshipListItem(Magang magang, MelihatDaftarMagangAdminDanPenyelenggara parent) {
        this.magang = magang;
        this.parent = parent;
        initializePanel();
    }
    
    private void initializePanel() {
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));
        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Title label
        javax.swing.JLabel titleLabel = new javax.swing.JLabel(magang.getJudulMagang());
        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        
        // Description label with limited text
        javax.swing.JLabel descLabel = new javax.swing.JLabel("<html><body style='width: 200px'>" + 
            magang.getDeskripsiMagang().substring(0, Math.min(100, magang.getDeskripsiMagang().length())) + 
            "...</body></html>");
        
        // Detail button
        javax.swing.JButton detailBtn = new javax.swing.JButton("Detail");
        detailBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parent.showDetail(magang);
            }
        });
        
        // Add components
        add(titleLabel);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(descLabel);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(detailBtn);
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DeskripsiMagang;
    private javax.swing.JLabel DeskripsiMagang1;
    private javax.swing.JButton Detail;
    private javax.swing.JLabel KualifikasiMagang;
    private javax.swing.JLabel LokasiMagang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    // End of variables declaration//GEN-END:variables
}
