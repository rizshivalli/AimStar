package com.css.aimstar.aimstar.model;

import com.google.gson.annotations.SerializedName;

public class CourseDetails {
    @SerializedName("id")
    public int id;
    @SerializedName("title")
    public String title;
    @SerializedName("image")
    public String image;
    @SerializedName("description")
    public String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
