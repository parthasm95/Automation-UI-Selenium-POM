package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automazing.constants.AppConstants;

import base.BaseTest;

public class SearchPageTest extends BaseTest{
	@BeforeClass
	public void accPageSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		homePage = accPage.goToHomePage();
		searchPage = homePage.performSearch("Dress");
	}
	
	@Test
	public void searchPageTitleTest() {
		String actTitle = searchPage.getSearchPageTitle();
		Assert.assertEquals(actTitle, AppConstants.SEARCH_PAGE_TITLE_VALUE);
	}
	
}
