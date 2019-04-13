package com.mikeescom.dineout.repo;

import com.mikeescom.dineout.repo.local.DineOutLocalRepo;
import com.mikeescom.dineout.repo.remote.DineOutRemoteRepo;
import com.mikeescom.dineout.repo.request.GetCategoriesResponse;
import com.mikeescom.dineout.repo.request.GetCitiesResponse;

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
    public Observable<GetCategoriesResponse> getCategories() {
        return Observable.mergeDelayError(remoteDineOutRepo.getCategories().doOnNext(new Consumer<GetCategoriesResponse>() {
                    @Override
                    public void accept(GetCategoriesResponse categories) throws Exception {
                        localDineOutRepo.saveCategories(categories.getCategories());
                    }
                }).subscribeOn(Schedulers.io()), localDineOutRepo.getCategories().subscribeOn(Schedulers.io())
        );
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
}
