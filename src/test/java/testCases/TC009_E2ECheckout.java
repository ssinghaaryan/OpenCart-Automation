package testCases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Cart;
import pageObjects.CheckoutPage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;
import testBase.BaseTest;
import utilities.ExtentReportManager;
import utilities.Log;
import utilities.LoginHelper;
import utilities.SearchProduct;
import utilities.WaitHelper;

public class TC009_E2ECheckout extends BaseTest {
	
	@Test(groups={"Demo"})
	public void verify_e2eCheckout() {
		
		test = ExtentReportManager.createTest("TC009_E2ECheckout");
		Log.info("------------------------------");
		Log.info("*** Started TC009_E2ECheckout ***");
		WaitHelper waitHelper = new WaitHelper(driver);
		
		LoginHelper loginHelper = new LoginHelper(driver);
		loginHelper.performLogin();
		test.info("User logged in.");
		Log.info("User logged in.");
		
		SearchProduct searchProduct = new SearchProduct(driver);
		waitHelper.waitForUrlToContain("account/account", 5);
		searchProduct.searchProduct();
		
		SearchPage searchPage = new SearchPage(driver);
		waitHelper.waitForElementVisible(searchPage.productName(), 5);
		driver.findElement(searchPage.productName()).click();
		test.info("Product found.");
		Log.info("Product found.");
		
		ProductPage productPage = new ProductPage(driver);
		Log.info("Product page opened.");
		String productPrice = driver.findElement(productPage.productPrice()).getText();
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String todayDate = today.format(formatter);
		waitHelper.waitForElementVisible(productPage.deliveryDateInput(), 5);
		driver.findElement(productPage.deliveryDateInput()).sendKeys(todayDate);
		//Scroll to Add to Cart btn.
		productPage.clickAddToCart();
		Log.info("Product added to cart.");
		test.info("Product added to cart.");
		
		productPage.clickShoppingCart();
		Log.info("Shopping cart opened.");
		test.info("Shopping cart opened.");
		
		Cart cart = new Cart(driver);
		cart.clickShippingDropdownBtn();
		waitHelper.waitForElementVisible(cart.countrySelect(), 5);
		Select selectCountry = new Select(driver.findElement(cart.countrySelect()));
		selectCountry.selectByContainsVisibleText("India");
		Select selectState = new Select(driver.findElement(cart.stateSelect()));
		selectState.selectByContainsVisibleText("Uttar Pradesh");
		WebElement postcode = driver.findElement(cart.postcodeInput());
		postcode.clear();
		postcode.sendKeys("101010");
		cart.clickQuoteBtn();
		
		waitHelper.waitForElementVisible(cart.shippingPopup(), 5);
		String[] shippingRateText = driver.findElement(cart.shippingRateText()).getText().split(" - ");
		cart.clickShippingRateRadioBtn();
		cart.clickApplyShippingBtn();
		
		waitHelper.waitForElementVisible(cart.successMsg(), 5);
		String[] fullSuccessMsg = driver.findElement(cart.successMsg()).getText().split("\n");
		String successMsg = fullSuccessMsg[0].trim();
		
		// Checkout previous logic under BaseTest class. 
		logAssert("Success: Your shipping estimate has been applied!".equals(successMsg), "Shipping estimate applied.", "No shipping estimate applied.");
		
		//Assertion for 'Flat Shipping Rate:' row added at bottom & total = unit price + shipping rate
		String extractedShippingRate = shippingRateText[1].trim();
		double shippingRate = Double.parseDouble(extractedShippingRate.replace("$", ""));
		double updatedProductPrice = Double.parseDouble(productPrice.replace("$", "")); //Replace this with Sub-total amount to have little more flexibility.
		
		double total = updatedProductPrice + shippingRate;
		double expectedTotal = Double.parseDouble(driver.findElement(cart.totalCartValue()).getText().replace("$", ""));
		
		logAssert(Double.compare(expectedTotal, total) == 0, "Total cart value updated & correct.", "Incorrect cart value");
		
		cart.clickCheckoutBtn();
	
//		if(loginHelper.isUserLoggedIn()) {
//			//Skipping Step 1 of logging in with credentials
//		} else {
//			//Enter guest info
//		}
		
		//First adding the logic -> If user is logged in
		//Step 1: Checkout Options -> Skipped
		//Step 2: Billing Details
		//- Existing Address
		//- New Address
		
		//<--- Checkout Page --->
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		waitHelper.waitForElementVisible(checkoutPage.billingStepLink(), 5);
		//<--- Step 2: Billing Details -->
		Log.info("Executing Step 2: Billing Details");
		WebElement billingStepLink = driver.findElement(checkoutPage.billingStepLink());
		String isBillingStepExpanded = billingStepLink.getAttribute("aria-expanded");
		
		waitHelper.expandAccordianStep(billingStepLink, checkoutPage.billingExistingOption());
		
		/* if(!"true".equalsIgnoreCase(isBillingStepExpanded)) {
			billingStepLink.click();
			waitHelper.waitForElementVisible(checkoutPage.billingExistingOption(), 5);
		} */
		
		if(driver.findElement(checkoutPage.billingExistingOption()).isSelected()) {
			Select billingExistingDropdown = new Select(driver.findElement(checkoutPage.billingExistingDropdown()));
			billingExistingDropdown.selectByContainsVisibleText("101");
			driver.findElement(checkoutPage.billingStepContinueBtn()).click();
			} else {
				driver.findElement(checkoutPage.billingExistingOption()).click();
			}
		
		//<--- Step 3: Delivery Details --->
		test.info("Executing Step 3: Delivery Details");
		Log.info("Executing Step 3: Delivery Details");
		waitHelper.waitForElementClickable(checkoutPage.deliveryStepLink(), 5);
		WebElement deliveryStepLink = driver.findElement(checkoutPage.deliveryStepLink());
		String isDeliveryStepExpanded = deliveryStepLink.getAttribute("aria-expanded");
		
		waitHelper.expandAccordianStep(deliveryStepLink, checkoutPage.deliveryExistingRadioOption());

		if(driver.findElement(checkoutPage.deliveryExistingRadioOption()).isSelected()) {
			Select deliveryExistingDropdown = new Select(driver.findElement(checkoutPage.deliveryExistingDropdown()));
			deliveryExistingDropdown.selectByContainsVisibleText("101");
			driver.findElement(checkoutPage.deliveryStepContinueBtn()).click();
		} else {
			driver.findElement(checkoutPage.deliveryExistingRadioOption()).click();
		}
		
		//<--- Step 4: Delivery Method --->
		test.info("Executing Step 4: Delivery Method");
		Log.info("Executing Step 4: Delivery Method");
		waitHelper.waitForElementClickable(checkoutPage.deliveryMethodStepLink(), 5);
		WebElement deliveryMethodStepLink = driver.findElement(checkoutPage.deliveryMethodStepLink());
		String isDeliveryMethodStepExpanded = deliveryMethodStepLink.getAttribute("aria-expanded");
		
		waitHelper.expandAccordianStep(deliveryMethodStepLink, checkoutPage.shippingRateRadioOption());
		
		WebElement shippingRateRadioOption = driver.findElement(checkoutPage.shippingRateRadioOption());
		if(shippingRateRadioOption.isSelected()) {
			driver.findElement(checkoutPage.commentTextarea()).sendKeys("This is a sample comment for Delivery Method step");
			driver.findElement(checkoutPage.deliveryMethodStepContinueBtn()).click();
		} else {
			shippingRateRadioOption.click();
		}
		
		//<--- Step 5: Payment Method --->
		test.info("Executing Step 5: Payment Method");
		Log.info("Executing Step 5: Payment Method");
		waitHelper.waitForElementClickable(checkoutPage.paymentMethodStepLink(), 5);
		WebElement paymentMethodStepLink =  driver.findElement(checkoutPage.paymentMethodStepLink());
		String ispaymentMethodStepExpanded = paymentMethodStepLink.getAttribute("aria-expanded");
		
		waitHelper.expandAccordianStep(paymentMethodStepLink, checkoutPage.codRadioOption());
		
		WebElement codRadioOption = driver.findElement(checkoutPage.codRadioOption());
		if(codRadioOption.isSelected()) {
			driver.findElement(checkoutPage.agreeCheckboxBtn()).click();
			driver.findElement(checkoutPage.paymentMethodStepContinueBtn()).click();
		} else {
			codRadioOption.click();
		}
		
		//<--- Step 6: Confirm Order --->
		test.info("Executing Step 6: Confirm Order");
		Log.info("Executing Step 6: Confirm Order");
		waitHelper.waitForElementClickable(checkoutPage.confirmOrderStepLink(), 5);
		WebElement confirmOrderStepLink = driver.findElement(checkoutPage.confirmOrderStepLink());
		String isConfirmOrderStepExpanded = confirmOrderStepLink.getAttribute("aria-expanded");
		
		waitHelper.expandAccordianStep(confirmOrderStepLink, checkoutPage.finalTotalTable());
		
		double tableTotalPrice = Double.parseDouble(driver.findElement(checkoutPage.tableTotalPrice()).getText().replace("$", ""));
		logAssert(Double.compare(expectedTotal, tableTotalPrice) == 0, "Final & Total Price of product are matching", "Not matching Final & Total Price");
		
//		driver.findElement(checkoutPage.confirmOrderBtn()).click();
		softAssert.assertAll();
		test.pass("E2E Checkout Successful");
		
	}
}












