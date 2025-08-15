package com.example.reporra.view.fragments.mynetwork.stockist;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reporra.R;
import com.example.reporra.data.adapters.viewpager.ChemistPagerAdapter;
import com.example.reporra.data.adapters.viewpager.StockistPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class StockistTabFragment extends Fragment {


    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    public StockistTabFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stockist_tab, container, false);
        tabLayout = view.findViewById(R.id.stockisttabLayout);
        viewPager = view.findViewById(R.id.stockisttabviewPager);

        StockistPagerAdapter adapter = new StockistPagerAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            if (position == 0) {
                tab.setText("Active Stockist");
            } else {
                tab.setText("Pending Stockist");
            }
        }).attach();

        return view;
    }
}