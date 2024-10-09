package com.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.backend.services.UserService;

@SpringBootTest(properties = "spring.profiles.active=test")
class RouteSetterApplicationTests {

	@MockBean
    private UserService userService;

    @Test
    void contextLoads() {
        // Context load test
    }
}