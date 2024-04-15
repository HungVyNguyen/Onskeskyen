package com.example.onskeskyen.models;

public class User {
    private int user_id;
    private String username;
    private String password;
    private String imagepath;

    public User(){

    }
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(int user_id, String username, String password, String imagepath) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.imagepath = imagepath;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
