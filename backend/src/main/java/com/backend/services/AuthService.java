package com.backend.services;

import com.backend.models.User;
import com.backend.repositories.UserRepository;
import com.backend.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Service
public class AuthService {
    // Purpose: Manages authentication logic, such as verifying credentials and generating JWT tokens.
    // Interactions: Works with UserRepository to fetch user credentials, and uses JwtUtil to generate tokens.

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    public String authenticate(String username, String password) {
        logger.info("Authenticating user: {}", username);
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return jwtUtil.generateToken(userDetails.getUsername()); // Extract username and pass it to generateToken
        } catch (Exception e) {
            logger.error("Authentication failed for user: {}", username, e);
            throw new RuntimeException("Invalid credentials");
        }
    }

    public User register(User user) {
        logger.info("Registering user: {}", user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        logger.info("Fetching user by username: {}", username);
        return userRepository.findByUsername(username);
    }

    public Optional<User> findByEmail(String email) {
        logger.info("Fetching user by email: {}", email);
        return userRepository.findByEmail(email);
    }
}