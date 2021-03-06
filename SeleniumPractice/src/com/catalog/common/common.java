package com.catalog.common;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class common {
	
	public String sURL="http://107.170.213.234/catalog/index.php";
	private WebDriver driver;
	
	public common(WebDriver driver){
		this.driver = driver;
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	

	public WebDriver openBrowser(){
		driver=new FirefoxDriver();
		System.out.println("Opening Firefox Browser");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 return driver;
	}
	
	public void openURL(){
		driver.get(sURL);
		System.out.println("URL is opened");

	}
	
	public void closeBrowser(){
		driver.quit();
		System.out.println("Browser is closed");
	}
	
	 public void verifyText(String expected){
		 try{
			 driver.findElement(By.xpath("//*[contains(text(),'"+ expected.trim() +"')]"));
			 System.out.println("On page " + driver.getTitle() + ". Expected Text \""+ expected +"\" verified");
			// return true;
		 }
		 catch(NoSuchElementException e){
			 System.out.println("On page " + driver.getTitle() + ". Expected Text \""+ expected +"\" not found");
			 Assert.fail("On page " + driver.getTitle() + ". Expected Text \""+ expected +"\" not found");
		 }
		 
	 }
	 
	 public void clickByXapth(String elementname){
	   driver.findElement(By.xpath(elementname)).click();
	 }
	 
	 public void setValueByName(String elementname, String sValue){
		 try{
			 driver.findElement(By.name(elementname)).sendKeys(sValue);
			 System.out.println("On page " + driver.getTitle() + ". Expected value \""+ sValue +"\" entered");
		 }catch(NoSuchElementException e){
			 System.out.println("On page " + driver.getTitle() + ". Expected element \""+ elementname +"\" not found");
			 Assert.fail("On page " + driver.getTitle() + ". Expected element \""+ elementname +"\" not found");
		 }
	 }
	 
		@BeforeSuite
		public void setUp(){
		openBrowser();
	     openURL();
		
		}
		
		@AfterSuite
		public void tearDown(){
	       closeBrowser();
			
		}
	
}
