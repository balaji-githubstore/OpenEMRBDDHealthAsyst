package com.healthasyst.base;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;

public class WebDriverWrapper {
	
	public static WebDriver driver;
	
	
	//runs after every scenario either it is pass or fail
	@After
	
	public void endScenario()
	{
		WebDriverWrapper.driver.quit();
	}
}
