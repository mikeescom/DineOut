package com.mikeescom.dineout.data.source;

import android.support.annotation.VisibleForTesting;

import com.mikeescom.dineout.data.Category;
import com.mikeescom.dineout.data.City;
import com.mikeescom.dineout.data.Collection;
import com.mikeescom.dineout.data.Cuisine;
import com.mikeescom.dineout.data.DailyMenu;
import com.mikeescom.dineout.data.Establishment;
import com.mikeescom.dineout.data.GeoCode;
import com.mikeescom.dineout.data.LocationDetails;
import com.mikeescom.dineout.data.Restaurant;
import com.mikeescom.dineout.data.Review;
import com.mikeescom.dineout.data.Search;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

public class DineOutRepository implements DineOutDataSource {

    @Nullable
    private static DineOutRepository INSTANCE = null;

    @NonNull
    private final DineOutDataSource mDineOutRemoteDataSource;

    @NonNull
    private final DineOutDataSource mDineOutLocalDataSource;

    @VisibleForTesting
    @Nullable
    Map<String, Category> mCachedCategories;
    @VisibleForTesting
    @Nullable
    Map<String, City> mCachedCities;
    @VisibleForTesting
    @Nullable
    Map<String, Collection> mCachedCollections;
    @VisibleForTesting
    @Nullable
    Map<String, Cuisine> mCachedCuisines;
    @VisibleForTesting
    @Nullable
    Map<String, Establishment> mCachedEstablishments;

    @VisibleForTesting
    boolean mCacheIsDirty = false;

    private DineOutRepository(@NonNull DineOutDataSource dineOutRemoteDataSource,
                            @NonNull DineOutDataSource dineOutLocalDataSource) {
        mDineOutRemoteDataSource = checkNotNull(dineOutRemoteDataSource);
        mDineOutLocalDataSource = checkNotNull(dineOutLocalDataSource);
    }

    public static DineOutRepository getInstance(@NonNull DineOutDataSource dineOutRemoteDataSource,
                                              @NonNull DineOutDataSource dineOutLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new DineOutRepository(dineOutRemoteDataSource, dineOutLocalDataSource);
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public Flowable<List<Category>> getCategories() {
        if (mCachedCategories != null && !mCacheIsDirty) {
            return Flowable.fromIterable(mCachedCategories.values()).toList().toFlowable();
        } else if (mCachedCategories == null) {
            mCachedCategories = new LinkedHashMap<>();
        }

        Flowable<List<Category>> remoteTasks = getAndSaveRemoteCategories();

        if (mCacheIsDirty) {
            return remoteTasks;
        } else {
            // Query the local storage if available. If not, query the network.
            Flowable<List<Category>> localTasks = getAndCacheLocalCategories();
            return Flowable.concat(localTasks, remoteTasks)
                    .filter(tasks -> !tasks.isEmpty())
                    .firstOrError()
                    .toFlowable();
        }
    }

    private Flowable<List<Category>> getAndCacheLocalCategories() {
        return mDineOutLocalDataSource.getCategories()
                .flatMap(categories -> Flowable.fromIterable(categories)
                        .doOnNext(category -> mCachedCategories.put(category.getCategoryId(), category))
                        .toList()
                        .toFlowable());
    }

    private Flowable<List<Category>> getAndSaveRemoteCategories() {
        return mDineOutRemoteDataSource
                .getCategories()
                .flatMap(tasks -> Flowable.fromIterable(tasks).doOnNext(category -> {
                    mDineOutLocalDataSource.saveCategory(category);
                    mCachedCategories.put(category.getCategoryId(), category);
                }).toList().toFlowable())
                .doOnComplete(() -> mCacheIsDirty = false);
    }

    @Override
    public void saveCategory(@NonNull Category category) {
        checkNotNull(category);
        mDineOutRemoteDataSource.saveCategory(category);
        mDineOutLocalDataSource.saveCategory(category);

        // Do in memory cache update to keep the app UI up to date
        if (mCachedCategories == null) {
            mCachedCategories = new LinkedHashMap<>();
        }
        mCachedCategories.put(category.getCategoryId(), category);
    }

    @Override
    public void saveCity(City city) {
        checkNotNull(city);
        mDineOutRemoteDataSource.saveCity(city);
        mDineOutLocalDataSource.saveCity(city);

        // Do in memory cache update to keep the app UI up to date
        if (mCachedCities == null) {
            mCachedCities = new LinkedHashMap<>();
        }
        mCachedCities.put(city.getId(), city);
    }

    @Override
    public void saveCollection(Collection collection) {
        checkNotNull(collection);
        mDineOutRemoteDataSource.saveCollection(collection);
        mDineOutLocalDataSource.saveCollection(collection);

        // Do in memory cache update to keep the app UI up to date
        if (mCachedCollections == null) {
            mCachedCollections = new LinkedHashMap<>();
        }
        mCachedCollections.put(collection.getCollectionId(), collection);
    }

    @Override
    public void saveCuisine(Cuisine cuisine) {
        checkNotNull(cuisine);
        mDineOutRemoteDataSource.saveCuisine(cuisine);
        mDineOutLocalDataSource.saveCuisine(cuisine);

        // Do in memory cache update to keep the app UI up to date
        if (mCachedCuisines == null) {
            mCachedCuisines = new LinkedHashMap<>();
        }
        mCachedCuisines.put(cuisine.getCuisineId(), cuisine);
    }

    @Override
    public void saveEstablishment(Establishment establishment) {
        checkNotNull(establishment);
        mDineOutRemoteDataSource.saveEstablishment(establishment);
        mDineOutLocalDataSource.saveEstablishment(establishment);

        // Do in memory cache update to keep the app UI up to date
        if (mCachedEstablishments == null) {
            mCachedEstablishments = new LinkedHashMap<>();
        }
        mCachedEstablishments.put(establishment.getEstablishmentId(), establishment);
    }

    @Override
    public Flowable<List<City>> getCities() {
        return null;
    }

    @Override
    public Flowable<List<Collection>> getCollections() {
        return null;
    }

    @Override
    public Flowable<List<Cuisine>> getCuisines() {
        return null;
    }

    @Override
    public Flowable<List<Establishment>> getEstablishments() {
        return null;
    }

    @Override
    public Flowable<GeoCode> getGeoCode() {
        return null;
    }

    @Override
    public Flowable<LocationDetails> getLocationDetails() {
        return null;
    }

    @Override
    public Flowable<DailyMenu> getDailyMenu() {
        return null;
    }

    @Override
    public Flowable<Restaurant> getRestaurant() {
        return null;
    }

    @Override
    public Flowable<Review> getReviews() {
        return null;
    }

    @Override
    public Flowable<Search> getSearch() {
        return null;
    }
}
