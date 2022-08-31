package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.reports.Reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	
	    snippets=SnippetType.CAMELCASE,
		monochrome = true,
		features= {"src\\test\\resources\\Folder"},
		glue= {"com\\stepdefinition"},
		dryRun=false,
		strict=true,
		plugin= {"pretty","json:target/output.json",
		"rerun:src\\test\\resources\\Folder\\failed.txt"})
public class TestRunner {

	@AfterClass
	public static void Afterclass() {

		Reporting.generatejvmreports(
				"C:\\Users\\nithya\\eclipse-workspace\\MovieInformationValidation\\target\\output.json");
	}
}
