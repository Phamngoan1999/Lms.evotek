package pageObjects;

import org.openqa.selenium.WebDriver;
import commons.AbstractPage;
import pageUI.LoginPageUI;

public class LoginPageObject extends AbstractPage{
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		System.out.println("--------------Driver at Login Page--------------");
		System.out.print(driver.toString());
		this.driver = driver;
	}
	
	public String getLoginUrl() {
		return getCurrentPageUrl(driver);
	}
	
	public void openrLoginUrl() {
		openUrl(driver,LoginPageUI.URL_LOGIN);
	}
	
	public void inputToUserIDTextbox(String userID) {
		waitToElementVisible(driver, LoginPageUI.USER_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.USER_TEXTBOX, userID);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public void clickToLoginButton() {
		waitToElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}
	
}
