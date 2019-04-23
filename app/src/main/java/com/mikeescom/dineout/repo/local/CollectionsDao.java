package com.mikeescom.dineout.repo.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface CollectionsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<DBCollection> items);

    @Query("SELECT * FROM " + DBConstant.COLLECTIONS_TABLE_NAME)
    List<DBCollection> getAll();
}
