package com.selenium.WebTesting;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationBookStore {

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();        
    }

    @Test
    void searchBookTest() {

        driver.get("https://automationbookstore.dev/");


        driver.findElement(By.id("searchBar")).sendKeys("Agile");

 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-li-static")));
        
        
        
        boolean resultsDisplayed = driver.findElements(By.cssSelector(".ui-li-static")).size() > 0;
        assertTrue(resultsDisplayed);
    }
    
}
