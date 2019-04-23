package com.mikeescom.dineout.repo.local;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = DBConstant.COLLECTIONS_TABLE_NAME)
public class DBCollection {
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = DBConstant.COLLECTION_ID)
    @SerializedName("collection_id")
    @Expose
    private int collectionId;
    @ColumnInfo(name = DBConstant.COLLECTION_RES_COUNT)
    @SerializedName("res_count")
    @Expose
    private int resCount;
    @ColumnInfo(name = DBConstant.COLLECTION_IMAGE_URL)
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @ColumnInfo(name = DBConstant.COLLECTION_URL)
    @SerializedName("url")
    @Expose
    private String url;
    @ColumnInfo(name = DBConstant.COLLECTION_TITLE)
    @SerializedName("title")
    @Expose
    private String title;
    @ColumnInfo(name = DBConstant.COLLECTION_DESC)
    @SerializedName("description")
    @Expose
    private String description;
    @ColumnInfo(name = DBConstant.COLLECTION_SHARE_URL)
    @SerializedName("share_url")
    @Expose
    private String shareUrl;

    public DBCollection(int collectionId
            , int resCount
            , String imageUrl
            , String url
            , String title
            , String description
            , String shareUrl) {
        this.collectionId = collectionId;
        this.resCount = resCount;
        this.imageUrl = imageUrl;
        this.url = url;
        this.title = title;
        this.description = description;
        this.shareUrl = shareUrl;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public int getResCount() {
        return resCount;
    }

    public void setResCount(int resCount) {
        this.resCount = resCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }
}

