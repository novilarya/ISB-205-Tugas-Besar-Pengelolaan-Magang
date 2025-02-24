/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.itenas.oop.project.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import org.itenas.oop.project.model.ModelProfil;

/**
 *
 * @author aryan
 */
public class ProfilAkun extends javax.swing.JPanel {

    private boolean selected;
    
    public ProfilAkun(ModelProfil data) {
        initComponents();
        setOpaque(false);
        if (data.getType() == ModelProfil.MenuType.MENU){
            lbProfil.setText(data.getName());
        }else if (data.getType() == ModelProfil.MenuType.TITLE){
            lbProfil.setVisible(false);
        }else{
            lbProfil.setText(" ");
        }
    }
    
    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbProfil = new javax.swing.JLabel();

        lbProfil.setBackground(new java.awt.Color(255, 255, 255));
        lbProfil.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbProfil.setText("Profil");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(lbProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbProfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    @Override
    protected void paintComponent(Graphics grphcs) {
        if (selected){
           Graphics2D g2 = (Graphics2D) grphcs;
           g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
           g2.setColor(new Color(246, 244, 240, 100));
           g2.fillRoundRect(10, 0, getWidth(), getHeight(), 20, 20);    
           //g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        }

        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbProfil;
    // End of variables declaration//GEN-END:variables
}
