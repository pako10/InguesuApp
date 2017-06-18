package com.example.pakoandrade.inguesuapp.fragments_menu;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pakoandrade.inguesuapp.MainActivity;
import com.example.pakoandrade.inguesuapp.R;

/**
 * Created by pakoAndrade on 01/11/16.
 */

public class PedaFragment extends android.support.v4.app.Fragment {
    TabLayout tabs;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_peda_principal, container, false);

        tabs = (TabLayout) view.findViewById(R.id.tabs);

        tabs.addTab(tabs.newTab().setText("Bares"));
        tabs.addTab(tabs.newTab().setText("BeachClub"));
        tabs.addTab(tabs.newTab().setIcon(R.mipmap.ic_launcher));

        viewPager = (ViewPager) view.findViewById(R.id.containerF);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));

        PagerPeda adapterPeda = new PagerPeda(getFragmentManager(),tabs.getTabCount());

        viewPager.setAdapter(adapterPeda);

        tabs.setOnTabSelectedListener(
                new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        // ...
                        viewPager.setCurrentItem(tab.getPosition());
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        // ...
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                        // ...
                    }
                }
        );
        return  view;
    }

    public static class PagerPeda extends FragmentPagerAdapter {

        //integer to count number of tabs
        int tabCount;

        //Constructor to the class
        public PagerPeda(FragmentManager fm, int tabCount) {
            super(fm);
            //Initializing tab count
            this.tabCount= tabCount;
        }

        //Overriding method getItem
        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            //Returning the current tabs
            switch (position) {
                case 0:
                    TabBares tab = new TabBares();
                    return tab;
                case 1:
                    MainActivity.TabHouse tab2 = new MainActivity.TabHouse();
                    return tab2;
                case 2:
                    MainActivity.TabPlus tab3 = new MainActivity.TabPlus();
                    return tab3;
                default:
                    return null;
            }
        }

        //Overriden method getCount to get the number of tabs
        @Override
        public int getCount() {
            return tabCount;
        }
    }

    public static class TabBares extends android.support.v4.app.Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_peda_bar, container, false);
        }

    }

    public static class TabBeachClub extends android.support.v4.app.Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_restaurant, container, false);
        }

    }
}
