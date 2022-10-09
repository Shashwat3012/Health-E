package com.example.healthe.data.request;

public class LoginUserRequest {
    private final String userName;
    private final String role;
    private final String password;
    private final String patientId;
    private final String nomineeName;

    public LoginUserRequest(String userName, String role, String password, String patientId, String nomineeName) {
        this.userName = userName;
        this.role = role;
        this.password = password;
        this.patientId = patientId;
        this.nomineeName = nomineeName;
    }

    public String getUserName() {
        return userName;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getNomineeName() {
        return nomineeName;
    }
}
