package com.css.aimstar.aimstar.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CourseDetailsModelList {


    @SerializedName("response")
    @Expose

    private ArrayList<CourseDetails> courseDetails = new ArrayList<>();

    public ArrayList<CourseDetails> getCourseDetails() {
        return courseDetails;
    }

    public void setCourseDetails(ArrayList<CourseDetails> courseDetails) {
        this.courseDetails = courseDetails;
    }
}
