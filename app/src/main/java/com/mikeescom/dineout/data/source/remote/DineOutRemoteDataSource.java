package com.mikeescom.dineout.data.source.remote;

import com.mikeescom.dineout.data.Category;
import com.mikeescom.dineout.data.City;
import com.mikeescom.dineout.data.Collection;
import com.mikeescom.dineout.data.Cuisine;
import com.mikeescom.dineout.data.DailyMenu;
import com.mikeescom.dineout.data.Establishment;
import com.mikeescom.dineout.data.GeoCode;
import com.mikeescom.dineout.data.LocationDetails;
import com.mikeescom.dineout.data.Restaurant;
import com.mikeescom.dineout.data.Review;
import com.mikeescom.dineout.data.Search;
import com.mikeescom.dineout.data.source.DineOutDataSource;

import java.util.List;

import io.reactivex.Flowable;

public class DineOutRemoteDataSource implements DineOutDataSource {
    @Override
    public Flowable<List<Category>> getCategories() {
        return null;
    }

    @Override
    public Flowable<List<City>> getCities() {
        return null;
    }

    @Override
    public Flowable<List<Collection>> getCollections() {
        return null;
    }

    @Override
    public Flowable<List<Cuisine>> getCuisines() {
        return null;
    }

    @Override
    public Flowable<List<Establishment>> getEstablishments() {
        return null;
    }

    @Override
    public Flowable<GeoCode> getGeoCode() {
        return null;
    }

    @Override
    public Flowable<LocationDetails> getLocationDetails() {
        return null;
    }

    @Override
    public Flowable<DailyMenu> getDailyMenu() {
        return null;
    }

    @Override
    public Flowable<Restaurant> getRestaurant() {
        return null;
    }

    @Override
    public Flowable<Review> getReviews() {
        return null;
    }

    @Override
    public Flowable<Search> getSearch() {
        return null;
    }

    @Override
    public void saveCategory(Category category) {

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
