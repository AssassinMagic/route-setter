package com.backend.controllers;

import com.backend.models.User;
import com.backend.services.AuthService;
import com.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    // Purpose: Handles authentication-related operations, such as login and registration.
    // Interactions: Calls AuthService to authenticate users and generate JWT tokens.
    @Autowired
    private final AuthService authService;

    @Autowired
    private final UserService userService;

    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        try {
            String token = authService.authenticate(user.getUsername(), user.getPassword());
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}
