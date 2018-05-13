package com.seleniummavenproject.testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wikipedia {

public WebDriver driver = null;
	
	public Wikipedia(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = ".//*[@id='js-link-box-en']")
	WebElement english;
	


	public void clickEnglishLanguage() {
		// TODO Auto-generated method stub
		english.click();
	}
}
