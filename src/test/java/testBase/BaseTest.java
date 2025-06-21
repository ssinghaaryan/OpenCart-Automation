 package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.ExtentReportManager;
import utilities.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//Properties class for reading variables from config.properties
import java.util.Properties;

//Log4j2
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {
	
	public WebDriver driver;
	protected SoftAssert softAssert;
	protected ExtentReports extent;
	protected ExtentTest test;
	
	@BeforeSuite
	public void setupReport() {
		extent = ExtentReportManager.getReportInstance();
	}
	
	@BeforeClass(groups={"Regression", "Demo"})
	public void setup() throws IOException {
		
		Properties prop = new Properties();
		
		File file = new File("./src/test/resources/config.properties");
		
		FileInputStream fis = new FileInputStream(file);
		
		prop.load(fis);
		
		softAssert = new SoftAssert();
		
		Log.info("Initializing WebDriver");
		driver = new ChromeDriver();
//		driver.get("https://tutorialsninja.com/demo/");
		Log.info("Navigating to URL");
		driver.get(prop.getProperty("app_url"));
		
	}
	
	public void logAssert(boolean condition, String successMsg, String failMsg) {
		if(condition) {
			softAssert.assertTrue(true, successMsg);
			Log.info(successMsg);
		} else {
			softAssert.assertTrue(false, failMsg);
			Log.error(failMsg);
		}
	}
	
//	@BeforeMethod(groups={"Regression", "Demo"})
//	public void setupMethod() {
//		softAssert = new SoftAssert();
//	}
	
	@AfterSuite
	public void tearDownReport() {
		extent.flush();
	}
	
	@AfterClass(groups={"Regression", "Demo"})
	public void tearDown() {
		Log.info("Closing Browser");
		driver.quit();
	}

}
