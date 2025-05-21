package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountInfo;
import pageObjects.MyAccount;
import testBase.BaseTest;
import utilities.LoginHelper;
import utilities.WaitHelper;

public class TC007_EditAccountInfo extends BaseTest {
	
	@Test(groups={"Regression"})
	public void verify_editAccountInfo() {
		
		logger.info("------------------------------");
		logger.info("*** Started TC007_EditAccountInfo");
		
		WaitHelper waitHelper = new WaitHelper(driver);
		
		logger.info("Logging in user");
		LoginHelper loginHelper = new LoginHelper(driver);
		loginHelper.performLogin();
		
		waitHelper.waitForUrlToContain("account/account", 5);
		
		MyAccount myAccount = new MyAccount(driver);
		if("My Account".equals(driver.findElement(myAccount.getConfirmationText()).getText())) {
			Assert.assertTrue(true);
			logger.info("User logged in");
		}
		
		driver.findElement(myAccount.editAccountInfoBtn()).click();
		
		waitHelper.waitForUrlToContain("account/edit", 5);
		logger.info("Edit Account Information page opened.");
		AccountInfo accountInfo = new AccountInfo(driver);
		
		//Validating all 4 fields are present.
		logger.info("Entering user details");
		String updatedFName = "Anthony";
		String updatedLName = "Borth";
		String updatedTPhone = "012431";
		waitHelper.waitAndInput(accountInfo.firstNameInput(), updatedFName);
		waitHelper.waitAndInput(accountInfo.lastNameInput(), updatedLName);
		waitHelper.waitAndInput(accountInfo.telephoneInput(), updatedTPhone);
		driver.findElement(accountInfo.continueBtn()).click();
		
		waitHelper.waitForUrlToContain("account/account", 5);
		waitHelper.waitForElementVisible(myAccount.successMsg(), 5);
		if("Success: Your account has been successfully updated.".equals(driver.findElement(myAccount.successMsg()).getText())) {
			Assert.assertTrue(true, "Success message displayed");
			logger.info("Success message displayed.");
		} else {
			Assert.assertTrue(false, "No Success message displayed.");
			logger.error("No Success message displayed.");
		}
		
		driver.findElement(myAccount.editAccountInfoBtn()).click();
		waitHelper.waitForUrlToContain("account/edit", 5);
		
		//Validating same details are displayed that were provided.
		waitHelper.waitForElementVisible(accountInfo.firstNameInput(), 5);
		if(updatedFName.equals(driver.findElement(accountInfo.firstNameInput()).getAttribute("value")) && updatedLName.equals(driver.findElement(accountInfo.lastNameInput()).getAttribute("value"))) {
			Assert.assertTrue(true, "First & Last name match");
			logger.info("First & Last name matched.");
		} else {
			Assert.assertTrue(false, "No match for First & Last name");
			logger.error("No match for First & Last name");
		}
		
		if(updatedTPhone.equals(driver.findElement(accountInfo.telephoneInput()).getAttribute("value"))) {
			Assert.assertTrue(true, "Telephone number match");
			logger.info("Telephone number match");
		} else {
			Assert.assertTrue(false, "No match for telephone number");
			logger.error("No match for telephone number");
		}
		logger.info("*** Finished TC007_EditAccountInfo ***");
	}

}

// Store the updated details being provided.
// Go back to Edit Info screen & compare if displayed text is same as the stored one.







