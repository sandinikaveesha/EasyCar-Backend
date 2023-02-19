package com.easycar.backend.repository;

import com.easycar.backend.model.Image;
import com.easycar.backend.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {

    @Query(value = "SELECT * FROM image WHERE vehicle=?1", nativeQuery = true)
    List<Image> get(Integer vehicle);
}