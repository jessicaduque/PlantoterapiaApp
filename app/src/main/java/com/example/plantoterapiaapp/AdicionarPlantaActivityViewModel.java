package com.example.plantoterapiaapp;

import android.net.Uri;

public class AdicionarPlantaActivityViewModel {
    //Tipo uma url, porém se trata de um endereço de um arquivo que está no celular(local)
    Uri selectedPhotoLocation = null; //o endereço da foto é retornado por um uri

    public Uri getSelectedPhotoLocation() {
        return selectedPhotoLocation;
    }

    public void setSelectedPhotoLocation(Uri selectedPhotoLocation) {
        this.selectedPhotoLocation = selectedPhotoLocation;
    }
}
