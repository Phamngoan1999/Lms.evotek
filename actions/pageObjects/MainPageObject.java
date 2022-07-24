package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.AbstractPage;
import pageUI.MainPageUI;

public class MainPageObject  extends AbstractPage{
	
	WebDriver driver;

	public MainPageObject(WebDriver driver) {
		System.out.println("--------------Driver at Login Page--------------");
		System.out.print(driver.toString());
		this.driver = driver;
	}
	
	public String getMessageWelcome() {
		return getELementText( driver, MainPageUI.MESSAGE_WELCOME);
	}
	
	public void clickLinkNewCustomer() {
		waitToElementVisible(driver, MainPageUI.LINK_NEW_CUSTOMER);
		clickToElement(driver, MainPageUI.LINK_NEW_CUSTOMER);
	}

	public void clickLogOut() {
		waitToElementVisible(driver, MainPageUI.LINK_LOG_OUT);
		clickToElement(driver, MainPageUI.LINK_LOG_OUT);
	}
	
	public void getMessageLogoutSuccess() {
		String successMessage = getTextInAlert(driver);
		Assert.assertEquals(successMessage, "You Have Succesfully Logged Out!!");
		acceptAlert(driver);
	}
}
