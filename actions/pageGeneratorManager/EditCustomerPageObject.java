package pageGeneratorManager;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.AbstractPage;
import pageUI.MainPageUI;

public class EditCustomerPageObject extends AbstractPage  {
	WebDriver driver;

	public EditCustomerPageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println("--------------Driver at Login Page--------------");
		System.out.print(driver.toString());
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
