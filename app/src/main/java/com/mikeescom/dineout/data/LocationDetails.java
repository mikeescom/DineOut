package com.mikeescom.dineout.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LocationDetails {
    @SerializedName("popularity")
    @Expose
    private Popularity popularity;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("best_rated_restaurants")
    @Expose
    private List<Restaurant> bestRatedRestaurants = null;

    public Popularity getPopularity() {
        return popularity;
    }

    public void setPopularity(Popularity popularity) {
        this.popularity = popularity;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Restaurant> getBestRatedRestaurants() {
        return bestRatedRestaurants;
    }

    public void setBestRatedRestaurants(List<Restaurant> bestRatedRestaurants) {
        this.bestRatedRestaurants = bestRatedRestaurants;
    }

}
