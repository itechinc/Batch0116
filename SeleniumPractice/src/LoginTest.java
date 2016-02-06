

import org.testng.annotations.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

	@BeforeTest
	public void openConnection(){
		System.out.println("I am in BeforeTest");
	}
	
	@AfterTest
	public void closeConnection(){
		System.out.println("I am in after test");
	}
	
	@BeforeSuite
	public void openSuite(){
		System.out.println("I am in before Suite");
	}
	@AfterSuite
	public void closeSuite(){
		System.out.println("I am in after suite");
	}
	
	@BeforeClass
	public void openBeforeClass(){

		System.out.println("I am in before Class");
	}
	
	@AfterClass
	public void closeAfterClass(){
		System.out.println("I am in after Class");
	}

	
	@BeforeMethod // execute for each and every test
	public void openBrowser(){
		System.out.println("I am in before method");
	}
	
	@AfterMethod
	public void closeBrowser(){
		System.out.println("I am in after method");
	}
	
	@Test 
	
	public void testLogin(){
		System.out.println("Executing  test1");
	}
	
	@Test
	public void testRegister(){
		System.out.println("Executing  test2");
	}
}
