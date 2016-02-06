import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MyFirstPageFactory {
	public String sURL="http://107.170.213.234/catalog/index.php";
	public WebDriver driver;
	
	@FindBy(how = How.NAME, using ="email_address")
	private WebElement emailid;
	
	@FindBy(name="email_address")
	private WebElement UserName;
	
	@FindBy(how = How.NAME, using ="password")
	private WebElement pwd;
	
	@FindBy(how = How.XPATH, using ="//*[@id='bodyContent']/div/div[1]/a[1]/u")
	private WebElement LogYourSelfLink;

	@FindBy(how = How.XPATH, using ="//*[@id='tdb5']")
	private WebElement loginButton;
	
	@FindBy(how = How.XPATH, using ="//*[@id='tdb4']/span")
	private WebElement LogOff;
	
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
		PageFactory.initElements(driver, this);
		LogYourSelfLink.click();
		System.out.println("Clicking the log yourself link");	
		emailid.sendKeys("ecalix@test.com");
		System.out.println("entering username=ecalix@test.com");
		pwd.sendKeys("test123");
		System.out.println("entering PWD=test123");
		loginButton.click();
		System.out.println("Sign IN Button Clicked");
		verifyText("Welcome to iBusiness");
		LogOff.click();
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

