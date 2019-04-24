package com.mikeescom.dineout.repo.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.mikeescom.dineout.repo.local.dbobjects.DBCategory;
import com.mikeescom.dineout.repo.local.dbobjects.DBCity;

@Database(entities = {DBCategory.class, DBCity.class, DBCollection.class}, version = 2, exportSchema = false)
public abstract class DineOutLocalDB extends RoomDatabase {
    public abstract CategoriesDao categoriesDao();
    public abstract CitiesDao citiesDao();
    public abstract CollectionsDao collectionsDao();
}
