package mPocket;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Utils {
	static WebDriver driver;
	public static WebElement element = null;
	
		
	public static void scrollWin(){
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		 jse.executeScript("window.scrollBy(0,500)");
		
	}

	
	public static void waitFewSec() {		
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}
}
