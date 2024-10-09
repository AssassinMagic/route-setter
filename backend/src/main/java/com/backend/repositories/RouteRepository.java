package com.backend.repositories;

import com.backend.models.Route;
import com.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.lang.NonNull;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    // Purpose: Interface for accessing route data in the database.
    // Interactions: Interacts with the Route entity to retrieve or store route data.

    List<Route> findByCreatedBy(User user);

    List<Route> findByGrade(String grade);

    List<Route> findByIsActive(boolean isActive);

    List<Route> findByLocation(String location);

    List<Route> findByTags(String tags);

    List<Route> findByNameContaining(String name);

    // Custom query to find top routes by upvotes (with pagination support)
    @Query("SELECT r FROM Route r ORDER BY r.likesCount DESC")
    List<Route> findTopRoutesByUpvotes(Pageable pageable);

    // Custom query to find the most recent active routes
    @Query("SELECT r FROM Route r WHERE r.isActive = true ORDER BY r.createdAt DESC")
    List<Route> findRecentActiveRoutes(Pageable pageable);

    // Custom query to find routes favorited by a specific user
    @Query("SELECT r FROM Route r WHERE :userId MEMBER OF r.favoriteList")
    List<Route> findRoutesFavoritedByUser(@Param("userId") Long userId);

    @NonNull
    Page<Route> findAll(@NonNull Pageable pageable);

    List<Route> findByGrade(String grade, Sort sort);

    // Increment view count for a route
    @Transactional
    @Modifying
    @Query("UPDATE Route r SET r.viewsCount = r.viewsCount + 1 WHERE r.id = :routeId")
    void incrementViewCount(@Param("routeId") Long routeId);
}
