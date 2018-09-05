package com.gmail.maystruks.sweetshop.fragment;


import android.content.Context;

import com.gmail.maystruks.sweetshop.CakeRepository;
import com.gmail.maystruks.sweetshop.IGetCakeList;

public class CakeListModel implements IGetCakeList.Model {

    IGetCakeList.OnGetCakesListener onGetCakesListener;

    public CakeListModel(IGetCakeList.OnGetCakesListener onGetCakesListener) {
        this.onGetCakesListener = onGetCakesListener;
    }


    @Override
    public void getCakes(Context context) {

        if (CakeRepository.getINSTANCE(context).getCakesList() != null) {
            onGetCakesListener.onGetCakesSuccess(CakeRepository.getINSTANCE(context).getCakesList());
        } else {
            onGetCakesListener.onGetCakesFailure("Null object reference");
        }
    }
}
