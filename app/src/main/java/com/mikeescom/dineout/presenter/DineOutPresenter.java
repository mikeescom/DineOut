package com.mikeescom.dineout.presenter;

import com.mikeescom.dineout.base.presenter.BasePresenter;
import com.mikeescom.dineout.view.DineOutView;

public abstract class DineOutPresenter extends BasePresenter<DineOutView> {
    public abstract void getCategories();
}
