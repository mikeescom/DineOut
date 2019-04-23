package com.mikeescom.dineout.repo.remote;

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
import com.mikeescom.dineout.repo.request.GetCategoriesResponse;
import com.mikeescom.dineout.repo.request.GetCitiesResponse;
import com.mikeescom.dineout.repo.request.GetCollectionsResponse;

import java.util.List;

import io.reactivex.Observable;

public interface DineOutRemoteRepo {
    Observable<GetCategoriesResponse> getCategories();
    Observable<GetCitiesResponse> getCities(String q, double lat, double lon, String citiesIds, int count);
    Observable<GetCollectionsResponse> getCollections(int cityId, double lat, double lon, int count);
    Observable<List<Cuisine>> getCuisines();
    Observable<List<Establishment>> getEstablishments();
    Observable<GeoCode> getGeoCode();
    Observable<LocationDetails> getLocationDetails();
    Observable<DailyMenu> getDailyMenu();
    Observable<Restaurant> getRestaurant();
    Observable<Review> getReviews();
    Observable<Search> getSearch();
}
