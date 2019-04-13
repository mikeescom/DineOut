package com.mikeescom.dineout.repo.request;

import com.mikeescom.dineout.repo.dto.City;

import java.util.List;

public class GetCitiesResponse {
    private List<City> location_suggestions;

    public GetCitiesResponse(List<City> cities) {
        this.location_suggestions = cities;
    }

    public List<City> getLocation_suggestions() {
        return location_suggestions;
    }

    public void setLocation_suggestions(List<City> location_suggestions) {
        this.location_suggestions = location_suggestions;
    }
}
