package com.ecalix.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.ecalix.common.CommonMethods;


public class LoginPage  {
    @FindBy(how = How.NAME, using = "email_address")
    private WebElement EMAILADDRESS;
   
    @FindBy(how = How.NAME, using = "password")
    private WebElement PASSWORD;
    
    @FindBy(how = How.XPATH, using = "//*[@id='tdb5']/span[1]")
    private WebElement SIGNIN;
    
    @FindBy(how = How.XPATH, using = "//*[@id='bodyContent']/div/div[1]/a[1]/u")
    private WebElement LOGYOURSELFIN;
    
    @FindBy(how = How.XPATH, using = "//*[@id='tdb4']/span")
    private WebElement LOGOFF;
    CommonMethods CM;
    
    
	public void enterUserName(String username){
		CM=new CommonMethods();
		CM.setValue(EMAILADDRESS, username);	
		
	}
	
	public void enterPassword(String password){
		CM=new CommonMethods();
		CM.setValue(PASSWORD, password);	
	}
	
	public void clickSignInButton(){	   
		//SIGNIN.click();
		CM.click(SIGNIN);
		System.out.println("Sign In Clicked");
	}
	
	public WelcometTOiBusiness validLogin(){
		enterUserName("ecalis@test.com");
		enterPassword("test123");
		clickSignInButton();
		return new WelcometTOiBusiness();
	}
	
	public void clikLogYourSelfIn(){
		CM.click(LOGYOURSELFIN);

		//LOGYOURSELFIN.click();
		//Assert.assertTrue(IsTextPresent("Welcome, Please Sign In"));
	}
	public void clickLogOff(){
		  LOGOFF.click();
	}
  
	

}
