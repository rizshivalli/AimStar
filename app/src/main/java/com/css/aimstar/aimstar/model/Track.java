package com.css.aimstar.aimstar.model;

import com.google.gson.annotations.SerializedName;

public class Track {


    private static final String APIPATH = "http://10.0.2.2:3000";

    @SerializedName("recommendedCourse")
    private String recommendedCourse;

    @SerializedName("graduationCourse1")
    private String graduationCourse1;

    @SerializedName("otherRCourse2")
    private String otherRCourse2;


    @SerializedName("otherRCourse1")
    private String otherRCourse1;


    @SerializedName("otherCourse1")
    private String otherCourse1;


    @SerializedName("otherCourse2")
    private String otherCourse2;


    @SerializedName("graduationCourse2")
    private String graduationCourse2;


    public static String getAPIPATH() {
        return APIPATH;
    }

    public String getRecommendedCourse() {
        return recommendedCourse;
    }

    public void setRecommendedCourse(String recommendedCourse) {
        this.recommendedCourse = recommendedCourse;
    }

    public String getGraduationCourse1() {
        return graduationCourse1;
    }

    public void setGraduationCourse1(String graduationCourse1) {
        this.graduationCourse1 = graduationCourse1;
    }

    public String getOtherRCourse2() {
        return otherRCourse2;
    }

    public void setOtherRCourse2(String otherRCourse2) {
        this.otherRCourse2 = otherRCourse2;
    }

    public String getOtherRCourse1() {
        return otherRCourse1;
    }

    public void setOtherRCourse1(String otherRCourse1) {
        this.otherRCourse1 = otherRCourse1;
    }

    public String getOtherCourse1() {
        return otherCourse1;
    }

    public void setOtherCourse1(String otherCourse1) {
        this.otherCourse1 = otherCourse1;
    }

    public String getOtherCourse2() {
        return otherCourse2;
    }

    public void setOtherCourse2(String otherCourse2) {
        this.otherCourse2 = otherCourse2;
    }

    public String getGraduationCourse2() {
        return graduationCourse2;
    }

    public void setGraduationCourse2(String graduationCourse2) {
        this.graduationCourse2 = graduationCourse2;
    }
}
