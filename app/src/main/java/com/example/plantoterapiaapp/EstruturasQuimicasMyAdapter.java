package com.example.plantoterapiaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EstruturasQuimicasMyAdapter extends RecyclerView.Adapter {
    //Responsável por construir e preencher a lista
    PlantaActivity plantaActivity;
    List<MyItem> estruturas_quimicas;

    public EstruturasQuimicasMyAdapter(PlantaActivity plantaActivity, List<MyItem> estruturas_quimicas){
        this.plantaActivity = plantaActivity;
        this.estruturas_quimicas = estruturas_quimicas;
    }

    @NonNull
    //Cria a visualização do item
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(plantaActivity);
        //Constroi uma view baseada em um arquivo de regra (item_list.xml)
        View v = inflater.inflate(R.layout.estruturas_quimicas_list, parent, false);

        return new MyViewHolder(v);
    }
    //Preenche os elementos de interface
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyItem myItem = estruturas_quimicas.get(position);
        View v = holder.itemView;
        ImageView imvPhoto = v.findViewById(R.id.imvEstruturaQuimicaFoto);
        imvPhoto.setImageBitmap(myItem.photo);

        TextView tvTitle = v.findViewById(R.id.tvEstruturaQuimicaTitulo);
        tvTitle.setText(myItem.title);

        TextView tvDescription = v.findViewById(R.id.tvEstruturaQuimicaDescricao);
        tvDescription.setText(myItem.description);

    }

    @Override
    public int getItemCount() {
        return estruturas_quimicas.size();
    }
}
