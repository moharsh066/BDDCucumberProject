package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class SearchPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	private final int explicitWaitTime;
	
	public SearchPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
		this.explicitWaitTime =CommonUtils.EXPLICIT_WAIT_BASIC_TIM;	
	}
	
	@FindBy(name = "search")
	public WebElement searchBoxField;
	
	@FindBy (xpath ="//button[@type ='button'] [@class ='btn btn-default btn-lg']")
	public WebElement searchButton;
	
	@FindBy (xpath ="//input[@id='button-search']/following::p[1]")
	public WebElement resultmessageText;
	
	
	public void enterValueInSeachBoxField(String productName) {
		elementUtils.clickAndTypeTextIntoElement(searchBoxField, productName, explicitWaitTime);
	}
	
	public void clickOnSearchButton() throws InterruptedException {
		elementUtils.clickOnElement(searchButton, explicitWaitTime);
		Thread.sleep(3000);
	}
	
	public String getresultMessage() {
		return elementUtils.getTextFromElement(resultmessageText, explicitWaitTime);
	}
	
	

			
			
	
}
