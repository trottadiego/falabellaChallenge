package seleniumgluecode;

import org.openqa.selenium.WebDriver;


import browser_manager.DriverManager;
import browser_manager.DriverManagerFactory;
import browser_manager.DriverType;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	private static WebDriver driver;
	private DriverManager driverManager;
	
	@Before 
	public void setUp() {
		
		driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
		driver = driverManager.getDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
	}
	
	@After
	public void taerDown() {
		//driverManager.quitDriver();
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

}
