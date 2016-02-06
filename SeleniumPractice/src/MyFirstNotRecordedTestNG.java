import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MyFirstNotRecordedTestNG {
	public String sURL="http://107.170.213.234/catalog/index.php";
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		driver=new FirefoxDriver();
		System.out.println("Opening Firefox Browser");
		driver.get(sURL);
		System.out.println("URL is opened");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
	//	 driver.manage().deleteAllCookies();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		System.out.println("Browser is closed");
		
	}
	
	@Test
	public void Login01(){
	
		driver.findElement(By.xpath("//*[@id='bodyContent']/div/div[1]/a[1]/u")).click();
		System.out.println("Clicking the log yourself link");	
		driver.findElement(By.name("email_address")).sendKeys("ecalix@test.com");
		System.out.println("entering username=ecalix@test.com");
		driver.findElement(By.name("password")).sendKeys("test123");
		System.out.println("entering PWD=test123");
		driver.findElement(By.id("tdb5")).click();
		System.out.println("Sign IN Button Clicked");
		String ExpectedText="Welcome to iBusiness";
		String ActualText=driver.findElement(By.xpath("//*[@id='bodyContent']/h1")).getText();
		System.out.println("ExpectedText="+ExpectedText+"\n"+"ActualText="+ActualText);
		Assert.assertEquals(ExpectedText, ActualText);
		driver.findElement(By.xpath("//*[@id='tdb4']/span")).click();
		System.out.println("Log Off Button Clicked");
	
	}
	
	@Test
	public void Login02(){
		driver.findElement(By.xpath("//*[@id='bodyContent']/div/div[1]/a[1]/u")).click();
		System.out.println("Clicking the log yourself link");	
		driver.findElement(By.id("tdb5")).click();
		System.out.println("Sign IN Button Clicked");
		String ExpectedText="Error: No match for E-Mail Address and/or Password.";
		String ActualText=driver.findElement(By.xpath("//*[@id='bodyContent']/table/tbody/tr/td")).getText();
		System.out.println("ExpectedText="+ExpectedText+"\n"+"ActualText="+ActualText);
		Assert.assertEquals(ExpectedText.trim(), ActualText.trim());	
	}
	
	
	
	
}
