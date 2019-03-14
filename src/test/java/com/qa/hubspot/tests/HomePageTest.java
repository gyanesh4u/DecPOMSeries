package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;

public class HomePageTest 
{
	BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;
	@BeforeMethod
	public void setup()
	{
		basePage=new BasePage();
		prop=basePage.init_properties();
		String browser=prop.getProperty("browser");
		driver=basePage.init_driver(browser);	
		driver.get(prop.getProperty("url"));
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test
	public void verifyHomePageTitleTest()
	{
		String title = homePage.getHomePageTitle();
		System.out.println("home page title is"+title);
		Assert.assertEquals(title,"Reports dashboard");
	}
	
	public void verifyHomePageHeaderTest()
	{
		Assert.assertTrue(homePage.verifyHomePageHeader());
	}
		
}
