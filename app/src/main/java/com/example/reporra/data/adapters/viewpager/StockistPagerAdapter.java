package com.example.reporra.data.adapters.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.reporra.view.fragments.mynetwork.chemist.ActiveChemistFragment;
import com.example.reporra.view.fragments.mynetwork.chemist.PendingChemistFragment;
import com.example.reporra.view.fragments.mynetwork.stockist.ActiveStockistFragment;
import com.example.reporra.view.fragments.mynetwork.stockist.PendingStockistFragment;

public class StockistPagerAdapter extends FragmentStateAdapter {

    public StockistPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new ActiveStockistFragment();
        } else {
            return new PendingStockistFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2; // Active and Pending
    }
}


