package com.denik.vy.services;

import com.denik.vy.entities.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getAllUsers();
    void editUser(User user);
    void deleteUser(int id);
    User getUser(int id);
}
