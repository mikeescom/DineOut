package com.mikeescom.dineout.repo.remote;

import com.mikeescom.dineout.repo.dto.Category;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public class DineOutServices {
    public interface CategoriesServices {

        @GET("categories")
        Observable<List<Category>> getCategories();

    }
}
