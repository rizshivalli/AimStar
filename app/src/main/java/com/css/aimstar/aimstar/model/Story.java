package com.css.aimstar.aimstar.model;

import com.google.gson.annotations.SerializedName;

public class Story{

    private static final String APIPATH = "http://10.0.2.2:3000";
    public static final String VIDPATH=APIPATH+"/uploads/videos/";
    public static final String FIMGPATH=APIPATH+"/uploads/images/feeds/";

    @SerializedName("title")
    public String title;
    @SerializedName("created_at")
    public String created_at;
    @SerializedName("description")
    public String description;
    @SerializedName("path")
    public String path;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

/*

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(String videoTime) {
        this.videoTime = videoTime;
    }

    public String getVideoDescription() {
        return videoDescription;
    }

    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

*/
  /*  public Story(String videoName, String videoTime, String videoDescription, String video) {
        this.videoName = videoName;
        this.videoTime = videoTime;
        this.videoDescription = videoDescription;
        this.video = video;
    }*/
}
