package com.mikeescom.dineout.repo;

import com.mikeescom.dineout.repo.request.GetCategoriesResponse;
import com.mikeescom.dineout.repo.request.GetCitiesResponse;

import io.reactivex.Observable;

public interface DineOutRepo {
    Observable<GetCategoriesResponse> getCategories();
    Observable<GetCitiesResponse> getCities(String q, double lat, double lon, String citiesIds, int count);
}

