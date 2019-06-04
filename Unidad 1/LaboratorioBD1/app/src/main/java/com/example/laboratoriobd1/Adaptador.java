package com.example.laboratoriobd1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolderConductores>{
    ArrayList<Conductor> listaConductores;

    Context context;

    public Adaptador(ArrayList<Conductor> listaClientes, Context context){
        this.listaConductores = listaClientes;
        this.context = context;
    }

    @Override
    public ViewHolderConductores onCreateViewHolder(ViewGroup viewGroup, int i) {
        int layout = R.layout.vista;
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layout, null, false);
        return new ViewHolderConductores(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderConductores viewHolderClientes, int i) {

        ViewHolderConductores.id.setText("ID: "+listaClientes.get(i).getIdCliente());
        ViewHolderConductores.num.setText("Nombre: "+listaClientes.get(i).getNombre());
        ViewHolderConductores.rfc.setText("RFC: "+listaClientes.get(i).getRfc());
        ViewHolderConductores.cel.setText("Celular: "+listaClientes.get(i).getCel());
        ViewHolderConductores.descripcion.setText("Descripcion: "+listaClientes.get(i).getDescripcion());
        ViewHolderConductores.costo.setText("Costo: "+listaClientes.get(i).getCosto());


    }

    @Override
    public int getItemCount() {
        return listaClientes.size();
    }

    public class ViewHolderConductores extends RecyclerView.ViewHolder{

        TextView id, nombre, rfc, cel, descripcion, costo;

        public ViewHolderConductores(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            nombre = itemView.findViewById(R.id.nombre);
            rfc = itemView.findViewById(R.id.rfc);
            cel = itemView.findViewById(R.id.cel);
            descripcion = itemView.findViewById(R.id.descripcion);
            costo = itemView.findViewById(R.id.costo);
        }
    }
}
