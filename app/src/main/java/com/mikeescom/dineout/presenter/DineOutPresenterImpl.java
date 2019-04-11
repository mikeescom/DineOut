package com.mikeescom.dineout.presenter;

import com.mikeescom.dineout.repo.DineOutRepo;
import com.mikeescom.dineout.repo.dto.Category;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class DineOutPresenterImpl extends DineOutPresenter {
    private DineOutRepo dineOutRep;
    private Scheduler scheduler;
    private Disposable disposable;

    public DineOutPresenterImpl(DineOutRepo dineOutRepo, Scheduler scheduler) {
        this.dineOutRep = dineOutRep;
        this.scheduler = scheduler;
    }

    @Override
    public void getCategories() {
        if (!isViewAttached()) {
            return;
        }

        getView().showLoading();

        disposable = dineOutRep.getCategories().observeOn(scheduler).subscribeWith(new DisposableObserver<List<Category>>() {
            @Override
            public void onNext(List<Category> categories) {
                if (!isViewAttached())
                    return;

                getView().showCategories(categories);

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
        disposable.dispose();
    }
}
