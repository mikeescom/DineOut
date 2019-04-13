package com.mikeescom.dineout.repo.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.mikeescom.dineout.repo.dto.Category;
import com.mikeescom.dineout.repo.local.dbobjects.DBCategory;

import java.util.List;

@Dao
public interface CategoriesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<DBCategory> items);

    @Query("SELECT * FROM " + DBConstant.CATEGORIES_TABLE_NAME)
    List<DBCategory> getAll();
}
