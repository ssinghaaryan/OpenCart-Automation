package testCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductPage;
import pageObjects.SearchPage;
import testBase.BaseTest;
import utilities.SearchProduct;
import utilities.WaitHelper;

public class TC008_ProductPage extends BaseTest {
	
	@Test(groups={"Regression"})
	public void verify_productPage() throws InterruptedException {
		
		Log.info("------------------------------");
		logger.info("*** Started TC008_ProductPage ***");
		
		WaitHelper waitHelper = new WaitHelper(driver);
		
		SearchProduct searchProduct = new SearchProduct(driver);
		logger.info("Searching for Product");
		searchProduct.searchProduct();
		
		SearchPage searchPage = new SearchPage(driver);
		WebElement product = driver.findElement(searchPage.productName());
		String productName = driver.findElement(searchPage.productName()).getText();
		String fullPrice = driver.findElement(searchPage.productPrice()).getText();
		String onlyPrice = fullPrice.split("Ex Tax")[0].trim();
		System.out.println(onlyPrice);
		product.click();
		
		ProductPage productPage = new ProductPage(driver);
		logger.info("Product Page opened");
		//Validation of various elements on page.
		if(productName.equals(driver.findElement(productPage.productName()).getText())) {
			Assert.assertTrue(true, "Correct Product Name displayed");
			logger.info("Correct Product Name displayed");
		} else {
			Assert.assertTrue(false, "Incorrect Product Name displayed");
			logger.info("Incorrect Product Name displayed");
		}

		System.out.println(driver.findElement(productPage.productPrice()).getText());
		if(onlyPrice.equals(driver.findElement(productPage.productPrice()).getText())) {
			Assert.assertTrue(true, "Correct Product Price displayed");
			logger.info("Correct Product Price displayed");
		} else {
			Assert.assertTrue(false, "Incorrect Product Price displayed");
			logger.info("Incorrect Product Price displayed");
		}
		driver.findElement(productPage.qtyInput()).isDisplayed(); // Add check for both isDisplayed & isEnabled.
		driver.findElement(productPage.addToCartBtn()).isDisplayed();
		logger.info("Add to Cart button displayed");
		driver.findElement(productPage.wishlistBtn()).isDisplayed();
		logger.info("Wishlist button displayed");
		driver.findElement(productPage.compareBtn()).isDisplayed();
		logger.info("Compare button displayed");
		
		logger.info("*** Finished TC008_ProductPage ***");
		
	}
}

/*
 * Compare Product Name, Price from Search Page with name on Product Page
 */