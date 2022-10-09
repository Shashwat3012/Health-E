package com.example.healthe.data.request;

public class RegisterUserRequest extends LoginRequest {
    private final String firstName;
    private final String lastName;

    public RegisterUserRequest(String userName, String role, String password, String firstName, String lastName) {
        super(userName, role, password);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
