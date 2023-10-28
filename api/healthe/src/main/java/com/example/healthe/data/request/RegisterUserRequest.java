package com.example.healthe.data.request;

public class RegisterUserRequest extends LoginRequest {
    private final String firstName;
    private final String lastName;
    private final String license;
    private final String hospital;
    private final String status;

    public RegisterUserRequest(String userName, String role, String password, String firstName,
                               String lastName, String license, String hospital, String status) {
        super(userName, role, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.license = license;
        this.hospital = hospital;
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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
