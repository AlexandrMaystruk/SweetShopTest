package com.gmail.maystruks.sweetshop.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.maystruks.sweetshop.IGetCakeList;
import com.gmail.maystruks.sweetshop.ItemType;
import com.gmail.maystruks.sweetshop.R;
import com.gmail.maystruks.sweetshop.adapter.RecyclerCakeListAdapter;

import java.util.ArrayList;
import java.util.List;


public class CakeListFragment extends Fragment implements IGetCakeList.View, SwipeRefreshLayout.OnRefreshListener {

    public static int ID_CAKE_LIST_FRAGMENT = 0;
    private View view;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerCakeListAdapter adapter;
    private CakePresenter presenter;
    private SwipeRefreshLayout swipeRefreshLayout;



    public CakeListFragment() {

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_cake_list, container, false);
        bindView();
        init();
        return view;
    }


    private void bindView() {
        recyclerView = view.findViewById(R.id.recycler_view_cake_list);
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh);

    }

    private void init() {

        presenter = new CakePresenter(this);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerCakeListAdapter(new ArrayList<ItemType>());
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout.setOnRefreshListener(this);

    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getCakes(getContext());
    }

    @Override
    public void onGetCakesSuccess(List<ItemType> cakes) {

        adapter.updateList(cakes);

    }

    @Override
    public void onGetCakesFailure(String message) {

        Log.e("err", message);

    }


    @Override
    public void onRefresh() {
        presenter.getCakes(getContext());
    }

    @Override
    public void showProgress() {


        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
            }
        });

    }

    @Override
    public void hideProgress() {

        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }


}
