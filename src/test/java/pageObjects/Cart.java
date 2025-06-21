package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.BasePage;

public class Cart extends BasePage {
	
	public Cart(WebDriver driver) {
		super(driver);
	}
	
	public List<WebElement> tableHeaders() {
		return driver.findElements(By.xpath("//div[@class='table-responsive']/table/thead/tr/td"));
	}
	
	public WebElement productNameCart() {
		//Not the most optamized xpath. But had to for now, as there was a hidden duplicate present.
		return driver.findElement(By.xpath("//div[@id='content']/form/div/table/tbody/tr/td[2]/a"));
	}
	
	public WebElement productPriceCart() {
		//Not the most optamized xpath. But had to for now, as there was a hidden duplicate present.
		return driver.findElement(By.xpath("//div[@id='content']/form/div/table/tbody/tr/td[6]"));
	}
	
	public By shippingDropdownBtn() {
		return By.xpath("//div[@id='accordion']/div[2]/div/h4/a");
	}
	
	public By countrySelect() {
		return By.xpath("//select[@id='input-country']");
	}
	
	public By stateSelect() {
		return By.xpath("//select[@id='input-zone']");
	}
	
	public By postcodeInput() {
		return By.xpath("//input[@id='input-postcode']");
	}
	
	public By quoteBtn() {
		return By.xpath("//button[@id='button-quote']");
	}
	
	public By shippingPopup() {
		return By.xpath("//div[@id='modal-shipping']");
	}
	
	public By shippingRateRadioBtn() {
		return By.xpath("//input[@name='shipping_method']");
	}
	
	public By shippingRateText() {
		return By.xpath("//label[input[@name='shipping_method']]");
	}
	
	public By applyShippingBtn() {
		return By.xpath("//input[@id='button-shipping']");
	}
	
	public By successMsg() {
		return By.xpath("//div[contains(@class, 'alert-success')]");
	}
	
	public By totalCartValue() {
		return By.xpath("//div[@id='content']/div[2]/div/table/tbody/tr[3]/td[2]");
	}
	
	public By checkoutBtn() {
		return By.linkText("Checkout");
	}
	
	/* Action Methods */
	
	public void clickShippingDropdownBtn() {
		driver.findElement(shippingDropdownBtn()).click();
	}
	
	public void clickQuoteBtn() {
		driver.findElement(quoteBtn()).click();
	}
	
	public void clickShippingRateRadioBtn() {
		driver.findElement(shippingRateRadioBtn()).click();
	}
	
	public void clickApplyShippingBtn() {
		driver.findElement(applyShippingBtn()).click();
	}
	
	public void clickCheckoutBtn() {
		driver.findElement(checkoutBtn()).click();
	}

}
