package com.catalog.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.catalog.common.common;

public class SignInPage  {
   public common CM;
	private WebDriver driver;
  
	public SignInPage(WebDriver driver){
		this.driver = driver;
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
   
	public void login(String Usetrname, String PWD){
//	  CM=new common();
//	  CM.setValueByName("email_address",Usetrname);
//	  CM.setValueByName("password", PWD);
//	  CM.clickByXapth("//*[@id='tdb5']/span[2]");
		driver.findElement(By.name("email_address")).sendKeys(Usetrname);
		System.out.println("entering username="+Usetrname);
		driver.findElement(By.name("password")).sendKeys(PWD);
		System.out.println("entering PWD="+PWD);
		driver.findElement(By.id("tdb5")).click();
		System.out.println("Sign IN Button Clicked");
		
	}
	
}
