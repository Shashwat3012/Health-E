package com.example.healthe.data.request;

import javax.persistence.Column;

public class PatientInfoRequest {

    private final String patientName;

    private final String patientId;

    private final String dob;

    private final float height;

    private final float weight;

    private final String allergies;

    private final String medication;

    private final String disease;

    private final String bloodGroup;

    private final String injuryHistory;

    private final String nominee1Name;

    private final String nominee1Contact;

    private final String nominee2Name;

    private final String nominee2Contact;

    public PatientInfoRequest(String patientName, String patientId, String dob, float height, float weight,
                              String allergies, String medication, String disease, String bloodGroup, String injuryHistory,
                              String nominee1Name, String nominee1Contact, String nominee2Name, String nominee2Contact) {
        this.patientName = patientName;
        this.patientId = patientId;
        this.dob = dob;
        this.height = height;
        this.weight = weight;
        this.allergies = allergies;
        this.medication = medication;
        this.disease = disease;
        this.bloodGroup = bloodGroup;
        this.injuryHistory = injuryHistory;
        this.nominee1Name = nominee1Name;
        this.nominee1Contact = nominee1Contact;
        this.nominee2Name = nominee2Name;
        this.nominee2Contact = nominee2Contact;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDOB() {
        return dob;
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

    public String getNominee1Name() {
        return nominee1Name;
    }

    public String getNominee1Contact() {
        return nominee1Contact;
    }

    public String getNominee2Name() {
        return nominee2Name;
    }

    public String getNominee2Contact() {
        return nominee2Contact;
    }
}
