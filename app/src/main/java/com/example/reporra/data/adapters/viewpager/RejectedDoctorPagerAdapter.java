package com.example.reporra.data.adapters.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.reporra.view.fragments.mynetwork.doctor.RejectedDoctorAdditionsFragment;
import com.example.reporra.view.fragments.mynetwork.doctor.RejectedDoctorDeletionsFragment;

public class RejectedDoctorPagerAdapter extends FragmentStateAdapter {

    public RejectedDoctorPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new RejectedDoctorAdditionsFragment(); // Doctor addition rejection
        } else {
            return new RejectedDoctorDeletionsFragment(); // Doctor deletion rejection
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
