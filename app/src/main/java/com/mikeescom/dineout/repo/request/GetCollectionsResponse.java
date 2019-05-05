package com.mikeescom.dineout.repo.request;

import com.mikeescom.dineout.repo.dto.Collections;

import java.util.List;

public class GetCollectionsResponse {
    private List<Collections> collections;

    public GetCollectionsResponse(List<Collections> collections) {
        this.collections = collections;
    }

    public List<Collections> getCollections() {
        return collections;
    }

    public void setCollections(List<Collections> collections) {
        this.collections = collections;
    }
}
