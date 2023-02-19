package com.easycar.backend.repository;

import com.easycar.backend.model.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AgencyRepository extends JpaRepository<Agency, Integer> {
    @Query(value = "SELECT COUNT(id) FROM agency WHERE br_no=?1 OR email=?2 OR phone_no=?3", nativeQuery = true)
    Integer validate(String br_no, String email, String phone);

    @Query(value = "SELECT * FROM agency WHERE id=?1", nativeQuery = true)
    Agency getAgency(Integer id);
}