package com.example.reporra.data.adapters.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.reporra.view.fragments.mynetwork.area.RejectedAreaAdditionsFragment;
import com.example.reporra.view.fragments.mynetwork.area.RejectedAreaDeletionsFragment;

public class RejectedAreaPagerAdapter extends FragmentStateAdapter {

    public RejectedAreaPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return (position == 0) ? new RejectedAreaAdditionsFragment() : new RejectedAreaDeletionsFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}