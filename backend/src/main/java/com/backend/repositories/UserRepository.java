package com.backend.repositories;

import com.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Long>{
    // Purpose: Interface for accessing user data in the database.
    // Interactions: Interacts with the User entity and the database to retrieve or save user data.

    Optional<User> findByUsername(String username);

}
