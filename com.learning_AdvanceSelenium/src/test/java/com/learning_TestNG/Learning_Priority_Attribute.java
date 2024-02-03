package com.learning_TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Learning_Priority_Attribute {

	@Test(priority=0) //acts like main method
	public void registerTest(){ //acts like test case
		Reporter.log("Executing Register Test Case....", true); //steps of the test case
	}
	
	@Test(priority=1) //acts like main method
	public void loginTest(){ //acts like test case
		Reporter.log("Executing Login Test Case....", true); //steps of the test case
	}
	
	@Test(priority=-1) //acts like main method
	public void searchTest(){ //acts like test case
		Reporter.log("Executing Search Test Case....", true); //steps of the test case
	}
}
