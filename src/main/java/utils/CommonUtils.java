package utils;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonUtils {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	public static final long IMPLICIT_WAIT_TIM = 30;
	public static final long PAGE_LOAD_TIM = 30;
	public static final int EXPLICIT_WAIT_BASIC_TIM = 30;
	
	public CommonUtils(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public boolean isElementDisplayed(WebElement element) {
		return  elementUtils.displayStatusOfElement(element, EXPLICIT_WAIT_BASIC_TIM);
	}

	public String getEmailWithTimeStamp() {
		Date date = new Date();
		return "arshad" + date.toString().replace(" ", "_").replace(":", "_") + "@gmail.com";
	}

}
