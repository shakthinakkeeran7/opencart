package com.opencart.util;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.opencart.baseclass.BaseClass;
import com.opencart.manager.FileReaderManager;
import com.opencart.manager.PageObjectManager;
import com.opencart.runner.TestRunner;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestContext {
	public static WebDriver driver = TestRunner.driver;
	private PageObjectManager pageObjectManager;
	private ScenarioContext scenarioContext;
	
	
	//private WebDriverManager webDriverManager;
	
	public TestContext(){
		
		pageObjectManager = new PageObjectManager(driver);
		scenarioContext = new ScenarioContext();
	
	
		
	}
	
//	public WebDriverManager getWebDriverManager() {
//		return webDriverManager;
//	}
	


	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}

}
