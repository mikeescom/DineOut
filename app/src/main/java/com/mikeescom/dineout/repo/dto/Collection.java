package com.mikeescom.dineout.repo.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Collection {

    @SerializedName("collection_id")
    @Expose
    private int collectionId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("res_count")
    @Expose
    private int resCount;
    @SerializedName("share_url")
    @Expose
    private String shareUrl;

    public Collection(int collectionId
            , String title
            , String url
            , String description
            , String imageUrl
            , int resCount
            , String shareUrl) {
        this.collectionId = collectionId;
        this.title = title;
        this.url = url;
        this.description = description;
        this.imageUrl = imageUrl;
        this.resCount = resCount;
        this.shareUrl = shareUrl;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getResCount() {
        return resCount;
    }

    public void setResCount(int resCount) {
        this.resCount = resCount;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

}