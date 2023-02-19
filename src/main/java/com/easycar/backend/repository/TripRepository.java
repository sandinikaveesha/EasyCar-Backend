package com.easycar.backend.repository;

import com.easycar.backend.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TripRepository extends JpaRepository<Trip, Integer> {
    @Query(value = "SELECT COUNT(id) FROM trip WHERE booking_ref=?1",nativeQuery = true)
    Integer validate(int bookingRef);
}