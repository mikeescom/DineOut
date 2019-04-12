package com.mikeescom.dineout.repo.request;

import com.mikeescom.dineout.repo.dto.Category;

import java.util.List;

public class GetCategoriesRequest {
    private List<Category> categories;

    public GetCategoriesRequest(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
