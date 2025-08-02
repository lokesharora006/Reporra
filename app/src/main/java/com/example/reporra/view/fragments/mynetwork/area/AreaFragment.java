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


        getChildFragmentManager().addOnBackStackChangedListener(() -> {
            if (getChildFragmentManager().getBackStackEntryCount() == 0) {
                fabAddArea.setVisibility(View.VISIBLE);
                bottomNavigationView.setVisibility(View.VISIBLE);
            }
        });

        // Initialize views
        bottomNavigationView = view.findViewById(R.id.bottomNavigationView);
        fabAddArea = view.findViewById(R.id.fabAddArea);


        fabAddArea.setVisibility(View.VISIBLE);

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

        // Handle FAB click - Navigate to full screen AddAreaFragment
        fabAddArea.setOnClickListener(v -> {
            AddAreaFragment addAreaFragment = new AddAreaFragment(); // Now should extend Fragment, not BottomSheetDialogFragment

            // Hide the FAB and BottomNavigation when navigating to AddAreaFragment
            fabAddArea.setVisibility(View.GONE);
            bottomNavigationView.setVisibility(View.GONE);

            // Navigate to full screen fragment
            getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_area, addAreaFragment)
                    .addToBackStack("AddArea") // Add to back stack for navigation
                    .commit();
        });

        return view;
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            // Show FAB and BottomNavigation when loading normal fragments
            if (fabAddArea != null) fabAddArea.setVisibility(View.VISIBLE);
            if (bottomNavigationView != null) bottomNavigationView.setVisibility(View.VISIBLE);

            getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_area, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Ensure FAB and BottomNav are visible when returning to this fragment
        if (fabAddArea != null) fabAddArea.setVisibility(View.VISIBLE);
        if (bottomNavigationView != null) bottomNavigationView.setVisibility(View.VISIBLE);
    }
}
