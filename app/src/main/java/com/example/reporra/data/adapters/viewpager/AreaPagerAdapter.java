package com.example.reporra.data.adapters.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.reporra.view.fragments.mynetwork.area.ActiveAreasFragment;
import com.example.reporra.view.fragments.mynetwork.area.DeletedAreasFragment;
import com.example.reporra.view.fragments.mynetwork.area.PendingAreasFragment;

public class AreaPagerAdapter extends FragmentStateAdapter {

    public AreaPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return (position == 0) ? new ActiveAreasFragment() : new PendingAreasFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
