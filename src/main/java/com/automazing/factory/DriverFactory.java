package com.automazing.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.automazing.exception.FrameworkException;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;

	public static String highlight;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	/**
	 * this method is initializing the driver on the basis of given browser name
	 * 
	 * @param browserName
	 * @return this returns the driver
	 */
	public WebDriver initDriver(Properties prop) {

		optionsManager = new OptionsManager(prop);
		highlight = prop.getProperty("highlight").trim();
		String browserName = prop.getProperty("browser").toLowerCase().trim();

		System.out.println("browser name is : " + browserName);

		// chrome:
		if (browserName.equalsIgnoreCase("chrome")) {
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}

		// firefox:
		else if (browserName.equalsIgnoreCase("firefox")) {
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		}

		// edge:
		else if (browserName.equalsIgnoreCase("edge")) {
			tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
		}

		// safari:
		else if (browserName.equalsIgnoreCase("safari")) {
			tlDriver.set(new SafariDriver());
		}

		else {
			System.out.println("plz pass the right browser name...." + browserName);
			throw new FrameworkException("NO BROWSER FOUND EXCEPTION...");
			
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url").trim());

		return getDriver();

	}

	/*
	 * get the local thread copy of the driver
	 */
	public synchronized static WebDriver getDriver() {
		return tlDriver.get();
	}

	/**
	 * this method is reading the properties from the .properties file
	 * 
	 * @return
	 * @throws FileNotFoundException
	 */
	public Properties initProp() {

		// mvn clean install -Denv="qa"
		// mvn clean install
		prop = new Properties();
		FileInputStream ip = null;
		String envName = System.getProperty("env");
		System.out.println("Running test cases on Env: " + envName);

		try {
			if (envName == null) {
				System.out.println("no env is passed....Running tests on QA env...");
				ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
			} else {
				switch (envName.toLowerCase().trim()) {
				case "qa":
					ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
					break;
				case "stage":
					ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
					break;
				case "dev":
					ip = new FileInputStream("./src/test/resources/config/dev.config.properties");
					break;
				case "prod":
					ip = new FileInputStream("./src/test/resources/config/config.properties");
					break;

				default:
					System.out.println("....Wrong env is passed....No need to run the test cases....");
				    throw new FrameworkException("WRONG ENVIRONMENT EXCEPTION...");
				}

			}
		} catch (FileNotFoundException e) {

		}

		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	/**
	 * take screenshot
	 */
	public static String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtil.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
