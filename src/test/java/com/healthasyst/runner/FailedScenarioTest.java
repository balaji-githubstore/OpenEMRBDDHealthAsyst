package com.healthasyst.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
		features = {"@target/rerun.txt"}
		,glue = {"com.healthasyst.stepdefn","com.healthasyst.base"}
		,publish = true
		,monochrome = true
		,plugin = {"pretty","html:target/index.html","rerun:target/rerun.txt"} 
		)

@RunWith(Cucumber.class)
public class FailedScenarioTest {

}
