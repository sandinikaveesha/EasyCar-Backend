package com.easycar.backend.service;

import com.easycar.backend.model.Brand;
import com.easycar.backend.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandImpl implements BrandService{
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public String save(Brand brand) {
        if(brandRepository.validateCode(brand.getCode())>0){
            return "false";
        }
        else{
            brandRepository.save(brand);
            return "true";
        }
    }

    @Override
    public List<Brand> all() {
        return brandRepository.findAll();
    }

    @Override
    public Brand get(Integer brand) {
        return brandRepository.findById(brand).orElse(null);
    }
}
