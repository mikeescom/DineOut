package com.mikeescom.dineout.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class GeoCode {

    @SerializedName("locality")
    @Expose
    private Location locality;
    @SerializedName("popularity")
    @Expose
    private Popularity popularity;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("nearby_restaurants")
    @Expose
    private List<Restaurant> nearbyRestaurants = null;

    public Location getLocality() {
        return locality;
    }

    public void setLocality(Location locality) {
        this.locality = locality;
    }

    public Popularity getPopularity() {
        return popularity;
    }

    public void setPopularity(Popularity popularity) {
        this.popularity = popularity;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Restaurant> getNearbyRestaurants() {
        return nearbyRestaurants;
    }

    public void setNearbyRestaurants(List<Restaurant> nearbyRestaurants) {
        this.nearbyRestaurants = nearbyRestaurants;
    }

}