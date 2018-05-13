package com.seleniummavenproject.testscript;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MainPage {

	public WebDriver driver = null;
	
	public MainPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = ".//*[@id='searchInput']")
	WebElement search;

	@FindBy(xpath = ".//*[@id='searchButton']")
	WebElement goSubmit;

	@FindBy(xpath = ".//*[@id='firstHeading']")
	WebElement capgeminiText;
	
	@FindBy(xpath = ".//*[@id='js-link-box-en']")
	WebElement english;
	
	@FindBy(xpath =".//*[@id='mw-content-text']/div/p[1]/i/a[1]")
	WebElement textDoesNotExist;
	
	@FindBy(xpath = ".//*[contains(text(),\"From today's featured article\")]")
	WebElement fromtodayfeaturedarticle;

	@FindBy(xpath = ".//*[@id='On_this_day...']")
	WebElement onThisDay;

	@FindBy(xpath = ".//*[@id='Did_you_know...']")
	WebElement didYouKnow;

	@FindBy(xpath = ".//*[@id='In_the_news']")
	WebElement inTheNews;
	
	
	
	public void enterCapgeminiOnSearch(String searchCapgemini) {
		search.sendKeys(searchCapgemini);
	}

	
	public void clickOnSearch() {
		goSubmit.click();
	}

	// validate the search result
	public void validateCapgeminiSearchResult() {

		String actual = capgeminiText.getText();
		String expected = "Capgemini";

		Assert.assertEquals(actual, expected);
		driver.navigate().back();
	}

	// enter seeItComesBackAndSearchWorks on search
	public void enterSeeItComesBackAndSearchWorks(String searchSeeIt) {
		search.sendKeys(searchSeeIt);
	}


	public void verifyCapgeminiResult(String strSearch) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
			
		
		search.sendKeys(strSearch);
		goSubmit.click();
		Assert.assertEquals(capgeminiText.getText(), "Capgemini");
		// TakesScreenshot
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
           FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshots\\"+"capgemini.png"));
		driver.navigate().back();
	}
	
	

	public void verifyNegativeString(String searchString) {
		// TODO Auto-generated method stub
		search.sendKeys(searchString);
		goSubmit.click();
		Assert.assertEquals(textDoesNotExist.getText(), "See it comes back and search works");		
		driver.navigate().back();
		
	}
	
	public void getFromtodaysFeaturedArticleText() {

		String actual = fromtodayfeaturedarticle.getText();
		String expected = "From today's featured article";
		Assert.assertEquals(actual, expected);
		

	}
	// validate In the news section  in mainpage
	public void getInTheNewsText() {
		String actual = inTheNews.getText();
		String expected = "In the news";
		Assert.assertEquals(actual, expected);
		
	}

	// validate On this day section  in mainpage
	public void getOnThisDayText() {
		String actual = onThisDay.getText();
		String expected = "On this day...";
		Assert.assertEquals(actual, expected);
		
	}

	// validate Did you know section  in mainpage
	public void getDidYouKnowText() {

		String actual = didYouKnow.getText();
		String expected = "Did you know...";
		Assert.assertEquals(actual, expected);
		

	}
	
}
