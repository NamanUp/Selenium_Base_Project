package com.learning_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.generic_Library.Base_Test_3;
import com.generic_Library.WebDriver_Utility;

public class Base_Test_3_searchTest extends Base_Test_3 {
	@Test()
	public void searchTest() throws InterruptedException  {
		//All the commented lines are moved to Base_Test class
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.get("https://demowebshop.tricentis.com/");
		
//		driver.findElement(By.linkText("Log in")).click();
//		driver.findElement(By.id("Email")).sendKeys("nikhil26@gmail.com");
//		driver.findElement(By.id("Password")).sendKeys("nikhil123");
//		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		driver.findElement(By.name("q")).sendKeys("mobile", Keys.ENTER);
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		
//		driver.findElement(By.linkText("Log out")).click();
		
		Thread.sleep(2000);
		test.log(Status.PASS, "Product Searched");
		
//		WebDriver_Utility.scrollToWebElement(driver, driver.findElement(By.xpath("//h1[text()='Search']")));
//		WebDriver_Utility.takesScreenshotOfWebPage(driver, "mobileSearchSS");
//		driver.quit();
	}
}
