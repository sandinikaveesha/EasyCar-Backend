package com.easycar.backend.repository;

import com.easycar.backend.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    @Query(value = "SELECT COUNT(id) FROM brand WHERE code=?1", nativeQuery = true)
    Integer validateCode(String code);
}