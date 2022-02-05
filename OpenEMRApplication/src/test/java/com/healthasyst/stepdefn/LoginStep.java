package com.healthasyst.stepdefn;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStep {

	WebDriver driver;

//	@Given("I open browser with OpenEMR page")
	@Given("I have browser with OpenEMR page")
	public void i_have_browser_with_open_emr_page() {
		
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.openemr.io/b/openemr");
	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {
		
		driver.findElement(By.id("authUser")).sendKeys(username);
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {
		
		driver.findElement(By.id("clearPass")).sendKeys(password);
	}

	@When("I select language as {string}")
	public void i_select_language_as(String language) {

	}

	@When("I click on login")
	public void i_click_on_login() {
		driver.findElement(By.cssSelector("[type='submit']")).click();
	}

	@Then("I should get access to portal with title as {string}")
	public void i_should_get_access_to_portal_with_title_as(String expectedTitle) {

		String actualTitle=driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	@Then("I should get the error as {string}")
	public void i_should_get_the_error_as(String expectedError) {
	    
		String actualError=driver.findElement(By.xpath("//div[contains(text(),'Invalid')]")).getText();
		
		Assert.assertEquals(expectedError, actualError);
	}


}





