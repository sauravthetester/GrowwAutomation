package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class MainPOM {
	
	
	public static String loginBtnLocator = "//span[text()='Login/Register']";
	public static String emailTextboxLocator = "//input[@id='login_email1']";
	public static String passwordTextboxLocator = "//input[@id='login_password1']";
	public static String continueBtnLocator = "//span[text()='Continue']";
	public static String submitBtnLocator = "//span[text()='Submit']";
	public static String pinInputLocator = "(//input[@type='number'])[value]";
	public static String pinInputLocatorValue = "//input[@type='number']";
	
	public WebElement loginBtn(WebDriver driver)
	{
		return driver.findElement(By.xpath(loginBtnLocator));
	}
	public WebElement emailTextbox(WebDriver driver)
	{
		return driver.findElement(By.xpath(emailTextboxLocator));
	}
	public WebElement continueBtn(WebDriver driver)
	{
		return driver.findElement(By.xpath(continueBtnLocator));
	}
	public WebElement passwordTextbox(WebDriver driver)
	{
		return driver.findElement(By.xpath(passwordTextboxLocator));
	}
	public WebElement submitBtn(WebDriver driver)
	{
		return driver.findElement(By.xpath(submitBtnLocator));
	}
	public String[] pinInputLocators(WebDriver driver,int len)
	{
		String[] str = new String[len];
		for(int i=0;i<len;i++)
		{
			String num = Integer.toString(i+1);
			String xpathValue = pinInputLocator.replaceAll("value", num);
			str[i] = xpathValue;
		}
		return str;
	}
}
