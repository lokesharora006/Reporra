package com.example.reporra.view.fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reporra.R;


public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_home, container, false);


        CardView cardMyNetwork = view.findViewById(R.id.cardMyNetwork);
        cardMyNetwork.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_myNetworkFragment)
        );

        return view;
    }
}