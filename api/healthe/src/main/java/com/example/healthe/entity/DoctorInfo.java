package com.example.healthe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctor_info")
public class DoctorInfo {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "user_name")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
    @Id
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "license_number")
    private String license;
    @Column(name = "hospital")
    private String hospital;
    @Column(name = "status")
    private String status;

    public DoctorInfo(String firstName, String lastName, String username, String password,
                      String role, String uuid, String license, String hospital, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.role = role;
        this.uuid = uuid;
        this.license = license;
        this.hospital = hospital;
        this.status = status;
    }

    public DoctorInfo() {
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getUuid() {
        return uuid;
    }
}
