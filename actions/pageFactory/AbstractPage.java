package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

	private WebDriverWait explicitWait;
	private long longTimeout = 30;

 	public void openUrl(WebDriver driver,String url) {
		driver.get(url);
	}
 	
	public void clickToElement(WebDriver driver,WebElement element) {
		element.click();
	}
	
	public void sendKeysToElement(WebDriver driver,WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public String getELementText(WebDriver driver,WebElement element) {
		return element.getText();
	}
	
	public void waitToElementVisible(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitToElementInVisible(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitToElementClickable(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
}
