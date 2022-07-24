package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageObject extends AbstractPage {
	
	WebDriver driver; 
	String linkLogin = "https://demo.guru99.com/v4/";
	
	public MainPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//tạo ra sự liên kết value trong findBy  với biến WebElement
	}
	
	@FindBy(xpath = "//marquee[@class='heading3']")
	private WebElement messageWebcome;

	@FindBy(xpath = "//a[text()='New Customer']")
	private WebElement linkNewCustomer;

	@FindBy(xpath = "//a[text()='Log out']")
	private WebElement linkLogOut;
	
	public String getMessageWelcome() {
		return getELementText( driver, messageWebcome);
	}
	
	public void clickLinkNewCustomer() {
		waitToElementVisible(driver, linkNewCustomer);
		clickToElement(driver, linkNewCustomer);
	}

	public void clickLogOut() {
		waitToElementVisible(driver, linkLogOut);
		clickToElement(driver, linkLogOut);
	}
	
}
