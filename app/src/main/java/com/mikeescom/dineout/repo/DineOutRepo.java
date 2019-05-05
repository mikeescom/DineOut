package com.mikeescom.dineout.repo;

import com.mikeescom.dineout.repo.request.GetCitiesResponse;
import com.mikeescom.dineout.repo.request.GetCollectionsResponse;

import io.reactivex.Observable;

public interface DineOutRepo {
    Observable<GetCitiesResponse> getCities(String q, double lat, double lon, String citiesIds, int count);
    Observable<GetCollectionsResponse> getCollections(int cityId, double lat, double lon, int count);
}

