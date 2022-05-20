package com.denik.vy.controllers;

import com.denik.vy.entities.User;
import com.denik.vy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {

    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String getIndex(ModelMap map){
        userService.addUser(new User("Bob Im"));
        return "home/index";
    }
}
