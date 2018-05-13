package com.seleniummavenproject.testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

//@Listeners(com.seleniummavenproject.utilities.TestListener.class)
// wikipedia
public class LanguageSelect {

	public WebDriver driver = null;

	@FindBy(xpath = ".//*[@id='js-link-box-en']")
	WebElement english;

	public LanguageSelect(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		String pageName=driver.getTitle();
		System.out.println(pageName);
	}

	// select english language
	

	public void selectEnglishLanguage(String selectlanguage) {
		english.sendKeys(selectlanguage);
	}

	// click on english language
	public void clickOnEnglishLanguage() {
		english.click();
	}

	// enter english language
	
	public void enterToEnglishLanguage(String selectlanguage) {
		///this.selectEnglishLanguage(selectlanguage);
		this.clickOnEnglishLanguage();
	}
	/*public void enterToEnglishLanguage(String enlishLanuage) {
		this.selectEnglishLanguage(enlishLanuage);
		this.clickOnEnglishLanguage();
	}*/

}
