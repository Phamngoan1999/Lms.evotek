package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

	private WebDriverWait explicitWait;
	private Alert alert;
	private Select select;
	private JavascriptExecutor jsExecutor;
	private Actions action;
	private WebElement element;
	private long longTimeout = 30;
	
 	public void openUrl(WebDriver driver,String url) {
		driver.get(url);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void waitToAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptAlert(WebDriver driver) {
		alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	public void sendKeyToAlert(WebDriver driver, String value) {
		alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}
	
	public String getTextInAlert(WebDriver driver) {
		alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public void switchToWindowByID(WebDriver driver,String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for(String runWindow : allWindows) {
			if(!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}
	
	public void switchToWindowByTitle(WebDriver driver,String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for(String runWindow : allWindows) {
			driver.switchTo().window(runWindow);
			String currentWin = driver.getTitle();
			if(currentWin.equals(parentID)) {
				break;
			}
		}
	}
	
	public boolean closeAllWindowsWithoutParent(WebDriver driver,String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for(String runWindow : allWindows) {
			if(!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
		if(driver.getWindowHandles().size() == 1)
			return true;
		return false;
	}
	
	public By byXpath(String location) {
		return By.xpath(location);
	}
	
	public WebElement find(WebDriver driver,String locator) {
		return driver.findElement(byXpath(locator));
	}
	
	public List<WebElement> finds(WebDriver driver,String locator) {
		return driver.findElements(byXpath(locator));
	}
	
	public void clickToElement(WebDriver driver,String locator) {
		find(driver,locator).click();
	}
	
	public void sendKeysToElement(WebDriver driver,String locator, String value) {
		find(driver,locator).clear();
		find(driver,locator).sendKeys(value);
	}
	
	public void selectedItermInDropdown(WebDriver driver,String locator, String itemValue) {
		select = new Select(find(driver, locator));
		select.selectByValue(itemValue);
	}
	
	public String getFirstSelectedItemInDropdown(WebDriver driver,String locator) {
		select = new Select(find(driver, locator));
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMultiple(WebDriver driver,String locator) {
		select = new Select(find(driver, locator));
		return select.isMultiple();
	}
	
	public void selectItermInCustomDrodown(WebDriver driver, String parentLocator, String childLocator,String expectedItem) {
		find(driver,parentLocator).click();
		sleepInSecond(1);
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXpath(childLocator)));
		
		List<WebElement> allItems = finds(driver,childLocator);
		for(WebElement item : allItems) {
			if(item.getText().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;	
				jsExecutor.executeScript("arguments[0].click();", item);
				sleepInSecond(1);
				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}
	
	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout*1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getElementAttribute(WebDriver driver, String locator, String attribute) {
		return find(driver, locator).getAttribute(attribute);
	}
	
	public String getELementText(WebDriver driver, String locator) {
		return find(driver, locator).getText();
	}
	
	public int countElementSize(WebDriver driver, String locator) {
		return finds(driver, locator).size();
	}
	
	public void checkToCheckbox(WebDriver driver, String locator) {
		if(!find(driver, locator).isSelected()) {
			find(driver, locator).click();
		}
	}
	
	public void uncheckToCheckbox(WebDriver driver, String locator) {
		if(find(driver, locator).isSelected()) {
			find(driver, locator).click();
		}
	}
	
	public boolean isControlDisplayed(WebDriver driver, String locator) {
		return find(driver, locator).isDisplayed();
	}

	public boolean isControlEnabled(WebDriver driver, String locator) {
		return find(driver, locator).isEnabled();
	}

	public boolean isControlSelected(WebDriver driver, String locator) {
		return find(driver, locator).isSelected();
	}
	
	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(find(driver,locator));
	}
	
	public void switchToDefaultPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void doubleClickToELement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(find(driver,locator)).perform();
	}

	public void rightClickToELement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(find(driver,locator)).perform();
	}
	
	public void hoverToELement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(find(driver,locator)).perform();
	}
	
	public void drapAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(find(driver,sourceLocator),find(driver,targetLocator)).perform();
	}

	public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(find(driver,locator),key).perform();
	}
	
	public Object executeForBrowser(WebDriver driver,String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeAsyncScript(javaScript);
	}
	
	public boolean verifyTextInInnerText(WebDriver driver,String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript(" return document.documentElement.innerText;").toString();
		return textActual.equals(textActual);
	}
	
	public void scollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJs(WebDriver driver,String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + 	"'");
	}
	
	public void hightlightElement(WebDriver driver,String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath(locator));
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, "style", "border: 5px solid red;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])",  element, "style", originalStyle);
	}
	
	public void clickToElementByJs(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = find(driver, locator);
		jsExecutor.executeScript("arguments[0].click();", element);
	}
	
	public void scollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = find(driver, locator);
		jsExecutor.executeScript("arguments[0].scollIntoView(true);", element);
		
	}
	
	public void sendKeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		element = find(driver, locator);
		jsExecutor.executeScript("arguments[0].setAttribute('value','" + value + "');", element);
	}
	
	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		element = find(driver, locator);
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}
	
	public boolean isImageLoaded(WebDriver driver, String locator) {
		element = find(driver, locator);
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefinded\" && arguments[0].naturalWidht >0 ", element);
		if(status) {
			return true;
		}else {
			return false;
		}
	}
	
	public void waitToElementPresence(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(byXpath(locator)));
	}
	
	public void waitToElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(locator)));
	}

	public void waitToElementInVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(locator)));
	}

	public void waitToElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(locator)));
	}
}
