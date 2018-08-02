package com.css.aimstar.aimstar.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.css.aimstar.aimstar.R;
import com.css.aimstar.aimstar.adapter.TextTabsAdapter;
import com.css.aimstar.aimstar.tabsfragment.StoryFragment;
import com.css.aimstar.aimstar.tabsfragment.TweetFragment;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private View rootView;
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TextTabsAdapter adapter;
    public HomeFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_home, container, false);
        initialise();
        prepareDataResource();

        viewPager = (ViewPager) rootView.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        adapter = new TextTabsAdapter(getChildFragmentManager(), fragmentList, titleList);
        viewPager.setAdapter(adapter);
        // Link ViewPager and TabLayout
        tabLayout.setupWithViewPager(viewPager);
        return rootView;
    }

    private void initialise() {

    }

    private void prepareDataResource() {

        addData(new TweetFragment(), "Experts Tweet");
        addData(new StoryFragment(), "Success Stories");


        // addData(new StoresFragment(), "THREE");
    }

    private void addData(Fragment fragment, String title) {
        fragmentList.add(fragment);
        titleList.add(title);
    }
}
