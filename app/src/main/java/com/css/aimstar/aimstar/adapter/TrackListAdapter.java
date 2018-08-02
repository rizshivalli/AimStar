package com.css.aimstar.aimstar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.css.aimstar.aimstar.R;
import com.css.aimstar.aimstar.model.Track;

import java.util.ArrayList;
import java.util.List;

public class TrackListAdapter extends RecyclerView.Adapter<TrackListAdapter.TrackHolder> {
    private LayoutInflater mInflater;
    private Context mContext;
    private List<Track> mTrackList;




    public TrackListAdapter(ArrayList<Track> mTrackList, Context mContext, LayoutInflater mInflater) {
        this.mInflater = mInflater;
        this.mContext = mContext;
        this.mTrackList = mTrackList;
}


    @Override
    public TrackListAdapter.TrackHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.track_layout,parent,false);
        TrackHolder trackHolder = new TrackHolder(view);
        return trackHolder;
    }

    @Override
    public void onBindViewHolder(TrackListAdapter.TrackHolder holder, int position) {
        Track track = mTrackList.get(position);
        holder.recommendedCourse.setText(track.getRecommendedCourse());
        holder.graduationCourse1.setText(track.getGraduationCourse1());
        holder.graduationCourse2.setText(track.getGraduationCourse2());
        holder.otherRCourse1.setText(track.getOtherRCourse1());
        holder.otherRCourse2.setText(track.getOtherRCourse2());
        holder.otherCourse1.setText(track.getOtherCourse1());
        holder.otherCourse2.setText(track.getOtherCourse2());

    }

    @Override
    public int getItemCount() {
        return mTrackList.size();
    }

    public class TrackHolder extends RecyclerView.ViewHolder {
       private Button recommendedCourse, graduationCourse1, otherRCourse2, otherRCourse1,otherCourse1, otherCourse2, graduationCourse2;
        public TrackHolder(View itemView) {

            super(itemView);
            recommendedCourse = itemView.findViewById(R.id.recommendedCourse);
            otherCourse1 = itemView.findViewById(R.id.otherCourse1);
            otherCourse2 = itemView.findViewById(R.id.otherCourse2);
            otherRCourse2 = itemView.findViewById(R.id.otherRCourse2);
            graduationCourse1 = itemView.findViewById(R.id.graduationCourse1);
            graduationCourse2 = itemView.findViewById(R.id.graduationCourse2);
            otherRCourse1 = itemView.findViewById(R.id.otherCourse1);
        }
    }
}
