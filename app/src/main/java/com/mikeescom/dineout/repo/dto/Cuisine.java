package com.mikeescom.dineout.repo.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cuisine {
    @SerializedName("cuisine_id")
    @Expose
    private String cuisineId;
    @SerializedName("cuisine_name")
    @Expose
    private String cuisineName;

    public String getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(String cuisineId) {
        this.cuisineId = cuisineId;
    }

    public String getCuisineName() {
        return cuisineName;
    }

    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
    }
}
