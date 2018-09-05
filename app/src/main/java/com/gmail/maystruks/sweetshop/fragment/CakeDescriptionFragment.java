package com.gmail.maystruks.sweetshop.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.gmail.maystruks.sweetshop.Cake;
import com.gmail.maystruks.sweetshop.DescriptionSingleton;
import com.gmail.maystruks.sweetshop.R;
import com.gmail.maystruks.sweetshop.adapter.Event;
import org.greenrobot.eventbus.EventBus;

import java.util.Objects;


public class CakeDescriptionFragment extends Fragment {

    public static int ID_DESCRIPTION_FRAGMENT = 1;

    private View view;
    private TextView tvTitle;
    private TextView tvDescription;
    private ImageView ivCakeImage;
    private Cake cake;


    public CakeDescriptionFragment() {

        cake = DescriptionSingleton.getINSTANCE().getCake();

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_description_cake, container, false);
        bindsView();
        init();
        return view;
    }


    private void bindsView() {

        ivCakeImage = view.findViewById(R.id.iv_image);
        tvTitle = view.findViewById(R.id.tv_name);
        tvDescription = view.findViewById(R.id.tv_description);

    }


    private void init() {

        if (cake.getName() != null) {
            ivCakeImage.setImageBitmap(cake.getCakeImage());
            tvDescription.setText(cake.getDescription());
            tvTitle.setText(cake.getName());
        }

        Toolbar toolbar = Objects.requireNonNull(getActivity()).findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EventBus.getDefault().post(new Event(CakeListFragment.ID_CAKE_LIST_FRAGMENT));
            }
        });

    }


}
