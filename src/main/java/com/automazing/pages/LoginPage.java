package com.automazing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automazing.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// By Locators
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signInBtn = By.id("SubmitLogin");
	private By forgotPasswordLink = By.linkText("Forgot your password?");

	// Page Class Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	//Page Actions
	public String getLoginPageTitle() {		
		String title = eleUtil.waitForTitleIsAndFetch(5,"Login - My Shop");
		System.out.println("Login page title: " + title);
		return title;
	}
	
	public String getLoginPageURL() {
		String url = eleUtil.waitForURLContainsAndFetch(5,"back=my-account" );
		System.out.println("Login page url: " + url);
		return url;
	}
	
	public boolean isForgotPwdLinkExist() {
		return eleUtil.waitForElementVisible(forgotPasswordLink, 5).isDisplayed();
	}
	
	public void doLogin(String un, String pwd) {
		System.out.println("App creds are : " + un + ":" + pwd);
		eleUtil.waitForElementVisible(emailId, 5).sendKeys(un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(signInBtn);
	}

}
