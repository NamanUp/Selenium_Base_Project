package com.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class Data_Provider_Base_Class {

	public static WebDriver flipDriver;
	public WebDriver driver;
	
	@BeforeTest(alwaysRun=true)
	public void openFlipKart() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		
		flipDriver = driver;
		
	}
	
//	@BeforeClass(alwaysRun=true)
//	public void clickSearchBar() {
//		
//	}
}
