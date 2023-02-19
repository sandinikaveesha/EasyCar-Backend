package com.easycar.backend.repository;

import com.easycar.backend.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query(value = "SELECT * FROM payment WHERE agency=?1", nativeQuery = true)
    List<Payment> getAllByAgency(Integer agency);

}