package com.mikeescom.dineout.repo.local;

import com.mikeescom.dineout.repo.dto.Categories;
import com.mikeescom.dineout.repo.dto.City;
import com.mikeescom.dineout.repo.dto.Collections;
import com.mikeescom.dineout.repo.dto.Cuisine;
import com.mikeescom.dineout.repo.dto.DailyMenu;
import com.mikeescom.dineout.repo.dto.Establishment;
import com.mikeescom.dineout.repo.dto.GeoCode;
import com.mikeescom.dineout.repo.dto.LocationDetails;
import com.mikeescom.dineout.repo.dto.Restaurant;
import com.mikeescom.dineout.repo.dto.Review;
import com.mikeescom.dineout.repo.dto.Search;
import com.mikeescom.dineout.repo.local.dbobjects.DBCategory;
import com.mikeescom.dineout.repo.local.dbobjects.DBCity;
import com.mikeescom.dineout.repo.request.GetCategoriesResponse;
import com.mikeescom.dineout.repo.request.GetCitiesResponse;
import com.mikeescom.dineout.repo.request.GetCollectionsResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;

import static com.google.common.base.Preconditions.checkNotNull;

public class DineOutLocalRepoImpl implements DineOutLocalRepo {

    private CategoriesDao categoriesDao;
    private CitiesDao citiesDao;
    private CollectionsDao collectionsDao;

    public DineOutLocalRepoImpl(DineOutLocalDB dineOutLocalDB) {
        this.categoriesDao = dineOutLocalDB.categoriesDao();
        this.citiesDao = dineOutLocalDB.citiesDao();
        this.collectionsDao = dineOutLocalDB.collectionsDao();
    }

    @Override
    public Observable<GetCategoriesResponse> getCategories() {
        return Observable.fromCallable(new Callable<GetCategoriesResponse>() {
            @Override
            public GetCategoriesResponse call() throws Exception {
                List<Categories> categoriesList = new ArrayList<>();
                for (DBCategory dbCategory : categoriesDao.getAll()) {
                    categoriesList.add(new Categories(dbCategory.getId(), dbCategory.getName()));
                }
                return new GetCategoriesResponse(categoriesList);
            }
        });
    }

    @Override
    public void saveCategories(List<Categories> categories) {
        List<DBCategory> dbCategoryList = new ArrayList<>();
        for (Categories categoriesObject : categories) {
            dbCategoryList.add(new DBCategory(categoriesObject.getCategory().getId(), categoriesObject.getCategory().getName()));
        }
        categoriesDao.insertAll(dbCategoryList);
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

    @Override
    public Observable<List<Cuisine>> getCuisines() {
        return null;
    }

    @Override
    public Observable<List<Establishment>> getEstablishments() {
        return null;
    }

    @Override
    public Observable<GeoCode> getGeoCode() {
        return null;
    }

    @Override
    public Observable<LocationDetails> getLocationDetails() {
        return null;
    }

    @Override
    public Observable<DailyMenu> getDailyMenu() {
        return null;
    }

    @Override
    public Observable<Restaurant> getRestaurant() {
        return null;
    }

    @Override
    public Observable<Review> getReviews() {
        return null;
    }

    @Override
    public Observable<Search> getSearch() {
        return null;
    }

    @Override
    public void saveCuisine(Cuisine cuisine) {

    }

    @Override
    public void saveEstablishment(Establishment establishment) {

    }
}
