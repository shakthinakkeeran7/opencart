package com.partycity.stepDefinition;

import java.util.HashMap;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.stdDSA;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.partycity.baseclass.BaseClass;
import com.partycity.dataprovider.ConfigExcelFileReader;
import com.partycity.enums.Context;
import com.partycity.manager.FileReaderManager;
import com.partycity.manager.PageObjectManager;
import com.partycity.pageobjects.LoginPage;
import com.partycity.runner.TestRunner;
import com.partycity.util.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class LoginPageTestSteps extends BaseClass {

	TestContext testContext;
	LoginPage loginPage;

	public LoginPageTestSteps(TestContext context) throws Throwable {

		testContext = context;
		loginPage = testContext.getPageObjectManager().getLoginPage();

	}

	@Given("I am on the login page to contine")
	public void i_am_on_the_login_page_to_contine() throws Throwable {
		String LoginUrl = FileReaderManager.getInstance().getCrInstance().getApplicationUrl() + "/account-login";
		launchUrl(LoginUrl);

	}

	@Then("I should see an error message indicating the login failed {string}")
	public void i_should_see_an_error_message_indicating_the_login_failed(String errorMessage) {

		Assert.assertEquals(getText(loginPage.getLoginFailedMessage()), errorMessage);

	}

	@When("I enter my valid {string} and {string}")
	public void i_enter_my_valid_and(String userName, String password) {
		inputValuestoWebelement(loginPage.getEmailAddress(), userName);
		inputValuestoWebelement(loginPage.getLoginPassword(), password);

	}

	@When("I click the login button")
	public void i_click_the_login_button() {
		clickonWebelement(loginPage.getLoginButton());

	}

	@Then("I should be redirected to the account page {string}")
	public void i_should_be_redirected_to_the_account_page(String url) {

		Assert.assertEquals(currentUrl(), url);
	}

	@After
	public void logout() {
		// Code to logout the user goes here
	}

}
