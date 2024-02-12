package com.opencart.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.opencart.pageobjects.AccountPage;
import com.opencart.pageobjects.LoginPage;

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
