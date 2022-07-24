package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends AbstractPage{

	WebDriver driver; 
	String linkLogin = "https://demo.guru99.com/v4/";
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//tạo ra sự liên kết value trong findBy  với biến WebElement
	}
	
	@FindBy(xpath = "https://demo.guru99.com/v4/")
	private WebElement urlLogin;
	
	@FindBy(xpath = "//input[@name='uid']")
	private WebElement userTextbox;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTextbox;

	@FindBy(xpath = "//input[@name='btnLogin']")
	private WebElement loginButton;

	@FindBy(xpath = "//input[@name='btnReset']")
	private WebElement resetButton;


	public void openrLoginUrl() {
		openUrl(driver,linkLogin);
	}
	
	public void inputToUserIDTextbox(String userID) {
		waitToElementVisible(driver, userTextbox);
		sendKeysToElement(driver, userTextbox, userID);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, passwordTextbox);
		sendKeysToElement(driver, passwordTextbox, password);
	}
	
	public void clickToLoginButton() {
		waitToElementVisible(driver, loginButton);
		clickToElement(driver, loginButton);
	}
}
