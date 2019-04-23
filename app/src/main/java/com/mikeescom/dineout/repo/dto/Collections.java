package com.mikeescom.dineout.repo.dto;

public class Collections {
    private Collection collection;

    public Collections (int collectionId
            , String title
            , String url
            , String description
            , String imageUrl
            , int resCount
            , String shareUrl) {
        collection = new Collection(collectionId, title, url, description, imageUrl, resCount, shareUrl);
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }
}
