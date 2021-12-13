package fullCreativeTest.PageObject;

import java.time.LocalDate;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.helpers.FormattingTuple;

import com.github.dockerjava.api.model.Driver;

public class DatePageWeb extends BasePage {

	private By dateCalender = By.id("datePickerMonthYearInput");
	private By dateCalenderMonthDropdown = By.className("react-datepicker__month-select");
	private By dateCalenderYearDropdown = By.className("react-datepicker__year-select");
	private By dateAndTimeCalender = By.id("dateAndTimePickerInput");
	private By dateAndTimeCalenderMonthDropdown = By.className("react-datepicker__month-read-view--selected-month");
	private By dateAndTimeCalenderYearDropdown = By.className("react-datepicker__year-read-view--selected-year");
	
	
	public DatePageWeb(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public DatePageWeb load() {
		driver.get("https://demoqa.com/date-picker");
		return this;
	}
	
	public DatePageWeb clickOnDateCalender(){
		waitAndFindElement(dateCalender).click();
		return this;
	}
	
	public DatePageWeb SetDate(String date) {
		
		LocalDate date1 = LocalDate.parse(date);
		
		SelectFromDropDownByValue(waitAndFindElement(dateCalenderMonthDropdown), Integer.toString(date1.getMonthValue()-1));
		SelectFromDropDownByValue(waitAndFindElement(dateCalenderYearDropdown), Integer.toString(date1.getYear()));
		String day = date1.getMonth().toString().substring(1).toLowerCase() +" " +date1.getDayOfMonth();
		waitAndFindElement(By.xpath("//*[contains(@class,'react-datepicker__day react-datepicker__day') and contains(@aria-label,'"+day+"')]")).click();
		return this;
		
	}
	
	
	/**
	 * @param date eg yyyy-mm-dd
	 * @param time eg 01:30 PM
	 * @return
	 */
	public DatePageWeb setDateAndTime(String date, String time) {
		
		LocalDate date1 = LocalDate.parse(date);
		waitAndFindElement(dateAndTimeCalender).click();
		if(!waitAndFindElement(dateAndTimeCalenderMonthDropdown).getText().contains(date1.getMonth().toString().substring(1).toLowerCase())) {
			waitAndFindElement(dateAndTimeCalenderMonthDropdown).click();
			waitAndFindElement(By.xpath("//*[@class='react-datepicker__month-option' and contains(text(),'"+date1.getMonth().toString().substring(1).toLowerCase()+"')]")).click();
		}
		if(!waitAndFindElement(dateAndTimeCalenderYearDropdown).getText().equals(Integer.toString(date1.getYear()))) {
			waitAndFindElement(dateAndTimeCalenderYearDropdown).click();
			waitAndFindElement(By.xpath("//*[@class='react-datepicker__year-option' and text()='"+date1.getYear()+"']")).click();
		}
		
		String day = date1.getMonth().toString().substring(1).toLowerCase() +" " +date1.getDayOfMonth();
		waitAndFindElement(By.xpath("//*[contains(@aria-label,'"+day+"')]")).click();
	
		waitAndFindElement(By.xpath("//*[@class='react-datepicker__time-list-item ' and text()='"+formatTime(time)+"']")).click();
		
		return this;
	}
	
	
	
}
