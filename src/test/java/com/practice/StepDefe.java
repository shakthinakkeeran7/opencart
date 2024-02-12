package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.opencart.baseclass.BaseClass;
import com.opencart.manager.FileReaderManager;
import com.opencart.pageobjects.LoginPage;
import com.opencart.util.TestContext;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefe extends BaseClass {

	TestContext testContext;
	LoginPage loginPage;
	
	

	public StepDefe(TestContext context) throws Throwable {

		testContext = context;
		loginPage = testContext.getPageObjectManager().getLoginPage();

	}
@Test
	@When("I enter the following username and password:")

	public void i_enter_the_following_username_and_password(DataTable dataTable) throws Throwable {
	

	}

}
