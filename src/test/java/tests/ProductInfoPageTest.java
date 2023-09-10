package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class ProductInfoPageTest extends BaseTest{
	
	@BeforeClass
	public void productInfoPageSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		homePage = accPage.goToHomePage();
	}
	
	@DataProvider
	public Object[][] getProductImagesTestData(){
		return new Object[][] {
			{"dress", "Printed Dress", 2},
			{"dress", "Printed Summer Dress", 4},
			{"dress", "Printed Dress", 2},
			{"summer", "Printed Chiffon Dress", 4},
			{"short sleeve", "Faded Short Sleeve T-shirts", 4},
		};
	}
	
	@Test(dataProvider = "getProductImagesTestData")
	public void productImagesCountTest(String SearchItemName, String productName, int productImageCount) {
		searchPage = homePage.performSearch(SearchItemName);
		productInfoPage = searchPage.selectProduct(productName);
		int actImagesCount = productInfoPage.getProductImagesCount();
		Assert.assertEquals(actImagesCount, productImageCount);
		
	}

}
