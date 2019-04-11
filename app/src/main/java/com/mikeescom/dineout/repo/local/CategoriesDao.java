package com.mikeescom.dineout.repo.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.mikeescom.dineout.repo.dto.Category;

import java.util.List;

@Dao
public interface CategoriesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Category> items);

    @Query("SELECT * FROM " + DBConstant.CATEGORIES_TABLE_NAME)
    List<Category> getAll();
}
