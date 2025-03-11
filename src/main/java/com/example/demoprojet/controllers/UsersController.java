package com.example.demoprojet.controllers;

import com.example.demoprojet.entity.infoUsers;
import com.example.demoprojet.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UsersController {


    private UsersRepo userRepository;

    @Autowired
    public UsersController(UsersRepo userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user/all")
    public List<infoUsers> allUsers() {
        return userRepository.findAll();
    }
}
