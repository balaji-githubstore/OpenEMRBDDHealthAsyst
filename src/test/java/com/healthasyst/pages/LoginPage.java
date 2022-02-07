package com.healthasyst.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.healthasyst.base.WebDriverWrapper;

public class LoginPage {
	private By usernameLocator = By.id("authUser");
	private By passwordLocator = By.id("clearPass");
	private By loginLocator = By.cssSelector("[type='submit']");
	private By errorLocator=By.xpath("//div[contains(text(),'Invalid')]");
	private By appDescLocator=By.xpath("//*[contains(text(),'most')]");

	private WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}


	public void enterUsername(String username) {
		driver.findElement(usernameLocator).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordLocator).sendKeys(password);
	}

	public void clickOnLogin() {
		driver.findElement(loginLocator).click();
	}

	public String getInvalidErrorMessage() {
		String text = driver.findElement(errorLocator).getText().trim();
		return text;
	}
	
	public String getApplicationDescription() {
		String text = driver.findElement(appDescLocator).getText().trim();
		return text;
	}
	
}
