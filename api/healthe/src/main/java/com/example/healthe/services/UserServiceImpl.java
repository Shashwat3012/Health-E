package com.example.healthe.services;

import com.example.healthe.data.request.RegisterUserRequest;
import com.example.healthe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class UserServiceImpl implements User{
    @Autowired
    private UserRepository userRepo;

    @Override
    public String registerUser(RegisterUserRequest userRequest) {
        String uuid = UUID.randomUUID().toString().substring(0,6);
        userRepo.save(new com.example.healthe.entity.User(userRequest.getFirstName(),userRequest.getLastName(),userRequest.getUserName(),userRequest.getPassword(),userRequest.getRole(),uuid));
        return uuid;
    }
}
