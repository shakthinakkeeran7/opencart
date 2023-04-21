package com.partycity.util;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.partycity.baseclass.BaseClass;
import com.partycity.manager.FileReaderManager;
import com.partycity.manager.PageObjectManager;
import com.partycity.runner.TestRunner;

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
