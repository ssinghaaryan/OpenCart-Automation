package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccount extends BasePage {
	
	public MyAccount(WebDriver driver) {
		super(driver);
	}
	
	public By successMsg() {
		return By.xpath("//div[contains(@class, 'alert-success')]");
	}
	
	public By getConfirmationText() {
		return By.xpath("//div[@id='content']/h2");
	}
	
	public By editAccountInfoBtn() {
		return By.xpath("//div[@id='content']/ul[1]/li[1]/a");
	}

}
