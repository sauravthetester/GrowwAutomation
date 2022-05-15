package test;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.GrowwBase;
import pom.HomePOM;
import pom.MainPOM;
import pom.UtilModules;

public class Buy extends GrowwBase
{
	GrowwBase base;
	MainPOM mainPOM;
	HomePOM homePOM;
	UtilModules util;
	
	@BeforeTest
	public void setUp()
	{
		base = new GrowwBase();
		mainPOM = new MainPOM();
		util = new UtilModules();
		base.initialize();
		base.cleanUp();
	}
	
	@Test(priority=1)
	void loginToGroww()
	{
		util.waitForElementClickable(driver, MainPOM.loginBtnLocator);
		mainPOM.loginBtn(driver).click();
		util.waitForElementClickable(driver, MainPOM.emailTextboxLocator);
		
		CharSequence emailId = prop.get("emailAddress").toString();
		mainPOM.emailTextbox(driver).sendKeys(emailId);
		
		util.waitForElementClickable(driver, MainPOM.continueBtnLocator);
		mainPOM.continueBtn(driver).click();
		util.waitForElementClickable(driver, MainPOM.passwordTextboxLocator);
		
		CharSequence password = prop.get("password").toString();
		mainPOM.passwordTextbox(driver).sendKeys(password);
		
		util.waitForElementClickable(driver, MainPOM.submitBtnLocator);
		mainPOM.submitBtn(driver).click();
		
		util.waitForElementClickable(driver, MainPOM.pinInputLocatorValue);
		int[] pinValues = util.getPIN(4);
		String[] pinInputLocators = mainPOM.pinInputLocators(driver, 4);
		util.enterPIN(driver,pinValues,pinInputLocators);
	}
	
	@Test(priority=2)
	void gotoStock()
	{
		util.waitForElementClickable(driver, HomePOM.searchBoxLocator);
		homePOM.searchBox(driver).click();
	}

}
