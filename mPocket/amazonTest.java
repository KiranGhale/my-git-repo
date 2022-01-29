package mPocket;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.awt.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class amazonTest {

	static WebDriver driver;
	String url;

	@Test
	public void searchItem() {

		driver.get(url);// Opening Amazon URL
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("field-keywords")).sendKeys("Running Shoe for men");// Sending item to search in
																						// search box
		// PageObjects.searchBox(driver, "Running Shoe for men");
		driver.findElement(By.id("nav-search-submit-button")).click();// Clicking search button
		// PageObjects.clickSearch(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Utils.waitFewSec();
		// Utils.scrollWin();
		// Scrolling window down to bring item in view
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");
		String WH1 = driver.getWindowHandle();// Saving Parent WindowHandler

		// Selecting item
		driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal'][1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Switching window from parent to new window

		Set<String> WHs = driver.getWindowHandles();
		System.out.println("All Window handles: " + WHs);
		for (String i : WHs) {
			driver.switchTo().window(i);
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//Adding item to cart
		driver.findElement(By.name("submit.add-to-cart")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("nav-cart-count-container")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String TotalPrice = driver.findElement(By.xpath("//span[@class='currencyINR'][1]")).getText();
//Printing the Current cart value
		System.out.println("Total Price is: " + TotalPrice);

//Switching back to parent window
		driver.switchTo().window(WH1);

	}


	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
		url = "https://www.amazon.in/";

	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}
