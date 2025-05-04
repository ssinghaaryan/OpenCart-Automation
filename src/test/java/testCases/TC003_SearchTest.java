package testCases;

import testBase.BaseTest;
import pageObjects.HomePage;
import pageObjects.SearchPage;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_SearchTest extends BaseTest {
	
	@Test(groups={"Regression"})
	public void verify_search() throws InterruptedException {
		
		HomePage homepage = new HomePage(driver);
		Thread.sleep(3000);
		String product = randomProduct();
		homepage.searchInput().sendKeys(product);
		Thread.sleep(3000);
		homepage.searchBtn().click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.urlContains("search=" + product));
		
		SearchPage searchpage = new SearchPage(driver);
		String actualTxt = searchpage.searchResultTxt().getText();
		
		String arr[] = actualTxt.split(" - ");
		String actualProduct = arr[arr.length - 1];
		Thread.sleep(3000);
		Assert.assertEquals(actualProduct, product);
		
		WebElement element = wait.until(ExpectedConditions.visibilityOf(searchpage.searchResultCount()));
		Assert.assertTrue(element.isDisplayed());
		
	}
	
	// Method/Assertion No.2 to check if the displayed item has name which is searched.
	
	// Method that pick random value from an array of different products list
	public String randomProduct() {
		
		String productsList = "Macbook, iPhone, Canon, iMac, Apple, HP, HTC, iPod, Palm, Samsung, Sony";
		String products[] = productsList.split(",\\s");
		
		int index = (int)Math.floor(Math.random() * products.length);
		
		String product = products[index];
		return product;
				
	}

}
