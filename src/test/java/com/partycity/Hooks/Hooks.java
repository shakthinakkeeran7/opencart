package com.partycity.Hooks;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import org.openqa.selenium.TakesScreenshot;

import com.partycity.baseclass.BaseClass;
import com.partycity.runner.TestRunner;
import com.partycity.util.UtilFunctions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends BaseClass {
	@Before
	public void beforeHooks(Scenario scenario) {
		String name = scenario.getName();
		System.out.println("Scenario: " + name);

		System.out.println("before");
	}

	@After
	public void afterHooks(Scenario scenario) throws IOException {

		if (scenario.isFailed()) {
			String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			String ScreenshotName = scenario.getName() + "_" + currentDate;

			final byte[] screenshot = ((TakesScreenshot) TestRunner.driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", ScreenshotName);

		}
	}
}
