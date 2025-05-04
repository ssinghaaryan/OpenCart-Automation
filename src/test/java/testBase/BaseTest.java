package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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
	public Logger logger;
	
	@BeforeClass(groups={"Sanity", "Regression"})
	public void setup() throws IOException {
		
		Properties prop = new Properties();
		
		File file = new File("./src/test/resources/config.properties");
		
		FileInputStream fis = new FileInputStream(file);
		
		prop.load(fis);
		
		logger = LogManager.getLogger(this.getClass());
		
		driver = new ChromeDriver();
//		driver.get("https://tutorialsninja.com/demo/");
		driver.get(prop.getProperty("app_url"));
	}
	
	@AfterClass(groups={"Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}

}
