package com.example.reporra.view.fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reporra.R;

public class MyNetworkFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_network, container, false);


        CardView cardArea = view.findViewById(R.id.card_area);
        CardView cardDoctor = view.findViewById(R.id.card_doctor); // <-- doctor card
        CardView cardChemist = view.findViewById(R.id.card_chemist); // <-- chemist card
        CardView cardStockist = view.findViewById(R.id.card_stockist); // <-- stockist card


        cardArea.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_myNetworkFragment_to_areaFragment)
        );

        cardDoctor.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_myNetworkFragment_to_doctorFragment)
        );

        cardChemist.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_myNetworkFragment_to_chemistFragment)
        );

        cardStockist.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_myNetworkFragment_to_stockistFragment)
        );

        return view;

    }
}