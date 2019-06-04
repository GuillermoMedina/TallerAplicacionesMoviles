package com.example.a33consumowebrecycler;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.MyViewHolder> {

    private Context context;
    private List<Item> list;

    public CardListAdapter(Context context, List<Item> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_list_item, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {

        final Item item = list.get(i);
        myViewHolder.noControl.setText(item.getNctrl());
        myViewHolder.nombre.setText(item.getName());
        myViewHolder.u1.setText(item.getU1());
        myViewHolder.u2.setText(item.getU2());
        myViewHolder.u3.setText(item.getU3());

        int cal1 = Integer.parseInt(myViewHolder.u1.getText().toString());
        int cal2 = Integer.parseInt(myViewHolder.u2.getText().toString());
        int cal3 = Integer.parseInt(myViewHolder.u3.getText().toString());
        colorRojo(cal1, cal2, cal3, myViewHolder);

    }

    private void colorRojo(int cali1, int cali2, int cali3, MyViewHolder myViewHolder) {


        if (cali1>=70 && cali2>=70 && cali3>=70){
            myViewHolder.viewForeground.setBackgroundColor(Color.parseColor("#FF4CAF50"));
        }
        else{
            if (cali1<70 && cali2<70 && cali3<70){
                myViewHolder.viewForeground.setBackgroundColor(Color.parseColor("#FFFF0707"));
            }
            else{
                myViewHolder.viewForeground.setBackgroundColor(Color.parseColor("#FFFFC107"));
            }
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void removeItem(int posicion){
        list.remove(posicion);
        notifyItemRemoved(posicion);
        notifyItemRangeChanged(posicion, list.size());
    }

    public void restoreItem(Item item, int posicion){
        list.add(posicion, item);
        notifyItemInserted(posicion);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView noControl, nombre, u1,  u2, u3;
        public RelativeLayout viewBackgroud, viewForeground;
        public ConstraintLayout cons;
        public FrameLayout frameLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            frameLayout = itemView.findViewById(R.id.frame);
            noControl = itemView.findViewById(R.id.NoControl);
            nombre = itemView.findViewById(R.id.Nombre);
            u1 = itemView.findViewById(R.id.U1);
            u2 = itemView.findViewById(R.id.U2);
            //viewBackgroud = itemView.findViewById(R.id.view_background);
            viewForeground = itemView.findViewById(R.id.view_foreground);
            u3 = itemView.findViewById(R.id.U3);
        }
    }

}
