package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getFirstName() {
		return driver.findElement(By.id("input-firstname"));
	}
	
	public WebElement getLastName() {
		return driver.findElement(By.id("input-lastname"));
	}
	
	public WebElement getEmail() {
		return driver.findElement(By.id("input-email"));
	}
	
	public WebElement getTelephone() {
		return driver.findElement(By.id("input-telephone"));
	}
	
	public WebElement getPwd() {
		return driver.findElement(By.xpath("//input[@placeholder='Password']"));
	}
	
	public WebElement getConfirmPwd() {
		return driver.findElement(By.xpath("//input[@placeholder='Password Confirm']"));
	}
	
	public WebElement clickPrivacy() {
		return driver.findElement(By.xpath("//input[@name='agree']"));
	}
	
	public WebElement clickContinue() {
		return driver.findElement(By.xpath("//input[@value='Continue']"));
	}

	public WebElement getConfirmationTxt() {
		return driver.findElement(By.xpath("//*[@id='content']/h1"));
	}
	
}
