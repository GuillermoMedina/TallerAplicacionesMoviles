package com.example.a12swipe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.daimajia.swipe.util.Attributes;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tvEmptyTextView;
    private RecyclerView mRecyclerView;
    private ArrayList<YoutuberModel> mDataSet;
    String nombre, nocontrol, carrera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvEmptyTextView = findViewById(R.id.empty_view);
        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mDataSet = new ArrayList<>();
        loadData();

        if (mDataSet.isEmpty()) {
            mRecyclerView.setVisibility(View.GONE);
            tvEmptyTextView.setVisibility(View.VISIBLE);
        } else {
            mRecyclerView.setVisibility(View.VISIBLE);
            tvEmptyTextView.setVisibility(View.GONE);
        }

        SwipeRecyclerViewAdapter mAdapter = new SwipeRecyclerViewAdapter(this, mDataSet);

        ((SwipeRecyclerViewAdapter) mAdapter).setMode(Attributes.Mode.Single);

        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.e("RecyclerView", "onScrollStateChanged");
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });



    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

    }

    /*private void agregarAlArreglo(String nombre, String control, String carrera) {
        for (int i = 0; i <= 9; i++) {
            if (i == 0) {
                nombre=nombre;
                nocontrol="15400788";
                mDataSet.add(new YoutuberModel(nombre, nocontrol + "\n"+"Carrera: Mantenimiento"));
            }
            if (i == 1) {
                nombre="CARDENAS RAMOS FRANCISCO EMANUEL";
                nocontrol="15400789";
                mDataSet.add(new YoutuberModel(nombre, nocontrol + "\n"+"Carrera:Civil"));
            }
            if (i == 2) {
                nombre="CASTILLO CORRALES VICTOR EMMANUEL";
                nocontrol="15400790";
                mDataSet.add(new YoutuberModel(nombre, nocontrol + "\n"+"Carrera:Bioquimica"));
            }
            if (i == 3) {
                nombre="CERVANTES JIMÉNEZ JOSÉ MIGUEL";
                nocontrol="15400791";
                mDataSet.add(new YoutuberModel(nombre, nocontrol + "\n"+"Carrera:Arquitectura"));
            }
            if (i == 4) {
                nombre="CORDERO RIVERA SELVA YAZMIN";
                nocontrol="15400792";
                mDataSet.add(new YoutuberModel(nombre, nocontrol + "\n"+"Carrera:ITIC"));
            }
            if (i == 5) {
                nombre="CORDERO VILLA OSCAR ALBERTO";
                nocontrol="15400793";
                mDataSet.add(new YoutuberModel(nombre, nocontrol + "\n"+"Carrera:Civil"));
            }

            if (i == 6) {
                nombre="ESPINOSA ABANDO DENISSE YANETH";
                nocontrol="15400794";
                mDataSet.add(new YoutuberModel(nombre, nocontrol + "\n"+"Carrera:Arquitectura"));
            }
            if (i == 7) {
                nombre="FIGUEROA CUETO JUAN RAMON";
                nocontrol="15400795";
                mDataSet.add(new YoutuberModel(nombre, nocontrol + "\n"+"Carrera:Quimica"));
            }
            if (i == 8) {
                nombre="GALLEGOS GODINEZ FRANCISCO JAVIER";
                nocontrol="15400796";
                mDataSet.add(new YoutuberModel(nombre, nocontrol + "\n"+"Carrera:Civil"));
            }
            if (i == 9) {
                nombre="GIL LLANOS JUAN PEDRO";
                nocontrol="15400797";
                mDataSet.add(new YoutuberModel(nombre, nocontrol + "\n"+"Carrera:Quimica"));
            }


        }
    }*/

    public void loadData() {

        for (int i = 0; i <= 9; i++) {
            if (i == 0) {
                nombre="ARANDA PATRON NOMAR JAZIE";
                nocontrol="15400788";
                carrera = "Mantenimiento";
                mDataSet.add(new YoutuberModel(nombre, nocontrol ,carrera));
            }
            if (i == 1) {
                nombre="CARDENAS RAMOS FRANCISCO EMANUEL";
                nocontrol="15400789";
                carrera = "Mantenimiento";
                mDataSet.add(new YoutuberModel(nombre, nocontrol , carrera));
            }
            if (i == 2) {
                nombre="CASTILLO CORRALES VICTOR EMMANUEL";
                nocontrol="15400790";
                carrera = "Mantenimiento";
                mDataSet.add(new YoutuberModel(nombre, nocontrol , carrera));
            }
            if (i == 3) {
                nombre="CERVANTES JIMÉNEZ JOSÉ MIGUEL";
                nocontrol="15400791";
                carrera = "Mantenimiento";
                mDataSet.add(new YoutuberModel(nombre, nocontrol, carrera));
            }
            if (i == 4) {
                nombre="CORDERO RIVERA SELVA YAZMIN";
                nocontrol="15400792";
                carrera = "Mantenimiento";
                mDataSet.add(new YoutuberModel(nombre, nocontrol , carrera));
            }
            if (i == 5) {
                nombre="CORDERO VILLA OSCAR ALBERTO";
                nocontrol="15400793";
                carrera = "Mantenimiento";
                mDataSet.add(new YoutuberModel(nombre, nocontrol, carrera));
            }

            if (i == 6) {
                nombre="ESPINOSA ABANDO DENISSE YANETH";
                nocontrol="15400794";
                carrera = "Mantenimiento";
                mDataSet.add(new YoutuberModel(nombre, nocontrol, carrera));
            }
            if (i == 7) {
                nombre="FIGUEROA CUETO JUAN RAMON";
                nocontrol="15400795";
                carrera = "Mantenimiento";
                mDataSet.add(new YoutuberModel(nombre, nocontrol, carrera));
            }
            if (i == 8) {
                nombre="GALLEGOS GODINEZ FRANCISCO JAVIER";
                nocontrol="15400796";
                carrera = "Mantenimiento";
                mDataSet.add(new YoutuberModel(nombre, nocontrol, carrera));
            }
            if (i == 9) {
                nombre="GIL LLANOS JUAN PEDRO";
                nocontrol="15400797";
                carrera = "Mantenimiento";
                mDataSet.add(new YoutuberModel(nombre, nocontrol, carrera));
            }


        }
    }

}
