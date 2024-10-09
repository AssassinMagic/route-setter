package com.backend.services;

import com.backend.models.User;
import com.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Optional;
import java.util.List;

@Service
public class UserService {
    // Purpose: Handles user-specific business logic, such as fetching user data.
    // Interactions: Works with UserRepository to access user data in the database.

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(User user) {
        logger.info("Creating user: {}", user.getUsername());
        return userRepository.save(user);
    }

    public Optional<User> getUserByUsername(String username) {
        logger.info("Fetching user by username: {}", username);
        return userRepository.findByUsername(username);
    }

    public Optional<User> getUserById(Long id) {
        logger.info("Fetching user by id: {}", id);
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        logger.info("Fetching all users");
        return userRepository.findAll();
    }

    @Transactional
    public void deleteUser(Long id) {
        logger.info("Deleting user by id: {}", id);
        userRepository.deleteById(id);
    }

    @Transactional
    public User updateUser(Long id, User updatedUser) {
        logger.info("Updating user by id: {}", id);
        return userRepository.findById(id).map(user -> {
            user.setUsername(updatedUser.getUsername());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setFirstname(updatedUser.getFirstname());
            user.setLastname(updatedUser.getLastname());
            user.setProfilePictureUrl(updatedUser.getProfilePictureUrl());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }
}