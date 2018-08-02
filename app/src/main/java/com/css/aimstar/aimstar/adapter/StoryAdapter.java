package com.css.aimstar.aimstar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import com.css.aimstar.aimstar.R;
import com.css.aimstar.aimstar.model.Story;

import java.util.ArrayList;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Story> storyList;

    public StoryAdapter(Context context, ArrayList<Story> storyList) {
        this.context = context;
        this.storyList = storyList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemViewS = LayoutInflater.from(parent.getContext()).inflate(R.layout.success_stories_card,parent, false);

        return new ViewHolder(itemViewS);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Story story = storyList.get(position);
        holder.videoName.setText(story.getTitle());
        holder.videoTime.setText(story.getCreated_at());
        holder.videoDescription.setText(story.getDescription());
        holder.videoView.setVideoPath(story.getPath());
        holder.videoView.start();
    }


    public int getItemCount() {
        return storyList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public VideoView videoView;
        public TextView videoName, videoTime, videoDescription;
        public ViewHolder(View itemView) {
            super(itemView);
            videoView= itemView.findViewById(R.id.videoView);
            videoName= itemView.findViewById(R.id.videoName);
            videoTime= itemView.findViewById(R.id.postedTime);
            videoDescription= itemView.findViewById(R.id.videoDescription);

        }
    }
    public StoryAdapter(ArrayList<Story> storyList, FragmentActivity activity){this.storyList= storyList;}
}
