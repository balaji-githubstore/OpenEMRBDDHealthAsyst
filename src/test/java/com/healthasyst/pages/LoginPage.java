package com.healthasyst.pages;

import org.openqa.selenium.By;

import com.healthasyst.base.WebDriverWrapper;

public class LoginPage {
	private static By usernameLocator = By.id("authUser");
	private static By passwordLocator = By.id("clearPass");
	private static By loginLocator = By.cssSelector("[type='submit']");
	private static By errorLocator=By.xpath("//div[contains(text(),'Invalid')]");
	private static By appDescLocator=By.xpath("//*[contains(text(),'most')]");

	public static void enterUsername(String username) {
		WebDriverWrapper.driver.findElement(usernameLocator).sendKeys(username);
	}

	public static void enterPassword(String password) {
		WebDriverWrapper.driver.findElement(passwordLocator).sendKeys(password);
	}

	public static void clickOnLogin() {
		WebDriverWrapper.driver.findElement(loginLocator).click();
	}

	public static String getInvalidErrorMessage() {
		String text = WebDriverWrapper.driver.findElement(errorLocator).getText().trim();
		return text;
	}
	
	public static String getApplicationDescription() {
		String text = WebDriverWrapper.driver.findElement(appDescLocator).getText().trim();
		return text;
	}
	
}
