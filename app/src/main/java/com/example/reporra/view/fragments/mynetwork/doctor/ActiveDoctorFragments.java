package com.example.reporra.view.fragments.mynetwork.doctor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reporra.R;

/**
 * A simple {@link Fragment} subclass.
<<<<<<<< HEAD:app/src/main/java/com/example/reporra/view/fragments/mynetwork/doctor/DoctorTabFragment.java
 * Use the {@link DoctorTabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DoctorTabFragment extends Fragment {
========
 * Use the {@link ActiveDoctorFragments#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActiveDoctorFragments extends Fragment {
>>>>>>>> areasfragments:app/src/main/java/com/example/reporra/view/fragments/mynetwork/doctor/ActiveDoctorFragments.java

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

<<<<<<<< HEAD:app/src/main/java/com/example/reporra/view/fragments/mynetwork/doctor/DoctorTabFragment.java
    public DoctorTabFragment() {
========
    public ActiveDoctorFragments() {
>>>>>>>> areasfragments:app/src/main/java/com/example/reporra/view/fragments/mynetwork/doctor/ActiveDoctorFragments.java
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
<<<<<<<< HEAD:app/src/main/java/com/example/reporra/view/fragments/mynetwork/doctor/DoctorTabFragment.java
     * @return A new instance of fragment DoctorTabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DoctorTabFragment newInstance(String param1, String param2) {
        DoctorTabFragment fragment = new DoctorTabFragment();
========
     * @return A new instance of fragment ActiveDoctorFragments.
     */
    // TODO: Rename and change types and number of parameters
    public static ActiveDoctorFragments newInstance(String param1, String param2) {
        ActiveDoctorFragments fragment = new ActiveDoctorFragments();
>>>>>>>> areasfragments:app/src/main/java/com/example/reporra/view/fragments/mynetwork/doctor/ActiveDoctorFragments.java
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
<<<<<<<< HEAD:app/src/main/java/com/example/reporra/view/fragments/mynetwork/doctor/DoctorTabFragment.java
        return inflater.inflate(R.layout.fragment_doctor_tab, container, false);
========
        return inflater.inflate(R.layout.fragment_active_doctor_fragments, container, false);
>>>>>>>> areasfragments:app/src/main/java/com/example/reporra/view/fragments/mynetwork/doctor/ActiveDoctorFragments.java
    }
}