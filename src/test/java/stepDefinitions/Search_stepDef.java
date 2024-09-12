package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.SearchPage;
import utils.CommonUtils;

public class Search_stepDef {

	public static WebDriver driver;
	private CommonUtils commonUtils;
	private CommonPage commonPage;
	private LoginPage loginPage;
	private RegisterPage registerPage;
	private SearchPage searchPage;
	
	public Search_stepDef() {
		driver =DriverFactory.getDriver();
		commonUtils = new CommonUtils(driver);
		commonPage = new CommonPage(driver);
		loginPage = new LoginPage(driver);
		registerPage = new RegisterPage(driver);
		searchPage = new SearchPage(driver);
	}
	// 1st scenario
	@When("User enters valid product {string} into Search box field")
	public void user_enters_valid_product_into_search_box_field(String validproductName) {
	     searchPage.enterValueInSeachBoxField(validproductName);
	}
	@When("User clicks on Search button")
	public void user_clicks_on_search_button() throws InterruptedException {
		searchPage.clickOnSearchButton();
	}
	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		Assert.assertTrue(commonUtils.isElementDisplayed(searchPage.resultmessageText));
	}
	
	
	//2nd scenario
	@When("User enters invalid product {string} into Search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidproductName) {
	   searchPage.enterValueInSeachBoxField(invalidproductName);
	}
	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() throws InterruptedException {
	   Assert.assertEquals("There is no product that matches the search criteria.", searchPage.getresultMessage());
	  Thread.sleep(3000);
	}
	
	//3rd scenario
	@When("User dont enter any product name {string} into Search box field")
	public void user_dont_enter_any_product_name_into_search_box_field(String noproductName) {
	  searchPage.enterValueInSeachBoxField(noproductName);
	}
}
