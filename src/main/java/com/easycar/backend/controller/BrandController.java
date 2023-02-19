package com.easycar.backend.controller;

import com.easycar.backend.model.Brand;
import com.easycar.backend.service.BrandService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
@CrossOrigin
public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping("/add")
    public String add(@RequestBody Brand brand){
        return brandService.save(brand);
    }

    @GetMapping("/all")
    public List<Brand> all(){
        return brandService.all();
    }

    @PostMapping("/get")
    public Brand get(@RequestBody ObjectNode data){
        return brandService.get(data.get("brand").asInt());
    }
}
