package com.denik.vy.services;

import com.denik.vy.entities.User;
import com.denik.vy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void editUser(User user) {
        User u = userRepository.findById(user.getId()).get();
        u.setName(user.getName());
        u.setPhone(user.getPhone());
        userRepository.save(u);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
    @Override
    public User getUser(int id){
        return userRepository.findById(id).get();
    }
}
