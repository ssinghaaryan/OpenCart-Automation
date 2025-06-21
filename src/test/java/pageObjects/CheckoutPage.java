package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	// Step 2 -> Billing Details
	public By billingStepLink() {
		return By.xpath("//a[contains(text(), 'Billing Details')]");
	}
	
	public By billingExistingOption() {
		return By.xpath("//input[@name='payment_address' and @checked='checked']");
	}
	
	public By billingExistingDropdown() {
		return By.xpath("//div[@id='payment-existing']/select");
	}
	
	public By billingStepContinueBtn() {
		return By.xpath("//input[@id='button-payment-address']");
	}
	
	//----------------------------
	
	// Step 3 -> Delivery Details
	public By deliveryStepLink() {
		return By.xpath("//a[contains(text(), 'Delivery Details')]");
	}
	
	public By deliveryExistingRadioOption() {
		return By.xpath("//input[@name='shipping_address' and @checked='checked']");
	}
	
	public By deliveryExistingDropdown() {
		return By.xpath("//div[@id='shipping-existing']/select");
	}
	
	public By deliveryStepContinueBtn() {
		return By.xpath("//input[@id='button-shipping-address']");
	}
	
	//----------------------------
	
	// Step 4 -> Delivery Method
	public By deliveryMethodStepLink() {
		return By.xpath("//a[contains(text(), 'Step 4: Delivery Method')]");
	}
	
	public By shippingRateRadioOption() {
		return By.xpath("//input[@name='shipping_method']");
	}
	
	public By commentTextarea() {
		return By.xpath("//textarea");
	}
	
	public By deliveryMethodStepContinueBtn() {
		return By.id("button-shipping-method");
	}
	
	//<--- Step 5: Payment Method --->
	public By paymentMethodStepLink() {
		return By.xpath("//a[contains(text(), 'Payment Method ')]");
	}
	
	public By codRadioOption() {
		return By.xpath("//input[@name='payment_method']");
	}
	
	public By agreeCheckboxBtn() {
		return By.xpath("//input[@name='agree']");
	}
	
	public By paymentMethodStepContinueBtn() {
		return By.id("button-payment-method");
	}
	
	//<--- Step 6: Confirm Order --->
	public By confirmOrderStepLink() {
		return By.xpath("//a[contains(text(), 'Confirm Order')]");
	}
	
	public By finalTotalTable() {
		return By.xpath("//div[@class='table-responsive']");
	}
	
	public By tableTotalPrice() {
		return By.xpath("//tfoot/tr[3]/td[2]");
	}
	
	public By confirmOrderBtn() {
		return By.id("button-confirm");
	}
 
}
