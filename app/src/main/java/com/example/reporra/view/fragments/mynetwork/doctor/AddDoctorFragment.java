package com.example.reporra.view.fragments.mynetwork.doctor;

import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reporra.R;
import com.google.android.material.textfield.TextInputEditText;


public class AddDoctorFragment extends Fragment {
    private TextInputEditText etDoctorName, etMobileNumber, etClinicHospital, etCity;
    private TextInputEditText etDoctorCode, etAadhaarNumber;
    private AutoCompleteTextView spinnerSpecialization, spinnerArea;
    private Button btnSubmit;
    private ImageView btnBack, iconAdvanced, iconArrow;
    private View btnShowAdvanced;
    private LinearLayout advancedFieldsContainer;
    private TextView textAdvanced;
    private boolean isAdvancedVisible = false;

    // Cache adapters to avoid recreation
    private ArrayAdapter<String> specializationAdapter;
    private ArrayAdapter<String> areaAdapter;

    // Handler for posting tasks
    private Handler mainHandler = new Handler(Looper.getMainLooper());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_doctor, container, false);

        // Initialize only essential views immediately
        initEssentialViews(view);

        // Post heavy operations to avoid blocking UI
        mainHandler.post(() -> {
            initRemainingViews(view);
            setupDropdowns();
            setupClickListeners();
        });

        return view;
    }

    private void initEssentialViews(View view) {
        // Initialize only the most critical views first
        btnBack = view.findViewById(R.id.btn_back);

        // Setup back button immediately so user can navigate away if needed
        btnBack.setOnClickListener(v -> {
            if (getActivity() != null) {
                getActivity().onBackPressed();
            }
        });
    }

    private void initRemainingViews(View view) {
        // Initialize remaining views in chunks to avoid blocking

        // Basic fields - chunk 1
        etDoctorName = view.findViewById(R.id.et_doctor_name);
        etMobileNumber = view.findViewById(R.id.et_mobile_number);
        etClinicHospital = view.findViewById(R.id.et_clinic_hospital);
        etCity = view.findViewById(R.id.et_city);

        // Dropdowns - chunk 2
        spinnerSpecialization = view.findViewById(R.id.spinner_specialization);
        spinnerArea = view.findViewById(R.id.spinner_area);

        // Advanced fields - chunk 3 (can be lazy loaded)
        etDoctorCode = view.findViewById(R.id.et_doctor_code);
        etAadhaarNumber = view.findViewById(R.id.et_aadhaar_number);

        // UI controls - chunk 4
        btnSubmit = view.findViewById(R.id.btn_submit);
        btnShowAdvanced = view.findViewById(R.id.btn_show_advanced);
        advancedFieldsContainer = view.findViewById(R.id.advanced_fields_container);
        iconAdvanced = view.findViewById(R.id.icon_advanced);
        iconArrow = view.findViewById(R.id.icon_arrow);
        textAdvanced = view.findViewById(R.id.text_advanced);
    }

    private void setupDropdowns() {
        // Create adapters lazily and cache them
        if (specializationAdapter == null) {
            String[] specializations = getSpecializations();
            specializationAdapter = new ArrayAdapter<>(
                    requireContext(), android.R.layout.simple_dropdown_item_1line, specializations);
        }

        if (areaAdapter == null) {
            String[] areas = getAreas();
            areaAdapter = new ArrayAdapter<>(
                    requireContext(), android.R.layout.simple_dropdown_item_1line, areas);
        }

        // Set adapters
        if (spinnerSpecialization != null) {
            spinnerSpecialization.setAdapter(specializationAdapter);
        }
        if (spinnerArea != null) {
            spinnerArea.setAdapter(areaAdapter);
        }
    }

    // Extract array creation to separate methods for better readability
    private String[] getSpecializations() {
        return new String[]{
                "General Physician", "Cardiologist", "Dermatologist", "Neurologist",
                "Orthopedic", "Pediatrician", "Gynecologist", "Psychiatrist",
                "ENT Specialist", "Ophthalmologist", "Dentist", "Radiologist"
        };
    }

    private String[] getAreas() {
        return new String[]{
                "Downtown", "Uptown", "City Center", "Suburbs", "Medical District"
        };
    }

    private void setupClickListeners() {
        if (btnShowAdvanced != null) {
            btnShowAdvanced.setOnClickListener(v -> toggleAdvancedFields());
        }

        if (btnSubmit != null) {
            btnSubmit.setOnClickListener(v -> {
                if (validateInputs()) {
                    submitDoctorData();
                }
            });
        }
    }

    private void toggleAdvancedFields() {
        if (isAdvancedVisible) {
            hideAdvancedFields();
        } else {
            showAdvancedFields();
        }
        isAdvancedVisible = !isAdvancedVisible;
    }

    private void showAdvancedFields() {
        if (advancedFieldsContainer == null) return;

        advancedFieldsContainer.setVisibility(View.VISIBLE);
        if (textAdvanced != null) {
            textAdvanced.setText("Hide Advanced Fields");
        }
        if (iconAdvanced != null) {
            iconAdvanced.setImageResource(R.drawable.ic_remove_circle);
        }

        if (iconArrow != null) {
            ObjectAnimator rotateArrow = ObjectAnimator.ofFloat(iconArrow, "rotation", 0f, 180f);
            rotateArrow.setDuration(300);
            rotateArrow.setInterpolator(new AccelerateDecelerateInterpolator());
            rotateArrow.start();
        }

        advancedFieldsContainer.setAlpha(0f);
        advancedFieldsContainer.animate()
                .alpha(1f)
                .setDuration(300)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .start();
    }

    private void hideAdvancedFields() {
        if (advancedFieldsContainer == null) return;

        advancedFieldsContainer.animate()
                .alpha(0f)
                .setDuration(300)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .withEndAction(() -> advancedFieldsContainer.setVisibility(View.GONE))
                .start();

        if (textAdvanced != null) {
            textAdvanced.setText("Show Advanced Fields");
        }
        if (iconAdvanced != null) {
            iconAdvanced.setImageResource(R.drawable.ic_add_circle);
        }

        if (iconArrow != null) {
            ObjectAnimator rotateArrow = ObjectAnimator.ofFloat(iconArrow, "rotation", 180f, 0f);
            rotateArrow.setDuration(300);
            rotateArrow.setInterpolator(new AccelerateDecelerateInterpolator());
            rotateArrow.start();
        }
    }

    private boolean validateInputs() {
        if (etDoctorName == null || spinnerSpecialization == null ||
                spinnerArea == null || etMobileNumber == null || etAadhaarNumber == null) {
            return false;
        }

        String doctorName = etDoctorName.getText().toString().trim();
        String specialization = spinnerSpecialization.getText().toString().trim();
        String area = spinnerArea.getText().toString().trim();
        String mobileNumber = etMobileNumber.getText().toString().trim();
        String aadhaarNumber = etAadhaarNumber.getText().toString().trim();

        if (doctorName.isEmpty()) {
            etDoctorName.setError("Doctor name is required");
            etDoctorName.requestFocus();
            return false;
        }

        if (specialization.isEmpty()) {
            Toast.makeText(getContext(), "Please select specialization", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (area.isEmpty()) {
            Toast.makeText(getContext(), "Please select area", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!mobileNumber.isEmpty() && (mobileNumber.length() != 10 || !mobileNumber.matches("\\d+"))) {
            etMobileNumber.setError("Please enter a valid 10-digit mobile number");
            etMobileNumber.requestFocus();
            return false;
        }

        if (!aadhaarNumber.isEmpty() && (aadhaarNumber.length() != 12 || !aadhaarNumber.matches("\\d+"))) {
            etAadhaarNumber.setError("Please enter a valid 12-digit Aadhaar number");
            etAadhaarNumber.requestFocus();
            return false;
        }

        return true;
    }

    private void submitDoctorData() {
        if (etDoctorName == null || spinnerSpecialization == null ||
                etMobileNumber == null || etClinicHospital == null ||
                spinnerArea == null || etCity == null ||
                etDoctorCode == null || etAadhaarNumber == null) {
            return;
        }

        String doctorName = etDoctorName.getText().toString().trim();
        String specialization = spinnerSpecialization.getText().toString().trim();
        String mobileNumber = etMobileNumber.getText().toString().trim();
        String clinicHospital = etClinicHospital.getText().toString().trim();
        String area = spinnerArea.getText().toString().trim();
        String city = etCity.getText().toString().trim();
        String doctorCode = etDoctorCode.getText().toString().trim();
        String aadhaarNumber = etAadhaarNumber.getText().toString().trim();

        Toast.makeText(getContext(), "Doctor added successfully!", Toast.LENGTH_SHORT).show();

        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Clean up handler to prevent memory leaks
        if (mainHandler != null) {
            mainHandler.removeCallbacksAndMessages(null);
        }
    }
}