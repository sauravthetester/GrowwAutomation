package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePOM {
	
	public static String searchBoxLocator = "//input[@placeholder='What are you looking for today?']";
	
	public WebElement searchBox(WebDriver driver)
	{
		return driver.findElement(By.xpath(searchBoxLocator));
	}
}
