package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automazing.constants.AppConstants;
import com.automazing.pages.AccountsPage;
import com.automazing.utils.ExcelUtil;
import com.automazing.utils.RandomGenUtil;

import base.BaseTest;

public class CreateAccountPageTest extends BaseTest{
	
	@BeforeClass
	public void createAccPageSetup() {
		createAccountPage = loginPage.goToCreateAccountPage(RandomGenUtil.getRandomEmail());
	}
	
	@DataProvider
	public Object[][] getCreateAccTestData(){
		Object[][] createAccData = ExcelUtil.getTestData(AppConstants.TEST_DATA_EXCEL_FILEPATH, AppConstants.CREATE_ACC_SHEETNAME);
		return createAccData;
	}
	
	@Test(dataProvider = "getCreateAccTestData")
	public void CreateAccountTest(String title, String firstName, String lastName, String password, 
									String dateOfBirth, String monthOfBirth, String yearOfBirth, String subscribe) {
		
		accPage = createAccountPage.doCreateAccount(title, firstName, lastName, password, dateOfBirth, monthOfBirth, yearOfBirth, subscribe);
		String actSuccessMsg = accPage.getCreateAccountSuccessMsg();
		Assert.assertEquals(actSuccessMsg, AppConstants.CREATE_ACC_SUCESS_MSG);
		loginPage = accPage.doSignOut();
		loginPage.goToCreateAccountPage(RandomGenUtil.getRandomEmail());
	}

}
