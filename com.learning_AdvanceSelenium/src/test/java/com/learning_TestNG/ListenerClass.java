package com.learning_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.generic_Library.Base_Test_2;

@Listeners(com.generic_Library.Listener_Implementation.class)
public class ListenerClass extends Base_Test_2 {

	@Test
	public void searchTest() throws InterruptedException{
			Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/");
			driver.findElement(By.name("q")).sendKeys("mobile", Keys.ENTER);
			Thread.sleep(2000);
			driver.quit();
	}
	
}
