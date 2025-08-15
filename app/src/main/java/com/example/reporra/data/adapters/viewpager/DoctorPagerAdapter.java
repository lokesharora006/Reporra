package com.example.reporra.data.adapters.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.reporra.view.fragments.mynetwork.doctor.ActiveDoctorFragments;
import com.example.reporra.view.fragments.mynetwork.doctor.PendingDoctorFragment;

public class DoctorPagerAdapter extends FragmentStateAdapter {

    public DoctorPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new ActiveDoctorFragments();
        } else {
            return new PendingDoctorFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2; // Active and Pending
    }
}