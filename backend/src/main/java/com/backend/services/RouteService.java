package com.backend.services;

import com.backend.models.Route;
import com.backend.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class RouteService {
    // Purpose: Manages the creation and retrieval of routes, including image uploads and storing route data.
    // Interactions: Works with RouteRepository to interact with the database and store or retrieve route data. Also interacts with services like AWS S3 to upload images.
    @Autowired
    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Route createRoute(Route route) {
        return routeRepository.save(route);
    }

    public Optional<Route> getRouteById(Long id) {
        return routeRepository.findById(id);
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }
}
