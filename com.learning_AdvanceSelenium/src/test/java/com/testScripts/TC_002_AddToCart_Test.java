package com.testScripts;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.generic_Library.Base_Test;
import com.generic_Library.WebDriver_Utility;

public class TC_002_AddToCart_Test extends Base_Test {
	
	@Test(groups="regressionTesting")
	public void addToCartTest() throws InterruptedException{
		
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("//ul[@class='top-menu']//a[@href='/computers']"))).perform();
//		Thread.sleep(1000);
//		action.moveToElement(driver.findElement(By.xpath("//ul[@class='top-menu']//li//ul[contains(@class,'sublist')]//li//a[@href='/desktops']"))).perform();
//		action.click().perform();
		
		driver.findElement(By.partialLinkText("APPAREL & SHOES")).click();
		driver.findElement(By.xpath("//a[text()='Casual Golf Belt']/ancestor::div[@class='details']/descendant::input")).click();
		driver.findElement(By.partialLinkText("Shopping cart")).click();
		WebDriver_Utility.scrollToWebElement(driver, driver.findElement(By.xpath("//h1[text()='Shopping cart']")));
		
		try {
			Reporter.log("Element is present...",true);
			WebDriver_Utility.takesScreenshotOfWebPage(driver, "shoppingCartSS");
		} catch (Exception e) {
			// TODO: handle exception
			Reporter.log("Element is not present...",true);
		}
		Thread.sleep(2000);
	}
}
