package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
	
	public void scrollToCart() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(addToCartBtn())).perform();
		// Scroll only
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", element);

	}
	
	public By productName() {
		return By.xpath("//div[@class='caption']/h4/a");
//		return driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[1]/h4/a"));
//		return driver.findElement(By.cssSelector("div.caption h4 a"));
	}
	
	public WebElement productPrice() {
		return driver.findElement(By.xpath("//p[@class='price']")); //span[@class='price-tax']/preceding-sibling::text()
	}
	
//	public WebElement addToCartBtn() {
//		return driver.findElement(By.xpath("//button[@type='button']/span[text() = 'Add to Cart']"));
//	}
	
	public By addToCartBtn() {
		return By.xpath("//button[@type='button']/span[text() = 'Add to Cart']");
	}
	
//	public WebDriver successMsg() {
//		return driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]"));
//	}

	public By successMsg() {
		return By.xpath("//div[contains(@class, 'alert-success')]");
	}
	
	public WebElement cartBtn() {
		return driver.findElement(By.xpath("//div[@id='cart']/button"));
	}
	
	public WebElement cartTotal() {
		return driver.findElement(By.xpath("//span[@id='cart-total']"));
	}
	
	public WebElement viewCartBtn() {
		return driver.findElement(By.xpath("//p[@class='text-right']/a[1]"));
	}
	
}
