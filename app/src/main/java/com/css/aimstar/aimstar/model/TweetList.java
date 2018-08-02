package com.css.aimstar.aimstar.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by sirajm on 14/06/18.
 */

public class TweetList {
    String TAG ="TweetList";
    @SerializedName("response")
    @Expose
    private ArrayList<Tweet> tweets = new ArrayList<>();

    public ArrayList<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(ArrayList<Tweet> tweets) {
        this.tweets = tweets;
    }
}
