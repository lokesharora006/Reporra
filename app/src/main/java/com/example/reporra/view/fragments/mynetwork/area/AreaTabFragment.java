package com.example.reporra.view.fragments.mynetwork.area;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reporra.R;
import com.example.reporra.data.adapters.viewpager.AreaPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class AreaTabFragment extends Fragment {


    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    public AreaTabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_area_tab, container, false);


        tabLayout = view.findViewById(R.id.areatabLayout);
        viewPager = view.findViewById(R.id.areatabviewPager);

        AreaPagerAdapter adapter = new AreaPagerAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            if (position == 0) {
                tab.setText("Active Areas");
            } else {
                tab.setText("Pending Areas");
            }
        }).attach();

        return view;

    }
}