package com.healthasyst.pages;

import org.openqa.selenium.By;

import com.healthasyst.base.WebDriverWrapper;

public class AboutStep {

	
	private WebDriverWrapper wrapper;

	public AboutStep(WebDriverWrapper wrapper)
	{
		this.wrapper=wrapper;
	}
	
	
	public void clickE()
	{
		wrapper.driver.findElement(By.xpath("")).click();
	}
}
