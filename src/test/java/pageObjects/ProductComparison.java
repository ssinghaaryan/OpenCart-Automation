package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ProductComparison extends BasePage {
	
	public ProductComparison(WebDriver driver) {
		super(driver);
	}
	
	public By productComparisonHeading() {
		return By.xpath("//div[@id='content']/h1");
	}
	
	public By productNamesComparison() {
		return By.xpath("//div[@id='content']/table/tbody[1]/tr[1]/td/a/strong");
	}
	
	public void scrollToFooter() {  // public ProductComparison scrollToFooter()  ->  Method Chaining
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//footer"))).perform();
	}
	
	public By addToCartBtn() {
		return By.xpath("//input[@value='Add to Cart']");
	}
	
	public By removeBtn() {
		return By.xpath("//a[contains(@class, 'btn-danger')]");
	}

}
