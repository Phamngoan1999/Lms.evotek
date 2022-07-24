package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.AbstractPage;
import pageUI.NewCustomerPageUI;

public class NewCustomerPageObject extends AbstractPage{

	WebDriver driver;
	
	public NewCustomerPageObject(WebDriver driver) {
		System.out.println("--------------Driver at New customer Page--------------");
		System.out.print(driver.toString());
		this.driver = driver;
	}

	public void inputToCustomerNameTextbox(String nameCustomer) {
		waitToElementVisible(driver, NewCustomerPageUI.NAME_TEXTBOX);
		sendKeysToElement(driver, NewCustomerPageUI.NAME_TEXTBOX, nameCustomer);
	}

	public void inputToDateOfBirthTextbox(String birthDayCustomer) {
		waitToElementVisible(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX);
		sendKeysToElement(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX, birthDayCustomer);
	}

	public void inputToAddressTextbox(String addressCustomer) {
		waitToElementVisible(driver, NewCustomerPageUI.ADDREESS_TEXTAREA);
		sendKeysToElement(driver, NewCustomerPageUI.ADDREESS_TEXTAREA, addressCustomer);
	}

	public void inputToCityTextbox(String cityCustomer) {
		waitToElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
		sendKeysToElement(driver, NewCustomerPageUI.CITY_TEXTBOX, cityCustomer);
	}

	public void inputToStateTextbox(String stateCustomer) {
		waitToElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
		sendKeysToElement(driver, NewCustomerPageUI.STATE_TEXTBOX, stateCustomer);
	}

	public void inputToPinTextbox(String pinCustomer) {
		waitToElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
		sendKeysToElement(driver, NewCustomerPageUI.PIN_TEXTBOX, pinCustomer);
	}

	public void inputToMobileNumberTextbox(String mobileNumberCustomer) {
		waitToElementVisible(driver, NewCustomerPageUI.PHOND_TEXTBOX);
		sendKeysToElement(driver, NewCustomerPageUI.PHOND_TEXTBOX, mobileNumberCustomer);
	}

	public void inputToEmailNumberTextbox(String emailCustomer) {
		waitToElementVisible(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX, emailCustomer);
	}

	public void inputToPasswordTextbox(String passwordCustomer) {
		waitToElementVisible(driver, NewCustomerPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, NewCustomerPageUI.PASSWORD_TEXTBOX, passwordCustomer);
	}

	public void clickToNewCustomerButton() {
		waitToElementVisible(driver, NewCustomerPageUI.SUBMIT_TEXTBOX);
		clickToElement(driver, NewCustomerPageUI.SUBMIT_TEXTBOX);
	}
	
	public void getMessageSuccessInfor() {
		String successMessage = getTextInAlert(driver);
		Assert.assertEquals(successMessage, "please fill all fields");
		acceptAlert(driver);
	}
}
