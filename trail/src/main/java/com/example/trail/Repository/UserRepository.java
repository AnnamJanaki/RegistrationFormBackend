package com.example.trail.Repository;

import com.example.trail.DTO.SignupDTO;
import com.example.trail.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository
public interface UserRepository extends JpaRepository<User, Serializable>{


    User findByEmail(String email);
    User save(SignupDTO signbydto);
}
