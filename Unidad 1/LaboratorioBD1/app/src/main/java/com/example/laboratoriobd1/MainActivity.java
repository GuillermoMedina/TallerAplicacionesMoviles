package com.example.laboratoriobd1;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    ConexionSQLiteHelper con;

    ArrayList<Conductor> listaConductores;

    RecyclerView listaObjetos;
    private RecyclerView.LayoutManager mLayaotManager;
    Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        con = new ConexionSQLiteHelper(MainActivity.this);

        init();
    }


    @Override
    protected void onStart() {
        super.onStart();
        con.openDB();
    }

    @Override
    protected void onStop() {
        super.onStop();
        con.closeDB();
    }

    private void init() {
        listaObjetos= findViewById(R.id.carview);
        listaObjetos.setLayoutManager(new LinearLayoutManager(this));
        listaConductores=new ArrayList<>();
    }

    /*private View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.imageButton4:
                    Toast.makeText(MainActivity.this,"Lista de Clientes cargada correctamente",Toast.LENGTH_SHORT).show();
                    listardatos();
                    break;
            }
        }
    };*/

    private void listardatos() {
        try {

            listaConductores = new ArrayList<>();
            StringBuffer datos = new StringBuffer();
            Cursor cursor = con.getAll();

            for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
                datos.append(cursor.getInt(cursor.getColumnIndex(Utilidades.IDCONDUCTOR)));
                datos.append(" - ");
                datos.append(cursor.getString(cursor.getColumnIndex(Utilidades.NUMEROLIC)));
                datos.append(" - ");
                datos.append(cursor.getString(cursor.getColumnIndex(Utilidades.MONTO)));
                datos.append(" - ");
                datos.append(cursor.getString(cursor.getColumnIndex(Utilidades.PUNTOS)));
                datos.append(" - ");
                datos.append(cursor.getString(cursor.getColumnIndex(Utilidades.CEL));
                datos.append(" - ");
                datos.append(cursor.getString(cursor.getColumnIndex(Utilidades.MAIL)));
                datos.append("\n");
                listaConductores.add(new Conductor(cursor.getInt(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6)));
            }
            adaptador = new Adaptador(listaConductores, getApplicationContext());
            listaObjetos.setAdapter(adaptador);

        }catch (SQLException e) {

        }

    }

    /*Insertar Datos del cliente en la base de datos
    public Long registrarClientes() {

        return con.insert(idCliente.getText().toString(), nombre.getText().toString(), rfc.getText().toString(), cel.getText().toString(), descripcion.getText().toString(), costo.getText().toString());

    }*/


    /*private void consultarCliente(String buscarId) {

        ConexionSQLiteHelper db = new ConexionSQLiteHelper(MainActivity.this);
        String[] datos;
        datos = db.buscarCliente(buscarId);

        idCliente.setText(datos[1]);
        nombre.setText(datos[2]);
        rfc.setText(datos[3]);
        cel.setText(datos[4]);
        descripcion.setText(datos[5]);
        costo.setText(datos[6]);

        Toast.makeText(MainActivity.this, "Se encontro correctamente el cliente con el id: "+ buscarId, Toast.LENGTH_LONG).show();

    }*/

}
