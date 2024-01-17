package com.project.CommonModules;

import com.project.locators.LoginPage;
import com.project.locators.QuotePage;

public class ObjectInitializer {

	public static ThreadLocal<CommonLocators> commonLocators = new ThreadLocal<CommonLocators>();
	public static ThreadLocal<CommonMethods> commonMethods = new ThreadLocal<CommonMethods>();
	
	public static ThreadLocal<LoginPage> loginPage = new ThreadLocal<LoginPage>();
	public static ThreadLocal<QuotePage> quotePage = new ThreadLocal<QuotePage>();
	
	public ObjectInitializer() {
		
		commonLocators.set(new CommonLocators());
		commonMethods.set(new CommonMethods());
		
		loginPage.set(new LoginPage());
		quotePage.set(new QuotePage());
		 
	}

}
