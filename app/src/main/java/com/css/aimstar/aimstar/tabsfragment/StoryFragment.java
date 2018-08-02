package com.css.aimstar.aimstar.tabsfragment;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.css.aimstar.aimstar.R;
import com.css.aimstar.aimstar.adapter.StoryAdapter;
import com.css.aimstar.aimstar.model.Story;
import com.css.aimstar.aimstar.model.StoryModelList;
import com.css.aimstar.aimstar.networking.Apis;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoryFragment extends Fragment {
    private RecyclerView SrecyclerView;
    private StoryAdapter storyAdapter;
    private ArrayList<Story> storyList = new ArrayList<>();
    private VideoView videoView;
    private  Story story;

    public StoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_story, container, false);
     //   videoView = (VideoView)rootView.findViewById(R.id.videoView);
      /* String uri="http://10.0.2.2/bunny.mp4";
        video.setVideoURI(Uri.parse(uri));*/
      /*  video.setMediaController(new MediaController(getContext()));
        video.requestFocus();
        video.start();*/
        SrecyclerView=(RecyclerView) rootView.findViewById(R.id.rViewSuccess);

        RecyclerView.LayoutManager layoutManagerS=new LinearLayoutManager(getActivity());
        SrecyclerView.setLayoutManager(layoutManagerS);
        storyAdapter = new StoryAdapter(getActivity(),storyList);

        SrecyclerView.setAdapter(storyAdapter);
        getStory();
        return  rootView;
    }

    private void getStory() {
        Call<StoryModelList> call = Apis.getApi().getStoryData();
        call.enqueue(new Callback<StoryModelList>() {
            @Override
            public void onResponse(Call<StoryModelList> call, Response<StoryModelList> response) {

                storyList=response.body().getStories();

                storyAdapter = new StoryAdapter(storyList, getActivity());
                SrecyclerView.swapAdapter(storyAdapter, false);
                storyAdapter.notifyDataSetChanged();

                Log.i("", "onResponse: ");
                Toast.makeText(getContext(),"Successful Story ", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<StoryModelList> call, Throwable t) {
                Toast.makeText(getContext(), "Story Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
