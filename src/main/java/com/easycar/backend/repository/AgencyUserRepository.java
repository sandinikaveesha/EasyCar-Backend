package com.easycar.backend.repository;

import com.easycar.backend.model.AgencyUser;
import com.easycar.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AgencyUserRepository extends JpaRepository<AgencyUser, Integer> {
    @Query(value = "SELECT COUNT(id) FROM agency_user WHERE email=?1 OR phone_no=?2",nativeQuery = true)
    Integer validate(String email, String phone);

    @Query(value = "SELECT COUNT(id) FROM user WHERE username=?1 AND password=?2 AND status='Active'",nativeQuery = true)
    Integer validateUser(String email, String password);



    @Query(value = "SELECT * FROM agency_user WHERE user_ref=?1",nativeQuery = true)
    AgencyUser getUserByLogin(Integer user);


}