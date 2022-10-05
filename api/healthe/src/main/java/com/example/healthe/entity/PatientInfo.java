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

    @Column(name = "nominee1_name")
    private String nominee1Name;

    @Column(name = "nominee1_contact")
    private String nominee1Contact;

    @Column(name = "nominee2_name")
    private String nominee2Name;

    @Column(name = "nominee2_contact")
    private String nominee2Contact;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public PatientInfo(String patientName, String patientId, String DOB, float height, float weight, String allergies,
                       String medication, String disease, String bloodGroup, String injuryHistory, String nominee1Name,
                       String nominee1Contact, String nominee2Name, String nominee2Contact) {
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
        this.nominee1Name = nominee1Name;
        this.nominee1Contact = nominee1Contact;
        this.nominee2Name = nominee2Name;
        this.nominee2Contact = nominee2Contact;
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

    @Override
    public String toString() {
        return "PatientInfo{" +
                "patientName='" + patientName + '\'' +
                ", patientId='" + patientId + '\'' +
                ", DOB='" + DOB + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", allergies='" + allergies + '\'' +
                ", medication='" + medication + '\'' +
                ", disease='" + disease + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", injuryHistory='" + injuryHistory + '\'' +
                ", nominee1Name='" + nominee1Name + '\'' +
                ", nominee1Contact='" + nominee1Contact + '\'' +
                ", nominee2Name='" + nominee2Name + '\'' +
                ", nominee2Contact='" + nominee2Contact + '\'' +
                ", id=" + id +
                '}';
    }
}
