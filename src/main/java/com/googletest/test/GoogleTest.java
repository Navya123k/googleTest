package com.googletest.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.googletest.pages.GoogleSearch;

/**
 * Test class for Google Search page
 * @author Admin
 *
 */
public class GoogleTest {
	
	WebDriver driver;
	
	GoogleSearch googleSearch;
	
	@BeforeTest
	public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") 
        		+ "/src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.google.com");
	}
	
	@Test
	public void testing() {
		googleSearch = new GoogleSearch(driver);
		googleSearch.serachText("LexisNexis");
		googleSearch.clickThirdLink();
		String pageTitle = googleSearch.getPageTitle();
		System.out.println("Page Title is: "+ pageTitle);
	}

	@AfterTest
	public void cleanup() {
		driver.quit();
	}
}