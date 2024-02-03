package com.learning_TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.generic_Library.File_Utility;

public class Learning_Excel_File {
	
	@Test
	public void registerTest() throws Throwable {
		
		String firstName = File_Utility.fetchSingleDataFromExcel("registerData", 1, 0);
		String lastName = File_Utility.fetchSingleDataFromExcel("registerData", 1, 1);
		String email = File_Utility.fetchSingleDataFromExcel("registerData", 1, 2);
		String password = File_Utility.fetchSingleDataFromExcel("registerData", 1, 3);
		String confirmPass = File_Utility.fetchSingleDataFromExcel("registerData", 1, 4);
		String gender = File_Utility.fetchSingleDataFromExcel("registerData", 1, 5);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(File_Utility.getPropertyValue("url"));
		
		driver.findElement(By.linkText("Register")).click();
		
		if (gender.equals("male")) {
			driver.findElement(By.id("gender-male")).click();
		} else {
			driver.findElement(By.id("gender-female")).click();
		}
		
		driver.findElement(By.id("FirstName")).sendKeys(firstName);
		driver.findElement(By.id("LastName")).sendKeys(lastName);
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPass);
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		Thread.sleep(2000);
		driver.quit();
	}

}
