package com.mikeescom.dineout.repo.dto;

public class Categories {
    private Category categories;

    public Categories (int id, String name) {
        categories = new Category(id, name);
    }

    public Category getCategory() {
        return categories;
    }

    public void setCategory(Category categories) {
        this.categories = categories;
    }
}
