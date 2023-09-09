package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automazing.constants.AppConstants;

import base.BaseTest;

public class HomePageTest extends BaseTest {
	
	@BeforeClass
	public void accPageSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		homePage = accPage.goToHomePage();
	}
	
	@Test
	public void homePageTitleTest() {
		String actTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actTitle, AppConstants.HOME_PAGE_TITLE_VALUE);
	}
	
	@Test
	public void homePageNavBarItemsTest() {
		List<String> actualHomePageNavBarItemsList = homePage.getHomePageNavBarItems();
		System.out.println("Actual Home Page Navigation Bar Items List: " + actualHomePageNavBarItemsList);
		Assert.assertEquals(actualHomePageNavBarItemsList, AppConstants.EXPECTED_HOME_PAGE_NAV_ITEMS_LIST);
	}
	
	@Test
	public void homePageCategoryItemsTest() {
		List<String> actualHomePageCategoryList = homePage.getHomePageCategoryList();
		System.out.println("Actual Home Page Category List: " + actualHomePageCategoryList);
		Assert.assertEquals(actualHomePageCategoryList, AppConstants.EXPECTED_HOME_PAGE_CTGR_ITEMS_LIST);
	}
	
	@DataProvider
	public Object[][] getProductData(){
		return new Object[][] {
			{"dress"},
			{"summer"},
			{"short sleeve"}
		};
	}
	
	
	@Test(dataProvider = "getProductData")
	public void searchProductCountTest(String SearchItemName) {
		searchPage = homePage.performSearch(SearchItemName);
		Assert.assertTrue(searchPage.getSearchProductsCount() > 0);
	}
	
	@Test
	public void searchProductTest() {
		
	}

}
