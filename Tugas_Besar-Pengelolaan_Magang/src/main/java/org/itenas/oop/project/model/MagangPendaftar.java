/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.oop.project.model;

/**
 *
 * @author aryan
 */
public class MagangPendaftar {
    private int kodeSeleksi;
    private String nama;
    private String jenisKelamin;
    private String pendidikanSaatIni;
    private int umur;
    private String judulMagang;

    public MagangPendaftar() {
    }

    public MagangPendaftar(int kodeSeleksi, String nama, String jenisKelamin, String pendidikanSaatIni, int umur, String judulMagang) {
        this.kodeSeleksi = kodeSeleksi;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.pendidikanSaatIni = pendidikanSaatIni;
        this.umur = umur;
        this.judulMagang = judulMagang;
    }

    public int getKodeSeleksi() {
        return kodeSeleksi;
    }

    public void setKodeSeleksi(int kodeSeleksi) {
        this.kodeSeleksi = kodeSeleksi;
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

    public String getJudulMagang() {
        return judulMagang;
    }

    public void setJudulMagang(String judulMagang) {
        this.judulMagang = judulMagang;
    }

        
}
