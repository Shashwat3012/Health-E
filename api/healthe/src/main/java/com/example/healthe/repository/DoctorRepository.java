package com.example.healthe.repository;

import com.example.healthe.entity.DoctorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface DoctorRepository extends JpaRepository<DoctorInfo,Long> {
    DoctorInfo findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
