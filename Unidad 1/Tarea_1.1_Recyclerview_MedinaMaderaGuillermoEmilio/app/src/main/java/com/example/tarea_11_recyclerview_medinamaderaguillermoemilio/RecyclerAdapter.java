package com.example.tarea_11_recyclerview_medinamaderaguillermoemilio;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

/**
 * Created by lenovo on 20/02/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private String[] nombres, control, carrera;
    private Context contexto;

    public RecyclerAdapter(String[] nombres, String[] control, String[] carrera, Context context) {
        this.nombres = nombres;
        this.control = control;
        this.carrera = carrera;
        this.contexto = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;


    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        holder.campo_nombre.setText(nombres[position]);
        holder.campo_control.setText(control[position]);
        holder.campo_carrera.setText(carrera[position]);

        holder.alumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(contexto, "Se va a editar la informacion de: "+nombres[position], Toast.LENGTH_LONG).show();
            }
        });

        holder.basura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(contexto, "Se va a eliminar: "+nombres[position], Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return nombres.length;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView campo_nombre,campo_control,campo_carrera;

        ImageView alumno, basura;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            campo_nombre = itemView.findViewById(R.id.alumno_id);
            campo_control = itemView.findViewById(R.id.noControl);
            campo_carrera = itemView.findViewById(R.id.carrera);

            alumno = itemView.findViewById(R.id.contacto);
            basura = itemView.findViewById(R.id.borrar);


        }
    }

}
