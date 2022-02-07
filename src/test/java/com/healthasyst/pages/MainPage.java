package com.healthasyst.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.healthasyst.base.WebDriverWrapper;

public class MainPage {
	//automate all menu
	private static By messagesLocator=By.xpath("//*[text()='Messages']");
	private static By patientClientLocator=By.xpath("//div[text()='Patient/Client']");
	private static By patientsLocator=By.xpath("//div[text()='Patients']");
	
	public static void waitForPresenceOfMessages()
	{
		WebDriverWait wait=new WebDriverWait(WebDriverWrapper.driver, Duration.ofSeconds(50));	
		wait.until(ExpectedConditions.presenceOfElementLocated(messagesLocator));
	}
	
	public static String getMainPageTitle()
	{
		return  WebDriverWrapper.driver.getTitle().trim();
	}
	
	public static void clickOnMessages()
	{
		WebDriverWrapper.driver.findElement(messagesLocator).click();
	}
	
	public static void clickOnPatientClient()
	{
		WebDriverWrapper.driver.findElement(patientClientLocator).click();
	}
	public static void clickOnPatients()
	{
		WebDriverWrapper.driver.findElement(patientsLocator).click();
	}
}
