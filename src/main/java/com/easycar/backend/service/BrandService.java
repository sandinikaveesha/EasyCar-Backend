package com.easycar.backend.service;

import com.easycar.backend.model.Brand;

import java.util.List;

public interface BrandService {
    public String save(Brand brand);
    public List<Brand> all();

    public Brand get(Integer brand);
}
