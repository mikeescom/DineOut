package com.mikeescom.dineout.presenter;

import com.mikeescom.dineout.repo.DineOutRepo;
import com.mikeescom.dineout.repo.dto.Category;
import com.mikeescom.dineout.repo.request.GetCategoriesRequest;

import java.util.List;

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

        mDisposable = mDineOutRep.getCategories().observeOn(mScheduler).subscribeWith(new DisposableObserver<GetCategoriesRequest>() {
            @Override
            public void onNext(GetCategoriesRequest categories) {
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
    public void onDetach() {
        super.onDetach();
        mDisposable.dispose();
    }
}
