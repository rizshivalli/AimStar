package com.css.aimstar.aimstar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.css.aimstar.aimstar.fragments.OrganizationProfileFragment;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportFragmentManager().beginTransaction().add(R.id.profileContainer,new OrganizationProfileFragment(),null).addToBackStack(null).commit();
    }
}
