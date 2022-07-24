package pageGeneratorManager;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUI.MainPageUI;

public class DepositPageObject extends AbstractPage {
	WebDriver driver;

	public DepositPageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println("--------------Driver at Login Page--------------");
		System.out.print(driver.toString());
	}
	
	public EditCustomerPageObject clickToDepositPageObject () {
		waitToElementVisible(driver, MainPageUI.LINK_EDIT_ACCOUNT);
		clickToElement(driver, MainPageUI.LINK_EDIT_ACCOUNT);
		return PageGeneratorManager.getEditCustomerPage(driver);
	}
}
