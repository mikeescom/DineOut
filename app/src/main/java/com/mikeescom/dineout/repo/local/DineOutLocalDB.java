package com.mikeescom.dineout.repo.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.mikeescom.dineout.repo.dto.Category;

@Database(entities = {Category.class}, version = 1, exportSchema = false)
public abstract class DineOutLocalDB extends RoomDatabase {
    public abstract CategoriesDao categoriesDao();
}
