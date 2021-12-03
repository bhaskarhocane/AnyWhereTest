package fullCreativeTest.PageObject;

import org.openqa.selenium.WebDriver;

public class CanvasWeb extends BasePage {

	public CanvasWeb(WebDriver driver) {
		super(driver);

	}

	public CanvasWeb load() {
		driver.get("http://www.htmlcanvasstudio.com/");
		return new CanvasWeb(driver);
	}

	public CanvasWeb drawLine(int startX, int startY, int endX, int endY) {
		String script = "var context = document.getElementById('imageView').getContext('2d');" + 
				"context.strokeStyle = '#000000';" + 
				"context.beginPath();" + 
				"context.moveTo("+startX+", "+startY+");" + 
				"context.lineTo("+endX+", "+endY+");" + 
				"context.stroke();" + 
				"context.closePath();";
				executeJS(script);
		return new CanvasWeb(driver);
	}
	
	public CanvasWeb drawRectangle(int startX, int startY, int endX, int endY) {
		String script = "var context = document.getElementById('imageView').getContext('2d');" + 
				"context.strokeStyle = '#000000';" + 
				"context.strokeRect("+startX+", "+startY+", "+endX+", "+endY+");";
				executeJS(script);
		return new CanvasWeb(driver);
	}
	
	public CanvasWeb erase(int startX, int startY, int endX, int endY) {
		StringBuilder script = new StringBuilder();
				script.append("var context = document.getElementById('imageView').getContext('2d');")
				.append("context.strokeStyle = '#FFFFFF';")
				.append("context.beginPath();")
				.append("context.moveTo("+startX+", "+startY+");");
			
				while(startX<endX) {
				 script.append("context.lineTo("+startX+", "+endY+");"); 
				 script.append("context.stroke();"); 
				 startX++;
				}
				executeJS(script.toString());
			
				
		return new CanvasWeb(driver);
	}

}
