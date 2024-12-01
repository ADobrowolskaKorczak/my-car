package com.example.my_car.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    @GetMapping("/welcome")
    public String welcome() {
        return "WELCOME";
    }

    @GetMapping("/user/userProfile")
    public String userProfile() {
        return "User profile";
    }

    @GetMapping("/admin/adminProfile")
    public String adminProfile() {
        return "Admin profile";
    }
}
