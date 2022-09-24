package com.example.healthe.repository;

import com.example.healthe.entity.PatientInfo;
import com.example.healthe.entity.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientInfoRepository extends JpaRepository<PatientInfo, Long> {
    //ideally only one object to be returned
//    PatientInfo findByuuid(@Param("uuid") String uuid);
    @Query("Select u from public.patient_info u WHERE u.patientId=:patientId")
    PatientInfo findByPatientId(@Param("patientId") String patientId);
}
