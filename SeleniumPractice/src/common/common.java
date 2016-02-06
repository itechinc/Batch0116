package common;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class common {
	
	public String sURL="http://107.170.213.234/catalog/index.php";
	public WebDriver driver;
	
	public void openBrowser(){
		driver=new FirefoxDriver();
		System.out.println("Opening Firefox Browser");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
	}
	
	public void openURL(){
		driver.get(sURL);
		System.out.println("URL is opened");

	}
	
	public void closeBrowser(){
		driver.quit();
		System.out.println("Browser is closed");
	}
	
	public void login(String Usetrname, String PWD){
		driver.findElement(By.name("email_address")).sendKeys(Usetrname);
		System.out.println("entering username="+Usetrname);
		driver.findElement(By.name("password")).sendKeys(PWD);
		System.out.println("entering PWD="+PWD);
		driver.findElement(By.id("tdb5")).click();
		System.out.println("Sign IN Button Clicked");
	}
	
	public void clickLogYourSelf(){
		driver.findElement(By.xpath("//*[@id='bodyContent']/div/div[1]/a[1]/u")).click();
		System.out.println("Clicking the log yourself link");
	}
	
	public void clickLogOff(){
		driver.findElement(By.xpath("//*[@id='tdb4']/span")).click();
		System.out.println("Log Off Button Clicked");
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
	
}
