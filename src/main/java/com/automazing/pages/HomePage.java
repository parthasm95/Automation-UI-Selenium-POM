package com.automazing.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automazing.constants.AppConstants;
import com.automazing.utils.ElementUtil;

public class HomePage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// By Locators
	private By navBarItems = By.xpath("//div[@class='nav']//div[@class='row']//div//a");
	private By searchBar = By.id("search_query_top");
	private By searchButton = By.xpath("//button[@name='submit_search']");
	private By categoryLinks = By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a");

	// Page Class Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// Page Actions
	public String getHomePageTitle() {
		String title = eleUtil.waitForTitleIsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT,AppConstants.HOME_PAGE_TITLE_VALUE);
		System.out.println("Home page title: " + title);
		return title;
	}
	
	public List<String> getHomePageNavBarItems(){
		List<String> navItems = new ArrayList<>();
		List<WebElement> links = eleUtil.getElements(navBarItems);
		for(WebElement e : links) {
			navItems.add(e.getText());
		}
		return navItems;
	}
	
	
	public List<String> getHomePageCategoryList(){
		List<String> catList = new ArrayList<>();
		List<WebElement> catLinks = eleUtil.getElements(categoryLinks);
		for(WebElement e : catLinks) {
			catList.add(e.getText());
		}
		return catList;
	}
	
	public Boolean isSearchBarExist() {
		return eleUtil.waitForElementVisible(searchBar,AppConstants.DEFAULT_SHORT_TIME_OUT).isDisplayed();
	}
	
	public SearchPage performSearch(String seachtext) {
		if(isSearchBarExist()) {
			eleUtil.doSendKeys(searchBar, seachtext);
			eleUtil.doClick(searchButton);
			return new SearchPage(driver);
		}
		else {
			System.out.println("Searchbar does not esixt...");
			return null;
		}
	}

}
