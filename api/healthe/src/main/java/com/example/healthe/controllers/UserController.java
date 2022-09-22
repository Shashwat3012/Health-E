package com.example.healthe.controllers;

import com.example.healthe.data.request.LoginUserRequest;
import com.example.healthe.data.request.RegisterUserRequest;
import com.example.healthe.entity.User;
import com.example.healthe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@Controller
@RestController
public class UserController {
    @Autowired
    private com.example.healthe.services.User userService;

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginUserRequest userRequest){
       // Optional<User> user = userRepo.findByUserName(userRequest.getUserName());
        //if user not null
        return "";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterUserRequest userRequest){
        return userService.registerUser(userRequest);
    }
}
