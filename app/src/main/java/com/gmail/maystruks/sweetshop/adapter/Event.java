package com.gmail.maystruks.sweetshop.adapter;

public class Event {

    private int  numberFragment;

    public int getMessage() {
        return numberFragment;
    }

    public void setMessage(int numberFragment) {
        this.numberFragment = numberFragment;
    }

    public Event(int numberFragment) {
        this.numberFragment = numberFragment;
    }
}
