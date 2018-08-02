package com.css.aimstar.aimstar.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.css.aimstar.aimstar.R;


public class DashboardFragment extends Fragment {
    CardView track,resourse,certification,help,feedback;


    public DashboardFragment() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_dashboard, container, false);
        track=view.findViewById(R.id.track);
        resourse=view.findViewById(R.id.resource);
        certification=view.findViewById(R.id.certificate);
        help=view.findViewById(R.id.help);
        feedback=view.findViewById(R.id.feedback);

        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_panel,new TrackFragment());
                fragmentTransaction.commit();
            }
        });
        resourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  ResourceFragment fr=new ResourceFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.dashboardContainer,fr);
                ft.commit();*/

              FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
              fragmentTransaction.replace(R.id.content_panel,new ResourceFragment());
              fragmentTransaction.commit();
            }
        });
        certification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_panel,new CourseDetailsFragment());
                fragmentTransaction.commit();
            }
        });

        return view;
    }









}
