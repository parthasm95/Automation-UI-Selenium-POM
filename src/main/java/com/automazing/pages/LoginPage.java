package com.automazing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automazing.constants.AppConstants;
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
		String title = eleUtil.waitForTitleIsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT,AppConstants.LOGIN_PAGE_TITLE_VALUE);
		System.out.println("Login page title: " + title);
		return title;
	}
	
	public String getLoginPageURL() {
		String url = eleUtil.waitForURLContainsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT,AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE );
		System.out.println("Login page url: " + url);
		return url;
	}
	
	public boolean isForgotPwdLinkExist() {
		return eleUtil.waitForElementVisible(forgotPasswordLink, AppConstants.DEFAULT_SHORT_TIME_OUT).isDisplayed();
	}
	
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("App creds are : " + un + ":" + pwd);
		eleUtil.waitForElementVisible(emailId, 5).sendKeys(un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(signInBtn);
		return new AccountsPage(driver);
	}

}
