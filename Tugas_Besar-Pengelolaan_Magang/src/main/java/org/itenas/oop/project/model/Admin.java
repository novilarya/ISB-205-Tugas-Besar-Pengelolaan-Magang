package org.itenas.oop.project.model;

/**
 *
 * @author aryan
 */
public class Admin {
    private String idAdmin;
    private String username;
    private String password;
    private String nama;

    public Admin() {
    }

    public Admin(String idAdmin, String username, String password, String nama) {
        this.idAdmin = idAdmin;
        this.username = username;
        this.password = password;
        this.nama = nama;
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
}
