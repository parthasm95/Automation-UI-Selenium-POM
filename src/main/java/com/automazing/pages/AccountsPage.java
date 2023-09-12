package com.automazing.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automazing.constants.AppConstants;
import com.automazing.utils.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	// By Locators
	private By accountItems = By.cssSelector("div#center_column span");
	private By homePageIcon = By.cssSelector(".icon-home");
	private By createAccSuccessMsg = By.cssSelector("p.alert.alert-success");
	private By signOutLink = By.xpath("//a[@title='Log me out']");
	
	//Page Class Constructor
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	//Page Actions
		public String getAccountsPageTitle() {
			String title = eleUtil.waitForTitleIsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT,AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
			System.out.println("Login page title: " + title);
			return title;
		}
		
		public String getAccountPageURL() {
			String url = eleUtil.waitForURLContainsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT,AppConstants.ACCOUNTS_PAGE_URL_FRACTION_VALUE);
			System.out.println("Account page url: " + url);
			return url;
		}
		
		public int getAccountItemsCount() {
			eleUtil.waitForElementsVisible(accountItems, AppConstants.DEFAULT_SHORT_TIME_OUT);
			return eleUtil.getTotalElementsCount(accountItems);
		}
		
		public List<String> getAccountItemsList() {
			List<String> accountsListTexts = new ArrayList<String>();
			List<WebElement> accountsHeaderList = eleUtil.getElements(accountItems);
			
			for(WebElement e : accountsHeaderList) {
				String text = e.getText();
				accountsListTexts.add(text);
				System.out.println(text);
			}
			return accountsListTexts;
		}
		
		public Boolean isHomeIconExist() {
			return eleUtil.waitForElementVisible(homePageIcon,AppConstants.DEFAULT_SHORT_TIME_OUT).isDisplayed();
		}
		
		public HomePage goToHomePage() {
			if(isHomeIconExist()) {
				eleUtil.doClick(homePageIcon);
				return new HomePage(driver);
			}
			else {
				System.out.println("Hope Page Icon does not exist...");
				return null;
			}
			
		}
		
		public String getCreateAccountSuccessMsg() {
			return eleUtil.waitForElementVisible(createAccSuccessMsg, AppConstants.DEFAULT_MEDIUM_TIME_OUT).getText();
		}
		
		public LoginPage doSignOut() {
			eleUtil.waitForElementVisible(signOutLink, AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
			return new LoginPage(driver);
		}
}
