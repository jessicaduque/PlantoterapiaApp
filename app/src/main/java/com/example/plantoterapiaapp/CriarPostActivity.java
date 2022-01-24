package com.example.plantoterapiaapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class CriarPostActivity extends AppCompatActivity {

    //Declara um valor inteiro estático para o requerimento da imagem
    static int PHOTO_PICKER_REQUEST = 1;
    String tipo_post = "nenhum";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_post);

        CriarPostActivityViewModel vm = new ViewModelProvider(this).get(CriarPostActivityViewModel.class);

        Uri selectedPhotoLocation = vm.getSelectedPhotoLocation();
        if(selectedPhotoLocation != null){
            ImageView imvPhotoPreview = findViewById(R.id.imvPhotoPreviewPlanta);
            imvPhotoPreview.setImageURI(selectedPhotoLocation);

        }

        //Quando o botão de imagem for clicado irá abrir a galeria do celular para selecionar um documento tipo imagem
        ImageButton imgChooseImage = findViewById(R.id.imbChooseImagePost);
        imgChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                photoPickerIntent.setType("image/*"); //Uma imagem de qualquer tipo, não restrito a um formato(ex:jpeg)
                startActivityForResult(photoPickerIntent, PHOTO_PICKER_REQUEST);
            }
        });

        // CÓDIGO AO CLICAR NO BOTÃO DO TIPO RECEITA
        Button btnReceita = findViewById(R.id.btnReceita);
        btnReceita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tipo_post = "receita";
                // CÓDIGO PARA ALTERAR A COR DO BOTÃO
            }
        });

        // CÓDIGO AO CLICAR NO BOTÃO DO TIPO ESTRUTURA QUÍMICA
        Button btnEstruturaQuimica = findViewById(R.id.btnEstrutQuimica);
        btnEstruturaQuimica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tipo_post = "estrutura química";
                // CÓDIGO PARA ALTERAR A COR DO BOTÃO
            }
        });

        // CÓDIGO AO CLICAR NO BOTÃO DO TIPO MODO DE PLANTIO
        Button btnModoPlantio = findViewById(R.id.btnModoPlantio);
        btnModoPlantio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tipo_post = "modo plantio";
                // CÓDIGO PARA ALTERAR A COR DO BOTÃO
            }
        });

        // CÓDIGO AO CLICAR NO BOTÃO DE ADICIONAR POST
        Button btnAddItem = findViewById(R.id.btnAddItemPost);
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CriarPostActivityViewModel vm = new ViewModelProvider(CriarPostActivity.this).get(CriarPostActivityViewModel.class);
                Uri selectedPhotoLocation = vm.getSelectedPhotoLocation();

                //Pega o que a pessoa digitou como título e transforma em string
                EditText etTitle = findViewById(R.id.etTitlePost);
                String title = etTitle.getText().toString();
                // Exibe uma mensagem de erro, caso não haja nada escrito nesse campo
                if(title.isEmpty()){
                    Toast.makeText(CriarPostActivity.this, "É necessário escrever um nome", Toast.LENGTH_LONG).show();
                    return;
                }

                // Mesma coisa acima mas para a descrição
                EditText etDescription = findViewById(R.id.etDescriptionPost);
                String description = etDescription.getText().toString();
                if(description.isEmpty()){
                    Toast.makeText(CriarPostActivity.this, "É necessário escrever uma descrição", Toast.LENGTH_LONG).show();
                    return;
                }

                // Verifica se o tipo de post foi escolhido
                if(tipo_post == "nenhum") {
                    Toast.makeText(CriarPostActivity.this, "É necessário selecionar o tipo de post", Toast.LENGTH_LONG).show();
                    return;
                }


                //Se o usuário tiver preenchido tudo a activity será finalizada
                Intent i = new Intent();
                i.setData(selectedPhotoLocation);
                i.putExtra("title", title);
                i.putExtra("description", description);
                i.putExtra("tipopost", tipo_post);
                setResult(Activity.RESULT_OK, i);
                finish();
            }
        });

        ;   }
    //Pega o resultado/foto
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PHOTO_PICKER_REQUEST){ //indica qual é a requisição
            if(resultCode == Activity.RESULT_OK){ //Se a pessoa selecionou uma foto
                Uri selectedPhotoLocation = data.getData(); //Pega a foto
                ImageView imvPhotoPreview = findViewById(R.id.imvPhotoPreviewPost);
                imvPhotoPreview.setImageURI(selectedPhotoLocation);

                CriarPostActivityViewModel vm = new ViewModelProvider(this).get(CriarPostActivityViewModel.class);
                vm.setSelectedPhotoLocation(selectedPhotoLocation);
            }
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}