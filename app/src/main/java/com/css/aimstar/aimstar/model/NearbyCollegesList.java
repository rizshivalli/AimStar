package com.css.aimstar.aimstar.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NearbyCollegesList {
    @SerializedName("response")

    @Expose
    private ArrayList<NearbyColleges> nearbyColleges=new ArrayList<>();

    public ArrayList<NearbyColleges> getNearbyColleges(){ return nearbyColleges; }

    public void setNearbyColleges(ArrayList<NearbyColleges> resultModels) {
        this.nearbyColleges = nearbyColleges;
    }
}
