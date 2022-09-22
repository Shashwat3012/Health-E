package com.example.healthe.services;

import com.example.healthe.data.request.LoginUserRequest;
import com.example.healthe.data.request.RegisterUserRequest;
import com.example.healthe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class UserServiceImpl implements User{
    @Autowired
    private UserRepository userRepo;

    @Override
    public String registerUser(RegisterUserRequest userRequest) {
        String uuid = UUID.randomUUID().toString().substring(0,6);
        userRepo.save(new com.example.healthe.entity.User(userRequest.getFirstName(),userRequest.getLastName(),userRequest.getUserName(),userRequest.getPassword(),userRequest.getRole(),uuid));
        return uuid;
    }

    @Override
    public String loginUser(LoginUserRequest userRequest) {
        Optional<com.example.healthe.entity.User> user = userRepo.findByUserName(userRequest.getUserName());
        if (user ==null){
            return "User Not Found!";}
        else{
            if(userRequest.getPassword()==user.get().getPassword()){
                return user.get().getRole();
            }
            else{
                return "Incorrect Password";
            }
        }
    }
}
