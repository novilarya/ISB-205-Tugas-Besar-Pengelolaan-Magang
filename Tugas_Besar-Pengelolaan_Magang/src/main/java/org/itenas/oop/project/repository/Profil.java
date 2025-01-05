/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.oop.project.repository;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import org.itenas.oop.project.event.EventMenuSelected;
import org.itenas.oop.project.model.ModelMenu;
import org.itenas.oop.project.model.ModelProfil;
import org.itenas.oop.project.panel.MenuItem;
import org.itenas.oop.project.panel.ProfilAkun;

/**
 *
 * @author aryan
 */
public class Profil<E extends Object> extends JList<E> {

    private final DefaultListModel model;
    private int selectedIndex = -1;
    private EventMenuSelected event;
    
    public void addEventMenuSelected(EventMenuSelected event){
        this.event = event;  
    }    

    public Profil() {
        model = new DefaultListModel();
        setModel(model);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    int index = locationToIndex(me.getPoint());
                    Object o = model.getElementAt(index);
                    if (o instanceof ModelProfil) {
                        ModelProfil menu = (ModelProfil) o;
                        if (menu.getType() == ModelProfil.MenuType.MENU) {
                            selectedIndex = index;
                            if (event != null){
                                event.selected(index);
                            }
                        }
                    } else {
                        selectedIndex = index;
                    }
                    repaint();
                }
            }
        });
    }
    
    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus) {
                ModelProfil data;
                if (o instanceof ModelProfil) {
                    data = (ModelProfil) o;
                } else {
                    data = new ModelProfil(o + "", ModelProfil.MenuType.EMPTY);
                }
                ProfilAkun item = new ProfilAkun(data);
                item.setSelected(selectedIndex == index);
                return item;
            }

        };
    }

    public void addItem(ModelProfil data) {
        model.addElement(data);
    }
    
}
