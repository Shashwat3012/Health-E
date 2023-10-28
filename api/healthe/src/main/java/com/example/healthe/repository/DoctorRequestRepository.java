package com.example.healthe.repository;

import com.example.healthe.entity.DoctorRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface DoctorRequestRepository extends JpaRepository<DoctorRequest, Long> {
    List<DoctorRequest> findByPatientId(@Param("patientId") String patientId);
    DoctorRequest findByRequestId(@Param("requestId") String requestId);

    List<DoctorRequest> findByDoctorId(@Param("doctorId") String doctorId);

    @Transactional
    @Modifying
    @Query("update DoctorRequest u set u.status =:status where u.requestId =:requestId")
    void updateStatus(@Param(value = "status") String status,@Param(value = "requestId") String requestId);
}
