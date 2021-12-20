package com.example.plantoterapiaapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.FileNotFoundException;
import java.util.List;

public class PlantaActivity extends AppCompatActivity {

    static int NEW_ITEM_REQUEST = 1; // Define um valor inteiro

    ReceitasMyAdapter receitasMyAdapter;
    ModosPlantioMyAdapter modosPlantioMyAdapter;
    EstruturasQuimicasMyAdapter estruturasQuimicasMyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planta);

        FloatingActionButton fabCriarPost = findViewById(R.id.fabCriarPost); // Define um floatingactionbutton da interface através de seu id
        fabCriarPost.setOnClickListener(new View.OnClickListener() { // Define o que ocorre ao clicar no botão definido
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlantaActivity.this, CriarPostActivity.class); // Cria uma intenção onde o usuário vai do MainActivity até o NewItemActivity
                startActivityForResult(i, NEW_ITEM_REQUEST); // Executa a intenção criada, para depois receber certo resultado, que será identificado pelo valor inteiro criado
            }
        });

        PlantaActivityViewModel vm = new ViewModelProvider(this).get(PlantaActivityViewModel.class); // Pega um viewmodel do mainactivityviewmodel para este main

        List<MyItem> receitas = vm.getReceitas(); // Pega a lista de itens no viewmodel recebido
        List<MyItem> modos_plantio = vm.getModos_plantio(); // Pega a lista de itens no viewmodel recebido
        List<MyItem> estruturas_quimicas = vm.getEstruturas_quimicas(); // Pega a lista de itens no viewmodel recebido

        receitasMyAdapter = new ReceitasMyAdapter(this, receitas); // Cria uma variável do tipo MyAdapter que recebe a lista de itens
        modosPlantioMyAdapter = new ModosPlantioMyAdapter(this, receitas); // Cria uma variável do tipo MyAdapter que recebe a lista de itens
        estruturasQuimicasMyAdapter = new EstruturasQuimicasMyAdapter(this, receitas); // Cria uma variável do tipo MyAdapter que recebe a lista de itens

        RecyclerView rvReceitas = findViewById(R.id.rvReceitas); // Define um recyclerview da interface através de seu id
        rvReceitas.setHasFixedSize(true); // Define que cada item da lista terá um tamanho igual (é algo que aumenta a velocidade)

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this); // Cria um tipo de layout de recyclerview, nesse caso linear
        rvReceitas.setLayoutManager(layoutManager); // Define como os itens da lista serão apresentados, nesse caso sendo de modo linear de acordo com o layout de recyclerview criado anteriormente

        rvReceitas.setAdapter(receitasMyAdapter); // Define qual adapter que vai construir os itens da lista
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { // Função que ocorre ao receber um resultado anterior que foi pedido
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == NEW_ITEM_REQUEST) { // Começa a definir uma parte de código que só vai ocorrer se o resultado pedido for referente ao pedido de mudar de algum resultado de antes, nesse caso identificado através do valor inteiro requestCode recebido desta função. Nesse caso, como a intenção executada que pediu resultado utilizou como inteiro o NEW_ITEM_REQUEST, isso será reconhecido como o requestCode desta função
            if(resultCode == Activity.RESULT_OK){ // Irá checar se o resultado pedido foi realizado com sucesso, nesse caso, se o ok foi dado em alguma hora para a atividade. Caso sim, o código seguinte rodará
                MyItem newItem = new MyItem(); // Cria um item utilizando a classe criada especificamente para criar itens

                Uri selectedPhotoLocation = data.getData(); // Define uma Uri com a Uri (endereço) da imagem escolhida pelo usuário, que no caso foi recebido na função como o valor data, que continha uma intenção reccebida com valor de Uri
                try {
                    Bitmap photo = Util.getBitmap(PlantaActivity.this, selectedPhotoLocation, 400, 200); // Pega a imagem de acordo com a Uri, cria um bitmap dela e reescala a imagem
                    newItem.photo = photo; // Define a foto do item como a foto criado acima com o Uri informado
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                String title = data.getStringExtra("title"); // Define uma string com o valor extra do título que foi colocado anteriormente na intenção que serviu de resultado para esta função
                String description = data.getStringExtra("description"); // Define uma string com o valor extra da descrição que foi colocada anteriormente na intenção que serviu de resultado para esta função

                newItem.title = title; // Define a o título do item criado anteriormente como o título definido aqui anteriormente
                newItem.description = description; // Define a descrição da foto do item criado anteriormente como a descrição definida aqui anteriormente


                PlantaActivityViewModel vm = new ViewModelProvider(this).get(MainActivityViewModel.class); // Pega um viewmodel do mainactivityviewmodel para este main

                List<MyItem> itens = vm.getReceitas(); // Pega a lista de itens no viewmodel recebido

                itens.add(newItem); // Adiciona na lista de itens o item criado anteriormente

                receitasMyAdapter.notifyItemInserted(itens.size()-1); // Avisa que um novo item foi criado
            }
        }
    }

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