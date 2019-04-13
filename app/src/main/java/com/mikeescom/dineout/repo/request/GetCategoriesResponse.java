package com.mikeescom.dineout.repo.request;

import com.mikeescom.dineout.repo.dto.Categories;
import com.mikeescom.dineout.repo.dto.Category;

import java.util.List;

public class GetCategoriesResponse {
    private List<Categories> categories;

    public GetCategoriesResponse(List<Categories> categories) {
        this.categories = categories;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }
}
