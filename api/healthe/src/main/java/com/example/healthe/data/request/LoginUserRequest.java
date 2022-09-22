package com.example.healthe.data.request;

public class LoginUserRequest {
    private String userName;
    private String role;
    private String password;

    public LoginUserRequest(String userName, String role, String password) {
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
