package com.example.a23laboratoriosqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    EditText buscar, id, nombre, noCtrl, cel, mail, carrera;
    Button btnVerDatos, btnActualizar, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        buscar = findViewById(R.id.buscar);
        id = findViewById(R.id.id);
        nombre = findViewById(R.id.nombre);
        noCtrl = findViewById(R.id.noCtrl);
        cel = findViewById(R.id.cel);
        mail = findViewById(R.id.mail);
        carrera = findViewById(R.id.carrera);

        btnVerDatos = findViewById(R.id.btnVerDatos);
        btnActualizar = findViewById(R.id.btnActualizar);
        btnRegresar = findViewById(R.id.btnRegresar);

        btnVerDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id.setText("");
                ConexionSQLiteHelper db = new ConexionSQLiteHelper(Main3Activity.this);
                String buscarId = buscar.getText().toString();
                String[] datos;
                datos = db.buscarCliente(buscarId);

                id.setText(datos[1]);
                nombre.setText(datos[2]);
                noCtrl.setText(datos[3]);
                cel.setText(datos[4]);
                mail.setText(datos[5]);
                carrera.setText(datos[6]);
                id.setEnabled(false);
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConexionSQLiteHelper db = new ConexionSQLiteHelper(Main3Activity.this);
                String txtId = id.getText().toString();
                String txtNombre = nombre.getText().toString();
                String txtNoCtrl = noCtrl.getText().toString();
                String txtCel = cel.getText().toString();
                String txtMail = mail.getText().toString();
                String txtCarrera = carrera.getText().toString();

                String mensaje = db.actualizar(txtId, txtNombre, txtNoCtrl, txtCel, txtMail, txtCarrera);

                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
                buscar.setText("");
                id.setText("");
                nombre.setText("");
                noCtrl.setText("");
                cel.setText("");
                mail.setText("");
                carrera.setText("");
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
