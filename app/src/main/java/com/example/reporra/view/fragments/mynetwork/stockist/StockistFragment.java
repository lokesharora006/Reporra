package com.example.reporra.view.fragments.mynetwork.stockist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reporra.R;
import com.example.reporra.view.fragments.mynetwork.chemist.ChemistTabFragment;
import com.example.reporra.view.fragments.mynetwork.chemist.DeletedChemistFragment;
import com.example.reporra.view.fragments.mynetwork.chemist.RejectedChemistFragment;
import com.example.reporra.view.fragments.mynetwork.doctor.AddDoctorFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class StockistFragment extends Fragment {

    private BottomNavigationView bottomNavigationView;
    private FloatingActionButton fabAddStockist;

    public StockistFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stockist, container, false);
        bottomNavigationView = view.findViewById(R.id.bottomNavigationViewStockist);
        fabAddStockist = view.findViewById(R.id.fabAddStockist);

        // Setup back stack listener to show FAB and BottomNav on back
        getChildFragmentManager().addOnBackStackChangedListener(() -> {
            if (getChildFragmentManager().getBackStackEntryCount() == 0) {
                fabAddStockist.setVisibility(View.VISIBLE);
                bottomNavigationView.setVisibility(View.VISIBLE);
            }
        });

        fabAddStockist.setVisibility(View.VISIBLE);

        loadFragment(new StockistTabFragment());

        // Handle bottom navigation item selection
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.nav_Stockist) {
                selectedFragment = new StockistTabFragment();
            } else if (itemId == R.id.nav_stockist_deleted) {
                selectedFragment = new DeletedStockistFragment();
            } else if (itemId == R.id.nav_stockist_rejected) {
                selectedFragment = new RejectedStockistFragment();
            }

            return loadFragment(selectedFragment);
        });

        // Handle FAB click
        fabAddStockist.setOnClickListener(v -> {
            AddStockistFragment addStockistFragment = new AddStockistFragment();

            fabAddStockist.setVisibility(View.GONE);
            bottomNavigationView.setVisibility(View.GONE);

            getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_stockist, addStockistFragment)
                    .addToBackStack("AddStockist")
                    .commit();
        });

        return view;
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            if (fabAddStockist != null) fabAddStockist.setVisibility(View.VISIBLE);
            if (bottomNavigationView != null) bottomNavigationView.setVisibility(View.VISIBLE);

            getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_stockist, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (fabAddStockist != null) fabAddStockist.setVisibility(View.VISIBLE);
        if (bottomNavigationView != null) bottomNavigationView.setVisibility(View.VISIBLE);
    }
}
