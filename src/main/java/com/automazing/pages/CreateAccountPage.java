package com.automazing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automazing.constants.AppConstants;
import com.automazing.utils.ElementUtil;

public class CreateAccountPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	// By Locators
	private By titleMr = By.id("uniform-id_gender1");
	private By titleMrs = By.id("uniform-id_gender2");
	private By firstNameTxt = By.id("customer_firstname");
	private By lastNameTxt = By.id("customer_lastname");
	private By passwordTxt = By.id("passwd");
	
	private By dateOfBirthDD = By.id("days");
	private By monthOfBirthDD = By.id("months");
	private By yearOfBirthDD = By.id("years");
	
	private By newsLetterChkBox = By.id("newsletter");
	private By registerBtn = By.id("submitAccount");

	
	//Page Class Constructor
	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	//Page Actions
	public AccountsPage doCreateAccount(String title, String firstName, String lastName, String password, 
							  String date, String month, String year, String subscribe) {
		
		if(title.trim().equalsIgnoreCase("mr")) 
			eleUtil.waitForElementVisible(titleMr, AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
		else if(title.trim().equalsIgnoreCase("mrs")) 
			eleUtil.waitForElementVisible(titleMrs, AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
		
		eleUtil.doSendKeys(firstNameTxt, firstName);
		eleUtil.doSendKeys(lastNameTxt, lastName);
		eleUtil.doSendKeys(passwordTxt, password);
		
		eleUtil.doSelectDropDownByValue(dateOfBirthDD, date);
		eleUtil.doSelectDropDownByValue(monthOfBirthDD, month);
		eleUtil.doSelectDropDownByValue(yearOfBirthDD, year);
		
		if(subscribe.equalsIgnoreCase("yes")) eleUtil.doClick(newsLetterChkBox);
		eleUtil.doClick(registerBtn);
		
		return new AccountsPage(driver);
	}

}
