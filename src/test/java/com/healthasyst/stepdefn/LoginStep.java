package com.healthasyst.stepdefn;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.healthasyst.base.WebDriverWrapper;
import com.healthasyst.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStep {

//	@Given("I open browser with OpenEMR page")
	@Given("I have browser with OpenEMR page")
	public void i_have_browser_with_open_emr_page() {
		
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();

		WebDriverWrapper.driver = new ChromeDriver();
		WebDriverWrapper.driver.manage().window().maximize();
		WebDriverWrapper.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWrapper.driver.get("https://demo.openemr.io/b/openemr");
	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {
		
		LoginPage.enterUsername(username);
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {
		
		WebDriverWrapper.driver.findElement(By.id("clearPass")).sendKeys(password);
	}

	@When("I select language as {string}")
	public void i_select_language_as(String language) {

	}

	@When("I click on login")
	public void i_click_on_login() {
		WebDriverWrapper.driver.findElement(By.cssSelector("[type='submit']")).click();
	}

	@Then("I should get access to portal with title as {string}")
	public void i_should_get_access_to_portal_with_title_as(String expectedTitle) {

		String actualTitle=WebDriverWrapper.driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	} 
	
	@Then("I should get the error as {string}")
	public void i_should_get_the_error_as(String expectedError) {
	    
		String actualError=WebDriverWrapper.driver.findElement(By.xpath("//div[contains(text(),'Invalid')]")).getText();
		
		Assert.assertEquals(expectedError, actualError);
	}


}





