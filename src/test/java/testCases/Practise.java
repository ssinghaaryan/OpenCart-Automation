package testCases;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseTest;
import utilities.SearchProduct;
import utilities.WaitHelper;

public class Practise extends BaseTest {

	@Test(groups={"Demo"})
	public void verify_practise() throws InterruptedException {
		
		WaitHelper waitHelper = new WaitHelper(driver);
		
		HomePage homePage = new HomePage(driver);
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//ul[contains(@class, 'navbar-nav')]/li[3]/a")));
		Thread.sleep(5000);
		action.moveToElement(driver.findElement(By.xpath("//ul[contains(@class, 'navbar-nav')]/li[3]/div/div/ul/li[2]/a")));
		Thread.sleep(5000);
		action.perform();
		
		SearchProduct searchProduct = new SearchProduct(driver);
		searchProduct.searchProduct();
		
		Select select = new Select(driver.findElement(By.xpath("//select[@id='input-sort']")));
//		select.selectByContainsVisibleText("Price (Low > High)");
//		select.selectByIndex(7);
		List<WebElement> dropdownOptions = select.getOptions();
		for(WebElement option: dropdownOptions) {
			System.out.println(option.getText());
		}
				
//		driver.switchTo().alert().
		
	}
	
}
