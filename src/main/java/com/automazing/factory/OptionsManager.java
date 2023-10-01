package com.automazing.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;
	
	public OptionsManager(Properties prop) {
		this.prop = prop;
	}
	
	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		if (Boolean.parseBoolean(prop.getProperty("remote"))) {
			co.setBrowserVersion(prop.getProperty("browserversion"));
			co.setCapability("browserName", "chrome");
			//co.setCapability("enableVNC", true);
			//co.setCapability("name", prop.getProperty("testcasename"));
		}
		
		if(Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			System.out.println("-----Running Chrome on Headless Mode-----");
			co.addArguments("--headless");
		}
		
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) {
			System.out.println("-----Running Chrome on incognito Mode-----");
			co.addArguments("--incognito");
		}
			
		return co;
	}
	
	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("remote"))) {
			fo.setCapability("browserName", "firefox");
			fo.setBrowserVersion(prop.getProperty("browserversion").trim());

			//fo.setCapability("enableVNC", true);
		}
		if(Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			System.out.println("-----Running Firefox on Headless Mode-----");
			fo.addArguments("--headless");
		}
		
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) {
			System.out.println("-----Running Firefox on incognito Mode-----");
			fo.addArguments("--incognito");
		}
			
		return fo;
	}
	
	public EdgeOptions getEdgeOptions() {
		eo = new EdgeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			System.out.println("-----Running Edge on Headless Mode-----");
			eo.addArguments("--headless");
		}
		
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) {
			System.out.println("-----Running Edge on incognito Mode-----");
			eo.addArguments("--incognito");
		}
			
		return eo;
	}
	

}
