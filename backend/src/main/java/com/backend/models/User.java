package com.backend.models;

import jakarta.persistence.*;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private Boolean isEmailVerified = false;
    private String verificationToken;

    private String profilePictureUrl;
    // private String resetToken; // for password reset maybe

    // route lists information

    private Integer score = 0;

    @ElementCollection
    private List<Long> favoriteRoutes = new ArrayList<>();

    @ElementCollection
    private List<Long> uploadedRoutes = new ArrayList<>();

    @ElementCollection
    private List<Long> likedRoutes = new ArrayList<>();

    @ElementCollection
    private List<Long> dislikedRoutes = new ArrayList<>();

    @ElementCollection
    private List<Long> commentedRoutes = new ArrayList<>();

    // extra user info

    // possible user bio?

    // user prefrences

    @ElementCollection
    private Map<String, Boolean> notificationPreferences = new HashMap<>();

    @ElementCollection
    private Map<String, Boolean> privacySettings = new HashMap<>();

    private String themePreference;
    private String location; // perfered climbing gym

    // getters and setters

    /**
     * @return String return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return String return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the profilePictureUrl
     */
    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    /**
     * @param profilePictureUrl the profilePictureUrl to set
     */
    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    /**
     * @return List<Long> return the favoriteRoutes
     */
    public List<Long> getFavoriteRoutes() {
        return favoriteRoutes;
    }

    /**
     * @param favoriteRoutes the favoriteRoutes to set
     */
    public void setFavoriteRoutes(List<Long> favoriteRoutes) {
        this.favoriteRoutes = favoriteRoutes;
    }

    /**
     * @return List<Long> return the uploadedRoutes
     */
    public List<Long> getUploadedRoutes() {
        return uploadedRoutes;
    }

    /**
     * @param uploadedRoutes the uploadedRoutes to set
     */
    public void setUploadedRoutes(List<Long> uploadedRoutes) {
        this.uploadedRoutes = uploadedRoutes;
    }

    /**
     * @return List<Long> return the likedRoutes
     */
    public List<Long> getLikedRoutes() {
        return likedRoutes;
    }

    /**
     * @param likedRoutes the likedRoutes to set
     */
    public void setLikedRoutes(List<Long> likedRoutes) {
        this.likedRoutes = likedRoutes;
    }

    /**
     * @return List<Long> return the dislikedRoutes
     */
    public List<Long> getDislikedRoutes() {
        return dislikedRoutes;
    }

    /**
     * @param dislikedRoutes the dislikedRoutes to set
     */
    public void setDislikedRoutes(List<Long> dislikedRoutes) {
        this.dislikedRoutes = dislikedRoutes;
    }

    /**
     * @return List<Long> return the commentedRoutes
     */
    public List<Long> getCommentedRoutes() {
        return commentedRoutes;
    }

    /**
     * @param commentedRoutes the commentedRoutes to set
     */
    public void setCommentedRoutes(List<Long> commentedRoutes) {
        this.commentedRoutes = commentedRoutes;
    }

    /**
     * @return Map<String, Boolean> return the notificationPreferences
     */
    public Map<String, Boolean> getNotificationPreferences() {
        return notificationPreferences;
    }

    /**
     * @param notificationPreferences the notificationPreferences to set
     */
    public void setNotificationPreferences(Map<String, Boolean> notificationPreferences) {
        this.notificationPreferences = notificationPreferences;
    }

    /**
     * @return String return the themePreference
     */
    public String getThemePreference() {
        return themePreference;
    }

    /**
     * @param themePreference the themePreference to set
     */
    public void setThemePreference(String themePreference) {
        this.themePreference = themePreference;
    }


    /**
     * @return LocalDateTime return the createdAt
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    /**
     * @return Boolean return the isEmailVerified
     */
    public Boolean isIsEmailVerified() {
        return isEmailVerified;
    }

    /**
     * @param isEmailVerified the isEmailVerified to set
     */
    public void setIsEmailVerified(Boolean isEmailVerified) {
        this.isEmailVerified = isEmailVerified;
    }

    /**
     * @return String return the verificationToken
     */
    public String getVerificationToken() {
        return verificationToken;
    }

    /**
     * @param verificationToken the verificationToken to set
     */
    public void setVerificationToken(String verificationToken) {
        this.verificationToken = verificationToken;
    }

    /**
     * @return Integer return the score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * @return Map<String, Boolean> return the privacySettings
     */
    public Map<String, Boolean> getPrivacySettings() {
        return privacySettings;
    }

    /**
     * @param privacySettings the privacySettings to set
     */
    public void setPrivacySettings(Map<String, Boolean> privacySettings) {
        this.privacySettings = privacySettings;
    }

}
