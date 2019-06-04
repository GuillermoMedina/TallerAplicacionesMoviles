package com.example.laboratoriobd1;

public class Utilidades {

    public static String TABLA = "CONDUCTOR";
    public static String IDCONDUCTOR = "IDCONDUCTOR";
    public static String NUMEROLIC = "NUMEROLIC";
    public static String MONTO = "MONTO";
    public static String PUNTOS ="PUNTOS";
    public static String CEL ="CEL";
    public static String MAIL ="MAIL";
    public static String ID="_id";

    public static final String DBNAME="BASEDEDATOS";


    public static String CREAR_TABLA="CREATE TABLE "+TABLA+"("+
            ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            IDCONDUCTOR+" TEXT NOT NULL, "+
            NUMEROLIC+" TEXT, "+
            MONTO+" TEXT, " +
            PUNTOS+" TEXT, " +
            CEL+" TEXT, " +
            MAIL+" TEXT)";

}
