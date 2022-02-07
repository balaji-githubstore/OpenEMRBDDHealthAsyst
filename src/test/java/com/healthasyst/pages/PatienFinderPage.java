package com.healthasyst.pages;

import org.openqa.selenium.By;

import com.healthasyst.base.WebDriverWrapper;

public class PatienFinderPage {
	private static By finFrameLocator = By.xpath("//iframe[@name='fin']");
	private static By addNewPatientLocator = By.xpath("//button[@id='create_patient_btn1']");

	public static void clickOnAddNewPatient() {
		WebDriverWrapper.driver.switchTo().frame(WebDriverWrapper.driver.findElement(finFrameLocator));

		WebDriverWrapper.driver.findElement(addNewPatientLocator).click();
		WebDriverWrapper.driver.switchTo().defaultContent();
	}

}
