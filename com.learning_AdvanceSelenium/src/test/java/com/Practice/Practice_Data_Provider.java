package com.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Practice_Data_Provider extends Data_Provider_Base_Class {
	

	@Test(dataProvider = "productList")
	public void productData(String PRODUCT) throws InterruptedException {
		flipDriver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(PRODUCT, Keys.ENTER);
		Thread.sleep(2000);
		String showingProduct = flipDriver.findElement(By.xpath("//input[@value='"+PRODUCT+"']")).getText();  
		////span[@class="_10Ermr"]//span[contains(text(),'mobile')]
		
		Assert.assertEquals(PRODUCT, showingProduct);
		
		Thread.sleep(2000);
		driver.close();
	}
		
	Object[][] product =  new Object[4][1];
	@DataProvider(name="productList")
	public Object[][] productList(){
			
			Object[][] product = new Object[1][1]; 

			product[0][0] = "mobile";
//			product[1][0] = "jacket";
//			product[2][0] = "jeans";
//			product[3][0] = "trousers";
//			data[4][0] = "pant";
//			data[5][0] = "shoes";
//			data[6][0] = "shirt";
//			data[7][0] = "T-shirt";
//			data[8][0] = "laptop";
//			data[9][0] = "macbook";
//			data[10][0] = "charger";
//			data[11][0] = "iphone";
//			data[12][0] = "printer";
//			data[13][0] = "bike";
//			data[14][0] = "car";
//			data[15][0] = "deo";
//			data[16][0] = "cable";
//			data[17][0] = "pendrive";
//			data[18][0] = "books";
//			data[19][0] = "bottle";
//			data[20][0] = "pen";
			
		
			return product;
	}
}
