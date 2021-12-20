package com.example.plantoterapiaapp;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class PlantaActivityViewModel extends ViewModel {

    List<MyItem> receitas = new ArrayList<>(); // Cria uma lista para itens de receitas que guarda o tipo MyItem (criado para fazer itens)
    List<MyItem> modos_plantio = new ArrayList<>(); // Cria uma lista para itens de modos de plantio que guarda o tipo MyItem (criado para fazer itens)
    List<MyItem> estruturas_quimicas = new ArrayList<>(); // Cria uma lista para itens de estruturas químicas que guarda o tipo MyItem (criado para fazer itens)

    public List<MyItem> getReceitas() {
        return receitas;
    }
    public List<MyItem> getModos_plantio() {
        return receitas;
    }
    public List<MyItem> getEstruturas_quimicas() {
        return receitas;
    }

}
