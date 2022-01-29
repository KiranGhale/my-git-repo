package mPocket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjects {
	public static WebElement element = null;
	
	public static WebElement searchBox(WebDriver driver, String searchItem) {
		element = driver.findElement(By.name("field-keywords"));
		element.sendKeys(searchItem);
		return element;
	}

	public static void clickSearch(WebDriver driver) {
		element = driver.findElement(By.id("nav-search-submit-button"));
		element.click();
	}
	

}
