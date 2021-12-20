package com.example.plantoterapiaapp;

import android.net.Uri;

import androidx.lifecycle.ViewModel;

public class AdicionarPlantaActivityViewModel extends ViewModel {
    Uri selectedPhotoLocation = null;

    public Uri getSelectedPhotoLocation() {
        return selectedPhotoLocation;
    }

    public void setSelectedPhotoLocation(Uri selectedPhotoLocation) {
        this.selectedPhotoLocation = selectedPhotoLocation;
    }
}
