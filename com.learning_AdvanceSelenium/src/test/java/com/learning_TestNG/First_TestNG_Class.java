package com.learning_TestNG;

import org.testng.annotations.Test;
import org.testng.Reporter;

public class First_TestNG_Class {
	
	@Test //acts like main method
	public void registerTest(){ //acts like test case
		Reporter.log("Executing Register Test Case....", true); //steps of the test case
	}
	
	@Test //acts like main method
	public void loginTest(){ //acts like test case
		Reporter.log("Executing Login Test Case....", true); //steps of the test case
	}
	
	@Test //acts like main method
	public void searchTest(){ //acts like test case
		Reporter.log("Executing Search Test Case....", true); //steps of the test case
	}
}
