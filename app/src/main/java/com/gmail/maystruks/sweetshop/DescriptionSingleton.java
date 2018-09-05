package com.gmail.maystruks.sweetshop;

public class DescriptionSingleton {

    private static DescriptionSingleton INSTANCE = null;

    private Cake cake;


    public Cake getCake() {
        return cake;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    private DescriptionSingleton() {
    }

    public static DescriptionSingleton getINSTANCE() {

        if (null == INSTANCE) {

            INSTANCE = new DescriptionSingleton();
        }
        return INSTANCE;
    }

}
