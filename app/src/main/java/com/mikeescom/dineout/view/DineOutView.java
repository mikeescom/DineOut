package com.mikeescom.dineout.view;

import com.mikeescom.dineout.base.view.MvpView;
import com.mikeescom.dineout.repo.dto.Categories;
import com.mikeescom.dineout.repo.dto.City;
import com.mikeescom.dineout.repo.dto.Collections;

import java.util.List;

public interface DineOutView extends MvpView {
    void showCategories(List<Categories> categories);
    void showCities(List<City> cities);
    void showCollections(List<Collections> collections);
}
