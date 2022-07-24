package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends AbstractPage {
	
	WebDriver driver; 
	String linkLogin = "https://demo.guru99.com/v4/";
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//tạo ra sự liên kết value trong findBy  với biến WebElement
	}
	
	@FindBy(xpath = "//input[@name='emailid']")
	private WebElement emailLogin;

	@FindBy(xpath = "//input[@name='btnLogin']")
	private WebElement btnLogin;

	@FindBy(xpath = "//td[text()='User ID :']/following-sibling::td")
	private WebElement userLogin;

	@FindBy(xpath = "//td[text()='Password :']/following-sibling::td")
	private WebElement passwordLogin;
	
	public void openrLoginUrl() {
		openUrl(driver,linkLogin);
	}

	public void inputToEmailTextbox(String emailValue) {
		waitToElementVisible(driver, emailLogin);
		sendKeysToElement(driver, emailLogin, emailValue);
	}
	
	public void clickToSubmitButton() {
		waitToElementVisible(driver, btnLogin);
		clickToElement(driver, btnLogin);
	}
	
	public String getUserIDText() {
		waitToElementVisible(driver, userLogin);
		return getELementText(driver, userLogin);
	}

	public String getPassWordText() {
		waitToElementVisible(driver, passwordLogin);
		return getELementText(driver, passwordLogin);
	}
	
	public void openLoginPage(WebDriver driver,String loginPageUrl) {
		openUrl(driver, loginPageUrl);
	}
}
