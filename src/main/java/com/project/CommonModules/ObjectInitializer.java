package com.project.CommonModules;

import com.project.locators.ContractMasterPage;
import com.project.locators.LoginPage_and_HomePage;
import com.project.locators.Quote_Page;

public class ObjectInitializer {

	//private static final ContractMasterPage ContractMasterPage = null;
	public static ThreadLocal<CommonLocators> commonLocators = new ThreadLocal<CommonLocators>();
	public static ThreadLocal<CommonMethods> commonMethods = new ThreadLocal<CommonMethods>();
	
	public static ThreadLocal<LoginPage_and_HomePage> loginPage = new ThreadLocal<LoginPage_and_HomePage>();
	public static ThreadLocal<Quote_Page> quotePage = new ThreadLocal<Quote_Page>();
	public static ThreadLocal<ContractMasterPage>contractMasterPage= new ThreadLocal<ContractMasterPage>();
	
	public ObjectInitializer() {
		
		commonLocators.set(new CommonLocators());
		commonMethods.set(new CommonMethods());
		
		loginPage.set(new LoginPage_and_HomePage());
		quotePage.set(new Quote_Page());
		contractMasterPage.set(new ContractMasterPage());
		
	 
		
	}

}
