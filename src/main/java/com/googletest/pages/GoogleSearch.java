package com.googletest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Google search page
 * @author Admin
 *
 */
public class GoogleSearch {
	
	// driver instance
    WebDriver driver;

    @FindBy(name="q")
    WebElement searchTextField;
    
    @FindBy(name="btnK")
    WebElement googleSearchButton;
    
    @FindBy(xpath="((.//div[@class='rc'])[3]/.//a)[1]")
    WebElement thirdLink;

    /**
     * constructor
     * @param driver
     */
    public GoogleSearch(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }  
    
    /**
     * populate the search text on text field
     * @param text
     */
    private void setSearchText(String text) {
    	searchTextField.clear();
    	searchTextField.sendKeys(text);
    }
    
    /**
     * click on the search button
     */
    private void clickSearchButton() {
    	googleSearchButton.click();
    }
    
    /**
     * search the given text on google search page
     * @param text
     */
    public void serachText(String text) {
    	setSearchText(text);
    	clickSearchButton();
    }
    
    /**
     * click the third link on the search result page
     */
    public void clickThirdLink() {
    	thirdLink.click();
    }
    
    /**
     * return the current page title
     * @return
     */
    public String getPageTitle() {
    	return driver.getTitle();
    }
}