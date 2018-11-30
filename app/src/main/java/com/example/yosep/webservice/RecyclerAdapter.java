package com.example.yosep.webservice;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Componentes> list = new ArrayList<>();

    RecyclerAdapter(List<Componentes> list){

        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {

        viewHolder.tv_marca.setText(list.get(i).getMarca());
        viewHolder.tv_descripcion.setText(list.get(i).getDescripcion());
        viewHolder.tv_precio.setText(Integer.toString(list.get(i).getPrecio()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_marca,tv_descripcion,tv_precio;

        public MyViewHolder(View itemView){

            super(itemView);

            tv_marca = (TextView)itemView.findViewById(R.id.marcarow);
            tv_descripcion = (TextView)itemView.findViewById(R.id.descripcionrow);
            tv_precio = (TextView)itemView.findViewById(R.id.preciorow);

        }

    }

}
