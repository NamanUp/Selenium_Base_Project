package com.learning_TestNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.generic_Library.WebDriver_Utility;
import com.objectRepository.LoginPage;
import com.objectRepository.WelcomePage;

public class Learning_Extent_Report {
	
@Test
public void loginTest() throws InterruptedException {
	
	ExtentSparkReporter spark = new ExtentSparkReporter("./src/test/resources/reports/FirstReport.html");
	ExtentReports reports = new ExtentReports();
	reports.attachReporter(spark);
	ExtentTest test = reports.createTest("loginTest");
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://demowebshop.tricentis.com/");

	test.addScreenCaptureFromBase64String(WebDriver_Utility.getScreenshotPath(driver));
	
	test.log(Status.INFO, "Opened url");
	
	try {
//		Assert.assertEquals(driver.getTitle(), "DWS");
		test.log(Status.INFO, "Demo Web Shop opened...");
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		test.log(Status.INFO, "Login Page opened...");
		LoginPage lp = new LoginPage(driver);
		lp.getEmailTextField().sendKeys("nikhil26@gmail.com");
		driver.navigate().refresh();
		lp.getEmailTextField().sendKeys("nikhil26@gmail.com");
		lp.getPasswordTextField().sendKeys("nikhil123");
		lp.getLoginButton().click();
		test.log(Status.INFO, "Demo Web Shop opened...");
		Thread.sleep(2000);
			
	} catch(Throwable e) {
		test.log(Status.FAIL, "fail....");
		test.addScreenCaptureFromBase64String(WebDriver_Utility.getScreenshotPath(driver));
	}
	test.addScreenCaptureFromBase64String(WebDriver_Utility.getScreenshotPath(driver));
	driver.quit();
	reports.flush();
}
}
