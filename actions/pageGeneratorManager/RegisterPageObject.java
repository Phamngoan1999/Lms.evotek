package pageGeneratorManager;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.RegisterPageUI;

public class RegisterPageObject extends AbstractPage{
	
	WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println("--------------Driver at register Page--------------");
		System.out.print(driver.toString());
	}
	
	public LoginPageObject openLoginPage(WebDriver driver,String loginPageUrl) {
		openUrl(driver, loginPageUrl);
		return new LoginPageObject(driver);
	}
	
	public void inputToEmailTextbox(String emailValue) {
		waitToElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailValue);
	}
	
	public void clickToSubmitButton() {
		waitToElementVisible(driver, RegisterPageUI.BTN_LOGIN);
		clickToElement(driver, RegisterPageUI.BTN_LOGIN);
	}
	
	public String getUserIDText() {
		waitToElementVisible(driver, RegisterPageUI.USER_LOGIN);
		return getELementText(driver, RegisterPageUI.USER_LOGIN);
	}

	public String getPassWordText() {
		waitToElementVisible(driver, RegisterPageUI.PASSWORD_LOGIN);
		return getELementText(driver, RegisterPageUI.PASSWORD_LOGIN);
	}
	
}
