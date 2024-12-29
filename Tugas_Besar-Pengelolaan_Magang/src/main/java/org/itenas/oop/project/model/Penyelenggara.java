package org.itenas.oop.project.model;

/**
 *
 * @author aryan
 */
public class Penyelenggara {
    private String idPenyelenggara;
    private String username;
    private String password;
    private String nama;
    private String instansiPenyelenggara;
    private String deskripsiInstansi;

    public Penyelenggara() {
    }

    public Penyelenggara(String idPenyelenggara, String username, String password, String nama, String instansiPenyelenggara, String deskripsiInstansi) {
        this.idPenyelenggara = idPenyelenggara;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.instansiPenyelenggara = instansiPenyelenggara;
        this.deskripsiInstansi = deskripsiInstansi;
    }

    public String getIdPenyelenggara() {
        return idPenyelenggara;
    }

    public void setIdPenyelenggara(String idPenyelenggara) {
        this.idPenyelenggara = idPenyelenggara;
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

    public String getInstansiPenyelenggara() {
        return instansiPenyelenggara;
    }

    public void setInstansiPenyelenggara(String instansiPenyelenggara) {
        this.instansiPenyelenggara = instansiPenyelenggara;
    }

    public String getDeskripsiInstansi() {
        return deskripsiInstansi;
    }

    public void setDeskripsiInstansi(String deskripsiInstansi) {
        this.deskripsiInstansi = deskripsiInstansi;
    }
    
    
}
