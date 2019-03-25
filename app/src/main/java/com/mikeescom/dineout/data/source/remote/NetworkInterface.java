package com.mikeescom.dineout.data.source.remote;

import com.mikeescom.dineout.data.Category;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NetworkInterface {

    @GET("categories")
    Observable<List<Category>> getCategories(@Query("user-key") String user_key);

}
