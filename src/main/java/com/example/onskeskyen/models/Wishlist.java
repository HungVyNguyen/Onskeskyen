package com.example.onskeskyen.models;

public class Wishlist {
    private int User_id;
    private int Wishlist_id;
    private String name;

    public Wishlist(){

    }

    public Wishlist(int user_id, int wishlist_id, String name) {
        User_id = user_id;
        Wishlist_id = wishlist_id;
        this.name = name;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public int getWishlist_id() {
        return Wishlist_id;
    }

    public void setWishlist_id(int wishlist_id) {
        Wishlist_id = wishlist_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
