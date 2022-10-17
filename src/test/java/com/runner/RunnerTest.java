package com.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/Features",
glue={"com.iris22a.stepdefination","com.iris22a.config"},
dryRun=false)
public class RunnerTest extends AbstractTestNGCucumberTests{
	
	@DataProvider(parallel=true)
	@Override
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
