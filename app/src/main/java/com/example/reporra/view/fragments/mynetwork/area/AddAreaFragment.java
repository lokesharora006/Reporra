package com.example.reporra.view.fragments.mynetwork.area;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.reporra.R;
import com.example.reporra.data.model.AreaModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


public class AddAreaFragment extends Fragment {

    private TextInputEditText etAreaName, etAreaCode;
    private AutoCompleteTextView spinnerAreaType;
    private Button btnSubmit;
    private ImageView btnBack;

    public AddAreaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_area, container, false);

        initViews(view);
        setupAreaTypeDropdown();
        setupClickListeners();

        return view;
    }

    private void initViews(View view) {
        etAreaName = view.findViewById(R.id.et_area_name);
        etAreaCode = view.findViewById(R.id.et_area_code);
        spinnerAreaType = view.findViewById(R.id.spinner_area_type);
        btnSubmit = view.findViewById(R.id.btn_submit);
        btnBack = view.findViewById(R.id.btn_back);
    }

    private void setupAreaTypeDropdown() {
        String[] areaTypes = {"HQ", "EX", "OUT"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_dropdown_item_1line, areaTypes);
        spinnerAreaType.setAdapter(adapter);
    }

    private void setupClickListeners() {
        btnBack.setOnClickListener(v -> navigateBack());

        btnSubmit.setOnClickListener(v -> {
            String areaName = etAreaName.getText().toString().trim();
            String areaCode = etAreaCode.getText().toString().trim();
            String areaType = spinnerAreaType.getText().toString().trim();

            if (validateInputs(areaName, areaCode, areaType)) {
                saveAreaToFirestore(areaName, areaCode, areaType);
            }
        });
    }

    private void saveAreaToFirestore(String areaName, String areaCode, String areaType) {
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        long timestamp = System.currentTimeMillis();

        AreaModel model = new AreaModel(areaName, areaCode, areaType, timestamp);
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("myNetwork")
                .document(uid)
                .collection("areas")
                .add(model)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(requireContext(), "Area saved successfully!", Toast.LENGTH_SHORT).show();
                    navigateBack();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(requireContext(), "Failed to save area: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

    private void navigateBack() {
        if (getParentFragmentManager().getBackStackEntryCount() > 0) {
            getParentFragmentManager().popBackStack();
        } else {
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_area, new AreaTabFragment())
                    .commit();
        }
    }

    private boolean validateInputs(String name, String code, String type) {
        if (name.isEmpty()) {
            etAreaName.setError("Area name is required");
            return false;
        }
        if (code.isEmpty()) {
            etAreaCode.setError("Area code is required");
            return false;
        }
        if (type.isEmpty()) {
            Toast.makeText(requireContext(), "Please select area type", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}