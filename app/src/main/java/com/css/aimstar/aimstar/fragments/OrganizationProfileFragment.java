package com.css.aimstar.aimstar.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.css.aimstar.aimstar.ProfileActivity;
import com.css.aimstar.aimstar.R;
import com.css.aimstar.aimstar.adapter.TextTabsAdapter;
import com.css.aimstar.aimstar.tabsfragment.PostsFragment;
import com.css.aimstar.aimstar.tabsfragment.ProcedureFragment;
import com.css.aimstar.aimstar.tabsfragment.ReviewsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrganizationProfileFragment extends Fragment {   /* ActionBar actionBar = getActivity().getActionBar();
ViewPager mViewPager;
TextTabsAdapter adapter;*/
    /* actionBar.hide();*/
    private View rootView;
   // private ProfileFragmentAdapter profileFragmentAdapter;

    private ProfileActivity profileActivity;
    private TextView mTextMessage;
    ViewPager viewPager;
    TabLayout tabLayout;
    TextTabsAdapter adapter;
    List<Fragment> fragmentList = new ArrayList<>();
    List<String> titleList = new ArrayList<>();

    public OrganizationProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_organization_profile, container, false);
        initialise();
        clicklisteners();
        prepareDataResource();
        // profileFragmentAdapter = new ProfileFragmentAdapter(getActivity().getSupportFragmentManager());
        //  vpPager.setAdapter(profileFragmentAdapter);
        adapter = new TextTabsAdapter(getChildFragmentManager(), fragmentList, titleList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        //  viewPager.setAdapter(new TextTabsAdapter(getChildFragmentManager(),fragmentList,titleList));
        return rootView;
    }
    private void initialise() {
        viewPager = (ViewPager) rootView.findViewById(R.id.viewPagerProfile);
        tabLayout = (TabLayout) rootView.findViewById(R.id.profileTabs);
    }

    private void prepareDataResource() {

        addData(new PostsFragment(), "Posts");
        addData(new ReviewsFragment(), "Reviews");
        addData(new ProcedureFragment(), "Procedure");


        // addData(new StoresFragment(), "THREE");
    }

    private void addData(Fragment fragment, String title) {
        fragmentList.add(fragment);
        titleList.add(title);
    }



    private void clicklisteners() {

    }

  /*  @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }
    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }*/

}
