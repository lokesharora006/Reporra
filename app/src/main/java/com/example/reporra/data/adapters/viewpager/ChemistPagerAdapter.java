package com.example.reporra.data.adapters.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.reporra.view.fragments.mynetwork.chemist.ActiveChemistFragment;
import com.example.reporra.view.fragments.mynetwork.chemist.PendingChemistFragment;
import com.example.reporra.view.fragments.mynetwork.doctor.ActiveDoctorFragments;
import com.example.reporra.view.fragments.mynetwork.doctor.PendingDoctorFragment;

public class ChemistPagerAdapter extends FragmentStateAdapter {

    public ChemistPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new ActiveChemistFragment();
        } else {
            return new PendingChemistFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2; // Active and Pending
    }
}

