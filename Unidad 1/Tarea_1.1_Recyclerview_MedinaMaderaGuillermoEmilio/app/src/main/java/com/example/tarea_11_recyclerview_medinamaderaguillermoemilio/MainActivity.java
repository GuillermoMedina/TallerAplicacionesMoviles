package com.example.tarea_11_recyclerview_medinamaderaguillermoemilio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    String [] nombres={"ARANDA PATRON NOMAR ",
            "CARDENAS RAMOS FRANCISCO ",
            "CASTILLO CORRALES VICTOR ",
            "CERVANTES JIMÉNEZ JOSÉ ",
            "CORDERO RIVERA YAZMIN",
            "CORDERO VILLA OSCAR ",
            "ESPINOSA ABANDO DENISSE ",
            "FIGUEROA CUETO JUAN ",
            "GALLEGOS GODINEZ FRANCISCO ",
            "PEREZ ARAIZA FLOR MARIELA",
            "PUGA FLORES CARLOS",
            "REYES GODINEZ CARLA ",
            "REYES GUERRERO GUILLERMO ",
            "RICO ESPARZA HENRY",
            "RIVERA RAMIREZ DAVID",
            "SANCHEZ CARRILLO BETSY ",
            "SILVA CAMACHO EDUARDO LUIS",
            "TORRES CUETO JESUS MANUEL",
            "VALDEZ LOPEZ HOLLIVER ",
            "VALENZUELA MIRAMONTES JOSE PABLO",
            "ZAMORANO ALCALÁ GUILLERMO"};

    String [] control = {"15400790",
            "15400791",
            "15400792",
            "15400793",
            "15400794",
            "15400795",
            "15400796",
            "15400797",
            "15400798",
            "15400799",
            "15400800",
            "15400801",
            "15400802",
            "15400803",
            "15400804",
            "15400805",
            "15400806",
            "15400807",
            "15400808",
            "15400809",
            "15400810"};

    String [] carrera = {"ITICS",
            "Sistemas",
            "Civil",
            "Arquitectura",
            "ITICS",
            "Sistemas",
            "Civil",
            "Arquitectura",
            "ITICS",
            "Sistemas",
            "Civil",
            "Arquitectura",
            "ITICS",
            "Sistemas",
            "Civil",
            "Arquitectura",
            "ITICS",
            "Sistemas",
            "Civil",
            "Arquitectura",
            "ITICS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Crear referencias hacia el componente RecycleriView
        recyclerView = findViewById(R.id.recycler_id);

        // Crear un objeto de tipo RecyclerAdapter que recibe un arreglo de cadenas
        adapter = new RecyclerAdapter(nombres, control, carrera, this);

        // Crea un objeto de tipo LinearLayoutManager
        layoutManager = new LinearLayoutManager(this);

        // Establecer el LayautManager
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        // Establecer el Adapter
        recyclerView.setAdapter(adapter);

    }
}
