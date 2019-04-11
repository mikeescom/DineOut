package com.mikeescom.dineout.repo.local;

import android.support.annotation.VisibleForTesting;

import com.mikeescom.dineout.repo.dto.Category;
import com.mikeescom.dineout.repo.dto.City;
import com.mikeescom.dineout.repo.dto.Collection;
import com.mikeescom.dineout.repo.dto.Cuisine;
import com.mikeescom.dineout.repo.dto.DailyMenu;
import com.mikeescom.dineout.repo.dto.Establishment;
import com.mikeescom.dineout.repo.dto.GeoCode;
import com.mikeescom.dineout.repo.dto.LocationDetails;
import com.mikeescom.dineout.repo.dto.Restaurant;
import com.mikeescom.dineout.repo.dto.Review;
import com.mikeescom.dineout.repo.dto.Search;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

public class DineOutLocalRepoImpl implements DineOutLocalRepo {

    private CategoriesDao categoriesDao;

    public DineOutLocalRepoImpl(CategoriesDao categoriesDao) {
        this.categoriesDao = categoriesDao;
    }

    @Override
    public Observable<List<Category>> getCategories() {
        return Observable.fromCallable(new Callable<List<Category>>() {
            @Override
            public List<Category> call() throws Exception {
                return categoriesDao.getAll();
            }
        });
    }

    @Override
    public void saveCategories(List<Category> categories) {
        categoriesDao.insertAll(categories);
    }

    @Override
    public Observable<List<City>> getCities() {
        return null;
    }

    @Override
    public Observable<List<Collection>> getCollections() {
        return null;
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
    public void saveCity(City city) {

    }

    @Override
    public void saveCollection(Collection collection) {

    }

    @Override
    public void saveCuisine(Cuisine cuisine) {

    }

    @Override
    public void saveEstablishment(Establishment establishment) {

    }
}
