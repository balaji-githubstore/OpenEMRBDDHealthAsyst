package com.healthasyst.base;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWrapper {

	public WebDriver driver;
	public static Scenario scenario;
	
	@Before
	public void before(Scenario scenario)
	{
		WebDriverWrapper.scenario=scenario;
		String name = WebDriverWrapper.scenario.getName();
		
		WebDriverWrapper.scenario.log("Scenarion name "+name);
	}

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

	public void endScenario(Scenario scenario) {
		
		if(scenario.isFailed())
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			byte[] scByte= ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(scByte, "image/png", "sc"+LocalDateTime.now());
		}
		
		//checking null
		if(driver !=null)
		{
			driver.quit();
		}
		
	}
}





