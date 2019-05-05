package com.mikeescom.dineout.repo.local;

import com.mikeescom.dineout.repo.dto.City;
import com.mikeescom.dineout.repo.dto.Collections;
import com.mikeescom.dineout.repo.request.GetCitiesResponse;
import com.mikeescom.dineout.repo.request.GetCollectionsResponse;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

public interface DineOutLocalRepo {
    Observable<GetCitiesResponse> getCities();
    Observable<GetCollectionsResponse> getCollections();

    void saveCities(@NonNull List<City> city);
    void saveCollection(@NonNull List<Collections> collections);
}
