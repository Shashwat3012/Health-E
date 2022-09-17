package com.example.healthe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient_info")
public class patientInfo {
    @Column(name = "patient_name")
    private  String patientName;

    @Id
    @Column(name = "uuid")
    private  int UUID;

    @Column(name = "dob")
    private String DOB;

    @Column(name = "height")
    private  float height;

    @Column(name =  "weight")
    private float weight;

    @Column(name =  "allergies")
    private  String allergies;

    @Column(name = "medication")
    private  String medication;

    @Column(name = "disease")
    private  String disease;

    @Column(name = "blood_group")
    private String bloodGroup;


    public patientInfo(String patientName, int UUID, String DOB, float height, float weight, String allergies, String medication, String disease, String bloodGroup) {
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

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getUUID() {
        return UUID;
    }

    public void setUUID(int UUID) {
        this.UUID = UUID;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    @Override
    public String toString() {
        return "patientInfo{" +
                "patientName='" + patientName + '\'' +
                ", UUID=" + UUID +
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
