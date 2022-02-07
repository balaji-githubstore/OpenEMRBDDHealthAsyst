package com.healthasyst.base;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
