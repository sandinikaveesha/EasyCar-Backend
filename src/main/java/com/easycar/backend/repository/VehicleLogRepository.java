package com.easycar.backend.repository;

import com.easycar.backend.model.VehicleLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehicleLogRepository extends JpaRepository<VehicleLog, Integer> {
    @Query(value = "SELECT COUNT(id) FROM vehicle_log WHERE booking=?1", nativeQuery = true)
    Integer validate(Integer booking);

    @Query(value = "SELECT * FROM vehicle_log WHERE booking=?1", nativeQuery = true)
    VehicleLog getLog(Integer booking);
}