package com.mikeescom.dineout.repo.local;

import com.mikeescom.dineout.repo.dto.City;
import com.mikeescom.dineout.repo.dto.Collections;
import com.mikeescom.dineout.repo.local.dbobjects.DBCity;
import com.mikeescom.dineout.repo.request.GetCitiesResponse;
import com.mikeescom.dineout.repo.request.GetCollectionsResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;

public class DineOutLocalRepoImpl implements DineOutLocalRepo {

    private CitiesDao citiesDao;
    private CollectionsDao collectionsDao;

    public DineOutLocalRepoImpl(DineOutLocalDB dineOutLocalDB) {
        this.citiesDao = dineOutLocalDB.citiesDao();
        this.collectionsDao = dineOutLocalDB.collectionsDao();
    }

    @Override
    public Observable<GetCitiesResponse> getCities() {
        return Observable.fromCallable(new Callable<GetCitiesResponse>() {
            @Override
            public GetCitiesResponse call() throws Exception {
                List<City> cityList = new ArrayList<>();
                for (DBCity dbCity : citiesDao.getAll()) {
                    cityList.add(new City(dbCity.getId()
                            , dbCity.getName()
                            , dbCity.getCountryId()
                            , dbCity.getCountryName()
                            , dbCity.getCountryFlagUrl()
                            , dbCity.getShouldExperimentWith()
                            , dbCity.getDiscoveryEnabled()
                            , dbCity.getHasNewAdFormat()
                            , dbCity.getIsState()
                            , dbCity.getStateId()
                            , dbCity.getStateName()
                            , dbCity.getStateCode()));
                }
                return new GetCitiesResponse(cityList);
            }
        });
    }

    @Override
    public void saveCities(List<City> cities) {
        List<DBCity> dbCitiesList = new ArrayList<>();
        for (City cityObject : cities) {
            dbCitiesList.add(new DBCity(cityObject.getId()
                    , cityObject.getName()
                    , cityObject.getCountry_id()
                    , cityObject.getCountry_name()
                    , cityObject.getCountry_flag_url()
                    , cityObject.getShould_experiment_with()
                    , cityObject.getDiscovery_enabled()
                    , cityObject.getHas_new_ad_format()
                    , cityObject.getIs_state()
                    , cityObject.getState_id()
                    , cityObject.getState_name()
                    , cityObject.getState_code()));
        }
        citiesDao.insertAll(dbCitiesList);
    }

    @Override
    public void saveCollection(List<Collections> collections) {
        List<DBCollection> dbCollectionList = new ArrayList<>();
        for (Collections collectionsObject : collections) {
            dbCollectionList.add(new DBCollection(collectionsObject.getCollection().getCollectionId()
                    , collectionsObject.getCollection().getResCount()
                    , collectionsObject.getCollection().getImageUrl()
                    , collectionsObject.getCollection().getUrl()
                    , collectionsObject.getCollection().getTitle()
                    , collectionsObject.getCollection().getDescription()
                    , collectionsObject.getCollection().getShareUrl()));
        }
        collectionsDao.insertAll(dbCollectionList);
    }

    @Override
    public Observable<GetCollectionsResponse> getCollections() {
        return Observable.fromCallable(new Callable<GetCollectionsResponse>() {
            @Override
            public GetCollectionsResponse call() throws Exception {
                List<Collections> collectionsList = new ArrayList<>();
                for (DBCollection dbCollection : collectionsDao.getAll()) {
                    collectionsList.add(new Collections(dbCollection.getCollectionId()
                            , dbCollection.getTitle()
                            , dbCollection.getUrl()
                            , dbCollection.getDescription()
                            , dbCollection.getImageUrl()
                            , dbCollection.getResCount()
                            , dbCollection.getShareUrl()));
                }
                return new GetCollectionsResponse(collectionsList);
            }
        });
    }
}
