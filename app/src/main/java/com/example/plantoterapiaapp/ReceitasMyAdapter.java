package com.example.plantoterapiaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReceitasMyAdapter extends RecyclerView.Adapter {
    //Responsável por construir e preencher a lista
    PlantaActivity plantaActivity;
    List<MyItem> receitas;

    public ReceitasMyAdapter(PlantaActivity plantaActivity, List<MyItem> receitas){
        this.plantaActivity = plantaActivity;
        this.receitas = receitas;
    }

    @NonNull
    //Cria a visualização do item
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(plantaActivity);
        //Constroi uma view baseada em um arquivo de regra (item_list.xml)
        View v = inflater.inflate(R.layout.receitas_list, parent, false);

        return new MyViewHolder(v);
    }
    //Preenche os elementos de interface
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyItem myItem = receitas.get(position);
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
        return receitas.size();
    }
}
