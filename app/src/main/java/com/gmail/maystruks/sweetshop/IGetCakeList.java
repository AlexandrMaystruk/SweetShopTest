package com.gmail.maystruks.sweetshop;

import android.content.Context;
import java.util.List;

public interface IGetCakeList {

    interface View {
        void onGetCakesSuccess(List<Cake> cakes);
        void onGetCakesFailure(String message);
        void showProgress();
        void hideProgress();
    }

    interface Presenter
    {
        void getCakes(Context context);
    }

    interface Model {
        void getCakes(Context context);

    }

    interface OnGetCakesListener {

        void onGetCakesSuccess(List<Cake> cakesList);
        void onGetCakesFailure(String message);
    }

}
