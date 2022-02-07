package com.healthasyst.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.healthasyst.base.WebDriverWrapper;

public class PatienFinderPage {
	private By finFrameLocator = By.xpath("//iframe[@name='fin']");
	private By addNewPatientLocator = By.xpath("//button[@id='create_patient_btn1']");

	private WebDriver driver;

	public PatienFinderPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnAddNewPatient() {
		driver.switchTo().frame(driver.findElement(finFrameLocator));

		driver.findElement(addNewPatientLocator).click();
		driver.switchTo().defaultContent();
	}

}
