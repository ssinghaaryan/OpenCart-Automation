package testCases;

import testBase.BaseTest;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchPage;
import pageObjects.WishlistPage;
import utilities.SearchProduct;
import utilities.WaitHelper;
import utilities.LoginHelper;

public class TC005_AddToWishlist extends BaseTest {
	
	@Test(groups={"Demo"})
	public void verify_addToWishlist() throws InterruptedException {
		
		WaitHelper waitHelper = new WaitHelper(driver);
		
		logger.info("--------------------------");
		logger.info("*** Started TC005_AddToWishlist ***");
		
		LoginHelper loginHelper = new LoginHelper(driver);
		loginHelper.performLogin();
		
		SearchProduct searchProduct = new SearchProduct(driver);
		searchProduct.searchProduct();
		String productName = searchProduct.getRandomProduct(); // Was calling method before searchProduct() & was getting null.
		
		SearchPage searchPage = new SearchPage(driver);
		List<WebElement> productList = driver.findElements(searchPage.productList());
		int listSize = productList.size();
		
		int index = (int)Math.ceil(Math.random() * listSize) - 1;
		productList.get(index).click();
		
		waitHelper.waitForElementVisible(searchPage.successMsg(), 5);
		
		// Validating product added to wishlist
		if(driver.findElement(searchPage.successMsg()).getText().contains("Success: ")) {
			Assert.assertTrue(true);
			logger.info("Product added to Wishlist");
		} else {
			Assert.assertTrue(false);
			logger.error("No product added to Wishlist");
		}
		
		driver.findElement(searchPage.wishlistBtn()).click();
		waitHelper.waitForUrlToContain("account/wishlist", 5);
		
		WishlistPage wishlistPage = new WishlistPage(driver);
		waitHelper.waitForElementVisible(wishlistPage.wishlistHeading(), 5);
		WebElement wishlistHeading = driver.findElement(wishlistPage.wishlistHeading());
		if(wishlistHeading.getText().equals("My Wish List")) {
			Assert.assertTrue(true);
			logger.info("Wishlist page opened");
		} else {
			Assert.assertTrue(false);
			logger.error("Not able to open wishlist page");
		}
		
		// Validating product present in Wishlist.
		if(driver.findElement(wishlistPage.productNameWishlist()).getText().contains(productName)) {
			Assert.assertTrue(true);
			logger.info("Wishlisted product present");
		} else {
			Assert.assertTrue(false);
			logger.error("Wishlisted product not present");
		}
		
		// Removing product too & validating.
		driver.findElement(wishlistPage.removeBtn()).click();
		waitHelper.waitForElementVisible(wishlistPage.successMsg(), 5);
		if(driver.findElement(wishlistPage.successMsg()).getText().contains("Success: ")) {
			Assert.assertTrue(true);
			logger.info("Product successfully removed from Wishlist");
		} else {
			Assert.assertTrue(false);
			logger.error("Product still present in Wishlist");
		}
		
		logger.info("*** Finished TC005_AddToWishlist ***");
		
	}

}
