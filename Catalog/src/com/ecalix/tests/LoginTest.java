package com.ecalix.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.ecalix.common.DataDriverXLS;
import com.ecalix.pageobjects.AccountLoginPages;


public class LoginTest {
	private WebDriver driver;
	
	public LoginTest(WebDriver driver){
		this.driver=driver;
	}
	
@Test
public void Login_02(){
	DataDriverXLS DataDriver=new DataDriverXLS("//Users//rameshtejavath//Documents//Selenium//Workbook2.xlsx");
    
    int iRowCount=DataDriver.getRowCount("sheet1");
    for (int i=0;i<=iRowCount;i++){
    	String Email=DataDriver.getCellData("sheet1", "UserName", i);
        String Password=DataDriver.getCellData("sheet1", "Password", i);
    	AccountLoginPages loginPage = new AccountLoginPages(driver);
		loginPage.enterUsername(Email);
		loginPage.enterPassword(Password);
		
    }
}

}
