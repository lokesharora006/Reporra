package com.example.reporra.view.fragments.mynetwork.chemist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reporra.R;
import com.example.reporra.view.fragments.mynetwork.doctor.AddDoctorFragment;
import com.example.reporra.view.fragments.mynetwork.doctor.DeletedDoctorsFragment;
import com.example.reporra.view.fragments.mynetwork.doctor.DoctorTabFragment;
import com.example.reporra.view.fragments.mynetwork.doctor.RejectedDoctorFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ChemistFragment extends Fragment {

    private BottomNavigationView bottomNavigationView;
    private FloatingActionButton fabAddChemist;

    public ChemistFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chemist, container, false);
        // Initialize views
        bottomNavigationView = view.findViewById(R.id.bottomNavigationViewChemist);
        fabAddChemist = view.findViewById(R.id.fabAddChemist);

        // Setup back stack listener to show FAB and BottomNav on back
        getChildFragmentManager().addOnBackStackChangedListener(() -> {
            if (getChildFragmentManager().getBackStackEntryCount() == 0) {
                fabAddChemist.setVisibility(View.VISIBLE);
                bottomNavigationView.setVisibility(View.VISIBLE);
            }
        });

        fabAddChemist.setVisibility(View.VISIBLE);

        // Load default tab (DoctorTabFragment)
        loadFragment(new ChemistTabFragment());

        // Handle bottom navigation item selection
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.nav_Chemist) {
                selectedFragment = new ChemistTabFragment();
            } else if (itemId == R.id.nav_chemist_deleted) {
                selectedFragment = new DeletedChemistFragment();
            } else if (itemId == R.id.nav_chemist_rejected) {
                selectedFragment = new RejectedChemistFragment();
            }

            return loadFragment(selectedFragment);
        });

        // Handle FAB click
        fabAddChemist.setOnClickListener(v -> {
            AddChemistFragment addChemistFragment = new AddChemistFragment();

            fabAddChemist.setVisibility(View.GONE);
            bottomNavigationView.setVisibility(View.GONE);

            getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_chemist, addChemistFragment)
                    .addToBackStack("AddChemist")
                    .commit();
        });

        return view;
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            if (fabAddChemist != null) fabAddChemist.setVisibility(View.VISIBLE);
            if (bottomNavigationView != null) bottomNavigationView.setVisibility(View.VISIBLE);

            getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_chemist, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (fabAddChemist != null) fabAddChemist.setVisibility(View.VISIBLE);
        if (bottomNavigationView != null) bottomNavigationView.setVisibility(View.VISIBLE);
    }
}
