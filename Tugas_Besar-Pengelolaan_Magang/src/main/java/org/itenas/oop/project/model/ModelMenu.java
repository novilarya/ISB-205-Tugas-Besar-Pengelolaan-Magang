/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.oop.project.model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author aryan
 */
public class ModelMenu {
    private String Name;
    private MenuType type;
    
    public static enum MenuType {
        TITLE, MENU, EMPTY
    }    

    public ModelMenu() {
    }

    public ModelMenu(String Name, MenuType type) {
        this.Name = Name;
        this.type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }
    
}
