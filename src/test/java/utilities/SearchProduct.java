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

	public void searchProduct() {
		
		WaitHelper waitHelper = new WaitHelper(driver);

		HomePage homepage = new HomePage(driver);
//		product = randomProduct();
		product = availableProduct();
		homepage.searchInput().sendKeys(product);
		homepage.searchBtn().click();
		
	}

	public String randomProduct() {

		String productsList = "MacBook, iPhone, iMac, HTC, iPod, Palm, Samsung, Sony";
		// HP LP3065 - Only Available for checkout.
		String products[] = productsList.split(",\\s");

		int index = (int) Math.floor(Math.random() * products.length);

		product = products[index];
		return product;

	}
	
	public String availableProduct() {
		return "HP";
	}
	
	public String getRandomProduct() {
		return product;
	}

}
