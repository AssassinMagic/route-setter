package com.backend.e2e;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

class UserE2ETests {

    @Test
    void testUserLogin() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/login");

        // Find the username and password input fields
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));

        // Enter the username and password
        usernameField.sendKeys("testuser");
        passwordField.sendKeys("password");

        // Find and click the login button
        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();

        // Verify the login was successful by checking the presence of a logout button or user profile
        WebElement logoutButton = driver.findElement(By.name("logout"));
        assertNotNull(logoutButton);

        driver.quit();
    }
}