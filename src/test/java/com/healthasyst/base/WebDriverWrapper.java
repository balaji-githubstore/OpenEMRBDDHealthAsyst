package com.healthasyst.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWrapper {

	public WebDriver driver;

	public void launchBrowser(String browser) {

		if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--headless");
			
			driver = new ChromeDriver(opt);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.openemr.io/b/openemr");
	}

	// runs after every scenario either it is pass or fail
	@After

	public void endScenario() {
		//checking null
		if(driver !=null)
		{
			driver.quit();
		}
		
	}
}
