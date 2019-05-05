package com.mikeescom.dineout.repo.remote;

import com.mikeescom.dineout.repo.request.GetCitiesResponse;
import com.mikeescom.dineout.repo.request.GetCollectionsResponse;

import io.reactivex.Observable;

public interface DineOutRemoteRepo {
    Observable<GetCitiesResponse> getCities(String q, double lat, double lon, String citiesIds, int count);
    Observable<GetCollectionsResponse> getCollections(int cityId, double lat, double lon, int count);
}
