package com.bank.user;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Level_01_Repeat_Yourself {

	   WebDriver driver;
	   String  projectPath = System.getProperty("user.dir");
	   String idUser, passwordUser;
	   String url = "https://demo.guru99.com/v4/";
   
	  @BeforeTest
	  public void beforeTest(){
		  	System.setProperty("webdriver.gecko.driver", projectPath + "/browerDriver/geckodriver.exe");
			driver = new FirefoxDriver();	
			driver.get("https://demo.guru99.com");
			driver.manage().window().maximize();
	  }
  
	  @Test
	  public void TC_01_Register_To_System() {
			driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("automation@gmail.com");
			driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
			idUser = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
			System.out.println(idUser);
	        passwordUser = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
			System.out.println(passwordUser);
	  }
	  
	  @Test
	  public void TC_02_Login_To_System() {
		  driver.get("https://demo.guru99.com/v4/");
		  driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(idUser);
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passwordUser);
		  driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		  Assert.assertEquals(driver.findElement(By.xpath("//marquee[@class='heading3']")).getText(), "Welcome To Manager's Page of Guru99 Bank");
	  }
	  
	  @AfterTest
	  public void afterTest() {
		  driver.quit();
	  }

}
