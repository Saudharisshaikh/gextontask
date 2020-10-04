package com.example.gextontask.SaveImageInDatabase;

import android.graphics.Bitmap;

public class ImageModel {

    Bitmap image;
    String imageName;

    public ImageModel() {
    }

    public ImageModel( String imageName,Bitmap image) {
        this.image = image;
        this.imageName = imageName;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
