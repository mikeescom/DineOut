package com.mikeescom.dineout.data.source;

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

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;

public interface DineOutDataSource {
    Flowable<List<Category>> getCategories();
    Flowable<List<City>> getCities();
    Flowable<List<Collection>> getCollections();
    Flowable<List<Cuisine>> getCuisines();
    Flowable<List<Establishment>> getEstablishments();
    Flowable<GeoCode> getGeoCode();
    Flowable<LocationDetails> getLocationDetails();
    Flowable<DailyMenu> getDailyMenu();
    Flowable<Restaurant> getRestaurant();
    Flowable<Review> getReviews();
    Flowable<Search> getSearch();

    void saveCategory(@NonNull Category category);
    void saveCity(@NonNull City city);
    void saveCollection(@NonNull Collection collection);
    void saveCuisine(@NonNull Cuisine cuisine);
    void saveEstablishment(@NonNull Establishment establishment);
}
