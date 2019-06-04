package com.example.a23laboratoriosqlite;

public class Alumno
{
    private int idAlumno;
    private String nombre;
    private String noCtrl;
    private String cel;
    private String mail;
    private String carrera;

    public Alumno(int idAlumno, String nombre, String noCtrl, String cel, String mail, String carrera) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.noCtrl = noCtrl;
        this.cel = cel;
        this.mail = mail;
        this.carrera = carrera;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idCliente) {
        this.idAlumno = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNoCtrl() {
        return noCtrl;
    }

    public void setNoCtrl(String noCtrl) {
        this.noCtrl = noCtrl;
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

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
