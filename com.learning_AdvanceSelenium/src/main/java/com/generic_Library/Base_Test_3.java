package com.generic_Library;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.sun.org.apache.bcel.internal.classfile.Method;

public class Base_Test_3 {
	
	public ExtentReports reports;
	public ExtentTest test;
	
	public static WebDriver sDriver;
	public WebDriver driver;
	
	@BeforeSuite
	public void configureReport() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./src/test/resources/reports/"+Java_Utility.getName()+".html");
		reports = new ExtentReports();
		reports.attachReporter(spark);
	}
	
	@BeforeClass(alwaysRun=true)
	public void openBrowser(){
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		sDriver=driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public void loginToDWS(Method method){
		test = reports.createTest(method.getName());
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("nikhil26@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("nikhil123");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	
	@AfterSuite
	public void saveReport() {
		reports.flush();
	}
 }
