package com.seleniummavenproject.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.seleniummavenproject.testscript.HomePageInEnglish;
import com.seleniummavenproject.testscript.LanguageSelect;
import com.seleniummavenproject.testscript.MainPage;
import com.seleniummavenproject.testscript.Wikipedia;

import junit.framework.Assert;

//@Listeners(com.seleniummavenproject.utilities.TestListener.class)
public class BaseTest<validateNegativeTest> {
	public WebDriver driver = null;

	@BeforeTest
	public void lunchBrowserAndApplication() {
		String projectPath = System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
		/*String pojectPathToDriver;
		System.setProperty("webdriver.chrome.driver", projectPath+"chromedriver");*/
		//System.setProperty("webdriver.chrome.driver","D:\\SW\\Drivers\\chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver",projectPath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.wikipedia.org");
		
		Assert.assertEquals(driver.getTitle(), "Wikipedia");
	}

/*    @Parameters({"selectlanguage","searchCapgemini","searchSeeIt"})
	@Test
	 public void startTest(String selectlanguage, String searchCapgemini,String searchSeeIt) {

	//public void startTest() {
		// System.out.println("selectlanguage: " +selectlanguage);
		//System.out.println("hi");
		// create the object of languageslect

		// 2
		homePageInEnlish.validateSeItComesBackAndSearchWorks(searchSeeIt);

		// 3
		homePageInEnlish.verifyMainPageRendering();

	}*/
    @Parameters({"searchCapgemini"})
    @Test
    public void verifyCapgemini(String searchCapgemini) throws InterruptedException, IOException
    {
    
    	Wikipedia objWiki = new Wikipedia(driver);
		objWiki.clickEnglishLanguage();

		MainPage objMainPage = new MainPage(driver);
		objMainPage.verifyCapgeminiResult(searchCapgemini);
		
		    }
    @Parameters({"searchSeeIt"})
    @Test
   public void verifyNegativeString(String searchString)
   {
    	Wikipedia objWiki = new Wikipedia(driver);
		objWiki.clickEnglishLanguage();
		
    	MainPage objMainPage = new MainPage(driver);
		objMainPage.verifyNegativeString(searchString);
   }
    
    @Test
    public void VerifyMainPageRendered()
    {
    	Wikipedia objWiki = new Wikipedia(driver);
		objWiki.clickEnglishLanguage();
		
		MainPage objMainPage = new MainPage(driver);
		objMainPage.getFromtodaysFeaturedArticleText();
		objMainPage.getDidYouKnowText();
		objMainPage.getInTheNewsText();
		objMainPage.getOnThisDayText();
		
    }
   

	@AfterTest
	public void closeBrowser() {
		 driver.close();
		

	}
}
