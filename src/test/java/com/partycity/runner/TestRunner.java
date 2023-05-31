package com.partycity.runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.partycity.baseclass.BaseClass;
import com.partycity.manager.FileReaderManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import io.github.bonigarcia.wdm.WebDriverManager;

@CucumberOptions(features = "src/test/resources/feature", glue = { "com.partycity.stepDefinition",
		"com.partycity.Hooks" }, dryRun = false,
		
		plugin = {
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:Report/FailedScenario.txt" }, monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {
	public static WebDriver driver;

	@BeforeSuite(alwaysRun = true)
	public void setUp() throws Throwable {
		String browser = FileReaderManager.getInstance().getCrInstance().getBrowser();
		driver = BaseClass.getBrowser(browser);
		
	}
	

	@AfterClass
	public static void tearDown() {

		driver.quit();
	}

}
