package com.example.healthe.repository;

import com.example.healthe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("Select u from User u WHERE u.username=:username")
    User findByUsername(@Param("username") String username);


}
