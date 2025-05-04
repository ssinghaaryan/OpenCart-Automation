package testCases;

import testBase.BaseTest;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class TC001_RegistrationTest extends BaseTest {
	
	@Test(groups={"Sanity", "Regression"})
	public void verify_registration() {
		
		HomePage homepage = new HomePage(driver);
		
		logger.info("*** Started TC001_RegistrationTest ***");
		logger.info("Clicking on My Account & Register buttons");
		homepage.myAccountBtn().click();
		homepage.registerBtn().click();
		
		RegistrationPage regpage = new RegistrationPage(driver);
		
		logger.info("Entering user details");
		regpage.getFirstName().sendKeys(random("ABCDEFGHIJKLM"));
		regpage.getLastName().sendKeys(random("ABCDEFGHIJKLM"));
		regpage.getEmail().sendKeys(random("ABCDEFGHIJKLMnopqrstuvwzyz123456789") + "@gmail.com");
		regpage.getTelephone().sendKeys("123123");
		regpage.getPwd().sendKeys("pwdpwd");
		regpage.getConfirmPwd().sendKeys("pwdpwd");
		regpage.clickPrivacy().click();
		regpage.clickContinue().click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.urlContains("account/success"));
		
		logger.info("Validation Confirmation Text");
		
		String expectedConfirmationTxt = regpage.getConfirmationTxt().getText();
		String actualConfirmationTxt = "Your Account Has Been Created!";
		
		if(expectedConfirmationTxt.equals(actualConfirmationTxt)) {
			Assert.assertTrue(true);
			logger.info("TC Passed");
		} else {
			String errorMsg = "Expected - " + expectedConfirmationTxt + ", but got - " + actualConfirmationTxt;
			logger.error("TC Failed |  " + errorMsg);
			Assert.assertTrue(false);
		}
	}
	
	// Method to generate random Strings for Names & Email.
	public String random(String characters) {
		
		String result = "";
		
		int length = characters.length();
		for(int i = 0; i < length; i++) {
			result += characters.charAt((int)Math.floor(Math.random() * length));
		}
		
		return result;
		
	}

}
