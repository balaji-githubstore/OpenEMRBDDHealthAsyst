package com.healthasyst.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@CucumberOptions(
		features = {"src/test/resources/feature"}
		,glue = {"com.healthasyst.stepdefn","com.healthasyst.base"}
		,publish = true
		,monochrome = true
//		,dryRun = true 
//		,tags = "@login and (not @high)"
//		,tags="@patient"
		,tags="@invalid"
//		,plugin = {"pretty","progress"} 
		,plugin = {"pretty","html:target/index.html"} 
		)

@RunWith(Cucumber.class)
public class RunnerTest {

}
