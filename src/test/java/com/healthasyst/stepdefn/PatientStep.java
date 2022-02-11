package com.healthasyst.stepdefn;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.healthasyst.base.MyVariableClass;
import com.healthasyst.base.WebDriverWrapper;
import com.healthasyst.pages.MainPage;
import com.healthasyst.pages.PatienFinderPage;
import com.healthasyst.pages.SearchOrAddPatientPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class PatientStep {
	
	private static String acutalAlertText;
	WebDriverWrapper wrapper;
	MainPage main;
	PatienFinderPage finderPage;
	SearchOrAddPatientPage searchPatient;
	MyVariableClass my;
	
	public PatientStep(WebDriverWrapper wrapper,MyVariableClass my)
	{
		this.wrapper=wrapper;
		intializePage();

		
	}
	
	public void intializePage()
	{

		 main=new MainPage(this.wrapper.driver);
		 finderPage=new PatienFinderPage(this.wrapper.driver);
		 searchPatient=new SearchOrAddPatientPage(this.wrapper.driver);
	}

	@When("I click on patient-client")
	public void i_click_on_patient_client() {

		main.clickOnPatientClient();
	}

	@When("I click on patient")
	public void i_click_on_patient() {
		main.clickOnPatients();
	}

	@When("I click on Add New Patient")
	public void i_click_on_add_new_patient() {
		finderPage.clickOnAddNewPatient();
	}

	@When("I fill the form")
	public void i_fill_the_form(io.cucumber.datatable.DataTable dataTable) {

		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.

		List<Map<String, String>> lists = dataTable.asMaps();

		System.out.println(lists.get(0));
		System.out.println(lists.get(0).get("firstname"));
		System.out.println(lists.get(0).get("lastname"));
		System.out.println(lists.get(0).get("dob"));
		System.out.println(lists.get(0).get("gender"));

		this.wrapper.driver.switchTo()
				.frame(wrapper.driver.findElement(By.xpath("//iframe[@name='pat']")));

		wrapper.driver.findElement(By.xpath("//input[@id='form_fname']"))
				.sendKeys(lists.get(0).get("firstname"));
		wrapper.driver.findElement(By.xpath("//input[@id='form_lname']"))
				.sendKeys(lists.get(0).get("lastname"));
		wrapper.driver.findElement(By.xpath("//input[@id='form_DOB']")).sendKeys(lists.get(0).get("dob"));

		Select genderSel = new Select(wrapper.driver.findElement(By.xpath("//select[@id='form_sex']")));
		genderSel.selectByVisibleText(lists.get(0).get("gender"));

	}

	@When("I click on create new patient")
	public void i_click_on_create_new_patient() {
		wrapper.driver.findElement(By.xpath("//button[@id='create']")).click();

		wrapper.driver.switchTo().defaultContent();
	}

	@When("I click on confirm create new patient")
	public void i_click_on_confirm_create_new_patient() throws InterruptedException {
		wrapper.driver.switchTo()
				.frame(wrapper.driver.findElement(By.xpath("//iframe[@id='modalframe']")));

		Thread.sleep(2000);
		
		wrapper.driver.findElement(By.xpath("//input[@value='Confirm Create New Patient']")).click();

		wrapper.driver.switchTo().defaultContent();

	}

	@When("I store the text and handle the alert box")
	public void i_store_the_text_and_handle_the_alert_box() {
		
		
		WebDriverWait wait=new WebDriverWait(wrapper.driver, Duration.ofSeconds(50));	
		wait.until(ExpectedConditions.alertIsPresent());
		
		
		acutalAlertText=wrapper.driver.switchTo().alert().getText();
		wrapper.driver.switchTo().alert().accept();
		
	}

	@When("I click on happy birthday if available")
	public void i_click_on_happy_birthday_if_available() {
		
		if(wrapper.driver.findElements(By.xpath("//div[@class='closeDlgIframe']")).size()>0)
		{
			wrapper.driver.findElement(By.xpath("//div[@class='closeDlgIframe']")).click();
		}
	}

	@Then("the alert text should contains  {string}")
	public void the_alert_text_should_contains(String expectedAlertText) {

		Assert.assertTrue(acutalAlertText.contains(expectedAlertText)); //expects true
	}

	@Then("I should get the added patient name {string}")
	public void i_should_get_the_added_patient_name(String expectedName) {
		
		wrapper.driver.switchTo()
		.frame(wrapper.driver.findElement(By.xpath("//iframe[@name='pat']")));
		
		String actualPatientName= wrapper.driver.findElement(By.xpath("//h2[contains(text(),'Medical Record Dashboard')]")).getText();
		
		Assert.assertEquals(expectedName, actualPatientName.trim(),"usename used is"+my.login_data);
		
//		Assert.assertTrue(actualPatientName.contains(expectedName));
		
		wrapper.driver.switchTo().defaultContent();
		
	}

}
