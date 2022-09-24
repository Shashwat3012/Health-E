package com.example.healthe.services;

import com.example.healthe.data.request.LoginUserRequest;
import com.example.healthe.data.request.PatientInfoRequest;
import com.example.healthe.data.request.RegisterUserRequest;
import com.example.healthe.entity.PatientInfo;
import com.example.healthe.repository.PatientInfoRepository;
import com.example.healthe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements User {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PatientInfoRepository patientRepo;

    @Override
    public String registerUser(RegisterUserRequest userRequest) {
        String uuid = UUID.randomUUID().toString().substring(0, 6);
        userRepo.save(new com.example.healthe.entity.User(userRequest.getFirstName(), userRequest.getLastName(), userRequest.getUserName(), userRequest.getPassword(), userRequest.getRole(), uuid));
        return uuid;
    }

    @Override
    public String loginUser(LoginUserRequest userRequest) {
        com.example.healthe.entity.User user = userRepo.findByUsername(userRequest.getUserName());
        if (user == null) {
            return "User Not Found!";
        } else {
            if (userRequest.getPassword() == user.getPassword()) {
                return user.getUuid();
            } else {
                return "Incorrect Password";
            }
        }
    }

    @Override
    public String saveUser(PatientInfoRequest patientInfo) {
        patientRepo.save(new PatientInfo(patientInfo.getPatientName(), patientInfo.getPatientId(),
                patientInfo.getDOB(), patientInfo.getHeight(),patientInfo.getWeight(),
                patientInfo.getAllergies(),patientInfo.getMedication(),patientInfo.getDisease(),
                patientInfo.getBloodGroup()));
        return "Submitted Successfully";
    }
}
