package com.ecalix.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecalix.common.CommonMethods;
import com.ecalix.pageobjects.AccountLoginPages;
import com.ecalix.pageobjects.WelcomePage;


public class AccountLoginTests {
	private WebDriver driver;
	private CommonMethods CF;
	
	@Parameters({ "remoteBrowserType"})
	@BeforeClass(alwaysRun=true)
	public void setup(String remoteBrowserType) throws Exception {
		CF = new CommonMethods();
		driver = CF.openBrowser(remoteBrowserType);
	
	}
	
	@Parameters({ "remoteBrowserType"})
	@BeforeMethod(alwaysRun=true)
	public void navigate(String remoteBrowserType) throws Exception {
		CF.navigateToSite(remoteBrowserType);
		driver = CF.getDriver();
	
	}
	
	@AfterMethod(alwaysRun=true) 
	public void after(ITestResult it) throws Exception{
		//it.setThrowable(new Throwable("Error capture: blah blah. \n" + "System error: " + it.getThrowable().getMessage()));
		CF.postResults(it);
	    driver.manage().deleteAllCookies(); 
		CF.tearDown();
	}	
	

	@Test
	public void testLogin01(){
		WelcomePage WelcomePage = new WelcomePage(driver);
		WelcomePage.clickLogYourself();
		//WelcomePage.clickLogYourself();
		AccountLoginPages loginPage = new AccountLoginPages(driver);
		loginPage.LoginWithDefault();
		LoginTest LT=new LoginTest(driver);
		driver.switchTo().window("alert");
		CF.verifyText("first name");
		driver.close();
		driver.switchTo().defaultContent();

	}

}
