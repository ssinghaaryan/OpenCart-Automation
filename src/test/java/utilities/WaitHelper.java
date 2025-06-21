package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.CheckoutPage;
import testBase.BaseTest;

public class WaitHelper extends BaseTest {
	
	public WaitHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement waitForElementVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public boolean waitForUrlToContain(String urlPart, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.urlContains(urlPart));
	}
	
	public void waitAndInput(By locator, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(text);
	}
	
	public void waitForElementClickable(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
//		element.click();
	}
	
	public void expandAccordianStep(WebElement stepLink, By waitForElement) {
		if(!"true".equalsIgnoreCase(stepLink.getAttribute("aria-expanded"))) {
			stepLink.click();
			waitForElementVisible(waitForElement, 5);
		}
	}
	
}
