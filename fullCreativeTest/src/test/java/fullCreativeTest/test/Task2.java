package fullCreativeTest.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import fullCreativeTest.PageObject.DatePageWeb;
import fullCreativeTest.base.TestBaseSetup;

public class Task2 extends TestBaseSetup{

	@Test(description="Date Picker", enabled=false)
	public void test1() {
		
		String date1 = "2022-01-31";
		String date2 = "2020-12-07";
		DatePageWeb datePageWeb = new DatePageWeb(driver);
		datePageWeb.load()
			.clickOnDateCalender()
			.SetDate(date1);
		
		datePageWeb.setDateAndTime(date2, "01:30 PM");
		
	}
	
	@Test(description="Shadow DOM")
	public void test2() {
		
		driver.get("https://the-internet.herokuapp.com/shadowdom");
		System.out.println(driver.findElement(By.xpath("//*[@slot='my-text']")).getText());
	}
	
}

	
