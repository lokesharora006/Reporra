package com.example.reporra.view.fragments.mynetwork.area;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.SearchView;

import com.example.reporra.R;
import com.example.reporra.data.adapters.viewpager.AreaPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class AreaFragment extends Fragment {


    private BottomNavigationView bottomNavigationView;
    private FloatingActionButton fabAddArea;

    public AreaFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_area, container, false);

        // Initialize views
        bottomNavigationView = view.findViewById(R.id.bottomNavigationView);
        fabAddArea = view.findViewById(R.id.fabAddArea);

        // Load default fragment (AreaTabFragment)
        loadFragment(new AreaTabFragment());

        // Handle BottomNavigationView item clicks
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            int itemId = item.getItemId();
            if (itemId == R.id.nav_area) {
                selectedFragment = new AreaTabFragment();
            } else if (itemId == R.id.nav_deleted) {
                selectedFragment = new DeletedAreasFragment();
            } else if (itemId == R.id.nav_rejected) {
                selectedFragment = new RejectedFragment();
            }

            return loadFragment(selectedFragment);
        });

        // Handle FAB click
        fabAddArea.setOnClickListener(v -> {
            AddAreaFragment addAreaFragment = new AddAreaFragment(); // Must extend BottomSheetDialogFragment
            addAreaFragment.show(getParentFragmentManager(), addAreaFragment.getTag());
        });

        return view;
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_area, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
