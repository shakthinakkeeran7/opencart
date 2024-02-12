package com.opencart.runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.opencart.baseclass.BaseClass;
import com.opencart.manager.FileReaderManager;

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

@CucumberOptions(features = "@Report/FailedScenario.txt", glue = { "com.partycity.stepDefinition",
		"com.partycity.Hooks" }, dryRun = false, plugin = {
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, monochrome = true)

public class TestReruner extends AbstractTestNGCucumberTests {
	public static WebDriver driver;

	@BeforeSuite(alwaysRun = true)
	public void setUp() throws Throwable {

		String browser = FileReaderManager.getInstance().getCrInstance().getBrowser();
		driver = BaseClass.getBrowser(browser);

	}

}
