package com.easycar.backend.service;

import com.easycar.backend.model.Category;
import com.easycar.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public String save(Category category) {
        if(categoryRepository.validateCode(category.getCode())> 0){
            return "false";
        }
        else{
            categoryRepository.save(category);
            return "true";
        }
    }

    @Override
    public List<Category> all() {
       return categoryRepository.findAll();
    }

    @Override
    public Category get(Integer category) {
        return categoryRepository.findById(category).orElse(null);
    }
}
