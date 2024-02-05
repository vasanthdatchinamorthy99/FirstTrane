package com.project.CustomModules;

import java.util.List;

import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
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
import io.cucumber.java.en.Given;

public class Quote_Methods {


	private final Logger logger = new CustomLogger(Quote_Methods.class);
	Page page = PageFactory.getPage();

	/**
	 * @author Vasanth D
	 * @param QuoteCreation
	 * @throws InterruptedException
	 */


	@And("Click Save&Submit to Approved the Quote")
	public void click_save_submit_to_approved_the_quote() {

		WebActions.click(ObjectInitializer.quotePage.get().button("Save & Submit"), "Click Save&submit Button");
		Waits.waitForGivenTime(4000);
		String Actualstatus = ObjectInitializer.quotePage.get().Status.innerText();
		GenericAssertions.assertEquals("Approved", Actualstatus, "Quote status is"+Actualstatus+"");	
	}


	@Given("Click Save to Draft a Quote")
	public void click_save_to_draft_a_quote() {

		WebActions.click(ObjectInitializer.quotePage.get().button("Save"), "Click Save Button");
		Waits.waitForGivenTime(4000);
		ObjectInitializer.quotePage.get().Quotes.click();
		Waits.waitForPageLoad();
		String Actualstatus = page.locator("(//*[text()='']//ancestor::tr//child::td)[5]//span[@class='slds-truncate']").innerText();
		GenericAssertions.assertEquals("Draft", Actualstatus, "Quote status is"+Actualstatus+"");
	}

	@Given("Add Inventory&SKU {string},{string}")
	public void add_inventory(String Inventory, String ContName) {//"HTG1144113" ,CONT_MAST_GMP004
		AddInventory(Inventory); 
		//	AddSKU_ContractandProceedAddons(ContName);
		AddSKs(Inventory, ContName);
	}


	@Given("Create Quote {string}")
	public void create_quote(String Type) {

		String Quote_number = create_Simple_Quote(Type);
		logger.info("Text: \"******** Quote created sucessfully :"+Quote_number+"*********");
	}

	@Given("selecting existing SKU items for a single inventory")
	public void selecting_existing_sku_items_for_a_single_inventory() {
		AddInventory("HTG1144113"); 
		AddSKU_ContractandProceedAddons("CONT_MAST_GMP004");
	}

	@Given("Add Model {string} and Select Dynamic contract SKU {string},{string},{string}")
	public void add_model_SelectDynamicContSKU(String Model, String Contractmaster,String Duration, String Usage) {

		AddModel(Model);
		WebActions.click(ObjectInitializer.quotePage.get().Add_SKUs_button, "Click AddSKUs button");
		page.locator("(//*[text()='"+Contractmaster+"']//ancestor::tr//child::td)[3]//input").click();
//		page.keyboard().press("ArrowDown");
//		page.keyboard().press("Enter");
//		//WebActions.click(Value, Clickable);
		page.click("(//*[text()='"+Contractmaster+"']//ancestor::tr//child::td)[3]//div[contains(text(),'"+Duration+" Months')]");

		page.locator("(//*[text()='"+Contractmaster+"']//ancestor::tr//child::td)[4]//input").click();
//		page.keyboard().press("ArrowDown");
//		page.keyboard().press("Enter");
		//WebActions.click(Value, Clickable);
		page.click("(//*[text()='"+Contractmaster+"']//ancestor::tr//child::td)[4]//div[contains(text(),'"+Usage+" Hours')]");

		WebActions.click(ObjectInitializer.quotePage.get().Selectbtn_Contract_Name(Contractmaster),"Selected contractname: "+Contractmaster+"");

		//		WebActions.click(ObjectInitializer.quotePage.get().button("Skip Add-ons"),"click: skip add-on button");
		//		WebActions.click(ObjectInitializer.quotePage.get().Save_and_Submit,"click: save&submit");

	}


	@Given("Skip Add-ons")
	public void skip_add_ons() {
		WebActions.click(ObjectInitializer.quotePage.get().button("Skip Add-ons"),"click: skip add-on button");
		WebActions.click(ObjectInitializer.quotePage.get().Save_and_Submit,"click: save&submit");
	}

	@Given("Proceed Add-ons")
	public void proceed_add_ons() {
		WebActions.click(ObjectInitializer.quotePage.get().button("Proceed to Add-ons"),"click: Proceed to Add-ons");
		boolean visible = page.locator("//h1[text()='Add SKUs']").isVisible();
		GenericAssertions.assertTrue(visible, "Header Visiable");

		List<Locator> all = page.locator("//*[@class='slds-checkbox__label']").all();
		for (Locator single : all) {
			single.click();
		}
		WebActions.click("//*[contains(@class,'slds-text-align--center slds-p-top--small slds')]//button[text()='Add']", "Added SKU Items");
	}


	@Given("AddModel&SKU {string},{string}")
	public void add_model_and_SKU(String string,String ContName) {
		AddModel(string);
		AddSKs(string, ContName);
	}

	@Given("Create a Dynamic Quote {string},{string},{string},{string},{string},{string}")
	public void create_a_dynamic_quote(String Type,String coveragemaster, String Duration, String Estimated, String PMA, String PMB) {

		create_a_Qoute02(Type,coveragemaster,Duration, Estimated, PMA, PMB);

	}






















	/**
	 * @author Vasanth D 
	 *@param Create a simple Quote
	 */

	public String create_Simple_Quote(String type) {
		Waits.waitForGivenTime(10000);
		//BrowserActions.navigateTo("https://tranetechnologies--fprasad.sandbox.lightning.force.com/lightning/o/tvnt__Quote__c/list");
		BrowserActions.navigateTo("https://tranetechnologies--fprasad.sandbox.my.site.com/TSVCDealerPortal/s/quote/tvnt__Quote__c");
		WebActions.click(ObjectInitializer.quotePage.get().New_Quotes, "NewQuote"); 
		//Dealer 		
		ObjectInitializer.quotePage.get().searchBox_Click("Dealer").click();
		page.type(ObjectInitializer.quotePage.get().searchBox_Input("Dealer"), "tk");//K TAMPA FL (G2280)_1  //TK Albany NY
		WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue("TK TAMPA FL (G2280)_1"), "Selected dropdown value");
		logger.info("Text: \"********Selected Dealer :TK Albuquerque NM*********");
		//Customer
		ObjectInitializer.quotePage.get().searchBox_Click("Customer").click();
		page.type(ObjectInitializer.quotePage.get().searchBox_Input("Customer"), "hi");
		WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue("HILLER FORD"), "Selected dropdown value");
		logger.info("Text: \"********Selected Customer: HILLER FORD*********");
		//Quote Type	
		ObjectInitializer.quotePage.get().searchBox_Click("Quote Type").click();
		WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue(type), "Selected dropdown value");
		logger.info("Text: \"********Selected Quote Type:T"+type+"*********");
		//Coverage Master
		ObjectInitializer.quotePage.get().searchBox_Click("Coverage Master").click();
		page.type(ObjectInitializer.quotePage.get().searchBox_Input("Coverage Master"), "auto");
		WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue("CONT_MAST_AUTO"), "Selected dropdown value");  	    
		Waits.waitForGivenTime(2000);
		//ObjectInitializer.quotePage.get().Save_button.click();
		WebActions.click(ObjectInitializer.quotePage.get().Save_button, "Save_Button");
		logger.info("Text: \"******** "+type+" Quote is Saved*********");

		Waits.waitForGivenTime(3000);
		return WebActions.getText(ObjectInitializer.quotePage.get().Created_Quote_data("Quote Number"));
	}

	/**
	 * @author Vasanth D 
	 *@param Create a Quote with more datas
	 * @return 
	 */
	public String create_a_Qoute02(String type,String Coveragemaster,String Duration,String Estmate,String PMA, String PMB ) {
		Waits.waitForGivenTime(10000);
		//BrowserActions.navigateTo("https://tranetechnologies--fprasad.sandbox.lightning.force.com/lightning/o/tvnt__Quote__c/list");
		BrowserActions.navigateTo("https://tranetechnologies--fprasad.sandbox.my.site.com/TSVCDealerPortal/s/quote/tvnt__Quote__c");
		WebActions.click(ObjectInitializer.quotePage.get().New_Quotes, "NewQuote");

		//Dealer 		
		ObjectInitializer.quotePage.get().searchBox_Click("Dealer").click();
		page.type(ObjectInitializer.quotePage.get().searchBox_Input("Dealer"), "tk");//K TAMPA FL (G2280)_1  //TK Albany NY
		WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue("TK TAMPA FL (G2280)_1"), "Selected dropdown value");
		logger.info("Text: \"********Selected Dealer :TK Albuquerque NM*********");
		//Customer
		ObjectInitializer.quotePage.get().searchBox_Click("Customer").click();
		page.type(ObjectInitializer.quotePage.get().searchBox_Input("Customer"), "hi");
		WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue("HILLER FORD"), "Selected dropdown value");
		logger.info("Text: \"********Selected Customer: HILLER FORD*********");
		//Quote Type	
		ObjectInitializer.quotePage.get().searchBox_Click("Quote Type").click();
		WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue(type), "Selected dropdown value");
		logger.info("Text: \"********Selected Quote Type:T"+type+"*********");
		//Coverage Master
		ObjectInitializer.quotePage.get().searchBox_Click("Coverage Master").click();
		page.type(ObjectInitializer.quotePage.get().searchBox_Input("Coverage Master"), Coveragemaster);
		WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue(Coveragemaster), "Selected dropdown value");

		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Duration(Months)").first(), Duration, "");   
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Estimated Hours(Diesel)").first(), Estmate, "");	    
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Estimated Hours(Electric)").first(), Estmate, "");    
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("PMA Frequency(Months)").first(), PMA, "");
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("PMB Frequency(Months)").first(), PMB, "");    
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("PMB Usage Frequency(Hours)").first(), "2000", "");

		// 	    WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Customer Email").first(), "emailid@tavant.com", "");  
		// 	    WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Customer Name").first(), "Legand", "");	    
		// 	    WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Customer Phone").first(), "0987654321", "");  
		// 	    WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Fleet Size").first(), "33", "");	    
		// 	    WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Part Pricing Deviation(%)").first(), "32", "");	    
		//Part Pricing
		// 		ObjectInitializer.quotePage.get().searchBox_Click("Part Pricing").click();
		// 	    WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue("Elite Pricing"), "Selected dropdown value");	    
		//Age Of Equipment
		// 	    ObjectInitializer.quotePage.get().searchBox_Click("Age Of Equipment").click();
		// 	    WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue("0-1 Yrs"), "Selected dropdown value");		    
		//Risk Associated
		// 	    ObjectInitializer.quotePage.get().searchBox_Click("Risk Associated").click();
		// 	    WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue("Dealer"), "Selected dropdown value"); 	    
		Waits.waitForGivenTime(2000);
		//ObjectInitializer.quotePage.get().Save_button.click();
		WebActions.click(ObjectInitializer.quotePage.get().Save_button, "Save_Button");
		logger.info("Text: \"******** "+type+" Quote is Saved*********");

		Waits.waitForGivenTime(3000);
		return WebActions.getText(ObjectInitializer.quotePage.get().Created_Quote_data("Quote Number"));
	}	

	/**
	 * @author Vasanth D 
	 *@param Add Inventory
	 */
	public void AddInventory(String Inventorys) {

		ObjectInitializer.quotePage.get().searchBox_Click("Inventory").click();
		page.type(ObjectInitializer.quotePage.get().searchBox_Input("Inventory"), "htg");
		WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue(Inventorys), "Selected dropdown value");
		WebActions.click(ObjectInitializer.quotePage.get().Add_button, "Click add button");
		logger.info("Text: \"******** Inventory added sucessfully*********");
	}

	public void AddSKs(String Inventory,String ContMast) {
		WebActions.click(ObjectInitializer.quotePage.get().AddSKUButton(Inventory), "Click AddSKUs button");


		page.locator("(//*[text()='"+ContMast+"']//ancestor::tr//child::td)[3]//input").click();
		page.keyboard().press("ArrowDown");
		page.keyboard().press("Enter");

		page.locator("(//*[text()='"+ContMast+"']//ancestor::tr//child::td)[4]//input").click();
		page.keyboard().press("ArrowDown");
		page.keyboard().press("Enter");


		WebActions.click(ObjectInitializer.quotePage.get().Selectbtn_Contract_Name(ContMast),"Selected contractname: "+ContMast+"");
		//	WebActions.click(ObjectInitializer.quotePage.get().button("Skip Add-ons"),"click: skip add-on button");
	}

	/**
	 * @author Vasanth D 
	 *@param Add Model
	 */
	public void AddModel(String Model) {
		ObjectInitializer.quotePage.get().searchBox_Click("Model").click();
		page.type(ObjectInitializer.quotePage.get().searchBox_Input("Model"), Model);
		WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue(Model), "Selected dropdown value");
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Quantity").first(), "2", "Quantity added");
		WebActions.click(ObjectInitializer.quotePage.get().Add_button, "Click Add_button");
		logger.info("Text: \"******** Model added sucessfully*********");
	}
	/**
	 * @author Vasanth D 
	 *@param Add SKU contract and click skip Addons
	 */
	public String AddSKU_ContractandSkipAddons(String ContractName) {
		WebActions.click(ObjectInitializer.quotePage.get().Add_SKUs_button, "Click AddSKUs button");
		WebActions.click(ObjectInitializer.quotePage.get().Selectbtn_Contract_Name(ContractName),"Selected contractname: "+ContractName+"");
		WebActions.click(ObjectInitializer.quotePage.get().button("Skip Add-ons"),"click: skip add-on button");
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
		WebActions.click(ObjectInitializer.quotePage.get().button("Proceed to Add-ons"),"click: Proceed to Add-ons");
		boolean visible = page.locator("//h1[text()='Add SKUs']").isVisible();
		GenericAssertions.assertTrue(visible, "Header Visiable");

		List<Locator> all = page.locator("//*[@class='slds-checkbox__label']").all();
		for (Locator single : all) {
			single.click();
		}
		WebActions.click("//*[contains(@class,'slds-text-align--center slds-p-top--small slds')]//button[text()='Add']", "Added SKU Items");
		logger.info("Text: \"********"+ContractName+" : proceed addons sucessfully*********");

	}



	public void PresentQuote() {

		WebActions.click(ObjectInitializer.quotePage.get().StatusChange("Present Quote"), "Click: Present Quote");
		Waits.optionalWaitUntilElementIsVisible(ObjectInitializer.quotePage.get().button("Proceed"), 5 , "Wait for element");
		WebActions.click(ObjectInitializer.quotePage.get().button("Proceed"), "Click: Proceed button");
		Waits.waitForGivenTime(20000);
		String status= ObjectInitializer.quotePage.get().Status.innerText();
		GenericAssertions.assertEquals("Presented", status, "Status:"+status+"");
		logger.info("Text: \"******** Status: Presented*********");
	}
	public void AcceptQuote() {

		WebActions.click(ObjectInitializer.quotePage.get().StatusChange("Accept Quote"), "Click: Accept Quote");	
		WebActions.click(ObjectInitializer.quotePage.get().StatusChange("Accept Quote"), "Click: Accept Quote");
		Waits.optionalWaitUntilElementIsVisible(ObjectInitializer.quotePage.get().button("Accept All"), 5 , "Wait for element");
		WebActions.click(ObjectInitializer.quotePage.get().button("Accept All"), "Click:Accept All");
		Waits.waitForGivenTime(5000);
		WebActions.click(ObjectInitializer.quotePage.get().button("Proceed"), "Click: Proceed button");
		Waits.waitForGivenTime(5000);
		System.out.println("refresh window");
		page.reload();
		Waits.waitForPageLoad();
		String status= ObjectInitializer.quotePage.get().Status.innerText();

		GenericAssertions.assertEquals("Accepted", status, "Status:"+status+"");
		logger.info("Text: \"******** Status: Accepted*********");
	}




























	@And("Create Quote-Guaranteed Maintenance Plan")
	public void CreateQuote() {

		Waits.waitForGivenTime(3000);
		String Quote_number = create_Simple_Quote("Guaranteed Maintenance Plan");
		logger.info("Text: \"******** Quote created sucessfully :"+Quote_number+"*********");


		AddInventory("HTG1144113");  //
		//AddSKU_ContractandSkipAddons("CONT_MAST_GMP004");
		//AddModel("");

		logger.info("Text: \"********addInventory with skip addons sucessfully*********");
		String Actal_Inventory = AddSKU_ContractandSkipAddons("CONT_MAST_GMP004");
		GenericAssertions.assertEquals(Actal_Inventory, "HTG1144113", " "+Actal_Inventory+"");
		//		
		String Actal_Quote_Number= ObjectInitializer.quotePage.get().Quote_Details("Quote").innerText();
		GenericAssertions.assertEquals(Actal_Quote_Number, Quote_number, " ");
		WebActions.click(ObjectInitializer.quotePage.get().Quote_Details("Quote"), "Click Quote:"+Actal_Quote_Number+"");
		String status= ObjectInitializer.quotePage.get().Status.innerText();
		GenericAssertions.assertEquals("Approved", status, "Status:"+status+"");
		logger.info("Text: \"******** Status: Approved*********");
		//
		WebActions.click(ObjectInitializer.quotePage.get().Status_Change_button("Present Quote"), "Click: Present Quote");
		//		Waits.optionalWaitUntilElementIsVisible(ObjectInitializer.quotePage.get().proceed_btn, 5 , "Wait for element");
		//		WebActions.click(ObjectInitializer.quotePage.get().proceed_btn, "Click: Proceed button");
		//		Waits.waitForGivenTime(20000);
		//		status= ObjectInitializer.quotePage.get().Status.innerText();
		//		GenericAssertions.assertEquals("Presented", status, "Status:"+status+"");
		//		logger.info("Text: \"******** Status: Presented*********");
		//
		//		WebActions.click(ObjectInitializer.quotePage.get().Status_Change_button("Accept Quote"), "Click: Accept Quote");
		//		Waits.optionalWaitUntilElementIsVisible(ObjectInitializer.quotePage.get().acceptAll_btn, 5 , "Wait for element");
		//		WebActions.click(ObjectInitializer.quotePage.get().acceptAll_btn, "Click:Accept All");
		//		Waits.waitForGivenTime(5000);
		//		WebActions.click(ObjectInitializer.quotePage.get().proceed_btn, "Click: Proceed button");
		//		Waits.waitForGivenTime(5000);
		//		System.out.println("refresh window");
		//		page.reload();
		//		Waits.waitForPageLoad();
		//		status= ObjectInitializer.quotePage.get().Status.innerText();
		//		
		//		GenericAssertions.assertEquals("Accepted", status, "Status:"+status+"");
		//		logger.info("Text: \"******** Status: Accepted*********");
		//       // page.evaluate("window.scrollBy(0,600)");
		//        MouseActions.scrollToBottom();
		//        Waits.optionalWaitUntilElementIsVisible(ObjectInitializer.quotePage.get().service_Contracts, 5 , "Wait for element");
		//		String text = WebActions.getText(ObjectInitializer.quotePage.get().service_Contracts);
		//		logger.info("Text: \"******** Service Contracts: "+text+"*********");
		//
		//		//			String Quote_List =	ObjectInitializer.quote_detail_page.get().Latest_Quote.getAttribute("title");
		//		//			System.out.println("the latest created quote number = "+Quote_List);
		//		//			
		//		//			GenericAssertions.assertEquals(Quote_number, Quote_List, "Created Quote is avaliable in the Quotelist");
		//		//			logger.info("Text: \"******** Guaranteed Maintenance Plan Quote is Avaliable in the Quote list*********");
	}



}
