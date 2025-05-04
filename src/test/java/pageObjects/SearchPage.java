package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage {
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement searchResultTxt() {
		return driver.findElement(By.xpath("//div[@id='content']/h1"));
	}
	
	
	public WebElement searchResultCount() {
		return driver.findElement(By.xpath("//div[contains(@class, 'text-right')]"));
	}
	
}
