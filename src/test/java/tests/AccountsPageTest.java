package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automazing.constants.AppConstants;

import base.BaseTest;

public class AccountsPageTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}
	
	@Test
	public void accPageTitleTest() {
        String actTitle = accPage.getAccountsPageTitle();
		Assert.assertEquals(actTitle, AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
	}

	@Test
	public void accPageURLTest() {
        String actURL = accPage.getAccountPageURL();
		Assert.assertTrue(actURL.contains(AppConstants.ACCOUNTS_PAGE_URL_FRACTION_VALUE));
	}
	
	@Test
	public void accPageItemsCountTest() {
        List<String> actualAccountItemsList = accPage.getAccountItemsList();
		System.out.println("Acc Page Items List: " + actualAccountItemsList);
		Assert.assertEquals(actualAccountItemsList.size(), AppConstants.ACCOUNTS_PAGE_ITEMS_COUNT);
	}
	
	@Test
	public void accPageItemsValueTest() {
        List<String> actualAccountItemsList = accPage.getAccountItemsList();
		System.out.println("Actual Acc Page Headers List: " + actualAccountItemsList);
		Assert.assertEquals(actualAccountItemsList, AppConstants.EXPECTED_ACCOUNTS_PAGE_ITEMS_LIST);
	}
	
	@Test
	public void naviagteToHomePageTest() {
		accPage.goToHomePage();
	}

}
