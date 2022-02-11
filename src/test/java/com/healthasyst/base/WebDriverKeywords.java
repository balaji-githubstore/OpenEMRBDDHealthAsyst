package com.healthasyst.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WebDriverKeywords {
	
	private WebDriver driver;

	public WebDriverKeywords(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickElement(By locator)
	{
		driver.findElement(locator).click();
	}
	
	public void typeOnElement(By locator,String text)
	{
		driver.findElement(locator).sendKeys(text);
	}
	
	public void clickUntilNextLocator(By loc1,By loc2,int count) throws Exception {
		
		int check=1;
		Exception exc=null;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		while(driver.findElements(loc2).size()>0 && check<=80)
		{
			try
			{
				if(check==count)
				{
					break;
				}
				check++;
				clickElement(loc1);
				exc=null;
				
			}
			catch (Exception e) {
				exc=e;
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		if(count==30 && exc!=null)
		{
			throw exc;
		}
	}
	
	public void clickMultipleTimes(By loc,int count) throws Exception {
		
		int check=1;
		Exception exc=null;
		int pollingInterval = 500;
		int timeOut = 60;
		boolean verify=false;
		while(check<=60)
		{
			try
			{
				if(check==count)
				{
					break;
				}
				
				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(timeOut)).pollingEvery(Duration.ofSeconds(pollingInterval))
						.ignoring(Exception.class);
				
				WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>(){
					
					public WebElement apply(WebDriver driver ) {
						return driver.findElement(loc);
					}
				});
				
				clickseleniumlink.click();
					
				//click
				exc=null;
				break;
			}
			catch(Exception ex)
			{
				exc=ex;
			}
		}
		
		if(count==30 && exc!=null && verify!=true)
		{
			throw exc;
		}
	}
	
public void clickUntilNextLocatorDisplayed(By loc1,By loc2,int count) throws Exception {
		
		int check=1;
		Exception exc=null;
		while(driver.findElement(loc2).isDisplayed() && check<=30)
		{
			try
			{
				if(check==count)
				{
					break;
				}
				check++;
				clickElement(loc1);
				exc=null;
//				break;
			}
			catch (Exception e) {
				exc=e;
			}
		}
		
		if(count==30)
		{
			throw exc;
		}
	}

	public static Object[][] sheetToObject(String path,String sheetName) throws IOException {
		
		FileInputStream file = new FileInputStream(path);
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet(sheetName);		
		int rowCount= sheet.getPhysicalNumberOfRows();		
		XSSFRow row = sheet.getRow(0);		
		int cellCount=row.getPhysicalNumberOfCells();
		
		Object[][] main=new Object[rowCount][cellCount];
		DataFormatter format=new DataFormatter();
		
		for(int r=0;r<rowCount;r++)
		{
			row = sheet.getRow(r);
			for(int c=0;c<cellCount;c++)
			{
				XSSFCell cell= row.getCell(c);			
				String value = format.formatCellValue(cell);
				main[r-1][c]=value;
			}
		}
		return main;

	}
}
