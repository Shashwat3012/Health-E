package com.example.healthe.services;

import com.example.healthe.data.request.LoginUserRequest;
import com.example.healthe.data.request.PatientInfoRequest;
import com.example.healthe.data.request.RegisterUserRequest;
import com.example.healthe.data.request.DoctorRequest;
import com.example.healthe.entity.PatientInfo;

import java.util.ArrayList;
import java.util.List;

public interface User {
    String registerUser(RegisterUserRequest userRequest);

    String loginUser(LoginUserRequest userRequest);

    String saveUser(PatientInfoRequest patientInfo);

    String requestData(DoctorRequest doctorRequest);

    PatientInfoRequest getPatientInfo(String patientId) throws InterruptedException;
}
