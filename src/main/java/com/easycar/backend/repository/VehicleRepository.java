package com.easycar.backend.repository;

import com.easycar.backend.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    @Query(value = "SELECT COUNT(id) FROM vehicle WHERE registration_no=?1",nativeQuery = true)
    Integer validate(String registration);

    @Query(value = "SELECT * FROM vehicle WHERE agency_ref=?1", nativeQuery = true)
    List<Vehicle> getByAgency(Integer agency);
}