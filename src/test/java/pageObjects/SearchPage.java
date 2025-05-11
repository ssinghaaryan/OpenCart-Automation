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
	
	public By productList() {
		return By.xpath("//button[@data-original-title='Add to Wish List']");
	}
	
	public By productName() {
		return By.xpath("//div[@class='caption']/h4/a");
	}
	
	public WebElement productPrice() {
		return driver.findElement(By.xpath("//p[@class='price']")); 
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
	
	public By productCompLink() {
		return By.xpath("//div[contains(@class, 'alert-success')]/a[2]");
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
	
	public By wishlistBtn() {
		return By.xpath("//a[@id='wishlist-total']");
	}
	
	public By compareBtn() {
		return By.xpath("//button[@data-original-title='Compare this Product']");
	}
	
	public By searchInput() {
		return By.xpath("//input[@placeholder='Search']");
	}
	
}
