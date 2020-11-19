package com.codeup.adlister.models;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.util.Password;
import com.github.javafaker.Faker;

import java.io.Serializable;
import java.sql.Date;
import java.util.Random;

public class User implements Serializable {
    private long id;
    private String username;
    private String email;
    private String password;
    private String avatar;
    private String role;
    private java.sql.Date creation;

    public User() {}
//  create temp user 
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        setPassword(password);
        randomAvatar();
    }

//    get user from db
    public User(long id, String username, String email, String password,String avatar,String role, java.sql.Date creation) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.role = role;
        this.creation = creation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Password.hash(password);
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void randomAvatar() {
        Random rand = new Random();
        int num = rand.nextInt(((90 - 1) + 1)) + 1;
        int toss = rand.nextInt(((2 - 1) + 1)) + 1;
        String baseUrl = "https://randomuser.me/api/portraits/";
        this.avatar = toss >1 ? baseUrl+"men/"+ num +".jpg": baseUrl+"women/"+ num +".jpg";
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreation() {
        return creation;
    }
}
