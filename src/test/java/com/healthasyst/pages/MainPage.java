package com.healthasyst.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.healthasyst.base.WebDriverWrapper;

public class MainPage {
	//automate all menu
	private  By messagesLocator=By.xpath("//*[text()='Messages']");
	private  By patientClientLocator=By.xpath("//div[text()='Patient/Client']");
	private  By patientsLocator=By.xpath("//div[text()='Patients']");
	
	private WebDriver driver;
	
	public MainPage(WebDriver driver)
	{
		this.driver=driver;
	}

	
	public  void waitForPresenceOfMessages()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));	
		wait.until(ExpectedConditions.presenceOfElementLocated(messagesLocator));
	}
	
	public  String getMainPageTitle()
	{
		return driver.getTitle().trim();
	}
	
	public  void clickOnMessages()
	{
		driver.findElement(messagesLocator).click();
	}
	
	public  void clickOnPatientClient()
	{
		driver.findElement(patientClientLocator).click();
	}
	public  void clickOnPatients()
	{
		driver.findElement(patientsLocator).click();
	}
}
