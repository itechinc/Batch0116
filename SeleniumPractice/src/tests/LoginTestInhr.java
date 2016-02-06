package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.common;

public class LoginTestInhr extends common{
	
	@BeforeMethod
	public void setUp(){
      openBrowser();
      openURL();
	}
	
	@AfterMethod
	public void tearDown(){
       closeBrowser();
		
	}
	
	@Test
	public void Login01(){
	  clickLogYourSelf();
	  login("ecalix@test.com","test123");
      String ExpectedText="Welcome to iBusiness";
      verifyText(ExpectedText);
      clickLogOff();
	}
	
	@Test
	public void Login02(){
		  clickLogYourSelf();
		  login("","");
	      String ExpectedText="Error: No match for E-Mail Address and/or Password.";
	      verifyText(ExpectedText);
	      clickLogOff();
	}

}
