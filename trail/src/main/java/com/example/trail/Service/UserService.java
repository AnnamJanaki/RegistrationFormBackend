package com.example.trail.Service;

import  com.example.trail.DTO.LoginDTO;
import  com.example.trail.DTO.SignupDTO;
import  com.example.trail.Entity.User;
import  com.example.trail.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;

@Service

public class UserService {
    @Autowired
    UserRepository userRepository;

    public User saveDetails(@RequestBody SignupDTO signbydto) {
        return userRepository.save(signbydto);
    }
    public int signUp(final SignupDTO signbydto){
        User saveduser = userRepository.findByEmail(signbydto.getEmail());
        if(ObjectUtils.isEmpty(saveduser)){
            User newuser = new User();
            newuser.setFullname(signbydto.getFullname());
            newuser.setName(signbydto.getName());
            newuser.setEmail(signbydto.getEmail());
            newuser.setPassword(signbydto.getPassword());
            newuser.setNumber(signbydto.getNumber());
            userRepository.save(newuser);
            return 1;
        }else{
            return 100;
        }
    }

    public int logIn(final LoginDTO loginbydto){
        User savedusers = userRepository.findByEmail(loginbydto.getEmail());
        if(!ObjectUtils.isEmpty(savedusers)){
            if (savedusers.getPassword().equals(loginbydto.getPassword())){
                return 1;
            }
        }return 100;
    }
}
