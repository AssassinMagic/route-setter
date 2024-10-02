package com.backend.controllers;

import com.backend.models.User;
import com.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/users")
public class UserController {
    // Purpose: Handles user-related operations, such as fetching user details.
    // Interactions: Calls UserService to retrieve user data from the database.

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
    
    @GetMapping("/{username}")
    public User getUser(@RequestParam String username) {
        return userService.getUserByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }
    
}
