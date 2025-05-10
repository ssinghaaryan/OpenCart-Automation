package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage extends BasePage {
	
	public WishlistPage(WebDriver driver) {
		super(driver);
	}
	
	public By wishlistHeading() {
		return By.xpath("//div[@id='content']/h2");
	}

	public By productNameWishlist() {
		return By.xpath("//div[@id='content']/div/table/tbody/tr/td[2]/a");
	}
	
	public By productPriceWishlist() {
		return By.xpath("//div[@class='price']");
	}
	
	public By removeBtn() {
		return By.xpath("//a[@data-original-title='Remove']");
	}
	
	public By successMsg() {
		return By.xpath("//div[contains(@class, \"alert-success\")]");
	}
	
}
