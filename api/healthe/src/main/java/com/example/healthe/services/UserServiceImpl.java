package com.example.healthe.services;

import com.example.healthe.data.request.DoctorRequest;
import com.example.healthe.data.request.LoginUserRequest;
import com.example.healthe.data.request.PatientInfoRequest;
import com.example.healthe.data.request.RegisterUserRequest;
import com.example.healthe.entity.PatientInfo;
import com.example.healthe.repository.DoctorRequestRepository;
import com.example.healthe.repository.PatientInfoRepository;
import com.example.healthe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements User{
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PatientInfoRepository patientRepo;
    @Autowired
    private DoctorRequestRepository doctorRepo;

    @Override
    public String registerUser(RegisterUserRequest userRequest) {
        String uuid = UUID.randomUUID().toString().substring(0, 6);
        userRepo.save(new com.example.healthe.entity.User(userRequest.getFirstName(), userRequest.getLastName(), userRequest.getUserName(), userRequest.getPassword(), userRequest.getRole(), uuid));
        return uuid;
    }

    @Override
    public String loginUser(LoginUserRequest userRequest) {
        com.example.healthe.entity.User user = userRepo.findByUsernameAndPassword(userRequest.getUserName(), userRequest.getPassword());
        if (user == null) {
            return "User Not Found!";
        } else {
            return user.getUuid();
        }
    }

    @Override
    public String saveUser(PatientInfoRequest patientInfo) {
        patientRepo.save(new PatientInfo(patientInfo.getPatientName(), patientInfo.getPatientId(),
                patientInfo.getDOB(), patientInfo.getHeight(),patientInfo.getWeight(),
                patientInfo.getAllergies(),patientInfo.getMedication(),patientInfo.getDisease(),
                patientInfo.getBloodGroup(),patientInfo.getInjuryHistory()));
        return "Submitted Successfully";
    }

    @Override
    public String requestData(DoctorRequest doctorRequest){
        String requestId = UUID.randomUUID().toString().substring(0, 6);
        doctorRepo.save(new com.example.healthe.entity.DoctorRequest(requestId,doctorRequest.getpatientId(),
                doctorRequest.getReason(),doctorRequest.getDoctorId(),doctorRequest.getDate(),
                doctorRequest.getStatus()));
        return "Status Pending!";
    }

    @Override
    public PatientInfoRequest getPatientInfo(String patientId) throws InterruptedException {
        PatientInfo patientList =  patientRepo.findByPatientId(patientId);
        PatientInfoRequest pRequest = new PatientInfoRequest(
                patientList.getPatientName(),
                patientList.getPatientId(),
                patientList.getDOB(),
                patientList.getHeight(),
                patientList.getWeight(),
                patientList.getAllergies(),
                patientList.getMedication(),
                patientList.getDisease(),
                patientList.getBloodGroup(),
                patientList.getInjuryHistory()
        );
        return pRequest;
    }

    @Override
    public List<com.example.healthe.entity.DoctorRequest> getRequestsForPatient(String patientId) {
        List<com.example.healthe.entity.DoctorRequest> patientRequests =  doctorRepo.findByPatientId(patientId);
        return patientRequests;
    }


}
