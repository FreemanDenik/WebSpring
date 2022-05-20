package com.denik.vy.controllers;

import com.denik.vy.entities.User;
import com.denik.vy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class homeController {

    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String index(ModelMap model){
        return "home/index";
    }

    @GetMapping("/users")
    public String users(ModelMap model){
        model.addAttribute("model", userService.getAllUsers());
        return "home/users";
    }
    @GetMapping("/add")
    public String add(ModelMap model){

        model.addAttribute("user", new User());
        return "home/add";
    }
    @PostMapping("/save")
    public String save(User user){

        userService.addUser(user);
        return "redirect:/users";
    }
    @GetMapping("/edit")
    public String edit(ModelMap model, int id) {

        User user = userService.getUser(id);
        model.addAttribute("model", user);
        return "home/edit";
    }
    @PostMapping("/edit")
    public String edit(User user) {

        userService.editUser(user);
        return "redirect:/users";
    }
    @PostMapping("/delete")
    public String delete(int id) {

        userService.deleteUser(id);
        return "redirect:/users";
    }
}
