package com.example.plantoterapiaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class PlantasMyAdapter extends RecyclerView.Adapter {
    //Responsável por construir e preencher a lista
    MainActivity mainActivity;
    List<MyItem> itens;
    ItemClickListener mItemListener;


    public PlantasMyAdapter(MainActivity mainActivity, List<MyItem> itens, ItemClickListener itemClickListener){
        this.mainActivity = mainActivity;
        this.itens = itens;
        this.mItemListener = itemClickListener;
    }


    @NonNull
    //Cria a visualização do item
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mainActivity);
        //Constroi uma view baseada em um arquivo de regra (item_list.xml)
        View v = inflater.inflate(R.layout.plantas_list, parent, false);

        return new MyViewHolder(v);
    }
    //Preenche os elementos de interface
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyItem myItem = itens.get(position);
        View v = holder.itemView;
        ImageView imvPhoto = v.findViewById(R.id.imvPlantaFoto);
        imvPhoto.setImageBitmap(myItem.photo);

        TextView tvTitle = v.findViewById(R.id.tvPlantaTitulo);
        tvTitle.setText(myItem.title);

        holder.itemView.setOnClickListener(view -> {
            mItemListener.onItemClick(itens.get(position));
        });

    }

    @Override
    public int getItemCount() {
        return itens.size();
    }

    public  interface ItemClickListener{
        void onItemClick(MyItem item);
    }
}

