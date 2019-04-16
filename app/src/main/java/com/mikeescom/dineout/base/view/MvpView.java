package com.mikeescom.dineout.base.view;

public interface MvpView {
    void showLoading();
    void hideLoading();
    void showError(String error);
}
