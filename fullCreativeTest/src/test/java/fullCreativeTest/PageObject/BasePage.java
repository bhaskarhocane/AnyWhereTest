package fullCreativeTest.PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import fullCreativeTest.base.TestBaseSetup;

public class BasePage extends TestBaseSetup {

	WebDriver driver;
	
	
	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
	}


	public BasePage executeJS(String script) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(script);
		return new BasePage(driver);
	}
	
	
}
