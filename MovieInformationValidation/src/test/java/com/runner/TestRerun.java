package com.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"C:\\Users\\nithya\\eclipse-workspace\\MovieInformationValidation\\"
				+ "src\\test\\resources\\Folder\\failed.txt"},
        glue = { "com\\stepdefinition" })

public class TestRerun {

}
