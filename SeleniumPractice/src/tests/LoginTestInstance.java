package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.common;

public class LoginTestInstance{
	public common CM;
	
	@BeforeMethod
	public void setUp(){
	CM =new common();
      CM.openBrowser();
      CM.openURL();
	}
	
	@AfterMethod
	public void tearDown(){
       CM.closeBrowser();
		
	}
	
	@Test
	public void Login01(){
	  CM.clickLogYourSelf();
	  CM.login("ecalix@test.com","test123");
      String ExpectedText="Welcome to iBusiness";
      CM.verifyText(ExpectedText);
      CM.clickLogOff();
	}
	
	@Test
	public void Login02(){
		  CM.clickLogYourSelf();
		  CM.login("","");
	      String ExpectedText="Error: No match for E-Mail Address and/or Password.";
	      CM.verifyText(ExpectedText);
	      CM.clickLogOff();
	}

}
