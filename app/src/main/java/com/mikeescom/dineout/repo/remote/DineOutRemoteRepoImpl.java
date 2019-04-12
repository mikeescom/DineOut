package com.mikeescom.dineout.repo.remote;

import com.mikeescom.dineout.base.remote.BaseRemote;
import com.mikeescom.dineout.base.remote.RemoteConfiguration;
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
import com.mikeescom.dineout.repo.request.GetCategoriesRequest;

import java.util.List;

import io.reactivex.Observable;

public class DineOutRemoteRepoImpl extends BaseRemote implements DineOutRemoteRepo {
    @Override
    public Observable<GetCategoriesRequest> getCategories() {
        return create(DineOutServices.CategoriesServices.class, RemoteConfiguration.BASE_URL).getCategories();
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
}
