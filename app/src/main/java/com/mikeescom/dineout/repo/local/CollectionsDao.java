package com.mikeescom.dineout.repo.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CollectionsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<DBCollection> items);

    @Query("SELECT * FROM " + DBConstant.COLLECTIONS_TABLE_NAME)
    List<DBCollection> getAll();
}
