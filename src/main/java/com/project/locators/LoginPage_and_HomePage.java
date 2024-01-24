package com.project.locators;

import static com.tavant.util.LocatorUtils.getFieldLabelInLanguage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.tavant.base.PageFactory;

public class LoginPage_and_HomePage {
	Page page = PageFactory.getPage();
	//login page
	public Locator username = page.locator("//input[@id='username']").first();
	public Locator password = page.locator("//input[@id='password']").first();
	public Locator loginButton = page.locator("//*[@type='button' or @type='submit']").first();

	public Locator DealerPortal_username = page.getByPlaceholder(getFieldLabelInLanguage("LoginPage", "username"));
	public Locator DealerPortal_password = page.getByPlaceholder(getFieldLabelInLanguage("LoginPage", "password"));

//Home page & common Locators
	public Locator SearchBox =page.locator("//*[contains(@class,'slds-global-header__item slds-global-header')]//button");
	public Locator InputSearchBox=page.locator("//*[contains(text(),'and more')]//parent::div//*[@class='slds-input']");
	public Locator SearchBox_Value(String Value) {
		return page.locator("//*[@class='primary slds-truncate slds-rich-text-editor__output']//*[text()='"+Value+"']");
	}
	public Locator Quotes_tab         = page.locator("//*[@title='Quotes']//parent::one-app-nav-bar-item-root");
    public Locator New_Button  = page.locator("(//*[@title='New'])[1]");
	public Locator More_arrow        = page.locator(" //span[text()='More']//parent::a//child::Lightning-icon");
	public Locator Related_botton    = page.locator("(//*[text()='Related'])[1]");
	public Locator Related_botton2 =page.locator("(//*[text()='Related'])[2]");
	public Locator Related_botton3 =page.locator("(//*[text()='Related'])[1] | (//*[text()='Related'])[2]");
	
	
	public Locator More_List(String list) {
    	return page.locator("//*[@role='menuitem']//span[text()='"+list+"']");
    }
	public Locator FirstDataInList(String data) {
		return page.locator("(//*[@title='"+data+"']//ancestor::table//child::tbody//child::th)[1]//a");
	}

}
