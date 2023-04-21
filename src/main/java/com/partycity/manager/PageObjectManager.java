package com.partycity.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.partycity.pageobjects.AccountPage;
import com.partycity.pageobjects.LoginPage;

public class PageObjectManager {
	WebDriver driver;
	LoginPage loginpage;
	AccountPage accountpage;
	public PageObjectManager(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AccountPage getAccountPage() {

		if (accountpage == null) {
			accountpage = new AccountPage(driver);
		}
		return accountpage;
	}
	public LoginPage getLoginPage() {

		if (loginpage == null) {
			loginpage = new LoginPage(driver);
		}
		return loginpage;
	}
	
	

}
