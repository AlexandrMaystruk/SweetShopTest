package com.gmail.maystruks.sweetshop.fragment;

import android.content.Context;

import com.gmail.maystruks.sweetshop.IGetCakeList;
import com.gmail.maystruks.sweetshop.ItemType;


import java.util.List;

public class CakePresenter implements IGetCakeList.Presenter, IGetCakeList.OnGetCakesListener {


    private IGetCakeList.View view;
    private CakeListModel cakeListModel;

    public CakePresenter(IGetCakeList.View view) {

        this.view = view;
        this.cakeListModel = new CakeListModel(this);
    }

    @Override
    public void onGetCakesSuccess(List<ItemType> cakesList) {
        view.onGetCakesSuccess(cakesList);
        view.hideProgress();
    }

    @Override
    public void onGetCakesFailure(String message) {

        view.onGetCakesFailure(message);
        view.hideProgress();
    }

    @Override
    public void getCakes(Context context) {
        view.showProgress();
        cakeListModel.getCakes(context);
    }
}
