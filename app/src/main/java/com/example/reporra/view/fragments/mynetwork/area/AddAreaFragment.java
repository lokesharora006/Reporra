package com.example.reporra.view.fragments.mynetwork.area;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reporra.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class AddAreaFragment extends BottomSheetDialogFragment {


    public AddAreaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_area, container, false);
    }
}