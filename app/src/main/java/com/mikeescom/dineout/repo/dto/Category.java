package com.mikeescom.dineout.repo.dto;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mikeescom.dineout.repo.local.DBConstant;

@Entity(tableName = DBConstant.CATEGORIES_TABLE_NAME)
public class Category {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DBConstant.CATEGORY_ID)
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @ColumnInfo(name = DBConstant.CATEGORY_NAME)
    @SerializedName("category_name")
    @Expose
    private String categoryName;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
