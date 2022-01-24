package com.example.plantoterapiaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ConhecaProjetoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conheca_projeto);

        // Pega a toolbar da interface usando seu ID e define ele como a barra da atividade
        Toolbar toolbar = findViewById(R.id.tbConhecaProjeto);
        setSupportActionBar(toolbar);
    }

    // Método que fala para a aplicação utilizar o menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.conhecaprojeto_toolbar, menu);
        return true;
    }

    // Método que indica o que acontece ao clicar em cada item
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()) {
            case R.id.opHome: // Indica o que ocorre no caso do ícone do home ser clicado
                // Código para ir para MainActivity
                Intent i1 = new Intent(ConhecaProjetoActivity.this, MainActivity.class);
                startActivity(i1);
            case R.id.opSobreNos: // Indica o que ocorre no caso do ícone do sobre nós ser clicado
                // Código para ir para Sobre Nós
                Intent i2 = new Intent(ConhecaProjetoActivity.this, SobreNosActivity.class);
                startActivity(i2);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}