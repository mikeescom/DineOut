package com.mikeescom.dineout.repo.local.dbobjects;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.mikeescom.dineout.repo.local.DBConstant;

import java.util.List;

@Dao
public interface CitiesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<DBCity> items);

    @Query("SELECT * FROM " + DBConstant.CITIES_TABLE_NAME)
    List<DBCity> getAll();
}
