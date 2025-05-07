package utilities;

import testBase.BaseTest;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
//import pageObjects.SearchPage;

public class SearchProduct extends BaseTest {
	
	private String product;
//	WebDriver driver;

	public SearchProduct(WebDriver driver) {
		this.driver = driver;
	}

	public void searchProduct() throws InterruptedException {

		HomePage homepage = new HomePage(driver);
		Thread.sleep(3000);
		product = randomProduct();
		homepage.searchInput().sendKeys(product);
		Thread.sleep(3000);
		homepage.searchBtn().click();
		
	}
	
	public String getRandomProduct() {
		return product;
	}

	public String randomProduct() {

		String productsList = "Macbook, iPhone, iMac, HTC, iPod, Palm, Samsung, Sony";
		// Removed {Canon, Apple, HP} from the list currently, as they are navigating to product main page. Will add later, along with main page object.
		String products[] = productsList.split(",\\s");

		int index = (int) Math.floor(Math.random() * products.length);

		String product = products[index];
		return product;

	}

}
