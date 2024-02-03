package com.learning_TestNG;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Learning_Data_Provider {
	
	@Test(dataProvider = "productData")
	public void searchData(String DATA) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop", "I am validating Title of the Web Page");
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("nikhil26@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("nikhil123");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		driver.findElement(By.id("small-searchterms")).sendKeys(DATA, Keys.ENTER);
		Thread.sleep(2000);
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/search?q="+DATA, "I am validating Title having Product Name");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./src/test/resources/screenshots/"+DATA+".png");
		try {
			FileHandler.copy(src, dest);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		driver.close();
	}
	
	
	@DataProvider(name="productData")
	public Object[][] productData(){
		
		Object[][] data = new Object[4][1]; 

		data[0][0] = "mobile";
		data[1][0] = "jacket";
		data[2][0] = "jeans";
		data[3][0] = "trousers";
//		data[4][0] = "pant";
//		data[5][0] = "shoes";
//		data[6][0] = "shirt";
//		data[7][0] = "T-shirt";
//		data[8][0] = "laptop";
//		data[9][0] = "macbook";
//		data[10][0] = "charger";
//		data[11][0] = "iphone";
//		data[12][0] = "printer";
//		data[13][0] = "bike";
//		data[14][0] = "car";
//		data[15][0] = "deo";
//		data[16][0] = "cable";
//		data[17][0] = "pendrive";
//		data[18][0] = "books";
//		data[19][0] = "bottle";
//		data[20][0] = "pen";
		
		return data;
		
	}
}
