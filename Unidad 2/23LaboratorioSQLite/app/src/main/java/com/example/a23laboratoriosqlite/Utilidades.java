package com.example.a23laboratoriosqlite;

public class Utilidades {

    public static String TABLA = "ALUMNO";
    public static String IDALUMNO = "IDALUMNO";
    public static String NOMBRE = "NOMBRE";
    public static String NOCTRL = "NOCTRL";
    public static String CEL="CEL";
    public static String MAIL="MAIL";
    public static String CARRERA="CARRERA";
    public static String ID="_id";

    public static final String DBNAME="BASEDEDATOS";


    public static String CREAR_TABLA="CREATE TABLE "+TABLA+"("+
            ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            IDALUMNO+" TEXT NOT NULL, "+
            NOMBRE+" TEXT, "+
            NOCTRL+" TEXT, " +
            CEL+" TEXT, " +
            MAIL+" TEXT, " +
            CARRERA+" TEXT)";

}
