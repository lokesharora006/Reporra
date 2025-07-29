package com.example.reporra.view.fragments.mynetwork.doctor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reporra.R;
import com.example.reporra.view.fragments.mynetwork.area.AddAreaFragment;
import com.example.reporra.view.fragments.mynetwork.area.AreaTabFragment;
import com.example.reporra.view.fragments.mynetwork.area.DeletedAreasFragment;
import com.example.reporra.view.fragments.mynetwork.area.RejectedFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class DoctorFragment extends Fragment {


    private BottomNavigationView bottomNavigationView;

    private FloatingActionButton fabAddDoctor;

    public DoctorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_doctor, container, false);


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
