package com.example.healthe.data.request;

public class PatientInfoRequest {

    private final String patientName;

    private final String patientId;

    private final String DOB;

    private final float height;

    private final float weight;

    private final String allergies;

    private final String medication;

    private final String disease;

    private final String bloodGroup;

    private final String injuryHistory;

    public PatientInfoRequest(String patientName, String patientId, String DOB, float height, float weight,
                              String allergies, String medication, String disease, String bloodGroup, String injuryHistory) {
        this.patientName = patientName;
        this.patientId = patientId;
        this.DOB = DOB;
        this.height = height;
        this.weight = weight;
        this.allergies = allergies;
        this.medication = medication;
        this.disease = disease;
        this.bloodGroup = bloodGroup;
        this.injuryHistory = injuryHistory;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPatientId() {
        return patientId;
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

    public String getInjuryHistory() {
        return injuryHistory;
    }
}
