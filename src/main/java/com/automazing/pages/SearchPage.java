package com.automazing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automazing.constants.AppConstants;
import com.automazing.utils.ElementUtil;

public class SearchPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	// By Locators
	By searchItems = By.xpath("//div[@class='product-image-container']");
	

	// Page Class Constructor
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	// Page Actions
	public String getSearchPageTitle() {
		String title = eleUtil.waitForTitleIsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT,AppConstants.SEARCH_PAGE_TITLE_VALUE);
		System.out.println("Search page title: " + title);
		return title;
	}
	
	public int getSearchProductsCount() {
		int searchProductCount =  eleUtil.waitForElementsVisible(searchItems, AppConstants.DEFAULT_MEDIUM_TIME_OUT).size();
		System.out.println("Searched Produts Count: "+searchProductCount);
		return searchProductCount;
	}
	
	public ProductInfoPage selectProduct(String productName) {
		By productLocator = By.partialLinkText(productName);
		eleUtil.waitForElementVisible(productLocator, AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
		return new ProductInfoPage(driver);
	}

}
