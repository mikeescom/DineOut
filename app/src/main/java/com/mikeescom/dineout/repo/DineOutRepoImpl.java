package com.mikeescom.dineout.repo;

import com.mikeescom.dineout.repo.local.DineOutLocalRepo;
import com.mikeescom.dineout.repo.remote.DineOutRemoteRepo;
import com.mikeescom.dineout.repo.request.GetCategoriesRequest;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DineOutRepoImpl implements DineOutRepo {

    DineOutRemoteRepo remoteDineOutRepo;
    DineOutLocalRepo localDineOutRepo;

    public DineOutRepoImpl(DineOutRemoteRepo remoteDineOutRepo, DineOutLocalRepo localDineOutRepo) {
        this.remoteDineOutRepo = remoteDineOutRepo;
        this.localDineOutRepo = localDineOutRepo;
    }

    @Override
    public Observable<GetCategoriesRequest> getCategories() {
        return Observable.mergeDelayError(remoteDineOutRepo.getCategories().doOnNext(new Consumer<GetCategoriesRequest>() {
                    @Override
                    public void accept(GetCategoriesRequest categories) throws Exception {
                        localDineOutRepo.saveCategories(categories.getCategories());
                    }
                }).subscribeOn(Schedulers.io()), localDineOutRepo.getCategories().subscribeOn(Schedulers.io())
        );
    }
}
