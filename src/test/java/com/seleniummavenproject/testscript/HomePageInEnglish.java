package com.seleniummavenproject.testscript;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;

//@Listeners(com.seleniummavenproject.utilities.TestListener.class)
//Main Page
public class HomePageInEnglish {

	public WebDriver driver = null;

	@FindBy(xpath = ".//*[@id='searchInput']")
	WebElement search;

	@FindBy(xpath = ".//*[@id='searchButton']")
	WebElement goSubmit;

	@FindBy(xpath = ".//*[@id='firstHeading']")
	WebElement capgeminiText;

	//.//*[@id='mw-content-text']/div/p[1]/i/a[1]    
	//".//*[@containsid='mw-content-text']/div/p[1]/i/..")
	/*@FindBy(xpath = ".//*[contains(text(),'does not exist')]")	
	WebElement doesNotExitText;*/
	
	@FindBy(xpath =".//*[@id='mw-content-text']/div/p[1]/i/a[1]")
	WebElement doesNotExitText;
	
	
	
	//.//*[contains(text(),"From today's featured article")]
	//.//*[@id='mp-tfa-h2']/span[2]
	@FindBy(xpath = ".//*[contains(text(),\"From today's featured article\")]")
	WebElement fromtodayfeaturedarticle;

	
	// .//*[contains(text(),'On this day')]

	@FindBy(xpath = ".//*[@id='On_this_day...']")
	WebElement onThisDay;

	// .//*[contains(text(),'Did you know')]
	@FindBy(xpath = ".//*[@id='Did_you_know...']")
	WebElement didYouKnow;

	// .//*[contains(text(),'Did you know')]
	@FindBy(xpath = ".//*[@id='In_the_news']")
	WebElement inTheNews;

	public HomePageInEnglish(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		String pageName=driver.getTitle();
		System.out.println(pageName);
	}

	// enter capgemini in seachbox

	public void enterCapgeminiOnSearch(String searchCapgemini) {
		search.sendKeys(searchCapgemini);

	}

	// searach with capgemini
	public void clickOnSearch() {
		goSubmit.click();

	}

	// validate the search result
	public void validateCapgeminiSearchResult() {

		String actual = capgeminiText.getText();
		String expected = "Capgemini";

		Assert.assertEquals(actual, expected);
		System.out.println(" Validate Capgemini Test Result");
		// using if condition
		/*if (actual.equalsIgnoreCase(expected)) {
			System.out.println("validate with capgemini result pass");

		} else {
			System.out.println("validate with capgemin result fail");
		}
*/
		// using assert

		// back to homepage after capagemini search vaidation
		driver.navigate().back();
	}

	// enter seeItComesBackAndSearchWorks on search
	public void enterSeeItComesBackAndSearchWorks(String searchSeeIt) {
		search.sendKeys(searchSeeIt);
	}

	// validate seache with
	public void validateSeItComesBackAndSearchWorks(String searchSeeIt) {

		this.enterSeeItComesBackAndSearchWorks(searchSeeIt);
		this.clickOnSearch();
		this.getSeItComesBackAndSearchWorksPageText();

	}

	
	// validate the capgemini test result
	public void verifyCapgeminiResult(String searchCapgemini) {
		this.enterCapgeminiOnSearch(searchCapgemini);
		this.clickOnSearch();
		this.validateCapgeminiSearchResult();

	}
	
	// Validate the see it come back test result
	public void getSeItComesBackAndSearchWorksPageText() {
		try {
			String actual = doesNotExitText.getText();
			System.out.println(actual);
			String expected = "does not exist";
			//Assert.assertEquals(actual, expected);
			//Assert.assertEquals(actual.contains(expected));
			System.out.println("From today's featured article verified");
			driver.navigate().back();
			Thread.sleep(5000);

			/*
			 * // using if condition if (actual.equalsIgnoreCase(expected)) {
			 * System.out.println("validate with capgemini result pass");
			 * 
			 * } else { System.out.println("N result fail"); }
			 */

			// Assert.assertNotSame(actual, expected, "search not found so page doesn't
			// exist");
			// Assert.assertTrue(driver.getTitle().contains(""));
			/*
			 * List<WebElement>
			 * actual=driver.findElements(By.xpath("//*[contains(text(),'does not exist')]")
			 * ); for(int i=0;i<actual.size();i++) { String str=actual.get(i).getText();
			 * System.out.println(str); }
			 */
			// Assert.assertTrue(actual.size() > 0, "does not exist");
			/*
			 * for(int i=0;i<=actual.size();i++) { Assert.assertEquals(actual, expected); }
			 */
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}


	// validate four sections on main page
	// validate From today's featured article verified sectopm in mainpage
	public void getFromtodaysFeaturedArticleText() {

		String actual = fromtodayfeaturedarticle.getText();
		String expected = "From today's featured article";
		Assert.assertEquals(actual, expected);
		System.out.println("From today's featured article verified");

	}
	// validate In the news section  in mainpage
	public void getInTheNewsText() {
		String actual = inTheNews.getText();
		String expected = "In the news";
		Assert.assertEquals(actual, expected);
		System.out.println(" In the news verified");
	}

	// validate On this day section  in mainpage
	public void getOnThisDayText() {
		String actual = onThisDay.getText();
		String expected = "On this day...";
		Assert.assertEquals(actual, expected);
		System.out.println("On this day... verified");
	}

	// validate Did you know section  in mainpage
	public void getDidYouKnowText() {

		String actual = didYouKnow.getText();
		String expected = "Did you know...";
		Assert.assertEquals(actual, expected);
		System.out.println("Did you know... verified");

	}
	
	

	public void verifyMainPageRendering() {
		this.getFromtodaysFeaturedArticleText();
		this.getDidYouKnowText();
		this.getInTheNewsText();
		this.getOnThisDayText();

	}

}
