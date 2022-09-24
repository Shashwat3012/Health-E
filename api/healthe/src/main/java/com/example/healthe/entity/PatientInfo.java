package com.example.healthe.entity;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
@Table(name = "patient_info")
public class PatientInfo {
    @Column(name = "patient_name")
    private String patientName;
    
    @Column(name = "patientId")
    private String patientId;

    @Column(name = "dob")
    private String DOB;

    @Column(name = "height")
    private float height;

    @Column(name = "weight")
    private float weight;

    @Column(name = "allergies")
    private String allergies;

    @Column(name = "medication")
    private String medication;

    @Column(name = "disease")
    private String disease;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "injury_history")
    private String injuryHistory;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public PatientInfo(String patientName, String patientId, String DOB, float height, float weight, String allergies,
                       String medication, String disease, String bloodGroup, String injuryHistory) {
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

    public PatientInfo() {
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

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "patientInfo{" +
                "patientName='" + patientName + '\'' +
                ", patientId=" + patientId +
                ", DOB='" + DOB + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", allergies='" + allergies + '\'' +
                ", medication='" + medication + '\'' +
                ", disease='" + disease + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                '}';
    }
}
