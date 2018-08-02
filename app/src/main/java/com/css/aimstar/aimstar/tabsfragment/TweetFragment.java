package com.css.aimstar.aimstar.tabsfragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.css.aimstar.aimstar.R;
import com.css.aimstar.aimstar.adapter.TweetListAdapter;
import com.css.aimstar.aimstar.model.TweetList;
import com.css.aimstar.aimstar.networking.Apis;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TweetFragment extends Fragment {
    private RecyclerView recyclerView;
    private View rootView;
    private TweetListAdapter tweetListAdapter;
    public TweetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_tweet, container, false);
        initialise();
        recyclerView =(RecyclerView) rootView.findViewById(R.id.rvTweets);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return rootView;
    }

    private void initialise() {
        populateTweets();
    }

    private void populateTweets() {

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading Please wait");
        progressDialog.show();
        Call<TweetList> call = Apis.getApi().getTweets();
        call.enqueue(new Callback<TweetList>() {
            @Override
            public void onResponse(Call<TweetList> call, Response<TweetList> response) {
                progressDialog.dismiss();
                TweetList tweetList = response.body();
                Log.i("IndividualList:", "onResponse: "+tweetList.getTweets());
                tweetListAdapter = new TweetListAdapter(tweetList.getTweets(),getContext());
                SetContents();
            }

            @Override
            public void onFailure(Call<TweetList> call, Throwable t) {

            }
        });
    }

    private void SetContents() {
        recyclerView.setAdapter(tweetListAdapter);
    }

}
