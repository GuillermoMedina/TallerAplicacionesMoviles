package com.example.a23laboratoriosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    public SQLiteDatabase myDB;

    public ConexionSQLiteHelper(Context context) {
        super(context, Utilidades.DBNAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDB(){
        myDB=getWritableDatabase();
    }

    public void closeDB() {
        if (myDB != null && myDB.isOpen()) {
            myDB.close();
        }
    }

    public Cursor getAll(){

        String query="SELECT * FROM "+ Utilidades.TABLA;

        return myDB.rawQuery(query,null);

    }

    public long insert(String idAlumno, String nombre, String noCtrl, String cel, String mail, String carrera){

        ContentValues contenedor = new ContentValues();
        contenedor.put(Utilidades.IDALUMNO, idAlumno);
        contenedor.put(Utilidades.NOMBRE, nombre);
        contenedor.put(Utilidades.NOCTRL, noCtrl);
        contenedor.put(Utilidades.CEL, cel);
        contenedor.put(Utilidades.MAIL, mail);
        contenedor.put(Utilidades.CARRERA, carrera);

        return myDB.insert(Utilidades.TABLA,null, contenedor);
    }

    public String[] buscarCliente(String buscar){
        String[] datos = new String[8];
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "SELECT * FROM " + Utilidades.TABLA + " WHERE _id ='"+buscar+"'";
        Cursor registros = database.rawQuery(query, null);

        if (registros.moveToFirst()){
            for (int i=0; i<7; i++){
                datos[i] = registros.getString(i);
            }
            datos[7] = "Encontrado correctamente el cliente con el id: " + buscar;
        }else{
            datos[7] = "Nose encontro el Cliente con el id "+ buscar;
        }

        database.close();
        return datos;
    }

    public String actualizar(String id, String nombre, String noCtrl, String cel, String mail, String carrera){
        String mensaje = "";

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contenedor = new ContentValues();

        contenedor.put(Utilidades.IDALUMNO, id);
        contenedor.put(Utilidades.NOMBRE, nombre);
        contenedor.put(Utilidades.NOCTRL, noCtrl);
        contenedor.put(Utilidades.CEL, cel);
        contenedor.put(Utilidades.MAIL, mail);
        contenedor.put(Utilidades.CARRERA, carrera);

        int cantidad = database.update(Utilidades.TABLA, contenedor, "IDALUMNO='"+id+"'", null);

        if (cantidad!=0){
            mensaje = "Se Actualizado Correctamente el Cliente: " + nombre;
        }else{
            mensaje = "No se pudo Actualizar";
        }

        database.close();
        return mensaje;
    }
}
