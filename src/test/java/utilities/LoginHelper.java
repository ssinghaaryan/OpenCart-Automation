package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseTest;

public class LoginHelper extends BaseTest {
	
	public LoginHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	public void performLogin() {
		
		HomePage homepage = new HomePage(driver);
//		logger.info("Clicking on My Account & Login buttons");
		homepage.myAccountBtn().click();
		homepage.loginBtn().click();
		
		LoginPage loginpage = new LoginPage(driver);
//		logger.info("Entering user details");
		loginpage.emailInput().sendKeys("aaryan.ssingh101@gmail.com");
		loginpage.pwdInput().sendKeys("qautomation");
		loginpage.loginBtn().click();
		
	}
	
//	public boolean isUserLoggedIn() {
//		homepage.myAccountBtn().click();
//		WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
//		return logoutBtn.isDisplayed();
//	}

}
