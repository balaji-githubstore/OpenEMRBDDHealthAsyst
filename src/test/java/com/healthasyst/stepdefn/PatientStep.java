package com.healthasyst.stepdefn;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.healthasyst.base.WebDriverWrapper;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class PatientStep {
	
	private static String acutalAlertText;

	@When("I click on patient-client")
	public void i_click_on_patient_client() {

		WebDriverWrapper.driver.findElement(By.xpath("//div[text()='Patient/Client']")).click();
	}

	@When("I click on patient")
	public void i_click_on_patient() {
		WebDriverWrapper.driver.findElement(By.xpath("//div[text()='Patients']")).click();

	}

	@When("I click on Add New Patient")
	public void i_click_on_add_new_patient() {
		WebDriverWrapper.driver.switchTo()
				.frame(WebDriverWrapper.driver.findElement(By.xpath("//iframe[@name='fin']")));
		WebDriverWrapper.driver.findElement(By.xpath("//button[@id='create_patient_btn1']")).click();
		WebDriverWrapper.driver.switchTo().defaultContent();
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

		WebDriverWrapper.driver.switchTo()
				.frame(WebDriverWrapper.driver.findElement(By.xpath("//iframe[@name='pat']")));

		WebDriverWrapper.driver.findElement(By.xpath("//input[@id='form_fname']"))
				.sendKeys(lists.get(0).get("firstname"));
		WebDriverWrapper.driver.findElement(By.xpath("//input[@id='form_lname']"))
				.sendKeys(lists.get(0).get("lastname"));
		WebDriverWrapper.driver.findElement(By.xpath("//input[@id='form_fname']")).sendKeys(lists.get(0).get("dob"));

		Select genderSel = new Select(WebDriverWrapper.driver.findElement(By.xpath("//input[@id='form_sex']")));
		genderSel.deselectByVisibleText(lists.get(0).get("gender"));

	}

	@When("I click on create new patient")
	public void i_click_on_create_new_patient() {
		WebDriverWrapper.driver.findElement(By.xpath("//button[@id='create']")).click();

		WebDriverWrapper.driver.switchTo().defaultContent();
	}

	@When("I click on confirm create new patient")
	public void i_click_on_confirm_create_new_patient() {
		WebDriverWrapper.driver.switchTo()
				.frame(WebDriverWrapper.driver.findElement(By.xpath("//iframe[@id='modalframe']")));

		WebDriverWrapper.driver.findElement(By.xpath("//input[@value='Confirm Create New Patient']")).click();

		WebDriverWrapper.driver.switchTo().defaultContent();

	}

	@When("I store the text and handle the alert box")
	public void i_store_the_text_and_handle_the_alert_box() {
		
		
		WebDriverWait wait=new WebDriverWait(WebDriverWrapper.driver, Duration.ofSeconds(50));	
		wait.until(ExpectedConditions.alertIsPresent());
		
		
		acutalAlertText=WebDriverWrapper.driver.switchTo().alert().getText();
		WebDriverWrapper.driver.switchTo().alert().accept();
		
	}

	@When("I click on happy birthday if available")
	public void i_click_on_happy_birthday_if_available() {
		
		if(WebDriverWrapper.driver.findElements(By.xpath("//div[@class='closeDlgIframe']")).size()>0)
		{
			WebDriverWrapper.driver.findElement(By.xpath("//div[@class='closeDlgIframe']")).click();
		}
	}

	@Then("the alert text should contains  {string}")
	public void the_alert_text_should_contains(String expectedAlertText) {

		Assert.assertTrue(acutalAlertText.contains(expectedAlertText)); //expects true
	}

	@Then("I should get the added patient name {string}")
	public void i_should_get_the_added_patient_name(String expectedName) {
		
		WebDriverWrapper.driver.switchTo()
		.frame(WebDriverWrapper.driver.findElement(By.xpath("//iframe[@name='pat']")));
		
		String actualPatientName= WebDriverWrapper.driver.findElement(By.xpath("//h2[contains(text(),'Medical Record Dashboard')]")).getText();
		
		Assert.assertEquals(expectedName, actualPatientName);
		
		WebDriverWrapper.driver.switchTo().defaultContent();
		
		WebDriverWrapper.driver.quit();
	}

}
