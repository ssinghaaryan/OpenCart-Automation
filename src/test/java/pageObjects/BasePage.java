package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver; // Putting the driver instance getting from the class using the BasePage and putting it into this class driver.
		PageFactory.initElements(driver, this);
	}
	
}
