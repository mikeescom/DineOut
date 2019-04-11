package com.mikeescom.dineout.repo.remote;

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

import java.util.List;

import io.reactivex.Observable;

public interface DineOutRemoteRepo {
    Observable<List<Category>> getCategories();
    Observable<List<City>> getCities();
    Observable<List<Collection>> getCollections();
    Observable<List<Cuisine>> getCuisines();
    Observable<List<Establishment>> getEstablishments();
    Observable<GeoCode> getGeoCode();
    Observable<LocationDetails> getLocationDetails();
    Observable<DailyMenu> getDailyMenu();
    Observable<Restaurant> getRestaurant();
    Observable<Review> getReviews();
    Observable<Search> getSearch();
}