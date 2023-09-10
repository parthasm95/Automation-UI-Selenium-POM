package com.automazing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automazing.constants.AppConstants;
import com.automazing.utils.ElementUtil;

public class ProductInfoPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	// By Locators
	private By productHeader = By.cssSelector("h1[itemprop='name']");
	private By productImages = By.cssSelector("#thumbs_list_frame img");
	//Page Constructor
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	//Page Actions
	public String getProductHeaderValue() {
		String productHeaderValue = eleUtil.doElementGetText(productHeader);
		System.out.println("Product Header Value is : "+ productHeaderValue);
		return productHeaderValue;
	}
	
	public int getProductImagesCount() {
		int imagesCount = eleUtil.waitForElementsVisible(productImages, AppConstants.DEFAULT_MEDIUM_TIME_OUT).size();
		System.out.println("Product Images Count is : "+ imagesCount);
		return imagesCount;
		
	}

}
