package com.generic_Library;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Base_Test {
	public WebDriver driver;
	
	@BeforeClass(alwaysRun=true)
	public void openBrowser(){
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void loginToDWS(){

		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("nikhil26@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("nikhil123");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	
	@AfterMethod(alwaysRun=true)
	public void logoutFromDWS(){
		driver.findElement(By.linkText("Log out")).click();
	}
	
	@AfterClass(alwaysRun=true)
	public void closeBrowser(){
		driver.quit();
	}
}