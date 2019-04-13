package com.mikeescom.dineout.repo.request;

import com.mikeescom.dineout.repo.dto.Categories;
import com.mikeescom.dineout.repo.dto.Category;

import java.util.List;

public class GetCategoriesRequest {
    private List<Categories> categories;

    public GetCategoriesRequest(List<Categories> categories) {
        this.categories = categories;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }
}
