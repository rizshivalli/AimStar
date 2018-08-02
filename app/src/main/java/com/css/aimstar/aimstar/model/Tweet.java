package com.css.aimstar.aimstar.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sirajm on 14/06/18.
 */

public class Tweet {

    private static final String APIPATH = "http://10.0.2.2:3000";
    public static final String IMGPATH=APIPATH+"/uploads/images/";
    public static final String FIMGPATH=APIPATH+"/uploads/images/feeds/";

    @SerializedName("name")
    private String name;

    @SerializedName("profile_pic")
    private String profilePic;

    @SerializedName("tweet")
    private String tweet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePic() {
        return IMGPATH+profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }
}
