package com.learning_TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.generic_Library.File_Utility;

public class Learning_Excel_File_2 {

	@DataProvider(name = "searchingData")
	public Object[][] searchData() throws Throwable {
		return File_Utility.fetchMultipleDataFromExcel("searchData");
	}
	
	@Test(dataProvider = "searchingData")
	public void searchTest(String search) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys(search, Keys.ENTER);
		Thread.sleep(2000);
		driver.quit();
	}
}
