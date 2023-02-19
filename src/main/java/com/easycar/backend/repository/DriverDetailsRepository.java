package com.easycar.backend.repository;

import com.easycar.backend.model.DriverDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriverDetailsRepository extends JpaRepository<DriverDetails, Integer> {
    @Query(value = "SELECT COUNT(id) FROM driver_details WHERE identification_no=?1 AND licence_no=?2", nativeQuery = true)
    Integer validate(String identificationNo, String licenceNo);
}