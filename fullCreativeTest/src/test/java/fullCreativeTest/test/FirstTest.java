package fullCreativeTest.test;

import org.testng.annotations.Test;

import fullCreativeTest.PageObject.CanvasWeb;
import fullCreativeTest.base.TestBaseSetup;

public class FirstTest extends TestBaseSetup{

	
	@Test
	public void canvasTest() throws InterruptedException {
		CanvasWeb canvasPage = new CanvasWeb(driver);
		canvasPage.load()
			.drawLine(200, 200, 400, 200)
			.drawLine(300, 100, 300, 300)
			.drawRectangle(100, 400, 200, 50)
			.erase(200, 200, 400, 200);
		
		
		Thread.sleep(5000);
	}
	
}
