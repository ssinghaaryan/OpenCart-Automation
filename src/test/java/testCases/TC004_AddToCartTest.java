package testCases;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBase.BaseTest;
import utilities.Log;
import utilities.SearchProduct;
import pageObjects.Cart;
import utilities.WaitHelper;

public class TC004_AddToCartTest extends BaseTest {
	
	@Test(groups={"Regression"})
	public void verify_addToCart() throws InterruptedException {
		
		Log.info("*** Staring TC0004_AddToCartTest ***");
		WaitHelper waitHelper = new WaitHelper(driver);
		
		Log.info("Searching for Product");
		SearchProduct searchProduct = new SearchProduct(driver);
		searchProduct.searchProduct();
		
		SearchPage searchPage = new SearchPage(driver);
		searchPage.scrollToCart();
		
		waitHelper.waitForElementVisible(searchPage.addToCartBtn(), 5);
		driver.findElement(searchPage.addToCartBtn()).click();
		String productName = driver.findElement(searchPage.productName()).getText();
		String productPrices[] = driver.findElement(searchPage.productPrice()).getText().split("\n");
		String productPrice = productPrices[0];
		
		waitHelper.waitForElementVisible(searchPage.successMsg(), 5);
		WebElement successMsg = driver.findElement(searchPage.successMsg());
		
		// Validating the success msg for adding product to cart.
		if(successMsg.getText().contains("Success: ")) {
			Assert.assertTrue(true);
			Log.info("Product added to cart");
		} else {
			Assert.assertTrue(false);
			Log.info("Product not added to cart");
		}
		
		// Validating product price & cart value of search page is equal.
		String arr1[] = searchPage.cartTotal().getText().split(" - ");
		String cartTotal = arr1[arr1.length - 1];
		
		String arr2[] = driver.findElement(searchPage.productPrice()).getText().split("\n");
		String price = arr2[0];
		
		Assert.assertEquals(price, cartTotal.trim());
		
		searchPage.cartBtn().click();
		searchPage.viewCartBtn().click();
		
		waitHelper.waitForUrlToContain("checkout/cart", 5);
		
		// Validating table headers are displayed correctly.
		Cart cartPage = new Cart(driver);
		List<WebElement> actualHeaders = cartPage.tableHeaders();
		List<String> expectedHeaders = Arrays.asList("Image", "Product Name", "Model", "Quantity", "Unit Price", "Total");
		Log.info("Expected Headers present in cart");
		for(int i = 0; i < expectedHeaders.size(); i++) {
			Assert.assertEquals(actualHeaders.get(i).getText(), expectedHeaders.get(i).trim());
		}
		
		// Validate same product (name) is displayed in cart, which is added.
		Assert.assertEquals(cartPage.productNameCart().getText().trim(), productName);
		Log.info("Validating Product Name in cart.");
		//Validate same product (price) is displayed in cart, while adding.
		Assert.assertEquals(cartPage.productPriceCart().getText().trim(), productPrice);
		Log.info("Validating Product Price in cart.");
		
		Log.info("*** Finished TC004_AddToCartTest ***");
		
	}

}













