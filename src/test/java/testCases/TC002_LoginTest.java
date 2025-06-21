package testCases;

import testBase.BaseTest;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.Log;
import utilities.LoginHelper;
import utilities.WaitHelper;

public class TC002_LoginTest extends BaseTest {
	
	@Test(groups={"Regression"})
	public void verify_login() {
		
		WaitHelper waitHelper = new WaitHelper(driver);
		
		Log.info("*** Started TC002_LoginTest ***");
		LoginHelper loginHelper = new LoginHelper(driver);
		
		LoginPage loginPage = new LoginPage(driver);
		
		waitHelper.waitForUrlToContain("account/account", 5);
		
		String actualTxt = driver.findElement(loginPage.getConfirmationText()).getText();
		Assert.assertEquals(actualTxt, "My Account");
		Log.info("TC Passed/Failed");
		Log.info("*** Finished TC002_LoginTest ***");
		
	}

}
