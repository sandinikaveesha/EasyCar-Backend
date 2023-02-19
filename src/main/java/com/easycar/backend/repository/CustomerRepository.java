package com.easycar.backend.repository;

import com.easycar.backend.model.Customer;
import com.easycar.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "SELECT COUNT(id) FROM customer WHERE email=?1 OR phone_no=?2", nativeQuery = true)
    Integer validate(String email, String phone);
    @Query(value = "SELECT COUNT(id) FROM user WHERE username=?1 AND password=?2",nativeQuery = true)
    Integer validateUser(String email, String password);



    @Query(value = "SELECT * FROM customer WHERE user_ref=?1", nativeQuery = true)
    Customer getCustomer(Integer user);




}