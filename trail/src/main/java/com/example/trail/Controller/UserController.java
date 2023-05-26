package com.example.trail.Controller;

import com.example.trail.DTO.LoginDTO;
import com.example.trail.DTO.SignupDTO;
import com.example.trail.Entity.User;
import com.example.trail.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;




@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class UserController {
    @Autowired

    UserService userService;

    @PostMapping(value = "/save")
    public User save(@RequestBody SignupDTO signbydto) {
        return userService.saveDetails(signbydto);
    }
    @PostMapping(value = "/signupuser")
    public ResponseEntity<MyResponse> signup(@RequestBody SignupDTO signupDTO) {
        int response = userService.signUp(signupDTO);
        if (response == 1) {
            return ResponseEntity.ok(new MyResponse("saved user details"));
        } else {
            return ResponseEntity.ok(new MyResponse("already exists "));
        }
    }
    @PostMapping("/login")
    public ResponseEntity<MyResponse> login(@RequestBody LoginDTO loginDTO) {
        int responses = userService.logIn(loginDTO);
        if (responses == 1) {
            return ResponseEntity.ok(new MyResponse("login successful"));
        } else {
            return ResponseEntity.ok(new MyResponse("failed to login"));
        }
    }
}