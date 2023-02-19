package com.easycar.backend.controller;

import com.easycar.backend.model.Category;
import com.easycar.backend.service.CategoryService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public String add(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @GetMapping("/all")
    public List<Category> all(){
        return categoryService.all();
    }

    @PostMapping("/get")
    public Category get(@RequestBody ObjectNode data){
        return categoryService.get(data.get("category").asInt());
    }
}
