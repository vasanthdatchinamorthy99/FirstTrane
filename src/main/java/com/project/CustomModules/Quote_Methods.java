package com.project.CustomModules;

import org.apache.logging.log4j.Logger;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.mongodb.assertions.Assertions;
import com.project.CommonModules.ObjectInitializer;
import com.tavant.actions.BrowserActions;
import com.tavant.actions.MouseActions;
import com.tavant.actions.WebActions;
import com.tavant.assertions.GenericAssertions;
import com.tavant.base.PageFactory;
import com.tavant.listeners.CustomLogger;
import com.tavant.waits.Waits;

import groovyjarjarantlr4.v4.codegen.model.Action;
import io.cucumber.java.en.And;

public class Quote_Methods {


	private final Logger logger = new CustomLogger(Quote_Methods.class);
	Page page = PageFactory.getPage();

	/**
	 * @author Vasanth D
	 * @param QuoteCreation
	 * @throws InterruptedException
	 */

	private String status="";
	//private String status_Exp="";
	@And("Create Quote-Guaranteed Maintenance Plan")
	public void CreateQuote() {

		Waits.waitForGivenTime(3000);
		String Quote_number = create_Quote("Guaranteed Maintenance Plan");
		logger.info("Text: \"******** Quote created sucessfully :"+Quote_number+"*********");
		
		
		AddInventory("");
		
		   Waits.waitForGivenTime(5000);
		    GenericAssertions.assertTrue(false, "Failed by me");
		logger.info("Text: \"********addInventory with skip addons sucessfully*********");
//		String Actal_Inventory = AddSKU_ContractandSkipAddons("CONT_MAST_AUTO04");
//		GenericAssertions.assertEquals(Actal_Inventory, Exp_Inventory, " "+Actal_Inventory+"");
//		
		String Actal_Quote_Number= ObjectInitializer.quotePage.get().Quote_Details("Quote").innerText();
		GenericAssertions.assertEquals(Actal_Quote_Number, Quote_number, " ");
		WebActions.click(ObjectInitializer.quotePage.get().Quote_Details("Quote"), "Click Quote:"+Actal_Quote_Number+"");
		status= ObjectInitializer.quotePage.get().Status.innerText();
		GenericAssertions.assertEquals("Approved", status, "Status:"+status+"");
		logger.info("Text: \"******** Status: Approved*********");

		WebActions.click(ObjectInitializer.quotePage.get().Status_Change_button("Present Quote"), "Click: Present Quote");
		Waits.optionalWaitUntilElementIsVisible(ObjectInitializer.quotePage.get().proceed_btn, 5 , "Wait for element");
		WebActions.click(ObjectInitializer.quotePage.get().proceed_btn, "Click: Proceed button");
		Waits.waitForGivenTime(20000);
		status= ObjectInitializer.quotePage.get().Status.innerText();
		GenericAssertions.assertEquals("Presented", status, "Status:"+status+"");
		logger.info("Text: \"******** Status: Presented*********");

		WebActions.click(ObjectInitializer.quotePage.get().Status_Change_button("Accept Quote"), "Click: Accept Quote");
		Waits.optionalWaitUntilElementIsVisible(ObjectInitializer.quotePage.get().acceptAll_btn, 5 , "Wait for element");
		WebActions.click(ObjectInitializer.quotePage.get().acceptAll_btn, "Click:Accept All");
		Waits.waitForGivenTime(5000);
		WebActions.click(ObjectInitializer.quotePage.get().proceed_btn, "Click: Proceed button");
		Waits.waitForGivenTime(5000);
		System.out.println("refresh window");
		page.reload();
		Waits.waitForPageLoad();
		status= ObjectInitializer.quotePage.get().Status.innerText();
		
		GenericAssertions.assertEquals("Accepted", status, "Status:"+status+"");
		logger.info("Text: \"******** Status: Accepted*********");
       // page.evaluate("window.scrollBy(0,600)");
        MouseActions.scrollToBottom();
        Waits.optionalWaitUntilElementIsVisible(ObjectInitializer.quotePage.get().service_Contracts, 5 , "Wait for element");
		String text = WebActions.getText(ObjectInitializer.quotePage.get().service_Contracts);
		logger.info("Text: \"******** Service Contracts: "+text+"*********");

		//			String Quote_List =	ObjectInitializer.quote_detail_page.get().Latest_Quote.getAttribute("title");
		//			System.out.println("the latest created quote number = "+Quote_List);
		//			
		//			GenericAssertions.assertEquals(Quote_number, Quote_List, "Created Quote is avaliable in the Quotelist");
		//			logger.info("Text: \"******** Guaranteed Maintenance Plan Quote is Avaliable in the Quote list*********");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @author Vasanth D 
     *@param Create a simple Quote pass quote type into String
	 */
	
	public String create_Quote(String type) {
		Waits.waitForGivenTime(10000);
		//BrowserActions.navigateTo("https://tranetechnologies--fprasad.sandbox.lightning.force.com/lightning/o/tvnt__Quote__c/list");
		BrowserActions.navigateTo("https://tranetechnologies--fprasad.sandbox.my.site.com/TSVCDealerPortal/s/quote/tvnt__Quote__c");
//		WebActions.click(ObjectInitializer.loginPage.get().More_arrow, "ViewProfileButton");
//		WebActions.click(ObjectInitializer.quotePage.get().Quotes, "ViewProfileButton");
//		Waits.waitForGivenTime(3000);
//		Waits.waitUntilElementIsVisible(ObjectInitializer.quotePage.get().New_Quotes, "new");
		WebActions.click(ObjectInitializer.quotePage.get().New_Quotes, "NewQuote");
//		Waits.optionalWaitUntilElementIsVisible(ObjectInitializer.quotePage.get().Search_Box,4 , "Waiting for search box");
//		WebActions.click(ObjectInitializer.quotePage.get().Search_Box, "Click");
//		Waits.waitForGivenTime(2000);
//		//WebActions.enterText(ObjectInitializer.quotePage.get().Search_Box, "TK - NA", "Selected Business Unit: TK - NA");
//		page.keyboard().type("TK - NA");
//		page.keyboard().press("ArrowDown");
//		Waits.waitForGivenTime(2000);
//		page.keyboard().press("Enter");
		logger.info("Text: \"********Selected TK - NA in Business Unit*********");
		ObjectInitializer.quotePage.get().searchBox_Click("Dealer").click();
		page.type(ObjectInitializer.quotePage.get().searchBox_Input("Dealer"), "tk");//K TAMPA FL (G2280)_1  //TK Albany NY
      //  WebActions.enterText(ObjectInitializer.quotePage.get().searchBox_Input("Dealer"), "TK", "EnterText : TK TAMPA FL (G2280)_1");
		WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue("TK TAMPA FL (G2280)_1"), "Selected dropdown value");
//		page.keyboard().type("TK");
//		//WebActions.enterText(ObjectInitializer.quotePage.get().search_boxes("Dealer"), "TK", "Selected Dealer :TK");
//		page.keyboard().press("ArrowDown");
//		Waits.waitForGivenTime(4000);
//		page.keyboard().press("Enter");
		logger.info("Text: \"********Selected Dealer :TK Albuquerque NM*********");
//HILLER FORD
		ObjectInitializer.quotePage.get().searchBox_Click("Customer").click();
		page.type(ObjectInitializer.quotePage.get().searchBox_Input("Customer"), "hi");
		//WebActions.enterText(ObjectInitializer.quotePage.get().searchBox_Input("Customer"), "hi", "EnterText : THILLER FORD");
		WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue("HILLER FORD"), "Selected dropdown value");
		
		logger.info("Text: \"********Selected Customer: HILLER FORD*********");

	
		ObjectInitializer.quotePage.get().searchBox_Click("Quote Type").click();
		WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue(type), "Selected dropdown value");
		
		logger.info("Text: \"********Selected Quote Type:T"+type+"*********");

		//Part Pricing
		ObjectInitializer.quotePage.get().searchBox_Click("Part Pricing").click();
	    WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue("Elite Pricing"), "Selected dropdown value");
		
	    
	    //Age Of Equipment
	    ObjectInitializer.quotePage.get().searchBox_Click("Age Of Equipment").click();
	    WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue("0-1 Yrs"), "Selected dropdown value");
		
	    //Coverage Master
	    ObjectInitializer.quotePage.get().searchBox_Click("Coverage Master").click();
		page.type(ObjectInitializer.quotePage.get().searchBox_Input("Coverage Master"), "auto");
	    //WebActions.enterText(ObjectInitializer.quotePage.get().searchBox_Input("Coverage Master"), "auto", "EnterText : Part Pricing");
	    WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue("CONT_MAST_AUTO"), "Selected dropdown value");
	   
	    //Risk Associated
	    ObjectInitializer.quotePage.get().searchBox_Click("Risk Associated").click();
	    WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue("Dealer"), "Selected dropdown value");
	    
	    
	    WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Customer Email").first(), "emailid@tavant.com", "");
	    
	    WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Customer Name").first(), "Legand", "");
	    
	    WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Customer Phone").first(), "0987654321", "");
	    
	    WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Duration(Months)").first(), "12", "");
	    
	    WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Estimated Hours(Diesel)").first(), "23", "");
	    
	    WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Estimated Hours(Electric)").first(), "3332", "");
	    
	    WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("PMA Frequency(Months)").first(), "23", "");
	    //PMB Frequency(Months)

	    WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("PMB Frequency(Months)").first(), "23", "");
	    
	    WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("PMB Usage Frequency(Hours)").first(), "23", "");
	    
	    WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Fleet Size").first(), "33", "");
	    
	    WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Part Pricing Deviation(%)").first(), "32", "");
	    
	  	    
		Waits.waitForGivenTime(2000);
		ObjectInitializer.quotePage.get().Save_button.click();
		WebActions.click(ObjectInitializer.quotePage.get().Save_button, "Save_Button");
		logger.info("Text: \"******** Guaranteed Maintenance Plan Quote is Saved*********");

		Waits.waitForGivenTime(3000);
		return WebActions.getText(ObjectInitializer.quotePage.get().Created_Quote_data("Quote Number"));
	}
	
	

	/**
	 * @author Vasanth D 
     *@param Add Inventory
	 */
	public void AddInventory(String Inventorys) {
	
		WebActions.click(ObjectInitializer.quotePage.get().searchBox_Input("Inventory"), "Click Inventory search box");
		String Exp_Inventory = "HTG1318599";
		page.keyboard().type(Exp_Inventory);
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(2000);
		page.keyboard().press("Enter");
		WebActions.click(ObjectInitializer.quotePage.get().Add_button, "Click add button");
		logger.info("Text: \"******** Add Model/Inventory added sucessfully*********");
		
	}
	/**
	 * @author Vasanth D 
     *@param Add SKU contract and click skip Addons
	 */
	public String AddSKU_ContractandSkipAddons(String ContractName) {
		WebActions.click(ObjectInitializer.quotePage.get().Add_SKUs_button, "Click AddSKUs button");
		WebActions.click(ObjectInitializer.quotePage.get().Selectbtn_Contract_Name(ContractName),"Selected contractname: "+ContractName+"");
		WebActions.click(ObjectInitializer.quotePage.get().Skip_Addons_button,"click: skip add-on button");
		boolean visible = page.isVisible(ObjectInitializer.quotePage.get().Table_body);
		GenericAssertions.assertTrue(visible, "table body is visiable");
		WebActions.click(ObjectInitializer.quotePage.get().Save_and_Submit,"click: save&submit");
		
		WebActions.click(ObjectInitializer.loginPage.get().Related_botton,"click: Related button");
		WebActions.click(ObjectInitializer.quotePage.get().Quote_Unit_Name,"click: Quote unit name");
		logger.info("Text: \"********"+ContractName+" add with skip addons sucessfully*********");
		return ObjectInitializer.quotePage.get().Quote_Details("Inventory").innerText();
	}
	/**
	 * @author Vasanth D 
     *@param Add SKU contract and click ProceedAddons
	 */
	public void AddSKU_ContractandProceedAddons(String ContractName) {
		WebActions.click(ObjectInitializer.quotePage.get().Add_SKUs_button, "Click AddSKUs button");
		WebActions.click(ObjectInitializer.quotePage.get().Selectbtn_Contract_Name(ContractName),"Selected contractname: "+ContractName+"");
	//	logger.info("Text: \"********"+ContractName+" : proceed addons sucessfully*********");
	//	return ContractName;
		
		Waits.waitForGivenTime(10000);
	GenericAssertions.assertTrue(true, "failed by me");
	}
	
	
	

}
