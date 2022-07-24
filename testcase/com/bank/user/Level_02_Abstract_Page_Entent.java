package com.bank.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commons.AbstractPage;

public class Level_02_Abstract_Page_Entent extends AbstractPage{

	   WebDriver driver;
	   String  projectPath = System.getProperty("user.dir");
	   String idUser, passwordUser;
	   String url = "https://demo.guru99.com/v4/";
	   AbstractPage abstractPage;

	  @BeforeTest
	  public void beforeTest(){
		  	System.setProperty("webdriver.gecko.driver", projectPath + "/browerDriver/geckodriver.exe");
			driver = new FirefoxDriver();	
			openUrl( driver, "https://demo.guru99.com");
			driver.manage().window().maximize();
	  }

	  @Test
	  public void TC_01_Register_To_System() {
		  	sendKeysToElement(driver,"//input[@name='emailid']","automation@gmail.com");
		  	clickToElement(driver, "//input[@name='btnLogin']");
		  	idUser = getELementText(driver,"//td[text()='User ID :']/following-sibling::td");
		  	System.out.println(idUser);
		  	passwordUser = getELementText(driver,"//td[text()='Password :']/following-sibling::td");
		  	System.out.println(passwordUser);
	  }

	  @Test
	  public void TC_02_Register_To_System() {
		  openUrl( driver, "https://demo.guru99.com/v4/");
		  sendKeysToElement(driver, "//input[@name='uid']", idUser);
		  sendKeysToElement(driver, "//input[@name='password']", passwordUser);
		  clickToElement(driver, "//input[@name='btnLogin']");
		  Assert.assertEquals(driver.findElement(By.xpath("//marquee[@class='heading3']")).getText(), "Welcome To Manager's Page of Guru99 Bank");
	  }
	  
	  @AfterTest
	  public void afterTest() {
		  driver.quit();
	  }
	  
}
