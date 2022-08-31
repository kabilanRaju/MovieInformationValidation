package com.stepdefinition;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BaseClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HooksClass extends BaseClass {

	@Before
	public void BeforeScenario() throws IOException {

		getDriver(getPropertyFile("browserType"));
		maximize();
		implicitWait(40);
		navigat(getPropertyFile("url"));

	}

	@After
	public  void AfterScenario(Scenario sc) {
		if(!sc.isFailed()) {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
	byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
	sc.embed(screenshotAs, "EveryScenario");
	}
		closeAllWindows();
	}}
