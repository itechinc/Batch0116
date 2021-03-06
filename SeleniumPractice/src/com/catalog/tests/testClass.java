package com.catalog.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.catalog.common.common;
import com.catalog.pages.SignInPage;
import com.catalog.pages.WelcomePage;


public class testClass {
	public common CM;
	public SignInPage SignIn;
	public WelcomePage Welcome;
	private WebDriver driver;
	
	@BeforeSuite
	public void setUp(){
	   CM =new common(driver);
      driver=CM.openBrowser();
      CM.openURL();
	
	}
	
	@AfterSuite
	public void tearDown(){
       CM.closeBrowser();
		
	}

}
