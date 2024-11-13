package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablePage {

	WebDriver driver;

	public WebTablePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "simpletable")
	public WebElement nameTable;

	WebElement table = nameTable;

	
 
	public void header_webtable() throws InterruptedException {
		List<WebElement> headers = table.findElements(By.tagName("th"));
		for (WebElement header : headers) {
			String text = header.getText();
			System.out.println(text);
		}
		List<WebElement> allrows = table.findElements(By.xpath("//table[@id='simpletable']/tbody/tr"));
		int size = allrows.size();
	//	System.out.println("Rows size: " + size);
		if (size == 3) {
			System.out.println("Pass");
		} else
			System.out.println("fail");
		for (int i = 0; i < size; i++) {
			List<WebElement> rows = allrows.get(i).findElements(By.tagName("td"));
			WebElement lastname = rows.get(1);
			String text = lastname.getText();
			if (text.equalsIgnoreCase("Raj")) {
				WebElement input = rows.get(3).findElement(By.tagName("input"));
				input.click();
				break;
			}
			
		}
		Thread.sleep(3000);
	}
	

}
