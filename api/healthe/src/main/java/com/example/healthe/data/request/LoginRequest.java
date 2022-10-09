package com.example.healthe.data.request;

public class LoginRequest {
    private final String userName;
    private final String role;
    private final String password;

    public LoginRequest(String userName, String role, String password) {
        this.userName = userName;
        this.role = role;
        this.password = password;
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
}
