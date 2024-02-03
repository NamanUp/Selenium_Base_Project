package com.testScripts;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.generic_Library.WebDriver_Utility;

public class TC_003_RemoveFromCart_Test extends TC_002_AddToCart_Test {
	
	@Test(groups="regressionTesting")
	public void removeFromCartTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Shopping cart")).click();
		driver.findElement(By.xpath("(//a[text()='Casual Golf Belt'])[2]/ancestor::tr[@class='cart-item-row']/descendant::input[@type='checkbox']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[name='updatecart']")).click();
		WebDriver_Utility.scrollToWebElement(driver, driver.findElement(By.xpath("//h1[text()='Shopping cart']")));
		try {
			Reporter.log("Element is present...",true);
			WebDriver_Utility.takesScreenshotOfWebPage(driver, "removeshoppingCartSS");
		} catch (Exception e) {
			// TODO: handle exception
			Reporter.log("Element is not present...",true);
		}
	}
}
