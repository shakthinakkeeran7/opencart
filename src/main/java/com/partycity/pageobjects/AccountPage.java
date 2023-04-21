package com.partycity.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	WebDriver driver = null;

	public AccountPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public WebElement getSignOutButton() {
		return signOutButton;
	}

	@FindBy(xpath = "//span[contains(text(),'Sign Out')]")
	private WebElement signOutButton;
	
}
