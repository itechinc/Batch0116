package com.catalog.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.catalog.common.common;

public class WelcomePage  {
	public common CM;
	
	private WebDriver driver;
	  
	public WelcomePage(WebDriver driver){
		this.driver = driver;	
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	public void clickLogYourSelf(){
	
		CM=new common(driver);
//		CM.clickByXapth("//*[@id='bodyContent']/div/div[1]/a[1]/u");
		//driver.findElement(By.xpath("//*[@id='bodyContent']/div/div[1]/a[1]/u")).click();
	    CM.clickByXapth("//*[@id='bodyContent']/div/div[1]/a[1]/u");
	}
	
	public void clickLogOff(){
		driver.findElement(By.xpath("//*[@id='tdb4']/span")).click();
		//CM.clickByXapth("//*[@id='tdb4']/span");
	}


}
