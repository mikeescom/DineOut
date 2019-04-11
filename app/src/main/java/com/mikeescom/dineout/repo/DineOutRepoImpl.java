package com.mikeescom.dineout.repo;

import com.mikeescom.dineout.repo.dto.Category;
import com.mikeescom.dineout.repo.local.DineOutLocalRepo;
import com.mikeescom.dineout.repo.remote.DineOutRemoteRepo;

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
    public Observable<List<Category>> getCategories() {
        return Observable.mergeDelayError(remoteDineOutRepo.getCategories().doOnNext(new Consumer<List<Category>>() {
                    @Override
                    public void accept(List<Category> categories) throws Exception {
                        localDineOutRepo.saveCategories(categories);
                    }
                }).subscribeOn(Schedulers.io()), localDineOutRepo.getCategories().subscribeOn(Schedulers.io())
        );
    }
}
