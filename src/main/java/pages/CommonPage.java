package pages;

import java.time.LocalDate;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class CommonPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	private final int explicitWaitTime;

	public CommonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
		this.explicitWaitTime = CommonUtils.EXPLICIT_WAIT_BASIC_TIM;
	}
	
	public String getEmailWithTimeStamp() {
		Date date = new Date();
		return "arshad" + date.toString().replace(" ", "_").replace(":", "_") + "@gmail.com";
	}
	
	//Call this clickDynamicCurrentCalendarDay on Page class. 
//	public void ClickDayInCalendar() {
//		ElementUtils.clickOnElement(clickCurrentCalendarDay(), explicitWaitTime);
//	}
	public WebElement clickDynamicCurrentCalendarDay() {
		LocalDate currentDate = LocalDate.now();
		int day = currentDate.getDayOfMonth();
		String dayString = Integer.toString(day);
		String dynamicXPath = "//a[normalize-space()='" + dayString + "']";
		return driver.findElement(By.xpath(dynamicXPath));
	}
	
	//Call this clickDynamicData on Page class. 
//	public void ClickData(String text) {
//		ElementUtils.clickOnElement(clickDynamicData(text), explicitWaitTime);
//	}
	public WebElement clickDynamicData(String text) {
		String dynamicXPathData = "//input[@id='cbSelect"+text+"']";
		return driver.findElement(By.xpath(dynamicXPathData));
	}

}
