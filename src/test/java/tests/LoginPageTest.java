package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class LoginPageTest extends BaseTest{
	
	@Test
	public void loginPageTitleTest() {
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, "Login - My Shop");
	}
	
	@Test
	public void loginPageURLTest() {
        String actualURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actualURL.contains("back=my-account"));
	}
	
	@Test
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Test
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}

}
