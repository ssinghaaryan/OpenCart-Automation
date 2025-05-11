package utilities;

import testBase.BaseTest;
import utilities.WaitHelper;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
//import pageObjects.SearchPage;

public class SearchProduct extends BaseTest {
	
	public String product;

	public SearchProduct(WebDriver driver) {
		this.driver = driver;
	}

	public void searchProduct() throws InterruptedException {
		
		WaitHelper waitHelper = new WaitHelper(driver);

		HomePage homepage = new HomePage(driver);
		product = randomProduct();
		homepage.searchInput().sendKeys(product);
		homepage.searchBtn().click();
		
	}

	public String randomProduct() {

		String productsList = "MacBook, iPhone, iMac, HTC, iPod, Palm, Samsung, Sony";
		// HP LP3065 - Available
		// Removed {Canon, Apple, HP} from the list currently, as they are navigating to product main page. Will add later, along with main page object.
		String products[] = productsList.split(",\\s");

		int index = (int) Math.floor(Math.random() * products.length);

		product = products[index];
		return product;

	}
	
	public String getRandomProduct() {
		return product;
	}

}
