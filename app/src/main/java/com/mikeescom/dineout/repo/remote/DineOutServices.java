package com.mikeescom.dineout.repo.remote;

import com.mikeescom.dineout.base.remote.RemoteConfiguration;
import com.mikeescom.dineout.repo.dto.Category;
import com.mikeescom.dineout.repo.request.GetCategoriesRequest;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public class DineOutServices {
    public interface CategoriesServices {

        @Headers({"user-key: " + RemoteConfiguration.API_KEY})
        @GET("categories")
        Observable<GetCategoriesRequest> getCategories();

    }
}
