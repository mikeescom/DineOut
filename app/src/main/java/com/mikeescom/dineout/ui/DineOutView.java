package com.mikeescom.dineout.ui;

import com.mikeescom.dineout.base.view.MvpView;
import com.mikeescom.dineout.repo.dto.City;
import com.mikeescom.dineout.repo.dto.Collections;

import java.util.List;

public interface DineOutView extends MvpView {
    void showCities(List<City> cities);
    void showCollections(List<Collections> collections);
}
