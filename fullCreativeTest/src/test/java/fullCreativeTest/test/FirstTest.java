package fullCreativeTest.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import fullCreativeTest.PageObject.CanvasWeb;
import fullCreativeTest.base.TestBaseSetup;

public class FirstTest extends TestBaseSetup{

	
//	@Test
//	public void canvasTest() throws InterruptedException {
//		CanvasWeb canvasPage = new CanvasWeb(driver);
//		canvasPage.load()
//			.drawLine(200, 200, 400, 200)
//			.drawLine(300, 100, 300, 300)
//			.drawRectangle(100, 400, 200, 50)
//			.erase(200, 200, 400, 200);
		
		
//		Thread.sleep(5000);
//	}
//	
//	1->2
//	6->2
//	4->1
	
	
//	public static Map<Integer, Integer> occur(int[] arr) {
//		
//		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//		1,1,6,2,4,5,2,6
//		for (int i = 0; i < arr.length; i++) {
//			if(map.containsKey(arr[i]))
//				map.put(arr[i], map.get(arr[i])+1);
//			else
//				map.put(arr[i], 1);
//		}
//		
//		return map;
//		
//	}
	
	
	public static int[] rearrange(int[] i) {
//		i/p -> 0,0,1,0,1,1,1,0

		int zeroesCounter = 0;
		int onesCounter = 0;
		
		for (int j = 0; j < i.length; j++) {
			if(i[j] == 0)
				zeroesCounter++;
				else
				onesCounter++;
		}
		
		int[] rearrangedArray = new int[i.length];
		int currentIndex = 0;
		while (zeroesCounter>0) {
			rearrangedArray[currentIndex]=0;
			currentIndex++;
			zeroesCounter--;
		}
		while (onesCounter>0) {
			rearrangedArray[currentIndex]=1;
			currentIndex++;
			onesCounter--;
		}
		
		return rearrangedArray;
	}
	
	public static void main(String[] args) {
		
//		i/p -> 0,0,1,0,1,1,1,0
//		o/p -> 0,0,0,0,1,1,1,1
		
		int[] arr = {0,0,1,0,1,1,1,0};
		System.out.println(Arrays.toString(rearrange(arr)));
		
		
	}
	
}
