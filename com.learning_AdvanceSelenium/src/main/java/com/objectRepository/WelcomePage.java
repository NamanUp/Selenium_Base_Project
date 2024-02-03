package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	
	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[@class='ico-login']")
	private WebElement loginLink;
	
	@FindBy(linkText="small-searchterms")
	private WebElement searchTextFields;
	
	@FindBy(xpath="//input[@value='Search']")
	private WebElement searchButton;

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getSearchTextFields() {
		return searchTextFields;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
}
