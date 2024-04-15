package com.example.onskeskyen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String createUser(){
        return "home/create_user";
    }

    @PostMapping
    public String createUserDB(){

        return userService.createUserDB();

    }



}
