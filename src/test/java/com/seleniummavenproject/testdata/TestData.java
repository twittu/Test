package com.seleniummavenproject.testdata;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class TestData {

	public WebDriver driver;
	
	@DataProvider(name="searchData")
	public Object[][] searchTestDataPass(){
		
		Object[][] obj = new Object[8][8];
	
		//1st row
			obj[0][0]= "";
			
			
			//2dn row
			obj[1][0]= "";
			//3rd row
			obj[2][0]= "";
			//4th row
			obj[3][0]= "";
			//5th row
			obj[4][0]= "";
			//6th row
			obj[5][0]= "";
			//7th row
			obj[6][0]= "";
			//8th row
			obj[7][0]= "";
			
			
		
		return obj; 
	}
}
