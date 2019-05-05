package com.mikeescom.dineout.repo.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.mikeescom.dineout.repo.local.dbobjects.DBCity;

import java.util.List;

@Dao
public interface CitiesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<DBCity> items);

    @Query("SELECT * FROM " + DBConstant.CITIES_TABLE_NAME)
    List<DBCity> getAll();
}
