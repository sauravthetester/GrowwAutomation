package pom;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.GrowwBase;

public class UtilModules 
{
	private WebDriverWait wait;
	
	public void waitForElementClickable(WebDriver driver,String xpath)
	{
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}
	public void enterText(WebElement element,String inputTextValue)
	{
		element.sendKeys(inputTextValue);
	}
	
	public int[] getPIN(int digits)
	{
		String pinStr = (String) GrowwBase.prop.get("pincode");
		int pin = Integer.parseInt(pinStr);
		
		int[] arr = new int[digits];
		
		for(int i=digits-1;i>=0;i--)
		{
			if(pin/10==0)
			{
				arr[i]=pin;
				break;
			}
			arr[i]=pin%10;
			pin=pin/10;
		}
		System.out.println("pin array: "+Arrays.toString(arr));
		return arr;
	}
	public void enterPIN(WebDriver driver, int[] pinValues, String[] xpathValues)
	{
		CharSequence[] ch = new CharSequence[pinValues.length];
		for(int i=0;i<pinValues.length;i++)
		{
			ch[i]=Integer.toString(pinValues[i]);
		}
		for(int i=0;i<xpathValues.length;i++)
		{
			driver.findElement(By.xpath(xpathValues[i])).clear();
			try {Thread.sleep(1000);} catch (InterruptedException e) {}
		}
		for(int i=0;i<xpathValues.length;i++)
		{
			System.out.println("char"+i+"  = "+ch[i]);
			driver.findElement(By.xpath(xpathValues[i])).sendKeys(ch[i]);
			try {Thread.sleep(1000);} catch (InterruptedException e) {}
		}
	}
}
