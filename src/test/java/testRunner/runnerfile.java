package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "C:\\Users\\arshe\\eclipse-workspace\\ui.automation.cucumber2\\src\\test\\java\\feature\\Register.feature",
		glue = {"stepDefinitions","hooks"},
       	 tags = "@SmokeTest",
		publish=true,
		monochrome = true,
		plugin={"pretty","html:target/CucumberReports/CucumberReport.html",
		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
       
public class runnerfile extends AbstractTestNGCucumberTests {

}
