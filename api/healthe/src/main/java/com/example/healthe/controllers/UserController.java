package com.example.healthe.controllers;

import com.example.healthe.data.request.*;
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

    @PostMapping("/editPatientData")
    public String editData(@RequestBody PatientInfoRequest patientInfo) {
        return userService.editUser(patientInfo);
    }


    @PostMapping("/requestPatientInfo")
    public String requestPatientInfo(@RequestBody DoctorRequest doctorRequest){
        return userService.requestData(doctorRequest);
    }

    @GetMapping("/getRequests")
    public List<com.example.healthe.entity.DoctorRequest> getRequests(@RequestParam String patientId) throws InterruptedException {
        try{
            return userService.getRequestsForPatient(patientId);
        } catch(Exception e){
            throw e;
        }

    }

    @GetMapping("/getRequestsByDoctor")
    public List<com.example.healthe.entity.DoctorRequest> getRequestsByDoctor(@RequestParam String doctorId) throws InterruptedException {
        try{
            return userService.getRequestsByDoctor(doctorId);
        } catch(Exception e){
            throw e;
        }

    }

    @GetMapping("/patientInfo")
    public PatientInfoRequest getPatientInfo(@RequestParam String patientId) throws InterruptedException {
        try{
            return userService.getPatientInfo(patientId);
        } catch(Exception e){
            throw e;
        }
    }

    @GetMapping("/patientInfoByDisease")
    public ArrayList<PatientInfoRequest> getPatientInfoByDisease(@RequestParam String disease) throws InterruptedException {
        try{
            return userService.getPatientInfoByDisease(disease);
        } catch(Exception e){
            throw e;
        }
    }

    @PostMapping("/updateRequestStatus")
    public String updateRequestStatus(@RequestBody UpdateDoctorRequest docRequest){
        return userService.updateRequestStatus(docRequest);
    }

}
