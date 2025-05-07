package testCases;

import testBase.BaseTest;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TC002_LoginTest extends BaseTest {
	
	@Test(groups={"Sanity", "Regression"})
	public void verify_login() {
		
		logger.info("*** Started TC002_LoginTest ***");
		HomePage homepage = new HomePage(driver);
		
		logger.info("Clicking on My Account & Login buttons");
		homepage.myAccountBtn().click();
		homepage.loginBtn().click();
		
		LoginPage loginpage = new LoginPage(driver);
		logger.info("Entering user details");
		loginpage.emailInput().sendKeys("aaryan.ssingh101@gmail.com");
		loginpage.pwdInput().sendKeys("qautomation");
		loginpage.loginBtn().click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.urlContains("account/account"));
		
		String actualTxt = loginpage.getConfirmationText().getText();
		Assert.assertEquals(actualTxt, "My Account");
		logger.info("TC Passed/Failed");
		logger.info("*** Finished TC002_LoginTest ***");
		
	}

}
