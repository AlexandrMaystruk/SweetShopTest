package com.gmail.maystruks.sweetshop;

import android.graphics.Bitmap;

public class Cake implements ItemType {

    private String name;
    private String description;
    private Bitmap cakeImage;

    public Cake(String name, String description, Bitmap cakeImage) {
        this.name = name;
        this.description = description;
        this.cakeImage = cakeImage;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bitmap getCakeImage() {
        return cakeImage;
    }

    public void setCakeImage(Bitmap cakeImage) {
        this.cakeImage = cakeImage;
    }


}
