package com.selenium.WebTesting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class web {
	
	@Test
	void validLoginTest() {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://travel.agileway.net/login");
		
		LoginPage login = new LoginPage(driver);
		login.loginClick("standard_user","sercet_user");
		
		assertTrue(driver.getCurrentUrl().contains("welcome"));
	}

}