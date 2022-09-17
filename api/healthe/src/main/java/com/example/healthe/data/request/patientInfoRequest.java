package com.example.healthe.data.request;

import javax.persistence.Column;
import javax.persistence.Id;

public class patientInfoRequest {

    private  String patientName;

    private  int UUID;

    private String DOB;

    private  float height;

    private float weight;

    private  String allergies;

    private  String medication;

    private  String disease;

    private String bloodGroup;

    public patientInfoRequest(String patientName, int UUID, String DOB, float height, float weight, String allergies, String medication, String disease, String bloodGroup) {
        this.patientName = patientName;
        this.UUID = UUID;
        this.DOB = DOB;
        this.height = height;
        this.weight = weight;
        this.allergies = allergies;
        this.medication = medication;
        this.disease = disease;
        this.bloodGroup = bloodGroup;
    }

    public String getPatientName() {
        return patientName;
    }

    public int getUUID() {
        return UUID;
    }

    public String getDOB() {
        return DOB;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getMedication() {
        return medication;
    }

    public String getDisease() {
        return disease;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }
}
