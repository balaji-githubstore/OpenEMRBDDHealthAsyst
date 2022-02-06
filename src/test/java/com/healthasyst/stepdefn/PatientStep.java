package com.healthasyst.stepdefn;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import com.healthasyst.base.WebDriverWrapper;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PatientStep {
	
	@When("I click on patient-client")
	public void i_click_on_patient_client() {
	    
		WebDriverWrapper.driver.findElement(By.xpath("//div[text()='Patient/Client']")).click();
	}
	@When("I click on patient")
	public void i_click_on_patient() {
	    
	    
	}
	@When("I click on Add New Patient")
	public void i_click_on_add_new_patient() {
	    
	    
	}
	@When("I fill the form")
	public void i_fill_the_form(io.cucumber.datatable.DataTable dataTable) {
	    
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		
		List<Map<String, String>> lists= dataTable.asMaps();
		
		System.out.println(lists.get(0));
		System.out.println(lists.get(0).get("firstname"));
		System.out.println(lists.get(0).get("lastname"));
		System.out.println(lists.get(0).get("dob"));
		System.out.println(lists.get(0).get("gender"));
	    
	}
	@When("I click on create new patient")
	public void i_click_on_create_new_patient() {
	    
	    
	}
	@When("I click on confirm create new patient")
	public void i_click_on_confirm_create_new_patient() {
	    
	    
	}
	@When("I store the text and handle the alert box")
	public void i_store_the_text_and_handle_the_alert_box() {
	    
	    
	}
	@When("I click on happy birthday if available")
	public void i_click_on_happy_birthday_if_available() {
	    
	    
	}
	@Then("the alert text should contains  {string}")
	public void the_alert_text_should_contains(String string) {
	    
	    
	}
	@Then("I should get the added patient name {string}")
	public void i_should_get_the_added_patient_name(String string) {
	    WebDriverWrapper.driver.quit();
	    
	}



}
