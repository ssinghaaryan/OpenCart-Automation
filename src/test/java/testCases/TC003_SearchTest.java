package testCases;

import testBase.BaseTest;
import utilities.SearchProduct;
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
		
		SearchProduct searchProduct = new SearchProduct(driver);
		searchProduct.searchProduct();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.urlContains("search=" + searchProduct.randomProduct()));
		
		SearchPage searchpage = new SearchPage(driver);
		String actualTxt = searchpage.searchResultTxt().getText();
		
		String arr[] = actualTxt.split(" - ");
		String actualProduct = arr[arr.length - 1];
		Thread.sleep(3000);
		Assert.assertEquals(actualProduct, searchProduct.randomProduct());
		
		WebElement element = wait.until(ExpectedConditions.visibilityOf(searchpage.searchResultCount()));
		Assert.assertTrue(element.isDisplayed());
		
	}

}
