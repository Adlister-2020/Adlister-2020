package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
    void updateUser(User user);
    User findByUserId(Long id);
    void deleteUser(User user);
    List<User> all();
}
