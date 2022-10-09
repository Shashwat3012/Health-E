package com.example.healthe.services;

import com.example.healthe.data.request.*;
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
        patientRepo.save(new PatientInfo(patientInfo.getPatientName(),patientInfo.getPatientId(),patientInfo.getDOB(),
                patientInfo.getHeight(),patientInfo.getWeight(),patientInfo.getAllergies(),patientInfo.getMedication(),
                patientInfo.getDisease(),patientInfo.getBloodGroup(),patientInfo.getInjuryHistory(),patientInfo.getNominee1Name(),
                patientInfo.getNominee1Contact(),patientInfo.getNominee2Name(),patientInfo.getNominee2Contact()));
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
                patientList.getInjuryHistory(),
                patientList.getNominee1Name(),
                patientList.getNominee1Contact(),
                patientList.getNominee2Name(),
                patientList.getNominee2Contact()
        );
        return pRequest;
    }

    @Override
    public List<com.example.healthe.entity.DoctorRequest> getRequestsForPatient(String patientId) {
        List<com.example.healthe.entity.DoctorRequest> patientRequests =  doctorRepo.findByPatientId(patientId);
        return patientRequests;
    }

    public List<com.example.healthe.entity.DoctorRequest> getRequestsByDoctor(String doctorId) {
        List<com.example.healthe.entity.DoctorRequest> doctorRequests =  doctorRepo.findByDoctorId(doctorId);
        return doctorRequests;
    }

    @Override
    public String editUser(PatientInfoRequest patientInfo) {
        patientRepo.updatePatientInfo(patientInfo.getPatientId(),patientInfo.getHeight(),
                patientInfo.getWeight(),patientInfo.getAllergies(),patientInfo.getMedication(),
                patientInfo.getDisease(),patientInfo.getBloodGroup(),patientInfo.getInjuryHistory(),
                patientInfo.getNominee1Name(),patientInfo.getNominee1Contact(),patientInfo.getNominee2Name(),
                patientInfo.getNominee2Contact());
        return "Submitted Successfully";
    }

    @Override
    public ArrayList<PatientInfoRequest> getPatientInfoByDisease(String disease) {
        List<PatientInfo> patientList =  patientRepo.findByPatientsByDisease(disease);
        ArrayList<PatientInfoRequest> pList = new ArrayList<>();
        for(PatientInfo patientObject: patientList) {
            PatientInfoRequest pRequest = new PatientInfoRequest(
                    patientObject.getPatientName(),
                    patientObject.getPatientId(),
                    patientObject.getDOB(),
                    patientObject.getHeight(),
                    patientObject.getWeight(),
                    patientObject.getAllergies(),
                    patientObject.getMedication(),
                    patientObject.getDisease(),
                    patientObject.getBloodGroup(),
                    patientObject.getInjuryHistory(),
                    patientObject.getNominee1Name(),
                    patientObject.getNominee1Contact(),
                    patientObject.getNominee2Name(),
                    patientObject.getNominee2Contact()
            );
            pList.add(pRequest);
        }
        return  pList;
    }

    @Override
    public String updateRequestStatus(UpdateDoctorRequest docRequest) {
        doctorRepo.updateStatus(docRequest.getStatus(),docRequest.getRequestId());
        return docRequest.getStatus();
    }


}
