package com.easycar.backend.repository;

import com.easycar.backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "SELECT COUNT(id) FROM category WHERE code=?1", nativeQuery = true)
    Integer validateCode(String code);
}