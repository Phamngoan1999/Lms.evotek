package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTestThread {
	public enum Brower{
		CHROME, FIREFOX;
	}

	public static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
	
	protected WebDriver getBrowerDriver(String browerName) {
		Brower brower = Brower.valueOf(browerName.toUpperCase());
		switch (brower) {
			case FIREFOX: {
				WebDriverManager.firefoxdriver().setup();
				threadDriver.set(new FirefoxDriver());
				break;
			}
			case CHROME: {
				WebDriverManager.chromedriver().setup();
				threadDriver.set(new ChromeDriver());
				break;
			}
			default:
				throw new RuntimeException("Name browser not found");
		}
		threadDriver.get().get("https://demo.guru99.com");
		threadDriver.get().manage().window().maximize();
		return threadDriver.get();
	}
	
	protected void removeBrowerDriver() {
		threadDriver.get().quit();
		threadDriver.remove();
	}
}
