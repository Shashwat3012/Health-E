package com.example.healthe.controllers;

import com.example.healthe.data.request.UserRequest;
import com.example.healthe.entity.User;
import com.example.healthe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Controller
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepo;
    @PostMapping("/login")
    public String loginUser(@RequestBody UserRequest userRequest){
        return "";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserRequest userRequest){
        String uuid = UUID.randomUUID().toString().substring(0,6);
        userRepo.save(new User("rohit","sharma",userRequest.getUserName(),userRequest.getPassword(),userRequest.getRole(),uuid));
        return uuid;
    }
}
