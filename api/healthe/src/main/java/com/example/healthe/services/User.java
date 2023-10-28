package com.example.healthe.services;

import com.example.healthe.data.request.*;
import com.example.healthe.entity.DoctorInfo;

import java.util.ArrayList;
import java.util.List;

public interface User {
    String registerUser(RegisterUserRequest userRequest);

    String loginUser(LoginUserRequest userRequest);

    String saveUser(PatientInfoRequest patientInfo);

    String requestData(DoctorRequest doctorRequest);

    PatientInfoRequest getPatientInfo(String patientId) throws InterruptedException;

    List<com.example.healthe.entity.DoctorRequest> getRequestsForPatient(String patientId);

    String updateRequestStatus(UpdateDoctorRequest docRequest);

    List<com.example.healthe.entity.DoctorRequest> getRequestsByDoctor(String doctorId);

    String editUser(PatientInfoRequest patientInfo);

    ArrayList<PatientInfoRequest> getPatientInfoByDisease(String disease);

    String updateDoctorUser(String doctorId);

    List<DoctorInfo> fetchAllDoctors();
}
