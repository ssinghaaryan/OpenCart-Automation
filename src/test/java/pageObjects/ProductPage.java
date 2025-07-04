package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
	
	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	public By shoppingCartBtn() {
		return By.xpath("//div[@id='top-links']/ul/li[4]/a");
	}
	
	public By wishlistBtn() {
		return By.xpath("//button[@data-original-title='Add to Wish List']");
	}
	
	public By compareBtn() {
		return By.xpath("//button[@data-original-title='Compare this Product']");
	}
	
	public By productName() {
		return By.xpath("//div[@id='content']/div/div[2]/h1");
	}
	
	public By productPrice() {
		return By.xpath("//div[@id='content']/div/div/ul/li/h2");
	}
	
	public By deliveryDateInput() {
		
		return By.xpath("//input[@id='input-option225']");
	}
	
	public By qtyInput() {
		return By.xpath("//input[@id='input-quantity']");
	}
	
	public By addToCartBtn() {
		return By.xpath("//button[@id='button-cart']");
	}
	
	/* Action Methods */
	
	public void clickAddToCart() {
		driver.findElement(addToCartBtn()).click();
	}
	
	public void clickShoppingCart() {
		driver.findElement(shoppingCartBtn()).click();
	}

}
