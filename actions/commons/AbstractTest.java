package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractTest {
	
	public enum Brower{
		CHROME, FIREFOX;
	}
	
	// private WebDriver driver;
	protected static WebDriver driver;
	
	protected WebDriver getBrowerDriver(String browerName) {
		Brower brower = Brower.valueOf(browerName.toUpperCase());
		switch (brower) {
			case FIREFOX: {
				WebDriverManager.firefoxdriver().setup();
    			driver = new FirefoxDriver();
                break;
            }
            case CHROME: {
				WebDriverManager.chromedriver().setup();
    			driver = new ChromeDriver();
                break;
            }  
            default:
                throw new RuntimeException("Name browser not found");
		}
		driver.get("https://demo.guru99.com");
		driver.manage().window().maximize();
		return driver;
	}
}
