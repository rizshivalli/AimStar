package com.css.aimstar.aimstar.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.css.aimstar.aimstar.R;
import com.css.aimstar.aimstar.adapter.NearbyCollegesAdapter;
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
public class OrganizationListFragment extends Fragment {
private  View rootView;
    private RecyclerView recyclerView;
    private List<NearbyColleges> nearbyColleges =new ArrayList<>();
    private NearbyCollegesAdapter nearbyCollegesAdapter;
    TextView name,description;
    ImageView image;
    public OrganizationListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =inflater.inflate(R.layout.fragment_organization_list, container, false);
        recyclerView=(RecyclerView)rootView.findViewById(R.id.rViewNearbyColleges);
        name=(TextView) rootView.findViewById(R.id.name);
        description=(TextView)rootView.findViewById(R.id.description);
        image=(ImageView)rootView.findViewById(R.id.image);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this.getActivity(),2);
        recyclerView.setLayoutManager(mLayoutManager);
        nearbyCollegesAdapter = new NearbyCollegesAdapter(getActivity(), nearbyColleges);
        recyclerView.swapAdapter(nearbyCollegesAdapter, false);
        nearbyCollegesAdapter.notifyDataSetChanged();

        getData();

        return rootView;
    }

    private void getData() {

        Call<NearbyCollegesList> call= Apis.getApi().getCollegelist();
        call.enqueue(new Callback<NearbyCollegesList>() {
            @Override
            public void onResponse(Call<NearbyCollegesList> call, Response<NearbyCollegesList> response) {
                NearbyCollegesList nearbyCollegesList = response.body();
                Log.i("IndividualList:", "onResponse: "+nearbyCollegesList.getNearbyColleges());
                nearbyCollegesAdapter = new NearbyCollegesAdapter(getContext(),nearbyCollegesList.getNearbyColleges());
                SetContents();
            }

            @Override
            public void onFailure(Call<NearbyCollegesList> call, Throwable t) {

            }
        });

                 }

    private void SetContents() {
        recyclerView.setAdapter(nearbyCollegesAdapter);
    }
}
