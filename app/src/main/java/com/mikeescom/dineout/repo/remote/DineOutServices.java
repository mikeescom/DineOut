package com.mikeescom.dineout.repo.remote;

import com.mikeescom.dineout.base.remote.RemoteConfiguration;
import com.mikeescom.dineout.repo.request.GetCategoriesResponse;
import com.mikeescom.dineout.repo.request.GetCitiesResponse;
import com.mikeescom.dineout.repo.request.GetCollectionsResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public class DineOutServices {
    public interface CategoriesServices {

        @Headers({"user-key: " + RemoteConfiguration.API_KEY})
        @GET("categories")
        Observable<GetCategoriesResponse> getCategories();

    }

    public interface CitiesServices {

        @Headers({"user-key: " + RemoteConfiguration.API_KEY})
        @GET("cities")
        Observable<GetCitiesResponse> getCities(@Query("q") String q
                , @Query("lat") double lat
                , @Query("lon") double lon
                , @Query("citiesIds") String citiesIds
                , @Query("count") int count);

    }

    public interface CollectionsServices {

        @Headers({"user-key: " + RemoteConfiguration.API_KEY})
        @GET("collections")
        Observable<GetCollectionsResponse> getCollections(@Query("city_id") int city_id
                , @Query("lat") double lat
                , @Query("lon") double lon
                , @Query("count") int count);

    }
}
