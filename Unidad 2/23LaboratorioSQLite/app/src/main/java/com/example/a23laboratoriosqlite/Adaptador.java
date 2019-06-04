package com.example.a23laboratoriosqlite;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolderAlumnos> {

    ArrayList<Alumno> listaAlumnos;

    Context context;

    public Adaptador(ArrayList<Alumno> listaAlumnos, Context context){
        this.listaAlumnos = listaAlumnos;
        this.context = context;
    }

    @Override
    public ViewHolderAlumnos onCreateViewHolder(ViewGroup viewGroup, int i) {
        int layout = R.layout.vista;
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layout, null, false);
        return new ViewHolderAlumnos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderAlumnos viewHolderAlumnos, int i) {

        //viewHolderClientes.id.setText("ID: "+listaClientes.get(i).getIdCliente());
        viewHolderAlumnos.nombre.setText("Nombre: "+listaAlumnos.get(i).getNombre());
        viewHolderAlumnos.noCtrl.setText(": "+listaAlumnos.get(i).getNoCtrl());
        viewHolderAlumnos.cel.setText("Celular: "+listaAlumnos.get(i).getCel());
        viewHolderAlumnos.mail.setText("Descripcion: "+listaAlumnos.get(i).getMail());
        viewHolderAlumnos.carrera.setText("Costo: "+listaAlumnos.get(i).getCarrera());


    }

    @Override
    public int getItemCount() {
        return listaAlumnos.size();
    }

    public class ViewHolderAlumnos extends RecyclerView.ViewHolder{

        TextView id, nombre, noCtrl, cel, mail, carrera;

        public ViewHolderAlumnos(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            nombre = itemView.findViewById(R.id.nombre);
            noCtrl = itemView.findViewById(R.id.noCtrl);
            cel = itemView.findViewById(R.id.cel);
            mail = itemView.findViewById(R.id.mail);
            carrera = itemView.findViewById(R.id.carrera);
        }
    }
}
