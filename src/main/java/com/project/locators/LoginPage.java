package com.project.locators;

import static com.tavant.util.LocatorUtils.getFieldLabelInLanguage;

import com.microsoft.playwright.Locator;
import com.tavant.base.PageFactory;

public class LoginPage {

	public Locator username = PageFactory.getPage().locator("//input[@id='username']").first();
	public Locator password = PageFactory.getPage().locator("//input[@id='password']").first();
	public Locator loginButton = PageFactory.getPage().locator("//*[@type='button' or @type='submit']").first();

	public Locator DealerPortal_username = PageFactory.getPage()
			.getByPlaceholder(getFieldLabelInLanguage("LoginPage", "username"));
	public Locator DealerPortal_password = PageFactory.getPage()
			.getByPlaceholder(getFieldLabelInLanguage("LoginPage", "password"));
}
