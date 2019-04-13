package com.mikeescom.dineout.presenter;

import com.mikeescom.dineout.repo.DineOutRepo;
import com.mikeescom.dineout.repo.request.GetCategoriesResponse;
import com.mikeescom.dineout.repo.request.GetCitiesResponse;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class DineOutPresenterImpl extends DineOutPresenter {
    private DineOutRepo mDineOutRep;
    private Scheduler mScheduler;
    private Disposable mDisposable;

    public DineOutPresenterImpl(DineOutRepo dineOutRepo, Scheduler scheduler) {
        mDineOutRep = dineOutRepo;
        mScheduler = scheduler;
    }

    @Override
    public void getCategories() {
        if (!isViewAttached()) {
            return;
        }

        getView().showLoading();

        mDisposable = mDineOutRep.getCategories().observeOn(mScheduler).subscribeWith(new DisposableObserver<GetCategoriesResponse>() {
            @Override
            public void onNext(GetCategoriesResponse categories) {
                if (!isViewAttached())
                    return;
                getView().showCategories(categories.getCategories());
            }

            @Override
            public void onError(Throwable e) {
                if (!isViewAttached())
                    return;
                getView().showError(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void getCities(String q, double lat, double lon, String citiesIds, int count) {
        if (!isViewAttached()) {
            return;
        }

        getView().showLoading();

        mDisposable = mDineOutRep.getCities(q, lat, lon, citiesIds, count).observeOn(mScheduler).subscribeWith(new DisposableObserver<GetCitiesResponse>() {
            @Override
            public void onNext(GetCitiesResponse cities) {
                if (!isViewAttached())
                    return;
                getView().showCities(cities.getLocation_suggestions());
            }

            @Override
            public void onError(Throwable e) {
                if (!isViewAttached())
                    return;
                getView().showError(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mDisposable.dispose();
    }
}
