package com.example.healthe.controllers;

import com.example.healthe.data.request.DoctorRequest;
import com.example.healthe.data.request.LoginUserRequest;
import com.example.healthe.data.request.PatientInfoRequest;
import com.example.healthe.data.request.RegisterUserRequest;
import com.example.healthe.entity.PatientInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
public class UserController {
    @Autowired
    private com.example.healthe.services.User userService;

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginUserRequest userRequest) {
        return userService.loginUser(userRequest);
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterUserRequest userRequest) {
        return userService.registerUser(userRequest);
    }

    @PostMapping("/savePatientData")
    public String saveData(@RequestBody PatientInfoRequest patientInfo) {
        return userService.saveUser(patientInfo);
    }

    @PostMapping("/requestPatientInfo")
    public String requestPatientInfo(@RequestBody DoctorRequest doctorRequest){
        return userService.requestData(doctorRequest);
    }

    @GetMapping("/patientInfo")
        public PatientInfoRequest getPatientInfo(@RequestParam String patientId) throws InterruptedException {
        try{
            return userService.getPatientInfo(patientId);
        } catch(Exception e){
            throw e;
        }

    }
}
