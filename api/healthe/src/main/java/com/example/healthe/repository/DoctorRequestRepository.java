package com.example.healthe.repository;

import com.example.healthe.entity.DoctorRequest;
import com.example.healthe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRequestRepository extends JpaRepository<DoctorRequest, Long> {
}
