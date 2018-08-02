package com.css.aimstar.aimstar.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class StoryModelList {
    @SerializedName("response")
    @Expose

    private ArrayList<Story> stories = new ArrayList<>();


    public ArrayList<Story> getStories() {
        return stories;
    }

    public void setStories(ArrayList<Story> stories) {
        this.stories = stories;
    }
}
