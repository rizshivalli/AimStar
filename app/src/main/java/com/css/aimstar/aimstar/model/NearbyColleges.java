package com.css.aimstar.aimstar.model;

import com.google.gson.annotations.SerializedName;

public class NearbyColleges  {
    //private String name,description,image;
    @SerializedName("id")
    public int id;
    @SerializedName("title")
    public String title;

    @SerializedName("description")
    public String description;

    @SerializedName("image")
    public String image;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /*   public NearbyColleges(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }*/
}
