package com.css.aimstar.aimstar.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.css.aimstar.aimstar.R;
import com.css.aimstar.aimstar.adapter.TrackListAdapter;
import com.css.aimstar.aimstar.model.TrackList;
import com.css.aimstar.aimstar.networking.Apis;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrackFragment extends Fragment {
    private RecyclerView recyclerViewTrack;
//private Button recommendedCourse, graduationCourse1, otherRCourse2, otherRCourse1,otherCourse1, otherCourse2, graduationCourse2;
private View rootView;
    private TrackListAdapter trackListAdapter;

    public TrackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_track, container, false);
        recyclerViewTrack=rootView.findViewById(R.id.recyclerViewTrack);
        recyclerViewTrack.setLayoutManager(new LinearLayoutManager(getContext()));
       /* recommendedCourse = rootView.findViewById(R.id.recommendedCourse);
        otherCourse1 = rootView.findViewById(R.id.otherCourse1);
        otherCourse2 = rootView.findViewById(R.id.otherCourse2);
        otherRCourse2 = rootView.findViewById(R.id.otherRCourse2);
        graduationCourse1 = rootView.findViewById(R.id.graduationCourse1);
        graduationCourse2 = rootView.findViewById(R.id.graduationCourse2);
        otherRCourse1 = rootView.findViewById(R.id.otherCourse1);
        recyclerViewTrack.setAdapter(trackListAdapter)*/;
        //onClickListeners();
       getData();


        return rootView;
    }

   private void getData() {

        Call<TrackList> call = Apis.getApi().getTracks();
        call.enqueue(new Callback<TrackList>() {
            @Override
            public void onResponse(Call<TrackList> call, Response<TrackList> response) {
                TrackList trackList = response.body();
                Log.i("IndividualList:", "onResponse: "+trackList.getTrack());
                trackListAdapter = new TrackListAdapter(trackList.getTrack(),getContext(),getLayoutInflater());
                //trackListAdapter = new TrackListAdapter(trackList.getTrack(),getContext());
                setContents();
            }

            @Override
            public void onFailure(Call<TrackList> call, Throwable t) {

            }
        });
    }

  /*  private void onClickListeners() {
        recommendedCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_panel,new CourseDetailsFragment());
                fragmentTransaction.commit();
            }
        });

        otherRCourse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_panel,new CourseDetailsFragment());
                fragmentTransaction.commit();

            }
        });

        graduationCourse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_panel,new CourseDetailsFragment());
                fragmentTransaction.commit();
            }
        });
        otherRCourse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_panel,new CourseDetailsFragment());
                fragmentTransaction.commit();
            }
        });
    }*/
  private void setContents() {
      recyclerViewTrack.setAdapter(trackListAdapter);
  }
}
