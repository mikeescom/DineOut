package com.mikeescom.dineout.repo.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.mikeescom.dineout.repo.local.dbobjects.DBCity;

@Database(entities = {DBCity.class, DBCollection.class}, version = 2, exportSchema = false)
public abstract class DineOutLocalDB extends RoomDatabase {
    public abstract CitiesDao citiesDao();
    public abstract CollectionsDao collectionsDao();
}
