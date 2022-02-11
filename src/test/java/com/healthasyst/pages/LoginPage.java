package com.healthasyst.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.healthasyst.base.WebDriverKeywords;
import com.healthasyst.base.WebDriverWrapper;

public class LoginPage extends WebDriverKeywords {
	private By usernameLocator = By.id("authUser");
	private By passwordLocator = By.id("clearPass");
	private By loginLocator = By.cssSelector("[type='submit']");
	private By errorLocator=By.xpath("//div[contains(text(),'Invalid')]");
	private By appDescLocator=By.xpath("//*[contains(text(),'most')]");
	
	
	@FindBy(xpath = "//div[contains(text(),'most')]")
	WebElement appDescEle;
	

	private WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public void enterUsername(String username) {
		
		typeOnElement(usernameLocator,username);
	}

	public void enterPassword(String password) {
		typeOnElement(passwordLocator,password);
	}

	public void clickOnLogin() {
		clickElement(loginLocator);
	}

	public String getInvalidErrorMessage() {
		String text = driver.findElement(errorLocator).getText().trim();
		return text;
	}
	
	public String getApplicationDescription() {
		String text = appDescEle.getText().trim();
		return text;
	}
	
}
