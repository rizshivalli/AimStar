package com.css.aimstar.aimstar.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.css.aimstar.aimstar.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {
    private EditText name, email, password, dob;
    private RadioButton male, female;
    private RadioGroup gender;
private  View rootView;

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       rootView= inflater.inflate(R.layout.fragment_sign_up, container, false);
       name=rootView.findViewById(R.id.registration_name);
        email=rootView.findViewById(R.id.registration_email);
        password=rootView.findViewById(R.id.registration_password);
        dob=rootView.findViewById(R.id.registration_dob);
        gender=rootView.findViewById(R.id.registration_gender);
        male=rootView.findViewById(R.id.radio_male);
        female=rootView.findViewById(R.id.radio_female);


       return rootView;
    }

}
