package com.example.plantoterapiaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ModosPlantioMyAdapter extends RecyclerView.Adapter {
    //Responsável por construir e preencher a lista
    ModosPlantioActivity modosPlantioActivity;
    List<MyItem> modos_plantio;

    public ModosPlantioMyAdapter(ModosPlantioActivity modosPlantioActivity, List<MyItem> modos_plantio){
        this.modosPlantioActivity = modosPlantioActivity;
        this.modos_plantio = modos_plantio;
    }

    @NonNull
    //Cria a visualização do item
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(modosPlantioActivity);
        //Constroi uma view baseada em um arquivo de regra (item_list.xml)
        View v = inflater.inflate(R.layout.modos_plantio_list, parent, false);

        return new MyViewHolder(v);
    }
    //Preenche os elementos de interface
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyItem myItem = modos_plantio.get(position);
        View v = holder.itemView;
        ImageView imvPhoto = v.findViewById(R.id.imvModoPlantioFoto);
        imvPhoto.setImageBitmap(myItem.photo);

        TextView tvTitle = v.findViewById(R.id.tvModoPlantioTitulo);
        tvTitle.setText(myItem.title);

        TextView tvDescription = v.findViewById(R.id.tvModoPlantioDescricao);
        tvDescription.setText(myItem.description);

    }

    @Override
    public int getItemCount() {
        return modos_plantio.size();
    }
}
