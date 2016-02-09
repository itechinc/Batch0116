package com.ecalix.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ecalix.common.*;


import org.apache.log4j.*;

public class AccountLoginPages{

	private Logger logger= Logger.getLogger(AccountLoginPages.class);

	@FindBy(how = How.NAME, using ="email_address")
	private WebElement username;
		
	
	@FindBy(how = How.NAME, using ="password")
	private WebElement password;
	

	@FindBy(how = How.XPATH, using ="//*[@id='tdb4']/span[2]")
	private WebElement loginButton;
	
	private WebDriver driver;
	private CommonMethods CF;

	
	public AccountLoginPages(WebDriver driver) {
		this.driver = driver;
		CF = new CommonMethods();
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger.info("Loading Account Login page..."); 
		PageFactory.initElements(this.driver, this);
		Assert.assertEquals(driver.getTitle().trim(), "osCommerce Demo");
		logger.info("Account Login page found, header verified.");
	}		 
	
	
	public void enterUsername (String username) {
		this.username.clear();
		CF.setValue(this.username, username);
	}
	
	public void enterPassword(String password) {
		this.password.clear();
		CF.setValue(this.password, password);
	}
	
	public void clickLogin() {
	
		CF.click(loginButton);
	}
	 
	
	public WelcomePage LoginWithDefault(){
		enterUsername("ecalix@test.com");
		enterPassword("test123");
		clickLogin();
		return PageFactory.initElements(this.driver, WelcomePage.class);
	}

}
