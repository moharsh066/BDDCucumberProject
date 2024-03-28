package factory;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;



public class DriverFactory {

	private static WebDriver driver = null;
	
	public enum BrowserType {
		CHROME, 
		FIREFOX, 
		EDGE, 
		SAFARI
	}
	public static WebDriver initializeBrowser(String browserName) throws Exception, IOException {
		BrowserType browserType = BrowserType.valueOf(browserName.toUpperCase());

		switch (browserType) {
		case CHROME:
			initializeChrome();
			break;
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case EDGE:
			initEdgeDriver();
			break;
		case SAFARI:
			driver = new SafariDriver();
			break;
		default:
			throw new IllegalArgumentException("Browser Type Not Supported");
		}
		return driver;
	}
	
	private static void initializeChrome() {
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--ignore-ssl-errors=yes","--ignore-certificate-errors");
		driver = new ChromeDriver(options);
	}
	
	private static void initEdgeDriver() {
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--ignore-ssl-errors=yes","--ignore-certificate-errors");
		driver = new EdgeDriver(options);
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
}
