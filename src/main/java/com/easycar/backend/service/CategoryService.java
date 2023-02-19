package com.easycar.backend.service;

import com.easycar.backend.model.Category;

import java.util.List;

public interface CategoryService {
    public String save(Category category);
    public List<Category> all();
    public Category get(Integer category);
}
