package com.project.CustomModules;

import org.apache.logging.log4j.Logger;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.project.CommonModules.ObjectInitializer;
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
		WebActions.click(ObjectInitializer.quotePage.get().More_arrow, "ViewProfileButton");
		WebActions.click(ObjectInitializer.quotePage.get().Quotes, "ViewProfileButton");
		Waits.waitForGivenTime(3000);
		Waits.waitUntilElementIsVisible(ObjectInitializer.quotePage.get().New_Quotes, "new");
		WebActions.click(ObjectInitializer.quotePage.get().New_Quotes, "NewQuote");
		Waits.optionalWaitUntilElementIsVisible(ObjectInitializer.quotePage.get().Search_Box,4 , "Waiting for search box");
		WebActions.click(ObjectInitializer.quotePage.get().Search_Box, "Click");
		Waits.waitForGivenTime(2000);
		//WebActions.enterText(ObjectInitializer.quotePage.get().Search_Box, "TK - NA", "Selected Business Unit: TK - NA");
		page.keyboard().type("TK - NA");
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(2000);
		page.keyboard().press("Enter");
		logger.info("Text: \"********Selected TK - NA in Business Unit*********");

		WebActions.click((ObjectInitializer.quotePage.get().search_boxes("Dealer")), "Click");
		page.keyboard().type("TK");
		//WebActions.enterText(ObjectInitializer.quotePage.get().search_boxes("Dealer"), "TK", "Selected Dealer :TK");
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(4000);
		page.keyboard().press("Enter");
		logger.info("Text: \"********Selected Dealer :TK*********");

		WebActions.click((ObjectInitializer.quotePage.get().search_boxes("Customer")), "Click");
		page.keyboard().type("HILLER FORD");
		//WebActions.enterText(ObjectInitializer.quotePage.get().search_boxes("Customer"), "HILLER FORD", "Selected Customer: HILLER FORD");
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(2000);
		page.keyboard().press("Enter");
		logger.info("Text: \"********Selected Customer: HILLER FORD*********");

		WebActions.click((ObjectInitializer.quotePage.get().search_boxes("Quote Type")), "Click");
		WebActions.click(ObjectInitializer.quotePage.get().Quote_Type, "Guaranteed Maintenance Plan");
		logger.info("Text: \"********Selected Quote Type: Guaranteed Maintenance Plan*********");

		Waits.waitForGivenTime(2000);
		WebActions.click(ObjectInitializer.quotePage.get().Save_button, "Save_Button");
		logger.info("Text: \"******** Guaranteed Maintenance Plan Quote is Saved*********");

		Waits.waitForGivenTime(3000);
		//	String Quote_number= ObjectInitializer.quotePage.get().Created_Quote_data("Quote Number").innerText();
		String Quote_number = WebActions.getText(ObjectInitializer.quotePage.get().Created_Quote_data("Quote Number"));
		logger.info("Text: \"******** Quote created sucessfully :"+Quote_number+"*********");

		WebActions.click(ObjectInitializer.quotePage.get().search_boxes("Inventory"), "Click Inventory search box");
		String Exp_Inventory = "HTG1318599";
		page.keyboard().type(Exp_Inventory);
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(2000);
		page.keyboard().press("Enter");
		WebActions.click(ObjectInitializer.quotePage.get().Add_button, "Click add button");
		logger.info("Text: \"******** Add Model/Inventory added sucessfully*********");
		WebActions.click(ObjectInitializer.quotePage.get().Add_SKUs_button, "Click AddSKUs button");
		//WebActions.click(ObjectInitializer.quotePage.get().Selectbtn_Contract_Name("CMDEMO_27DEC"),"Selected contractname: CMDEMO_27DEC");
		WebActions.click(ObjectInitializer.quotePage.get().Selectbtn_Contract_Name("CONT_MAST_AUTO"),"Selected contractname: CONT_MAST_AUTO");
		//CONT_MAST_AUTO
		WebActions.click(ObjectInitializer.quotePage.get().Skip_Addons_button,"click: skip add-on button");
		boolean visible = page.isVisible(ObjectInitializer.quotePage.get().Table_body);
		GenericAssertions.assertTrue(visible, "table body is visiable");
		WebActions.click(ObjectInitializer.quotePage.get().Save_and_Submit,"click: save&submit");
		WebActions.click(ObjectInitializer.quotePage.get().Related_botton,"click: Related button");
		WebActions.click(ObjectInitializer.quotePage.get().Quote_Unit_Name,"click: Quote unit name");

		String Actal_Inventory= ObjectInitializer.quotePage.get().Quote_Details("Inventory").innerText();
		GenericAssertions.assertEquals(Actal_Inventory, Exp_Inventory, " "+Actal_Inventory+"");
		logger.info("Text: \"********CONT_MAST_AUTO & SKUs added sucessfully*********");

		String Actal_Quote_Number= ObjectInitializer.quotePage.get().Quote_Details("Quote").innerText();
		GenericAssertions.assertEquals(Actal_Quote_Number, Quote_number, " ");
		WebActions.click(ObjectInitializer.quotePage.get().Quote_Details("Quote"), "Click Quote:"+Actal_Quote_Number+"");
		status= ObjectInitializer.quotePage.get().Status.innerText();
		GenericAssertions.assertEquals("Approved", status, "Status:"+status+"");
		logger.info("Text: \"******** Status: Approved*********");

		WebActions.click(ObjectInitializer.quotePage.get().Quote_status_Change("Present Quote"), "Click: Present Quote");
		Waits.optionalWaitUntilElementIsVisible(ObjectInitializer.quotePage.get().proceed_btn, 5 , "Wait for element");
		WebActions.click(ObjectInitializer.quotePage.get().proceed_btn, "Click: Proceed button");
		Waits.waitForGivenTime(20000);
		status= ObjectInitializer.quotePage.get().Status.innerText();
		GenericAssertions.assertEquals("Presented", status, "Status:"+status+"");
		logger.info("Text: \"******** Status: Presented*********");

		WebActions.click(ObjectInitializer.quotePage.get().Quote_status_Change("Accept Quote"), "Click: Accept Quote");
		Waits.optionalWaitUntilElementIsVisible(ObjectInitializer.quotePage.get().acceptAll_btn, 5 , "Wait for element");
		WebActions.click(ObjectInitializer.quotePage.get().acceptAll_btn, "Click:Accept All");
		Waits.waitForGivenTime(5000);
		WebActions.click(ObjectInitializer.quotePage.get().proceed_btn, "Click: Proceed button");
		Waits.waitForGivenTime(5000);
		System.out.println("refresh window");
		page.reload();
		Waits.waitForPageLoad();
		status= ObjectInitializer.quotePage.get().Status.innerText();
//		if (status != "Accepted") {
//			System.out.println("refresh window");
//			page.reload();
//			Waits.waitForGivenTime(5000);	
//			status= ObjectInitializer.quotePage.get().Status.innerText();
//		}
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

}
