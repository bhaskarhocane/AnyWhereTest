package fullCreativeTest.PageObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import fullCreativeTest.base.TestBaseSetup;

public class BasePage extends TestBaseSetup {

	WebDriver driver;

	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement waitAndFindElement(By locator) {
		WebDriverWait extWait = new WebDriverWait(driver, Duration.ofSeconds(30));;
		return extWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public BasePage executeJS(String script) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(script);
		return new BasePage(driver);
	}

	public void SelectFromDropDownByValue(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByValue(value);

	}
	
	public String formatTime(String timeIn12HrFormat) {

		DateFormat dateFormat = new SimpleDateFormat("hh:mm aa");

		DateFormat format = new SimpleDateFormat("HH:mm");
		Date time = null;
		try {
			time = dateFormat.parse(timeIn12HrFormat);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return format.format(time);
	
	}

	
}
