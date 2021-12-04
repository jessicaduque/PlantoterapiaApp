package com.example.plantoterapiaapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class AdicionarPlantaActivity extends AppCompatActivity {

    //Declara um valor inteiro estático para o requerimento da imagem
    static int PHOTO_PICKER_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_planta);

        AdicionarPlantaActivityViewModel vm = new ViewModelProvider(this).get(AdicionarPlantaActivityViewModel.class);

        Uri selectedPhotoLocation = vm.getSelectedPhotoLocation();
        if(selectedPhotoLocation != null){
            ImageView imvPhotoPreview = findViewById(R.id.imvPhotoPreview);
            imvPhotoPreview.setImageURI(selectedPhotoLocation);

        }

        //Quando o botão de imagem for clicado irá abrir a galeria do celular para selecionar um documento tipo imagem
        ImageButton imgChooseImage = findViewById(R.id.imbChooseImage);
        imgChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                photoPickerIntent.setType("image/*"); //Uma imagem de qualquer tipo, não restrito a um formato(ex:jpeg)
                startActivityForResult(photoPickerIntent, PHOTO_PICKER_REQUEST);
            }
        });

        Button btnAddItem = findViewById(R.id.btnAddItem);
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdicionarPlantaActivityViewModel vm = new ViewModelProvider(AdicionarPlantaActivity.this).get(AdicionarPlantaActivityViewModel.class);
                Uri selectedPhotoLocation = vm.getSelectedPhotoLocation();
                if(selectedPhotoLocation == null){ //Se não houver uma imagem selecionada, será exibida uma mensagem de erro na tela
                    Toast.makeText(AdicionarPlantaActivity.this, "É necessário selecionar uma imagen", Toast.LENGTH_LONG).show();
                    return;
                }
                //Pega o que a pessoa digitou como título e transforma em string
                EditText etTitle = findViewById(R.id.etTitle);
                String title = etTitle.getText().toString();
                //exibe uma mensagem de erro, caso não haja nada escrito nesse campo
                if(title.isEmpty()){
                    Toast.makeText(AdicionarPlantaActivity.this, "É necessário escrever um título", Toast.LENGTH_LONG).show();
                    return;
                }

                //Pega o que a pessoa digitou como descrição e transforma em string
                EditText etDescription = findViewById(R.id.etDescription);
                String description = etTitle.getText().toString();
                //exibe uma mensagem de erro, caso não haja nada escrito nesse campo
                if(description.isEmpty()){
                    Toast.makeText(AdicionarPlantaActivity.this, "É necessário escrever uma descrição", Toast.LENGTH_LONG).show();
                    return;
                }
                //Se o usuário tiver preenchido tudo a activity será finalizada
                Intent i = new Intent();
                i.setData(selectedPhotoLocation);
                i.putExtra("title", title);
                i.putExtra("description", description);
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
                ImageView imvPhotoPreview = findViewById(R.id.imvPhotoPreview);
                imvPhotoPreview.setImageURI(selectedPhotoLocation);

                AdicionarPlantaActivityViewModel vm = new ViewModelProvider(this).get(AdicionarPlantaActivityViewModel.class);
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