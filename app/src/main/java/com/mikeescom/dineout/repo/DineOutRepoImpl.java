package com.mikeescom.dineout.repo;

import com.mikeescom.dineout.repo.local.DineOutLocalRepo;
import com.mikeescom.dineout.repo.remote.DineOutRemoteRepo;
import com.mikeescom.dineout.repo.request.GetCitiesResponse;
import com.mikeescom.dineout.repo.request.GetCollectionsResponse;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DineOutRepoImpl implements DineOutRepo {

    DineOutRemoteRepo remoteDineOutRepo;
    DineOutLocalRepo localDineOutRepo;

    public DineOutRepoImpl(DineOutRemoteRepo remoteDineOutRepo, DineOutLocalRepo localDineOutRepo) {
        this.remoteDineOutRepo = remoteDineOutRepo;
        this.localDineOutRepo = localDineOutRepo;
    }

    @Override
    public Observable<GetCitiesResponse> getCities(String q, double lat, double lon, String citiesIds, int count) {
        return Observable.mergeDelayError(remoteDineOutRepo.getCities(q, lat, lon, citiesIds, count).doOnNext(new Consumer<GetCitiesResponse>() {
                    @Override
                    public void accept(GetCitiesResponse cities) throws Exception {
                        localDineOutRepo.saveCities(cities.getLocation_suggestions());
                    }
                }).subscribeOn(Schedulers.io()), localDineOutRepo.getCities().subscribeOn(Schedulers.io())
        );
    }

    @Override
    public Observable<GetCollectionsResponse> getCollections(int cityId, double lat, double lon, int count) {
        return Observable.mergeDelayError(remoteDineOutRepo.getCollections(cityId, lat, lon, count).doOnNext(new Consumer<GetCollectionsResponse>() {
                    @Override
                    public void accept(GetCollectionsResponse collections) throws Exception {
                        localDineOutRepo.saveCollection(collections.getCollections());
                    }
                }).subscribeOn(Schedulers.io()), localDineOutRepo.getCollections().subscribeOn(Schedulers.io())
        );
    }
}
