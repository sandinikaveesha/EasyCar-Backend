package com.easycar.backend.repository;

import com.easycar.backend.model.VehicleBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleBookingRepository extends JpaRepository<VehicleBooking, Integer> {
    @Query(value = "SELECT COUNT(id) FROM vehicle_booking WHERE status='Pending' AND vehicle_ref =?1", nativeQuery = true)
    Integer validate(int vehicle_ref);

    @Query(value = "SELECT * FROM vehicle_booking WHERE agency_ref=?1", nativeQuery = true)
    List<VehicleBooking> getByAgency(Integer agency);

    @Query(value = "SELECT * FROM vehicle_booking WHERE user_ref=?1", nativeQuery = true)
    List<VehicleBooking> getByUser(Integer user);


}