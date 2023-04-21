package com.partycity.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver = null;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public WebElement getEmailAddress() {
		return EmailAddress;
	}

	public WebElement getLoginPassword() {
		return LoginPassword;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}

	public WebElement getLoginFailedMessage() {
		return loginFailedMessage;
	}

	@FindBy(name = "loginEmail")
	private WebElement EmailAddress;

	@FindBy(name = "loginPassword")
	private WebElement LoginPassword;

	@FindBy(xpath = "//button[contains(text(),'Login')]")
	private WebElement LoginButton;
	
	
	@FindBy(xpath = "//span[@class='pc-fieldset__error']")
	private WebElement loginFailedMessage;
	
	
	

}
