package com.healthasyst.stepdefn;

import java.net.MalformedURLException;

import org.junit.Assert;

import com.healthasyst.base.MyVariableClass;
import com.healthasyst.base.WebDriverWrapper;
import com.healthasyst.pages.LoginPage;
import com.healthasyst.pages.MainPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {
	
	WebDriverWrapper wrapper;
	LoginPage login;
	MainPage main;
	MyVariableClass my;

	
	public LoginStep(WebDriverWrapper wrapper,MyVariableClass obj)
	{
		this.wrapper=wrapper;
		my=obj;
		
	}

//	@Given("I open browser with OpenEMR page")
	@Given("I have browser with OpenEMR page")
	public void i_have_browser_with_open_emr_page() throws MalformedURLException {

		
		this.wrapper.launchBrowser("ch","");
		intializePage();
		
		WebDriverWrapper.scenario.log("Browser launched successfully");
	}
	
	public void intializePage()
	{
		 login=new LoginPage(this.wrapper.driver);
		 main=new MainPage(wrapper.driver);
	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {
		my.login_data=username;
		login.enterUsername(username);
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {
		
		login.enterPassword(password);
	}

	@When("I select language as {string}")
	public void i_select_language_as(String language) {

	}

	@When("I click on login")
	public void i_click_on_login() throws Exception {
//		
//		int count=1;
//		Exception exc=null;
//		while(wrapper.driver.findElements(By.xpath("//*[text()='Messages']")).size()>0 && count<=30)
//		{
//			try
//			{
//				login.clickOnLogin();
//				count++;
//			}
//			catch (Exception e) {
//				exc=e;
//			}
//		}
//		
//		if(count==30)
//		{
//			throw exc;
//		}
//		
		login.clickOnLogin();
		
		
	}

	@Then("I should get access to portal with title as {string}")
	public void i_should_get_access_to_portal_with_title_as(String expectedTitle) {
		//wait for page load
		main.waitForPresenceOfMessages();
		String actualTitle = main.getMainPageTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@Then("I should get the error as {string}")
	public void i_should_get_the_error_as(String expectedError) {

		String actualError = login.getInvalidErrorMessage();

		Assert.assertEquals(expectedError, actualError);
	}

}
