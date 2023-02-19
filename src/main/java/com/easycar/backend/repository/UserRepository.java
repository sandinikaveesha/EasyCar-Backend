package com.easycar.backend.repository;

import com.easycar.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT COUNT(id) FROM user WHERE username=?1",nativeQuery = true)
    Integer validate(String username);

    @Query(value = "SELECT * FROM user WHERE username=?1 AND password=?2",nativeQuery = true)
    User getUser(String email, String password);
}