package com.mikeescom.dineout.repo.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

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
