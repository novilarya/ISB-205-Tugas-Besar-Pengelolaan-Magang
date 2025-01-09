package org.itenas.oop.project.component;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bc63cade28a926e191ad08d04d3967c1b45fb449
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Connection;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import org.itenas.oop.project.connection.ConnectionManager;
import org.itenas.oop.project.model.Magang;
import org.itenas.oop.project.repository.ControllerMagang;
import javax.swing.*;
import java.awt.*;
import org.itenas.oop.project.repository.RoundedPanel;

<<<<<<< HEAD
=======
=======
>>>>>>> f0d96a677e5fbd60c52133207f422fc770f230fd
>>>>>>> bc63cade28a926e191ad08d04d3967c1b45fb449
/**
 *
 * @author aryan
 */
public class MelihatDaftarMagangAdminDanPenyelenggara extends javax.swing.JPanel {
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bc63cade28a926e191ad08d04d3967c1b45fb449
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
    RoundedPanel panel = new RoundedPanel(30); // Sudut melingkar dengan radius 30
    panel.setLayout(new BorderLayout(10, 10));
    panel.setBackground(new Color(242, 242, 242));
    panel.setSize(223, 140);

    // Menambah padding yang berbeda untuk atas (25px) dan bawah (15px)
    panel.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(200, 200, 200), 0),
        BorderFactory.createEmptyBorder(15, 15, 15, 15)
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
    if (desc != null && desc.length() > 50) {
        desc = desc.substring(0, 47) + "...";
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
    detailBtn.setBackground(new Color(77, 161, 169)); // Warna biru
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
            jTextArea1.setText(magang.getDeskripsiMagang());
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
<<<<<<< HEAD
=======
=======

    /**
     * Creates new form KelolaMagangForm
     */
    public MelihatDaftarMagangAdminDanPenyelenggara() {
        initComponents();
>>>>>>> f0d96a677e5fbd60c52133207f422fc770f230fd
>>>>>>> bc63cade28a926e191ad08d04d3967c1b45fb449
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bc63cade28a926e191ad08d04d3967c1b45fb449
        jPanel4 = new org.itenas.oop.project.component.CardMagang();
        Detail = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cardMagang1 = new org.itenas.oop.project.component.CardMagang();
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
        jTextArea3 = new javax.swing.JTextArea();
        jTextArea4 = new javax.swing.JTextArea();
<<<<<<< HEAD
=======
=======
        jPanel4 = new javax.swing.JPanel();
        Detail = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
>>>>>>> f0d96a677e5fbd60c52133207f422fc770f230fd
>>>>>>> bc63cade28a926e191ad08d04d3967c1b45fb449

        setBackground(new java.awt.Color(239, 236, 229));

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));
<<<<<<< HEAD
        jScrollPane1.setBorder(null);

        jPanel3.setBackground(new java.awt.Color(239, 236, 229));
=======
<<<<<<< HEAD
        jScrollPane1.setBorder(null);

        jPanel3.setBackground(new java.awt.Color(239, 236, 229));
=======

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));
>>>>>>> f0d96a677e5fbd60c52133207f422fc770f230fd
>>>>>>> bc63cade28a926e191ad08d04d3967c1b45fb449

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
<<<<<<< HEAD
                .addContainerGap(145, Short.MAX_VALUE)
=======
<<<<<<< HEAD
                .addContainerGap(145, Short.MAX_VALUE)
=======
                .addContainerGap(141, Short.MAX_VALUE)
>>>>>>> f0d96a677e5fbd60c52133207f422fc770f230fd
>>>>>>> bc63cade28a926e191ad08d04d3967c1b45fb449
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
<<<<<<< HEAD
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
=======
<<<<<<< HEAD
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
=======
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
>>>>>>> f0d96a677e5fbd60c52133207f422fc770f230fd
>>>>>>> bc63cade28a926e191ad08d04d3967c1b45fb449
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
<<<<<<< HEAD
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(708, Short.MAX_VALUE))
=======
<<<<<<< HEAD
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(708, Short.MAX_VALUE))
=======
                .addGap(26, 26, 26)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(622, Short.MAX_VALUE))
>>>>>>> f0d96a677e5fbd60c52133207f422fc770f230fd
>>>>>>> bc63cade28a926e191ad08d04d3967c1b45fb449
        );

        jScrollPane1.setViewportView(jPanel3);

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bc63cade28a926e191ad08d04d3967c1b45fb449
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

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);

        javax.swing.GroupLayout cardMagang1Layout = new javax.swing.GroupLayout(cardMagang1);
        cardMagang1.setLayout(cardMagang1Layout);
        cardMagang1Layout.setHorizontalGroup(
            cardMagang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardMagang1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(cardMagang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DeskripsiMagang1)
                    .addComponent(DeskripsiMagang)
                    .addComponent(jLabel1)
                    .addComponent(LokasiMagang)
                    .addComponent(KualifikasiMagang)
                    .addGroup(cardMagang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(cardMagang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextArea4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextArea3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        cardMagang1Layout.setVerticalGroup(
            cardMagang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardMagang1Layout.createSequentialGroup()
                .addGroup(cardMagang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cardMagang1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cardMagang1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addComponent(DeskripsiMagang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextArea4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LokasiMagang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextArea3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeskripsiMagang1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KualifikasiMagang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

<<<<<<< HEAD
=======
=======
>>>>>>> f0d96a677e5fbd60c52133207f422fc770f230fd
>>>>>>> bc63cade28a926e191ad08d04d3967c1b45fb449
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
<<<<<<< HEAD
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardMagang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
=======
<<<<<<< HEAD
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardMagang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
=======
                .addGap(0, 473, Short.MAX_VALUE))
>>>>>>> f0d96a677e5fbd60c52133207f422fc770f230fd
>>>>>>> bc63cade28a926e191ad08d04d3967c1b45fb449
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bc63cade28a926e191ad08d04d3967c1b45fb449
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardMagang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
<<<<<<< HEAD
=======
=======
>>>>>>> f0d96a677e5fbd60c52133207f422fc770f230fd
>>>>>>> bc63cade28a926e191ad08d04d3967c1b45fb449
        );
    }// </editor-fold>//GEN-END:initComponents

    private void DetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DetailActionPerformed
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bc63cade28a926e191ad08d04d3967c1b45fb449
    public class InternshipListItem extends javax.swing.JPanel {
    private Magang magang;
    private MelihatDaftarMagangAdminDanPenyelenggara parent;
    
    public InternshipListItem(Magang magang, org.itenas.oop.project.component.MelihatDaftarMagangAdminDanPenyelenggara parent) {
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
    private org.itenas.oop.project.component.CardMagang cardMagang1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private org.itenas.oop.project.component.CardMagang jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
<<<<<<< HEAD
=======
=======


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Detail;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
>>>>>>> f0d96a677e5fbd60c52133207f422fc770f230fd
>>>>>>> bc63cade28a926e191ad08d04d3967c1b45fb449
    // End of variables declaration//GEN-END:variables
}
