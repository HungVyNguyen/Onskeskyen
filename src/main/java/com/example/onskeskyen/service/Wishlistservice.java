package com.example.onskeskyen.service;

import com.example.onskeskyen.models.Wishlist;
import com.example.onskeskyen.repository.Wishlistrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Wishlistservice {
    @Autowired
    Wishlistrepository wishlistrepository;


    public List<Wishlist> getwishlist() {
        return wishlistrepository.getWishlist();
    }


    public List<Wishlist> getmylist(int id) {
        return wishlistrepository.getmylist(id);
    }

    public void insert(String title, int userid) {
        wishlistrepository.insert(title,userid);
    }
}
