package testCases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseTest;
import pageObjects.SearchPage;
import pageObjects.ProductComparison;
import utilities.SearchProduct;
import utilities.WaitHelper;

public class TC006_ProductComparison extends BaseTest {
	
	@Test(groups={"Demo"})
	public void verify_productComparison() throws InterruptedException {
		
		logger.info("--------------------------");
		logger.info("*** Started TC006_ProductComparison ***");
		WaitHelper waitHelper = new WaitHelper(driver);
		Map<String, String> expectedProducts = new HashMap<>();
		SearchPage searchPage = new SearchPage(driver);
		
		SearchProduct searchProduct = new SearchProduct(driver);
		for(int i = 0; i < 3; i++) {
			logger.info("Searching Product");
			searchProduct.searchProduct();
			
			searchPage.scrollToCart();
			waitHelper.waitForElementVisible(searchPage.compareBtn(), 5);
			
			//Pick Product Name, Price & add it to Map.
			expectedProducts.put("Product" + i, driver.findElement(searchPage.productName()).getText());
			//System.out.println(expectedProducts.get("Product" + i)); // Printing products found on search & in Map.
			
			driver.findElement(searchPage.compareBtn()).click();
			
			waitHelper.waitForElementVisible(searchPage.successMsg(), 5);
			if(driver.findElement(searchPage.successMsg()).getText().contains("Success: ")) {
				Assert.assertTrue(true);
				logger.info("Product added to comparison screen");
			} else {
				Assert.assertTrue(false);
				logger.error("Product not added to comparison screen");
			}
			driver.findElement(searchPage.searchInput()).clear();
		}
		
		waitHelper.waitForElementVisible(searchPage.successMsg(), 5);
		driver.findElement(searchPage.productCompLink()).click();
		
		//Validating 'Product Comparison' heading & same product name present on comparison screen.
		waitHelper.waitForUrlToContain("product/compare", 5);
		ProductComparison productComparison = new ProductComparison(driver);
		if(driver.findElement(productComparison.productComparisonHeading()).getText().equals("Product Comparison")) {
			Assert.assertTrue(true);
			logger.info("Product Comparison screen opened.");
		} else {
			Assert.assertTrue(false);
			logger.error("Produt Comparison screen not opened.");
		}
		
		//Getting the list of elements(product names in the table).
		List<WebElement> actualProducts = driver.findElements(productComparison.productNamesComparison());
		
		//Converting the above list of WebElements -> List of String to be able to compare with expected product names.
		List<String> actualList = new ArrayList<>();
		for(WebElement product: actualProducts) {
			actualList.add(product.getText());
		}
		
		//Converting both Map of expected products & List of actual products to Set -> To handle if same product is added multiple times but visible only once on comparison screen.
		Set<String> expectedSet = new HashSet<>(expectedProducts.values());
		Set<String> actualSet = new HashSet<>(actualList);
/*		
		for(WebElement product: actualProducts) {
			System.out.println(product.getText()); // Printing products on Comparison screen.
		}
*/		
		//Asserting same products added via search are present on comparison screen, even if duplicates were searched.
		for(String expected: expectedSet) {
			Assert.assertTrue(actualSet.contains(expected), "Product not found on comparison page.");
		}
		logger.info("Products present are same as added.");
		
		//Asserting the price of products added (Will add later..)

		productComparison.scrollToFooter();
		if(driver.findElement(productComparison.addToCartBtn()).isDisplayed() && driver.findElement(productComparison.removeBtn()).isDisplayed()) {
			Assert.assertTrue(true);
			logger.info("Add to Cart & Remove buttons present for product.");
		} else {
			Assert.assertTrue(false);
			logger.error("Add to Cart & Remove buttons not present for product.");
		}
		logger.info("*** Finished TC006_ProductComparison ***");
	}
}