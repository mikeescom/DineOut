package com.mikeescom.dineout.view;

import com.mikeescom.dineout.base.view.MvpView;
import com.mikeescom.dineout.repo.dto.Category;

import java.util.List;

public interface DineOutView extends MvpView {
    void showCategories(List<Category> users);
    void showLoading();
    void hideLoading();
    void showError(String error);
}
