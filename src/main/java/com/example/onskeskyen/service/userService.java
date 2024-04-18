package com.example.onskeskyen.service;

import com.example.onskeskyen.models.User;
import com.example.onskeskyen.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {

    @Autowired
    private userRepository userrepository;


    public List<User> getuserlist() {
        return userrepository.getuserlist();
    }

    public  void createUser(String username, String password, String imagepath){
        userrepository.createUser(username, password, imagepath);
    }
    public int getUserIdForWishlist(int wishlistId) {
        // Delegate the call to userRepository
        return userrepository.getUserIdForWishlist(wishlistId);
    }


}
