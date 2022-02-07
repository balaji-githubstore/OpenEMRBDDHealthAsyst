package com.healthasyst.pages;

import org.openqa.selenium.By;

import com.healthasyst.base.WebDriverWrapper;

public class LoginPage {
	private static By usernameLocator = By.id("authUser");

	public static void enterUsername(String username) {
		WebDriverWrapper.driver.findElement(usernameLocator).sendKeys(username);
	}

}
