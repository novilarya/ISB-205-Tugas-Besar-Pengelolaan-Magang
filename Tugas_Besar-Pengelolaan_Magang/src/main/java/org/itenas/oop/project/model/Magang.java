package org.itenas.oop.project.model;
/**
 *
 * @author aryan
 */
public class Magang {
    private String kodeMagang;
    private String judulMagang;
    private String penyelenggara;
    private String lokasi;
    private String tipeMagang;
    private String posisiMagang;
    private String deskripsiMagang;
    private String kualifikasiMagang;

    public Magang() {
    }

    public Magang(String kodeMagang, String judulMagang, String penyelenggara, String lokasi, String tipeMagang, String posisiMagang, String deskripsiMagang, String kualifikasiMagang) {
        this.kodeMagang = kodeMagang;
        this.judulMagang = judulMagang;
        this.penyelenggara = penyelenggara;
        this.lokasi = lokasi;
        this.tipeMagang = tipeMagang;
        this.posisiMagang = posisiMagang;
        this.deskripsiMagang = deskripsiMagang;
        this.kualifikasiMagang = kualifikasiMagang;
    }

    public String getKodeMagang() {
        return kodeMagang;
    }

    public void setKodeMagang(String kodeMagang) {
        this.kodeMagang = kodeMagang;
    }

    public String getJudulMagang() {
        return judulMagang;
    }

    public void setJudulMagang(String judulMagang) {
        this.judulMagang = judulMagang;
    }

    public String getPenyelenggara() {
        return penyelenggara;
    }

    public void setPenyelenggara(String penyelenggara) {
        this.penyelenggara = penyelenggara;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getTipeMagang() {
        return tipeMagang;
    }

    public void setTipeMagang(String tipeMagang) {
        this.tipeMagang = tipeMagang;
    }

    public String getPosisiMagang() {
        return posisiMagang;
    }

    public void setPosisiMagang(String posisiMagang) {
        this.posisiMagang = posisiMagang;
    }

    public String getDeskripsiMagang() {
        return deskripsiMagang;
    }

    public void setDeskripsiMagang(String deskripsiMagang) {
        this.deskripsiMagang = deskripsiMagang;
    }

    public String getKualifikasiMagang() {
        return kualifikasiMagang;
    }

    public void setKualifikasiMagang(String kualifikasiMagang) {
        this.kualifikasiMagang = kualifikasiMagang;
    }

    
    
}
