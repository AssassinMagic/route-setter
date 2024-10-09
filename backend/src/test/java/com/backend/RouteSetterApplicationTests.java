package com.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.profiles.active=test")
class RouteSetterApplicationTests {

    @Test
    void contextLoads() {
        // This test will pass if the application context loads successfully
    }
}