package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.BasePage;

public class Cart extends BasePage {
	
	public Cart(WebDriver driver) {
		super(driver);
	}
	
	public List<WebElement> tableHeaders() {
		return driver.findElements(By.xpath("//div[@class='table-responsive']/table/thead/tr/td"));
	}
	
	public WebElement productNameCart() {
		//Not the most optamized xpath. But had to for now, as there was a hidden duplicate present.
		return driver.findElement(By.xpath("//div[@id='content']/form/div/table/tbody/tr/td[2]/a"));
	}
	
	public WebElement productPriceCart() {
		//Not the most optamized xpath. But had to for now, as there was a hidden duplicate present.
		return driver.findElement(By.xpath("//div[@id='content']/form/div/table/tbody/tr/td[6]"));
	}

}
