package base;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.automazing.factory.DriverFactory;
import com.automazing.pages.AccountsPage;
import com.automazing.pages.HomePage;
import com.automazing.pages.LoginPage;
import com.automazing.pages.SearchPage;

public class BaseTest {
	
	DriverFactory df;
	WebDriver driver;
	protected Properties prop;
	
	protected LoginPage loginPage;
	protected AccountsPage accPage;
	protected HomePage homePage;
	protected SearchPage searchPage;



	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.initProp();

		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);

	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}