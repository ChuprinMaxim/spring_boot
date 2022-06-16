package com.chuprin.spring_boot.controller;

import com.chuprin.spring_boot.model.User;
import com.chuprin.spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AppController {
    private final UserService userService;
    @Autowired
    public AppController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());

        return "all-users";
    }

    @GetMapping("/addNewForm")
    public String addNewForm(Model model) {
        model.addAttribute("user", new User());

        return "info-user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);

        return "redirect:/";
    }

    @GetMapping("/updateUser")
    public String updateUser(@RequestParam("updateUser") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));

        return "info-user";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("deleteUser") long id) {
        userService.deleteUser(id);

        return "redirect:/";
    }
}
