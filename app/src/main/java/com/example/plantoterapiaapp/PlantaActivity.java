package com.example.plantoterapiaapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.FileNotFoundException;
import java.util.List;

public class PlantaActivity extends AppCompatActivity {

    static int DISPLAY_ITEM_REQUEST = 1; // Define um valor inteiro

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planta);


        // Botão para ir a lista de estruturas químicas da planta
        Button btnEstruturasQuimicas = findViewById(R.id.btnEstruturasQuimicas);
        btnEstruturasQuimicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(PlantaActivity.this, EstruturasQuimicasActivity.class);
                startActivity(i1);
            }
        });


        // Botão para ir a lista de modos de plantio da planta
        Button btnModosPlantio = findViewById(R.id.btnModosPlantio);
        btnModosPlantio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(PlantaActivity.this, ModosPlantioActivity.class);
                startActivity(i2);
            }
        });

        // Botão para ir a lista de receitas da planta
        Button btnReceitas = findViewById(R.id.btnReceitas);
        btnReceitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(PlantaActivity.this, ReceitasActivity.class);
                startActivity(i3);
            }
        });

        // Define o título da planta
        TextView tvPlantaTitulo2 = findViewById(R.id.tvPlantaTitulo2);
        String title = getIntent().getStringExtra("title");
        tvPlantaTitulo2.setText(title);

        // Define a descrição da planta
        TextView tvPlantaDescricao = findViewById(R.id.tvPlantaDescricao);
        String descricao = getIntent().getStringExtra("description");
        tvPlantaDescricao.setText(descricao);

        // CÓDIGO PARA DEFINIR A FOTO DA PLANTA
    }

    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { // Função que ocorre ao receber um resultado anterior que foi pedido
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == DISPLAY_ITEM_REQUEST) { // Começa a definir uma parte de código que só vai ocorrer se o resultado pedido for referente ao pedido de mudar de algum resultado de antes, nesse caso identificado através do valor inteiro requestCode recebido desta função. Nesse caso, como a intenção executada que pediu resultado utilizou como inteiro o NEW_ITEM_REQUEST, isso será reconhecido como o requestCode desta função
            if(resultCode == Activity.RESULT_OK){ // Irá checar se o resultado pedido foi realizado com sucesso, nesse caso, se o ok foi dado em alguma hora para a atividade. Caso sim, o código seguinte rodará

                TextView tvPlantaTitulo2 = findViewById(R.id.tvPlantaTitulo2);
                String title = data.getStringExtra("title");
                tvPlantaTitulo2.setText(title);


                /*
                MyItem newItem = new MyItem(); // Cria um item utilizando a classe criada especificamente para criar itens

                Uri selectedPhotoLocation = data.getData(); // Define uma Uri com a Uri (endereço) da imagem escolhida pelo usuário, que no caso foi recebido na função como o valor data, que continha uma intenção reccebida com valor de Uri
                try {
                    Bitmap photo = Util.getBitmap(MainActivity.this, selectedPhotoLocation, 400, 200); // Pega a imagem de acordo com a Uri, cria um bitmap dela e reescala a imagem
                    newItem.photo = photo; // Define a foto do item como a foto criado acima com o Uri informado
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                String title = data.getStringExtra("title"); // Define uma string com o valor extra do título que foi colocado anteriormente na intenção que serviu de resultado para esta função
                String description = data.getStringExtra("description"); // Define uma string com o valor extra da descrição que foi colocada anteriormente na intenção que serviu de resultado para esta função

                newItem.title = title; // Define a o título do item criado anteriormente como o título definido aqui anteriormente
                newItem.description = description; // Define a descrição da foto do item criado anteriormente como a descrição definida aqui anteriormente


                MyViewModel vm = new ViewModelProvider(this).get(MyViewModel.class); // Pega um viewmodel do mainactivityviewmodel para este main

                List<MyItem> plantas = vm.getPlantas(); // Pega a lista de itens no viewmodel recebido

                plantas.add(newItem); // Adiciona na lista de itens o item criado anteriormente

                plantasMyAdapter.notifyDataSetChanged(); // Avisa que um novo item foi criado

            }
        }
    } */

    // Configura a atividade que inicia antes que o usuário comece a mexer
    @Override
    protected void onStart() {
        super.onStart();
    }

    // Configura a atividade quando recomeçada pelo usuário
    @Override
    protected void onRestart() {
        super.onRestart();
    }

    // Configura a atividade ao ser resumida pelo usuário
    @Override
    protected void onResume() {
        super.onResume();
    }

    // Configura a atividade quando pausada pelo usuário
    @Override
    protected void onPause() {
        super.onPause();
    }

    // Configura a atividade quando encerrada pelo usuário
    @Override
    protected void onStop() {
        super.onStop();
    }

    // Destrói tudo que tinha na atividade depois de ser encerrada
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}