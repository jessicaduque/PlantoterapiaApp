package com.example.plantoterapiaapp;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends ViewModel {
    List<MyItem> itens = new ArrayList<>(); // Cria uma lista para itens que guarda o tipo MyItem (criado para fazer itens)

    public List<MyItem> getItens() {
        return itens;
    }
}
