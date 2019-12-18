package browser_manager;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriverManager extends DriverManager {

	@Override
	public void createDriver() {

		System.setProperty("webdriver.ie.driver", "./src/test/resources/iedriver/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	}
}
