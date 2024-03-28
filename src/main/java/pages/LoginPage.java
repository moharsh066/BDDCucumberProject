package pages;

import javax.lang.model.element.Element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	private final int explicitWaitTime;
	
	public LoginPage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
		this.explicitWaitTime =CommonUtils.EXPLICIT_WAIT_BASIC_TIM;
	}
	
	@FindBy(xpath = "//span[text()='My Account']")
	public WebElement myAccountDropMenu;
	
	@FindBy(linkText = "Login")
	public WebElement loginOption;
	
	@FindBy(linkText = "Register")
	public WebElement registerOption;
	
	@FindBy(name = "search")
	public WebElement searchBoxField;
	
	@FindBy(xpath = "//button[contains(@class,'btn-default')]")
	public WebElement searchButton;
	
	// LOGIN Module Xpath
	@FindBy(id = "input-email")
	public WebElement emailField;
	
	@FindBy(id = "input-password")
	public WebElement passwordField;
	
	@FindBy(xpath = "//input[@value='Login']")
	public WebElement loginButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	public WebElement warningMessage;
	
	// for VALIDATE the login 
	@FindBy(linkText = "Edit your account information")
	public WebElement editYourAccountInformationOption;
	
	
	
	public void clickOnMyAccount() {
		elementUtils.clickOnElement(myAccountDropMenu, explicitWaitTime);
	}
	
	public void selectLoginOption() {
		elementUtils.clickOnElement(loginOption, explicitWaitTime);
	}
	
	public void selectRegisterOption() {
		elementUtils.clickOnElement(registerOption, explicitWaitTime);
	}
	
	public void clickOnSearchButton() {
		elementUtils.clickOnElement(searchButton, explicitWaitTime);
	}
	
	public void enterProductIntoSearchBox(String productText) {
		elementUtils.typeTextIntoElement(searchBoxField, productText, CommonUtils.EXPLICIT_WAIT_BASIC_TIM);
	}
	
	// LOGIN Module Methods
	public void enterEmailAddress(String emailText) {
		elementUtils.typeTextIntoElement(emailField, emailText, explicitWaitTime);
	}

	public void enterPassword(String passwordText) {
		elementUtils.typeTextIntoElement(passwordField, passwordText, explicitWaitTime);
	}

	public void clickOnLoginButton() {
		elementUtils.clickOnElement(loginButton, explicitWaitTime);
	}

	public boolean getWarningMessageText(String text) {
		return elementUtils.displayStatusOfText(warningMessage, text, explicitWaitTime);
	}
	
	
	
	
	
	
	
}



