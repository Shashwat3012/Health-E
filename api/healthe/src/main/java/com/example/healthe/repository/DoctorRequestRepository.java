package com.example.healthe.repository;

import com.example.healthe.entity.DoctorRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRequestRepository extends JpaRepository<DoctorRequest, Long> {
    List<DoctorRequest> findByPatientId(@Param("patientId") String patientId);

}
