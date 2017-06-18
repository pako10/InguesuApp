package com.example.pakoandrade.inguesuapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.pakoandrade.inguesuapp.fragments_menu.PedaFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationBar bottomNavigationBar;
    Button btFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        btFilter = (Button) findViewById(R.id.filterButton);

        initializeBottomNavigation();
        setFragment(0);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void initializeBottomNavigation() {
        bottomNavigationBar
                .setMode(BottomNavigationBar.MODE_FIXED);

        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);

      /*  bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);*/

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_local_bar_white_24dp, "Peda").setActiveColorResource(R.color.blue))//.setBadgeItem(numberBadgeItem))
                .addItem(new BottomNavigationItem(R.drawable.ic_restaurant_menu_white_24dp, "Bajon").setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "Casa").setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.ic_close_white_24dp, "Com").setActiveColorResource(R.color.brown))
                .addItem(new BottomNavigationItem(R.drawable.ic_add_white_24dp, "Mas").setActiveColorResource(R.color.grey))
                //.setFirstSelectedPosition(lastSelectedPosition)
                .initialise();



        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {

                if (position == 0){
                    setFragment(0);
                }
                if (position == 1){
                    setFragment(1);
                }
                if (position == 2){
                    setFragment(2);
                }
                if (position == 3){
                    setFragment(3);
                }
                if (position == 4){
                    setFragment(4);
                }
            }

            @Override
            public void onTabUnselected(int position) {
            }

            @Override
            public void onTabReselected(int position) {
            }
        });
    }


    public void setFragment(int position) {

        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        switch (position) {
            case 0:
                btFilter.setVisibility(View.VISIBLE);
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                PedaFragment peda = new PedaFragment();
                fragmentTransaction.replace(R.id.ejemplo_fragment, peda);
                fragmentTransaction.commit();
                break;
            case 1:
                btFilter.setVisibility(View.GONE);
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                TabRestaurant restaurant = new TabRestaurant();
                fragmentTransaction.replace(R.id.ejemplo_fragment, restaurant);
                fragmentTransaction.commit();
                break;
            case 2:
                btFilter.setVisibility(View.GONE);
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                TabHouse house = new TabHouse();
                fragmentTransaction.replace(R.id.ejemplo_fragment, house);
                fragmentTransaction.commit();
                break;
            case 3:
                btFilter.setVisibility(View.GONE);
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                TabClose close = new TabClose();
                fragmentTransaction.replace(R.id.ejemplo_fragment, close);
                fragmentTransaction.commit();
                break;
            case 4:
                btFilter.setVisibility(View.GONE);
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                TabPlus calendaio = new TabPlus();
                fragmentTransaction.replace(R.id.ejemplo_fragment, calendaio);
                fragmentTransaction.commit();
                break;

        }
    }


    public static class TabRestaurant extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_restaurant, container, false);
            Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
            toolbar.setTitle("Restaurantes");
            return view;
        }

    }

    public static class TabHouse extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_house, container, false);
        }

    }
    public static class TabClose extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_close, container, false);
        }

    }
    public static class TabPlus extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_plus, container, false);
        }

    }
}
