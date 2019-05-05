package com.mikeescom.dineout.repo.remote;

import com.mikeescom.dineout.base.remote.BaseRemote;
import com.mikeescom.dineout.base.remote.RemoteConfiguration;
import com.mikeescom.dineout.repo.request.GetCitiesResponse;
import com.mikeescom.dineout.repo.request.GetCollectionsResponse;

import io.reactivex.Observable;

public class DineOutRemoteRepoImpl extends BaseRemote implements DineOutRemoteRepo {
    @Override
    public Observable<GetCitiesResponse> getCities(String q, double lat, double lon, String citiesIds, int count) {
        return create(DineOutServices.CitiesServices.class, RemoteConfiguration.BASE_URL)
                .getCities(q, lat, lon, citiesIds, count);
    }

    @Override
    public Observable<GetCollectionsResponse> getCollections(int cityId, double lat, double lon, int count) {
        return create(DineOutServices.CollectionsServices.class, RemoteConfiguration.BASE_URL)
                .getCollections(cityId, lat, lon, count);
    }

}
