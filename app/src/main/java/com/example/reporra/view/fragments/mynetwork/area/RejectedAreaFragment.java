package com.example.reporra.view.fragments.mynetwork.area;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reporra.R;
import com.example.reporra.data.adapters.viewpager.RejectedAreaPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class RejectedAreaFragment extends Fragment {


    private TabLayout tabLayout;
    private ViewPager2 viewPager;


    public RejectedAreaFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_area_rejected, container, false);
        tabLayout = view.findViewById(R.id.rejectedAreaTabLayout);
        viewPager = view.findViewById(R.id.rejectedAreaViewPager);

        RejectedAreaPagerAdapter adapter = new RejectedAreaPagerAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            if (position == 0) {
                tab.setText("Rejected Additions");
            } else {
                tab.setText("Rejected Deletions");
            }
        }).attach();

        return view;
    }
}