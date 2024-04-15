package com.example.onskeskyen.controller;

import com.example.onskeskyen.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private userService userservice;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("users", userservice.getuserlist());
        return "home/index";

    }

}
