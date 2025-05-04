package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	//Step 1. Initializing the constructor
	// Will receive this driver from the TC.
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement myAccountBtn() {
		return driver.findElement(By.xpath("//a[@title='My Account']"));
	}

	public WebElement registerBtn() {
		return driver.findElement(By.xpath("//a[text()='Register']"));
	}
	
	public WebElement loginBtn() {
		return driver.findElement(By.xpath("//a[text()='Login']"));
	}
	
	public WebElement searchInput() {
		return driver.findElement(By.xpath("//input[@placeholder='Search']"));
	}
	
	public WebElement searchBtn() {
		return driver.findElement(By.xpath("//button[contains(@class, 'btn-default')]"));
	}
	
}
