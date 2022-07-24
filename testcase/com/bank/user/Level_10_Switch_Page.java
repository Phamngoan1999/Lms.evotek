package com.bank.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractTest;
import pageGeneratorManager.DepositPageObject;
import pageGeneratorManager.EditCustomerPageObject;
import pageGeneratorManager.LoginPageObject;
import pageGeneratorManager.MainPageObject;
import pageGeneratorManager.NewCustomerPageObject;
import pageGeneratorManager.RegisterPageObject;

public class Level_10_Switch_Page extends AbstractTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String idUser, passwordUser;
	String url = "https://demo.guru99.com/v4/";
	AbstractPage abstractPage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MainPageObject mainPage;
	NewCustomerPageObject newCustomerPageObject;
	DepositPageObject depositPageObject;
	EditCustomerPageObject editCustomerPageObject;
	
	@Parameters({ "browser" })
	@BeforeTest
	public void beforeTest(String browerName) {
		System.out.println("Brower name =" + browerName);
		driver = getBrowerDriver(browerName);
		registerPage = new RegisterPageObject(driver);
	}

	@Test
	public void TC_01_Register_To_System() {
		System.out.println("Register - Step 01:Input Email textbox");
		registerPage.inputToEmailTextbox("automation@gmail.com");

		System.out.println("Register - Step 02: Given mail");
		registerPage.clickToSubmitButton();

		System.out.println("Register - Step 03: Get IdUser/Password information");
		idUser = registerPage.getUserIDText();
		passwordUser = registerPage.getPassWordText();
	}

	@Test
	public void TC_02_Login_To_System() {
		System.out.println("New customer - Step 01: Open new customer page");
		mainPage.clickLinkNewCustomer();

		newCustomerPageObject = new NewCustomerPageObject(driver);
		System.out.println("New customer - Step 03: Input to Username/ Password textbox");
		newCustomerPageObject.inputToCustomerNameTextbox("sdasdasas");

		System.out.println("New customer - Step 04: Input to Birthday textbox");
		newCustomerPageObject.inputToDateOfBirthTextbox("01/01/1999");

		System.out.println("New customer - Step 05: Input to Address textbox");
		newCustomerPageObject.inputToAddressTextbox("Thaibinh");

		System.out.println("New customer - Step 06: Input to City textbox");
		newCustomerPageObject.inputToCityTextbox("Thaibinh");

		System.out.println("New customer - Step 07: Input to State textbox");
		newCustomerPageObject.inputToStateTextbox("Thái Bình");

		System.out.println("New customer - Step 08: Input to Pin textbox");
		newCustomerPageObject.inputToPinTextbox("01011999");

		System.out.println("New customer - Step 09: Input to Mobile textbox");
		newCustomerPageObject.inputToMobileNumberTextbox("0339845495");

		System.out.println("New customer - Step 10: Input to Email textbox");
		newCustomerPageObject.inputToEmailNumberTextbox("phngoan1999@gmail.com");

		System.out.println("New customer - Step 11: Input to Password textbox");
		newCustomerPageObject.inputToPasswordTextbox("123456");

		System.out.println("New customer - Step 12: Click Button new customer");
		newCustomerPageObject.clickToNewCustomerButton();

		System.out.println("New customer - Step 13: Verify message success");
		newCustomerPageObject.getMessageSuccessInfor();
	}

	@Test
	public void TC_03_Navigate_To_Other_Page() {
		// Main Page -> New Customer
		newCustomerPageObject = mainPage.clickToNewCustomer();
		
		//New Customer -> Deposit
		depositPageObject = newCustomerPageObject.clickToDepositPageObject();
				
		// Deposit ->Edit Customer
		editCustomerPageObject = depositPageObject.clickToDepositPageObject();
		
	}
	
	@Test
	public void TC_04_Log_Out_To_System() {
		System.out.println("Log out - Step 1: Click log out");
		editCustomerPageObject.clickLogOut();

		System.out.println("Log out - Step 1: Verify log out success");
		editCustomerPageObject.getMessageLogoutSuccess();
	}

//	@AfterTest
//	public void afterTest() {
//		driver.quit();
//	}
}
