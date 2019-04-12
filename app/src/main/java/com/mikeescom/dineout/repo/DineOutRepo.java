package com.mikeescom.dineout.repo;

import com.mikeescom.dineout.repo.dto.Category;
import com.mikeescom.dineout.repo.request.GetCategoriesRequest;

import java.util.List;

import io.reactivex.Observable;

public interface DineOutRepo {
    Observable<GetCategoriesRequest> getCategories();
}

