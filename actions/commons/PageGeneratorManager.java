package commons;

import org.openqa.selenium.WebDriver;

import pageGeneratorManager.DepositPageObject;
import pageGeneratorManager.EditCustomerPageObject;
import pageGeneratorManager.LoginPageObject;
import pageGeneratorManager.MainPageObject;
import pageGeneratorManager.NewCustomerPageObject;
import pageGeneratorManager.RegisterPageObject;


public class PageGeneratorManager {
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static MainPageObject getMainPage(WebDriver driver) {
		return new MainPageObject(driver);
	}
	
	public static NewCustomerPageObject getNewCustomerPage(WebDriver driver) {
		return new NewCustomerPageObject(driver);
	}
	
	public static DepositPageObject getDepositPage(WebDriver driver) {
		return new DepositPageObject(driver);
	}

	public static EditCustomerPageObject getEditCustomerPage(WebDriver driver) {
		return new EditCustomerPageObject(driver);
	}
}
