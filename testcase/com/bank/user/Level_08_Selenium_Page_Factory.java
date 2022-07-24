package com.bank.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageFactory.LoginPageObject;
import pageFactory.MainPageObject;
import pageFactory.RegisterPageObject;

public class Level_08_Selenium_Page_Factory extends AbstractTest{

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String idUser, passwordUser;
	String url = "https://demo.guru99.com/v4/";
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MainPageObject mainPage;
	
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
		System.out.println("Login - Step 01: Open login page");
		loginPage = new LoginPageObject(driver);
		loginPage.openrLoginUrl();

		System.out.println("Login - Step 02: Input to Username/ Password textbox");
		loginPage.inputToUserIDTextbox(idUser);
		loginPage.inputToPasswordTextbox(passwordUser);

		System.out.println("Login - Step 03: Click button login");
		loginPage.clickToLoginButton();
		mainPage = new MainPageObject(driver);

		System.out.println("Login - Step 04: Verify screen login");
		Assert.assertEquals(mainPage.getMessageWelcome(), "Welcome To Manager's Page of Guru99 Bank");
	}


	@Test
	public void TC_04_Log_Out_To_System() {
		System.out.println("Log out - Step 1: Click log out");
		mainPage.clickLogOut();

//		System.out.println("Log out - Step 1: Verify log out success");
//		mainPage.getMessageLogoutSuccess();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
