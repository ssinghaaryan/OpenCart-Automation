package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver); // This sends the driver to the parent(BasePage) class to initate the PageFactory.
	}
	
	public WebElement emailInput() {
		return driver.findElement(By.xpath("//input[@id='input-email']"));
	}
	
	public WebElement pwdInput() {
		return driver.findElement(By.xpath("//input[@id='input-password']"));
	}
	
	public WebElement loginBtn() {
		return driver.findElement(By.xpath("//input[@value='Login']"));
	}
	
	public By getConfirmationText() {
		return By.xpath("//div[@id='content']/h2");
	}

}
