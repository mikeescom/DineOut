package com.mikeescom.dineout.repo.local.dbobjects;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mikeescom.dineout.repo.local.DBConstant;

@Entity(tableName = DBConstant.CATEGORIES_TABLE_NAME)
public class DBCategory {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DBConstant.CATEGORY_ID)
    @SerializedName("id")
    @Expose
    private int id;
    @ColumnInfo(name = DBConstant.CATEGORY_NAME)
    @SerializedName("name")
    @Expose
    private String name;

    public DBCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
