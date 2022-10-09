package com.example.healthe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "doctor_info")
public class DoctorInfo extends User {
    @Column(name = "license_number")
    private String license;
    @Column(name = "hospital")
    private String hospital;
    @Column(name = "status")
    private String status;

    public DoctorInfo(String firstName, String lastName, String username, String password, String role, String uuid, String license, String hospital, String status) {
        super(firstName, lastName, username, password, role, uuid);
        this.license = license;
        this.hospital = hospital;
        this.status = status;
    }

    public String getLicense() {
        return license;
    }

    public String getHospital() {
        return hospital;
    }

    public String getStatus() {
        return status;
    }
}
