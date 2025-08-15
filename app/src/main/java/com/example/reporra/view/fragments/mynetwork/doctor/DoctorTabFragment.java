package com.example.reporra.view.fragments.mynetwork.doctor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reporra.R;
import com.example.reporra.data.adapters.viewpager.DoctorPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class DoctorTabFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    public DoctorTabFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_doctor_tab, container, false);
        tabLayout = view.findViewById(R.id.doctortabLayout);
        viewPager = view.findViewById(R.id.doctortabviewPager);

        DoctorPagerAdapter adapter = new DoctorPagerAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            if (position == 0) {
                tab.setText("Active Doctors");
            } else {
                tab.setText("Pending Doctors");
            }
        }).attach();

        return view;
    }
}