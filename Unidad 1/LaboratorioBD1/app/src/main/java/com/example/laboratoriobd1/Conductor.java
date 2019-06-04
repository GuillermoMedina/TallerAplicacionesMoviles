package com.example.laboratoriobd1;

public class Conductor {
    private int idConductor;
    private String numeroLic;
    private String monto;
    private String puntos;
    private String cel;
    private String mail;

    public Conductor(int idConductor, String numeroLic, String monto, String puntos, String cel, String mail) {
        this.idConductor = idConductor;
        this.numeroLic = numeroLic;
        this.monto = monto;
        this.puntos = puntos;
        this.cel = cel;
        this.mail = mail;
    }

    public int getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(int idConductor) {
        this.idConductor = idConductor;
    }

    public String getNumeroLic() {
        return numeroLic;
    }

    public void setNumeroLic(String numeroLic) {
        this.numeroLic = numeroLic;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
