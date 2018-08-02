package com.css.aimstar.aimstar.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.css.aimstar.aimstar.R;
import com.css.aimstar.aimstar.adapter.CourseDetailsAdapter;
import com.css.aimstar.aimstar.adapter.NearbyCollegesAdapter;
import com.css.aimstar.aimstar.model.CourseDetails;
import com.css.aimstar.aimstar.model.CourseDetailsModelList;
import com.css.aimstar.aimstar.model.NearbyColleges;
import com.css.aimstar.aimstar.model.NearbyCollegesList;
import com.css.aimstar.aimstar.networking.Apis;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CourseDetailsFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<NearbyColleges> nearbyColleges = new ArrayList<>();
    private GridLayoutManager gridLayoutManager;
    private NearbyCollegesAdapter nearbyCollegesAdapter;
    private View rootView;
    private Button Button;
    public CourseDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView=inflater.inflate(R.layout.fragment_course_details, container, false);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.rViewCollege);
        Button button_viewAll = rootView.findViewById(R.id.button_viewAll);
        button_viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_panel,new OrganizationListFragment());
                fragmentTransaction.commit();
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this.getActivity(),2);
        recyclerView.setLayoutManager(mLayoutManager);
        nearbyCollegesAdapter = new NearbyCollegesAdapter(getContext(), nearbyColleges);
        recyclerView.setAdapter(nearbyCollegesAdapter);
      getNearbyColleges();

        return rootView;
    }



    private void getNearbyColleges() {
        Call<NearbyCollegesList> call = Apis.getApi().getCollegelist();
        call.enqueue(new Callback<NearbyCollegesList>() {
            @Override
            public void onResponse(Call<NearbyCollegesList> call, Response<NearbyCollegesList> response) {
                NearbyCollegesList nearbyCollegesList = response.body();
                Log.i("IndividualList:", "onResponse: " +nearbyCollegesList.getNearbyColleges());
                nearbyCollegesAdapter = new NearbyCollegesAdapter(getActivity(),nearbyCollegesList.getNearbyColleges());
            //    nearbyCollegesAdapter = new NearbyCollegesAdapter(nearbyCollegesList.getNearbyColleges(),getContext());
                setContents();
            }

            @Override
            public void onFailure(Call<NearbyCollegesList> call, Throwable t) {
                Toast.makeText(getContext(), "Failure", Toast.LENGTH_SHORT).show();

            }
            private void setContents() {
                recyclerView.setAdapter(nearbyCollegesAdapter);
            }
        });
    }

}
