package com.example.plantoterapiaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class SobreNosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre_nos);

        // Pega a toolbar da interface usando seu ID e define ele como a barra da atividade
        Toolbar toolbar = findViewById(R.id.tbSobreNos);
        setSupportActionBar(toolbar);
    }

    // Método que fala para a aplicação utilizar o menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sobrenos_toolbar, menu);
        return true;
    }

    // Método que indica o que acontece ao clicar em cada item
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()) {
            case R.id.opHome: // Indica o que ocorre no caso do ícone do home ser clicado
                // Código para ir para MainActivity
                return true;
            case R.id.opConhecaProjeto: // Indica o que ocorre no caso do ícone do conheça o projeto ser clicado
                // Código para ir para Conheça o Projeto
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}