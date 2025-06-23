package com.example.reporra.view.fragments.mynetwork.area;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.reporra.R;
import com.example.reporra.data.adapters.area.DeletedAreaAdapter;
import com.example.reporra.data.model.AreaModel;

import java.util.ArrayList;
import java.util.List;


public class DeletedAreasFragment extends Fragment {


    private SearchView searchView;
    private RecyclerView recyclerView;
    private DeletedAreaAdapter adapter;
    private List<AreaModel> deletedAreas;

    public DeletedAreasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_deleted_areas, container, false);
        // Initialize views
        searchView = view.findViewById(R.id.searchViewDeleted);
        recyclerView = view.findViewById(R.id.recyclerViewDeleted);

        // Setup RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Dummy data for testing
        deletedAreas = new ArrayList<>();
        deletedAreas.add(new AreaModel("Sector 12"));
        deletedAreas.add(new AreaModel("Palam Vihar"));
        deletedAreas.add(new AreaModel("DLF Phase 3"));

        // Setup adapter
        adapter = new DeletedAreaAdapter(deletedAreas);
        recyclerView.setAdapter(adapter);

        // Handle search
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false; // Not needed
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });

        return view;
    }

}