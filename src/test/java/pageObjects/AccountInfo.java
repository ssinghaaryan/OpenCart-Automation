package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountInfo extends BasePage {
	
	public AccountInfo(WebDriver driver) {
		super(driver);
	}
	
	public By firstNameInput() {
		return By.xpath("//input[@id='input-firstname']");
	}
	
	public By lastNameInput() {
		return By.xpath("//input[@id='input-lastname']");
	}
	
	public By emailInput() {
		return By.xpath("//input[@id='input-email']");
	}
	
	public By telephoneInput() {
		return By.xpath("//input[@id='input-telephone']");
	}
	
	public By continueBtn() {
		return By.xpath("//div[@class='pull-right']/input");
	}

}
