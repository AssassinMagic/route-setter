package com.backend.services;

import com.backend.models.User;
import com.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    // Purpose: Handles user-specific business logic, such as fetching user data.
    // Interactions: Works with UserRepository to access user data in the database.

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }
}