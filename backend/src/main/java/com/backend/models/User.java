package com.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {
    // Purpose: Represents the user table in the database.
    // Interactions: Interacts with UserRepository to persist and retrieve user data.

    // basic information
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String firstname;
    private String lastname;
    private LocalDateTime createdAt;
    private boolean isEmailVerified = false;
    private String verificationToken;

    private String profilePictureUrl;

    private int score = 0;

    @ElementCollection
    @CollectionTable(name = "favorite_routes", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "route_id")
    private List<Long> favoriteRoutes = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "uploaded_routes", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "route_id")
    private List<Long> uploadedRoutes = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "liked_routes", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "route_id")
    private List<Long> likedRoutes = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "disliked_routes", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "route_id")
    private List<Long> dislikedRoutes = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "commented_routes", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "route_id")
    private List<Long> commentedRoutes = new ArrayList<>();

    // Map collections with @ElementCollection
    @ElementCollection
    @CollectionTable(name = "notification_preferences", joinColumns = @JoinColumn(name = "user_id"))
    @MapKeyColumn(name = "preference_key")
    @Column(name = "preference_value")
    private Map<String, Boolean> notificationPreferences = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "privacy_settings", joinColumns = @JoinColumn(name = "user_id"))
    @MapKeyColumn(name = "setting_key")
    @Column(name = "setting_value")
    private Map<String, Boolean> privacySettings = new HashMap<>();

    // extra user info

    // possible user bio?

    // user prefrences

    private String themePreference;
    private String location; // perfered climbing gym

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
