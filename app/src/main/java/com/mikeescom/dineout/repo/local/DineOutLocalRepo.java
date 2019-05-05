package com.mikeescom.dineout.repo.local;

import com.mikeescom.dineout.repo.dto.Categories;
import com.mikeescom.dineout.repo.dto.City;
import com.mikeescom.dineout.repo.dto.Collection;
import com.mikeescom.dineout.repo.dto.Collections;
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
import io.reactivex.annotations.NonNull;

public interface DineOutLocalRepo {
    Observable<GetCategoriesResponse> getCategories();
    Observable<GetCitiesResponse> getCities();
    Observable<GetCollectionsResponse> getCollections();
    Observable<List<Cuisine>> getCuisines();
    Observable<List<Establishment>> getEstablishments();
    Observable<GeoCode> getGeoCode();
    Observable<LocationDetails> getLocationDetails();
    Observable<DailyMenu> getDailyMenu();
    Observable<Restaurant> getRestaurant();
    Observable<Review> getReviews();
    Observable<Search> getSearch();

    void saveCategories(@NonNull List<Categories> categories);
    void saveCities(@NonNull List<City> city);
    void saveCollection(@NonNull List<Collections> collections);
    void saveCuisine(@NonNull Cuisine cuisine);
    void saveEstablishment(@NonNull Establishment establishment);
}
