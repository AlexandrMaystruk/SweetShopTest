package com.gmail.maystruks.sweetshop.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import com.gmail.maystruks.sweetshop.adapter.Event;
import com.gmail.maystruks.sweetshop.fragment.CakeDescriptionFragment;
import com.gmail.maystruks.sweetshop.R;
import com.gmail.maystruks.sweetshop.fragment.CakeListFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private Toolbar toolbar;
    private static int currentFragmentId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    private void bindViews() {
        toolbar = findViewById(R.id.toolbar);

    }

    private void init() {

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, new CakeListFragment()).commit();


    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment).commit();
    }

    @Override
    public void onBackPressed() {

        if (currentFragmentId == 0 || currentFragmentId == -1) {
            finish();
        } else {
            setFragment(new CakeListFragment());
            currentFragmentId = -1;
            toolbar.removeAllViews();

        }

    }

    @Subscribe
    public void onEvent(Event event) {
        switch (event.getMessage()) {

            case 0:
                currentFragmentId = 0;
                setFragment(new CakeListFragment());
                toolbar.removeAllViews();
                break;
            case 1:
                currentFragmentId = 1;
                toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
                setFragment(new CakeDescriptionFragment());
                break;
        }

    }

}
