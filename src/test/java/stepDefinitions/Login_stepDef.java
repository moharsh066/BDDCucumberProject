package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;
import pages.LoginPage;
import utils.CommonUtils;
import utils.ElementUtils;

public class Login_stepDef {
	
	public static WebDriver driver;
	
		private CommonUtils commonUtils; // for waits
		private CommonPage commonPage;
		private LoginPage login_Page;
		
		public Login_stepDef() {
			driver = DriverFactory.getDriver();
			commonUtils = new CommonUtils(driver);
			login_Page = new LoginPage(driver);	
		}

		@Given("User navigates to login page")
		public void user_navigates_to_login_page() {
		   login_Page.clickOnMyAccount();
		   login_Page.selectLoginOption();
		}
		@When("User enters valid email address {string} into email field")
		public void user_enters_valid_email_address_into_email_field(String emailText) {
		   login_Page.enterEmailAddress(emailText);
		}
		
		//  \"([^\"]*)\"
		@When("User enters valid password {string} into password field")
		public void user_enters_valid_password_into_password_field(String passwordText) {
		   login_Page.enterPassword(passwordText);
		}
		@When("User clicks on Login button")
		public void user_clicks_on_login_button() throws InterruptedException {
		   login_Page.clickOnLoginButton();
		   Thread.sleep(3000);
		}
		@Then("User should get successfully logged in")
		public void user_should_get_successfully_logged_in() {
			Assert.assertTrue(commonUtils.isElementDisplayed(login_Page.editYourAccountInformationOption));
		}
		
		
		
		@When("User enters invalid email address into email field")      
		public void user_enters_invalid_email_address_into_email_field() {
		   login_Page.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
		}
		@When("User enters invalid password {string} into password field")
		public void user_enters_invalid_password_into_password_field(String invalidPassword) {
		   login_Page.enterPassword(invalidPassword);
		}
		@Then("User should see this warning message {string} regarding about credentials mismatch")
		public void user_should_see_this_warning_message_regarding_about_credentials_mismatch(String text) {
		Assert.assertTrue(login_Page.getWarningMessageText(text));
		}
		
		@When("User dont enter email address into email field")
		public void user_dont_enter_email_address_into_email_field() {
			login_Page.enterEmailAddress("");
		}
		@When("User dont enter password into password field")
		public void user_dont_enter_password_into_password_field() {
			login_Page.enterPassword("");
		}
}
