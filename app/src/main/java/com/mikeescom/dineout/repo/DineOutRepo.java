package com.mikeescom.dineout.repo;

import com.mikeescom.dineout.repo.dto.Category;

import java.util.List;

import io.reactivex.Observable;

public interface DineOutRepo {
    Observable<List<Category>> getCategories();
}

