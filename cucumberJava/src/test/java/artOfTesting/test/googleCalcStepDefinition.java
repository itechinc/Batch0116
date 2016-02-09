package artOfTesting.test;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class googleCalcStepDefinition {
	
	
	protected WebDriver driver;
	
	 @Before
	    public void setup() {
	       // driver = new FirefoxDriver();
	   	 File chromedriver = new File("//Users//rameshtejavath//documents//selenium//drivers//chromedriver");
			System.setProperty("webdriver.chrome.driver", chromedriver.getAbsolutePath());
			DesiredCapabilities Capabilities = new DesiredCapabilities();
			Capabilities = DesiredCapabilities.chrome();
			Capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
			driver = new ChromeDriver(Capabilities);
			System.out.println("Chrome Browser is opened");
	}
		
	@Given("^I open Catalog$")
	public void I_open_google() {
		//Set implicit wait of 10 seconds and launch google
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://107.170.213.234/catalog/");
		System.out.println("Catalog page is opened");
	}
	
	@Given("^I open facebook.com$")
	public void I_open_facebook() {
		//Set implicit wait of 10 seconds and launch google
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		System.out.println("facebook page is opened");
	}
	
	@When("^I enter \"([^\"]*)\" in search textbox$")
	public void I_enter_in_search_textbox(String additionTerms) {
		//Write term in google textbox
		WebElement googleTextBox = driver.findElement(By.name("keywords"));
		googleTextBox.sendKeys(additionTerms);
		System.out.println("Catalog page search entered");		
		//Click on searchButton
		WebElement searchButton = driver.findElement(By.xpath("//*[@id='columnLeft']/div[3]/div[2]/form/input[4]"));
		searchButton.click();
		System.out.println("clicked on serach");
	}
	
	@When("^I enter \"([^\"]*)\" in user textbox$")
	public void I_enter_in_facebookusername_textbox() {
		driver.findElement(By.id("email")).sendKeys("");
		System.out.println("user entered");		
		driver.findElement(By.xpath("//*[@id='u_0_n']")).click();
		System.out.println("clicked button");
	}
	
	@Then("^I should get result as \"([^\"]*)\"$")
	public void I_should_get_correct_result(String expectedResult) {
		//Get result from calculator
		String result=driver.getTitle();
		
//		WebElement calculatorTextBox = driver.findElement(By.id("cwos"));
//		String result = calculatorTextBox.getText();
				
		//Verify that result of 2+2 is 4
		Assert.assertEquals(result, expectedResult);
		
		driver.close();
	}
	
	 @After
	    public void closeBrowser() {
	        driver.quit();
	 }

}


