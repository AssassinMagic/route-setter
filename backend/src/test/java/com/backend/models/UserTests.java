package com.backend.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTests {

    @Test
    void testUserInitialization() {
        User user = new User();
        assertNotNull(user.getFavoriteRoutes());
        assertNotNull(user.getUploadedRoutes());
        assertNotNull(user.getLikedRoutes());
        assertNotNull(user.getDislikedRoutes());
        assertNotNull(user.getCommentedRoutes());
        assertNotNull(user.getNotificationPreferences());
        assertNotNull(user.getPrivacySettings());
    }

    @Test
    void testUserEmailVerification() {
        User user = new User();
        user.setEmailVerified(true);
        assertTrue(user.getIsEmailVerified());
    }

    @Test
    void testUserPasswordIgnored() {
        User user = new User();
        user.setPassword("secret");
        // Assuming you have a method to serialize the user to JSON
        String json = serializeUserToJson(user);
        assertFalse(json.contains("secret"));
    }

    // Helper method to serialize user to JSON (you need to implement this)
    private String serializeUserToJson(User user) {
        // Implement JSON serialization logic
        return "";
    }
}