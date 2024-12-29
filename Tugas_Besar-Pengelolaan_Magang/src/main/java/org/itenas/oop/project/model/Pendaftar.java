package org.itenas.oop.project.model;

/**
 *
 * @author aryan
 */
public class Pendaftar {
    private String idPendaftar;
    private String username;
    private String password;
    private String nama;
    private String jenisKelamin;
    private String pendidikanSaatIni;
    private int umur;

    public Pendaftar() {
    }

    public Pendaftar(String idPendaftar, String username, String password, String nama, String jenisKelamin, String pendidikanSaatIni, int umur) {
        this.idPendaftar = idPendaftar;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.pendidikanSaatIni = pendidikanSaatIni;
        this.umur = umur;
    }

    public String getIdPendaftar() {
        return idPendaftar;
    }

    public void setIdPendaftar(String idPendaftar) {
        this.idPendaftar = idPendaftar;
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

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getPendidikanSaatIni() {
        return pendidikanSaatIni;
    }

    public void setPendidikanSaatIni(String pendidikanSaatIni) {
        this.pendidikanSaatIni = pendidikanSaatIni;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }
    
    
}
