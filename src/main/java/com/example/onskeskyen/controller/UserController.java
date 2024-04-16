package com.example.onskeskyen.controller;


import com.example.onskeskyen.models.User;
import com.example.onskeskyen.service.Wishlistservice;
import com.example.onskeskyen.service.userService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private Wishlistservice wishlistservice;
    @Autowired
    private userService userservice;



    @GetMapping("/cancel")
    public String cancel(@RequestParam int id){
        int idValue = userservice.getUserIdForWishlist(id);
        return "redirect:/Showmylist?id=" + idValue;
    }
    @PostMapping("/delete")
    public String delete(@RequestParam int id){
        int idValue = userservice.getUserIdForWishlist(id);
        wishlistservice.delete(id);
        return "redirect:/Showmylist?id=" + idValue;
    }

    @GetMapping("/confirm_delete")
    public String confirmdelete(@RequestParam int id, Model model){
        model.addAttribute("list2",id);
        model.addAttribute(wishlistservice.getspicifikwishlist(id));
        return "home/confirm_delete";
    }

    @GetMapping("/showthislist")
    public String mylistmedwishlist(Model model){
        model.addAttribute("alllist",wishlistservice.getall());
        return "home/showall";
    }

    @GetMapping("/create_user")
    public String createUser(){
        return "home/create_user";
    }

    @PostMapping("/create_user")
    public String createUser(@RequestParam String username, @RequestParam String password, @RequestParam String imagepath){
       userservice.createUser(username, password, imagepath);

        return "redirect:/";

    }

    @GetMapping("/Showmylist")
    public String myList(Model model, @RequestParam int id){
        model.addAttribute("userid2", id);
        model.addAttribute("mywishlist", wishlistservice.getmylist(id));
        return "home/AddList";
    }

    @GetMapping("/ShowList")
    public String Userlist(Model model){
        model.addAttribute("Userlist",userservice.getuserlist());
        return "home/Showlist";
    }

    @GetMapping("/new")
    public String insert( Model model, @RequestParam int userid){
        model.addAttribute("userid4", userid);
        return "home/new";
    }

    @PostMapping("/insert")
    public String insert(@RequestParam String title,@RequestParam int userid3){
        wishlistservice.insert(title,userid3);
        return "redirect:/Showmylist?id=" + userid3;
    }

    @PostMapping("/valid")
    public String validate(Model model, @RequestParam String username, @RequestParam String password) {
        List<User> userList = userservice.getuserlist();
        boolean isValidUser = false;
        User user1 = new User();
        for (int i = 0; i < userList.size(); i++) {
            user1 = userList.get(i);
            if (user1.getUsername().equals(username) && user1.getPassword().equals(password)) {
                isValidUser = true;
                break;
            }

        }
        int id = user1.getUser_id();

        System.out.println(id);
        if (isValidUser) {
            model.addAttribute("id",id);
            return "redirect:/Showmylist?id=" + id;
        } else {
            model.addAttribute("message", "WRONG");
            return "home/index";
        }


    }

}
