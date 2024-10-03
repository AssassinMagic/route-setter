package com.backend.repositories;

import com.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    // Purpose: Interface for accessing user data in the database.
    // Interactions: Interacts with the User entity and the database to retrieve or save user data.

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    // Custom query to find users registered after a certain date
    @Query("SELECT u FROM User u WHERE u.createdAt > :date")
    List<User> findUsersRegisteredAfter(LocalDateTime date);

    // Custom query to find users by partial match in username
    @Query("SELECT u FROM User u WHERE u.username LIKE %:username%")
    List<User> findByUsernameContaining(@Param("username") String username);



}
