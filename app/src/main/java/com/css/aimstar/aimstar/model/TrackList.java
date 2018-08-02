package com.css.aimstar.aimstar.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TrackList {

    String TAG ="TrackList";
    @SerializedName("response")

    @Expose
    private ArrayList<Track> track = new ArrayList<>();

    public ArrayList<Track> getTrack() {
        return track;
    }

    public void setTrack(ArrayList<Track> track) {
        this.track = track;
    }
}
