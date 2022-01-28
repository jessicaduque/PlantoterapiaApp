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
    ReceitasActivity receitasActivity;
    List<MyItem> receitas;

    public ReceitasMyAdapter(ReceitasActivity receitasActivity, List<MyItem> receitas){
        this.receitasActivity = receitasActivity;
        this.receitas = receitas;
    }

    @NonNull
    //Cria a visualização do item
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(receitasActivity);
        //Constroi uma view baseada em um arquivo de regra (item_list.xml)
        View v = inflater.inflate(R.layout.receitas_list, parent, false);

        return new MyViewHolder(v);
    }
    //Preenche os elementos de interface
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyItem myItem = receitas.get(position);
        View v = holder.itemView;
        ImageView imvPhoto = v.findViewById(R.id.imvReceitaFoto);
        imvPhoto.setImageBitmap(myItem.photo);

        TextView tvTitle = v.findViewById(R.id.tvReceitaTitulo);
        tvTitle.setText(myItem.title);

        TextView tvDescription = v.findViewById(R.id.tvReceitaDescricao);
        tvDescription.setText(myItem.description);

    }

    @Override
    public int getItemCount() {
        return receitas.size();
    }
}
