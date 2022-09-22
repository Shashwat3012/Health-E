package com.example.healthe.services;

import com.example.healthe.data.request.RegisterUserRequest;

public interface User {
    String registerUser(RegisterUserRequest userRequest);
}
