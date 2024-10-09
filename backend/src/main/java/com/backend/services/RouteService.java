package com.backend.services;

import com.backend.models.Route;
import com.backend.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Optional;
import java.util.List;

@Service
public class RouteService {
    // Purpose: Manages the creation and retrieval of routes, including image uploads and storing route data.
    // Interactions: Works with RouteRepository to interact with the database and store or retrieve route data. Also interacts with services like AWS S3 to upload images.

    private static final Logger logger = LoggerFactory.getLogger(RouteService.class);

    @Autowired
    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Transactional
    public Route createRoute(Route route) {
        logger.info("Creating route: {}", route.getName());
        return routeRepository.save(route);
    }

    public Optional<Route> getRouteById(Long id) {
        logger.info("Fetching route by id: {}", id);
        return routeRepository.findById(id);
    }

    public List<Route> getAllRoutes() {
        logger.info("Fetching all routes");
        return routeRepository.findAll();
    }

    @Transactional
    public void deleteRoute(Long id) {
        logger.info("Deleting route by id: {}", id);
        routeRepository.deleteById(id);
    }

    @Transactional
    public Route updateRoute(Long id, Route updatedRoute) {
        logger.info("Updating route by id: {}", id);
        return routeRepository.findById(id).map(route -> {
            route.setName(updatedRoute.getName());
            route.setDescription(updatedRoute.getDescription());
            route.setImageUrl(updatedRoute.getImageUrl());
            route.setRouteData(updatedRoute.getRouteData());
            route.setGrade(updatedRoute.getGrade());
            route.setLocation(updatedRoute.getLocation());
            route.setTags(updatedRoute.getTags());
            return routeRepository.save(route);
        }).orElseThrow(() -> new RuntimeException("Route not found with id " + id));
    }
}
