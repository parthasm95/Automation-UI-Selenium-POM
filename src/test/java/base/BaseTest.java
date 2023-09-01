package base;


import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.automazing.factory.DriverFactory;
import com.automazing.pages.LoginPage;

public class BaseTest {
	
	DriverFactory df;
	WebDriver driver;
	protected Properties prop;
	
	protected LoginPage loginPage;



	@BeforeTest
	public void setup() throws FileNotFoundException {
		df = new DriverFactory();
		prop = df.initProp();

		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);

	}

}
