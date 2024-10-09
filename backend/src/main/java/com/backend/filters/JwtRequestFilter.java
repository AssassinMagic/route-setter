package com.backend.filters;

import com.backend.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(JwtRequestFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        // Extract Authorization header from the request
        final String requestTokenHeader = request.getHeader("Authorization");

        String username = null;
        String jwtToken = null;

        try {
            // JWT Token is in the form "Bearer token"
            if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
                jwtToken = requestTokenHeader.substring(7);

                // Extract username from token
                username = jwtUtil.extractUsername(jwtToken);
            } else {
                logger.warn("JWT Token does not begin with Bearer String");
            }

            // Once we get the token, validate it
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

                // if token is valid configure Spring Security to manually set authentication
                if (jwtUtil.validateToken(jwtToken, userDetails)) {

                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                    usernamePasswordAuthenticationToken.setDetails(
                            new WebAuthenticationDetailsSource().buildDetails(request));

                    // Set the authentication in the context
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                } else {
                    logger.warn("JWT Token is invalid");
                }
            }
        } catch (ExpiredJwtException e) {
            logger.warn("JWT Token has expired");
            // Optionally, send an error response
            // response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "JWT Token has expired");
            // return;
        } catch (Exception e) {
            logger.error("An error occurred while processing the JWT Token", e);
        }

        // Continue the filter chain
        chain.doFilter(request, response);
    }
}
