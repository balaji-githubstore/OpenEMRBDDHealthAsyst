package com.healthasyst.stepdefn;

import java.io.IOException;

import com.healthasyst.base.WebDriverKeywords;

import io.cucumber.java.en.*;

public class HaStep {

	@Given("I have the excel with keywords in sheet {string}")
	public void demo(String sheetname) {

	}

	@When("I try to run")
	public void i_try_to_run() {

	}

	@Then("I should get the result as {string}")
	public void i_should_get_the_result_as(String string) {

	}

	@Given("I have browser")
	public void i_have_browser() {

	}

	@When("I try to run enter username {string}")
	public void i_try_to_run_enter_username(String string) {

	}

	@When("I pick the data from the excel {string} and sheetname {string}")
	public void i_pick_the_data_from_the_excel_and_sheetname(String excel, String sheet) throws IOException {
		
		Object[][] main = WebDriverKeywords.sheetToObject(excel, sheet);
		System.out.println(main[1][0]);

	}


}





