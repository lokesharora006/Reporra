package com.example.reporra.view.fragments.mynetwork.doctor;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reporra.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class DoctorFragment extends Fragment {


    private BottomNavigationView bottomNavigationView;
    private FloatingActionButton fabAddDoctor;

    public DoctorFragment() {
        // Required empty public constructor
    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_doctor, container, false);

        // Initialize views
        bottomNavigationView = view.findViewById(R.id.bottomNavigationViewDoctor);
        fabAddDoctor = view.findViewById(R.id.fabAddDoctor);

        // Setup back stack listener to show FAB and BottomNav on back
        getChildFragmentManager().addOnBackStackChangedListener(() -> {
            if (getChildFragmentManager().getBackStackEntryCount() == 0) {
                fabAddDoctor.setVisibility(View.VISIBLE);
                bottomNavigationView.setVisibility(View.VISIBLE);
            }
        });

        fabAddDoctor.setVisibility(View.VISIBLE);

        // Load default tab (DoctorTabFragment)
        loadFragment(new DoctorTabFragment());

        // Handle bottom navigation item selection
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.nav_Doctor) {
                selectedFragment = new DoctorTabFragment();
            } else if (itemId == R.id.nav_doctor_deleted) {
                selectedFragment = new DeletedDoctorsFragment();
            } else if (itemId == R.id.nav_doctor_rejected) {
                selectedFragment = new RejectedDoctorFragment();
            }

            return loadFragment(selectedFragment);
        });

        // Handle FAB click
        fabAddDoctor.setOnClickListener(v -> {
            AddDoctorFragment addDoctorFragment = new AddDoctorFragment();

            fabAddDoctor.setVisibility(View.GONE);
            bottomNavigationView.setVisibility(View.GONE);

            getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_doctor, addDoctorFragment)
                    .addToBackStack("AddDoctor")
                    .commit();
        });

        return view;
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            if (fabAddDoctor != null) fabAddDoctor.setVisibility(View.VISIBLE);
            if (bottomNavigationView != null) bottomNavigationView.setVisibility(View.VISIBLE);

            getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_doctor, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (fabAddDoctor != null) fabAddDoctor.setVisibility(View.VISIBLE);
        if (bottomNavigationView != null) bottomNavigationView.setVisibility(View.VISIBLE);
    }
}
