package stepDefinitions;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WebTablePage;

public class WebTable_stepDef {
	WebDriver driver;
	WebTablePage webPage;

	public WebTable_stepDef() {
		driver = DriverFactory.getDriver();
		webPage = new WebTablePage(driver);
	}

	@Given("User navigates to webtable page")
	public void user_navigates_to_webtable_page() throws InterruptedException {
		webPage.header_webtable();
	
	}

	@When("User search for Raj in Lastname column")
	public void user_search_for_raj_in_lastname_column() {

	}

	@Then("User mark as present")
	public void user_mark_as_present() {

	}

}
