package com.example.healthe.repository;

import com.example.healthe.entity.DoctorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface DoctorRepository extends JpaRepository<DoctorInfo,Long> {

    @Query("Select u from DoctorInfo u WHERE u.username=:username AND u.password =:password")
    DoctorInfo findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    @Override
    @Query("Select u from DoctorInfo u")
    List<DoctorInfo> findAll();

    @Transactional
    @Modifying
    @Query("update DoctorInfo u set u.status =:status where u.uuid =:doctorId")
    void updateDoctorStatus(@Param(value = "status") String status,@Param(value = "doctorId") String doctorId);
}
