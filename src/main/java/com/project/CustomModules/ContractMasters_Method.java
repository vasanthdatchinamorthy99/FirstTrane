package com.project.CustomModules;

import static org.junit.Assert.assertTrue;

import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import org.apache.logging.log4j.Logger;
import org.joda.time.LocalDate;

import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.mongodb.assertions.Assertions;
import com.project.CommonModules.ObjectInitializer;
import com.tavant.actions.BrowserActions;
import com.tavant.actions.KeyBoardActions;
import com.tavant.actions.MouseActions;
import com.tavant.actions.WebActions;
import com.tavant.assertions.GenericAssertions;
import com.tavant.base.PageFactory;
import com.tavant.listeners.CustomLogger;
import com.tavant.waits.Waits;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ContractMasters_Method {


	private final Logger logger = new CustomLogger(Quote_Methods.class);
	Quote_Methods quotemthod = new Quote_Methods();
	Page page = PageFactory.getPage();
	String TodayDate="";
	/**
	 * @author Vasanth D
	 * @param Contract_Master
	 * @throws InterruptedException
	 */

	@Given("Create a MasterContract with Single Contract SKU and SKU items")
	public void create_a_master_contract_with_single_contract_sku_and_sku_items() {

		Waits.waitForGivenTime(3000);
		WebActions.click(ObjectInitializer.loginPage.get().More_arrow, "ViewProfileButton");
		WebActions.click(ObjectInitializer.loginPage.get().More_List("Contract Masters"), "Click: Contract Master");

		Waits.waitForGivenTime(3000);
		Add_ContractMaster("CONT_MAST_AUTOSingle04", "Guaranteed Maintenance Plan");
		RuleConfiguration();
		Waits.waitForGivenTime(2000);

		WebActions.click(ObjectInitializer.loginPage.get().Related_botton,"click: Related button");
		Add_Contract_SKU("CONT_SKU_AUTOSingle04", 1);
		for (int j =1; j <=4; j++) {
			if (j==1) {
				Waits.waitForGivenTime(1000);
				//GenericAssertions.assertTrue(false, TodayDate);
				WebActions.click(ObjectInitializer.loginPage.get().Related_botton2,"click: Related button");
				Waits.waitForGivenTime(1000);
				page.keyboard().press("Tab");
				page.keyboard().press("Tab");
				Waits.waitForGivenTime(1000);
				page.keyboard().press("Enter");
				Add_SKUItem_Maintenance();
			}else if (j==2) {
				WebActions.click(ObjectInitializer.loginPage.get().Related_botton2,"click: Related button");
				Waits.waitForGivenTime(1000);
				page.keyboard().press("Tab");
				page.keyboard().press("Tab");
				Waits.waitForGivenTime(1000);
				page.keyboard().press("Enter");
				Add_SKUItem_AddonMaintenance();
			}else if (j==3) {
				WebActions.click(ObjectInitializer.loginPage.get().Related_botton2,"click: Related button");
				Waits.waitForGivenTime(1000);
				page.keyboard().press("Tab");
				page.keyboard().press("Tab");
				Waits.waitForGivenTime(1000);
				page.keyboard().press("Enter");
				Add_SKUItem_ExtendedWarranty();
			}else if (j==4) {
				WebActions.click(ObjectInitializer.loginPage.get().Related_botton2,"click: Related button");
				Waits.waitForGivenTime(1000);
				page.keyboard().press("Tab");
				page.keyboard().press("Tab");
				Waits.waitForGivenTime(1000);
				page.keyboard().press("Enter");
				Add_SKUItem_AddOnExtendedWarranty();
			}
		}
	}


	@Given("Create a ContractMaster(.*)and(.*) with Multiple Contract SKU and SKU items$")
	public void create_a_contract_master_cont_type_with_Multiple_contract_sku_and_sku_items(String ContName ,String ContType) {
	   
		Waits.waitForGivenTime(3000);
		WebActions.click(ObjectInitializer.loginPage.get().More_arrow, "ViewProfileButton");
		WebActions.click(ObjectInitializer.loginPage.get().More_List("Contract Masters"), "Click: Contract Master");

		Waits.waitForGivenTime(3000);
		Add_ContractMaster(ContName, ContType);
		RuleConfiguration();
		Waits.waitForGivenTime(2000);

		WebActions.click(ObjectInitializer.loginPage.get().Related_botton,"click: Related button");
		String ContractSKU_URL = page.url();
		for (int i=1; i <=2; i++) {
			if (i==2) {
				System.out.println("*****************************************************I=2");
				page.navigate(ContractSKU_URL);
				Waits.waitForPageLoad();
				WebActions.click(ObjectInitializer.loginPage.get().Related_botton,"click: Related button");
				System.out.println("I=2");
			}
			System.out.println("************************************************************I=1");
			Add_Contract_SKU(""+ContName+">>SKU_00"+i+"",i);
			for (int j =1; j <=4; j++) {
				if (j==1) {
					Waits.waitForGivenTime(1000);
					WebActions.click(ObjectInitializer.loginPage.get().Related_botton2,"click: Related button");
					Waits.waitForGivenTime(1000);
					page.keyboard().press("Tab");
					page.keyboard().press("Tab");
					Waits.waitForGivenTime(1000);
					page.keyboard().press("Enter");
					Add_SKUItem_Maintenance();
				}else if (j==2) {
					WebActions.click(ObjectInitializer.loginPage.get().Related_botton2,"click: Related button");
					Waits.waitForGivenTime(1000);
					page.keyboard().press("Tab");
					page.keyboard().press("Tab");
					Waits.waitForGivenTime(1000);
					page.keyboard().press("Enter");
					Add_SKUItem_AddonMaintenance();
				}else if (j==3) {
					WebActions.click(ObjectInitializer.loginPage.get().Related_botton2,"click: Related button");
					Waits.waitForGivenTime(1000);
					page.keyboard().press("Tab");
					page.keyboard().press("Tab");
					Waits.waitForGivenTime(1000);
					page.keyboard().press("Enter");
					Add_SKUItem_ExtendedWarranty();
				}else if (j==4) {
					WebActions.click(ObjectInitializer.loginPage.get().Related_botton2,"click: Related button");
					Waits.waitForGivenTime(1000);
					page.keyboard().press("Tab");
					page.keyboard().press("Tab");
					Waits.waitForGivenTime(1000);
					page.keyboard().press("Enter");
					Add_SKUItem_AddOnExtendedWarranty();
				}
			}
		}
		
	}
















	/**
	 * @author Vasanth D 
	 *@param Create or Add New Contract Master
	 */
	public void Add_ContractMaster(String ContractMasterName, String ContractType) {

		WebActions.click(ObjectInitializer.loginPage.get().New_Button, "Click: New");
		String text = WebActions.getText(ObjectInitializer.contractMasterPage.get().PopUpHeader);
		GenericAssertions.assertEquals("New Contract Master", text, "Popup Header ="+text+"");
		//String ContractMasterName= "CONT_MAST_AUTO03";
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Contract Master Name"), ContractMasterName, "EnterText: CONT_MAST_AUTO04 ");
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Description"), "Description_"+ContractMasterName+"", "Enter Text:Description_"+ContractMasterName+"");
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Contract Master Code"), ""+ContractMasterName+"CODE", "EnterText=CONT_MAST_AUTO02 ");

		WebActions.click(ObjectInitializer.contractMasterPage.get().status_Button, "Click: Status dropdownList");
		page.keyboard().press("ArrowDown");
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");//selected Active
		//Waits.waitForGivenTime(3000);
		TodayDate = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("M/d/yyyy"));
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Active From"), TodayDate, "Enter Text:1/5/2027"); 
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Active Until"), "1/5/2027", "Enter Text:1/5/2027"); 

		WebActions.click(ObjectInitializer.contractMasterPage.get().contract_Type, "Contract type search box");
		WebActions.click(ObjectInitializer.contractMasterPage.get().contractType_Value(ContractType), "Contract Typeselected: Guaranteed Maintenance Plan");

		WebActions.click(ObjectInitializer.contractMasterPage.get().savebtn, "Click :Save Button");
		Waits.waitForGivenTime(3000);
		String Actual_ContractMasterName = WebActions.getText(ObjectInitializer.contractMasterPage.get().created_ContractMaster_Data("Contract Master Name"));
		GenericAssertions.assertEquals(ContractMasterName, Actual_ContractMasterName, Actual_ContractMasterName);

		String Actual_ContractType = WebActions.getText(ObjectInitializer.contractMasterPage.get().created_ContractMaster_Data("Contract Type"));
		GenericAssertions.assertEquals(ContractType, Actual_ContractType, Actual_ContractType);

	}
	/**
	 * @author Vasanth D 
	 *@param Contract Master RuleConfiguration
	 */
	public void RuleConfiguration() {
		WebActions.click("//*[text()='Add Condition']", "click : Add Condition");
		WebActions.click("//*[text()='Create New Condition']", "Click : New Condition");
		WebActions.click("(//*[@class=\"slds-grid slds-wrap slds-grow\"])[1]", "Click : Please select Creatria inputbox");
		WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue("Record"), "Record selected Createria");
		WebActions.click("//*[text()='Warranty Product fields']//parent::div//child::input", "Click : Warranty Product Fields");
		WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue("Item Type"), "Click : Item Type");


		WebActions.click(ObjectInitializer.contractMasterPage.get().selectbtn, "Click: Status dropdownList");
		WebActions.click("(//*[@class=\"slds-grid slds-wrap slds-grow\"])[2]", "Click : Operator inputbox");
		WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue("equals"), "Record selected Createria");


		WebActions.click("(//*[@class=\"slds-grid slds-wrap slds-grow\"])[4]", "Click : Operator inputbox");
		WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue("Machine"), "Record selected Createria");
		WebActions.click(ObjectInitializer.contractMasterPage.get().savebtn, "Click :Save Button");
		WebActions.click("//*[@class=\"title slds-grid slds-grid_align-spread\"]//button", "close button");
		page.dragAndDrop("//*[@data-type='WOD_2__Warranty_Product__c']", "//*[@class='droppablestyle']");
	}

	/**
	 * @author Vasanth D 
	 *@param ADD New Contract SKU
	 */
	public void Add_Contract_SKU(String ContractSKUName, int i) {
		WebActions.click(ObjectInitializer.contractMasterPage.get().CS_New_button,"click: CM_New button");
		Waits.waitForGivenTime(2000);
		String texts = WebActions.getText(ObjectInitializer.contractMasterPage.get().PopUpHeader);
		GenericAssertions.assertEquals("New Contract SKU", texts, "Popup Header ="+texts+"");
		//String ContractSKUName = "CONT_SKU_AUTO03";
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Contract SKU Name"), ContractSKUName, "Enter Text:"+ContractSKUName+"");

		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Description"), ""+ContractSKUName+"Description", "Enter Text:"+ContractSKUName+"");
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Contract SKU Code"), ""+ContractSKUName+"CODE", "Enter Text:"+ContractSKUName+"");
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Active From"), TodayDate, "Enter Text:1/5/2027"); 
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Active Until"), "1/5/2027", "Enter Text:1/5/2027"); 
		WebActions.click(ObjectInitializer.contractMasterPage.get().status_Button, "Click: Status dropdownList");
		page.keyboard().press("ArrowDown");
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");

		WebActions.click(ObjectInitializer.contractMasterPage.get().duration_Type, "Click: Status dropdownList");
		page.keyboard().press("ArrowDown");
		//page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");

		WebActions.click(ObjectInitializer.contractMasterPage.get().usage_UOM, "Click: Status dropdownList");
		page.keyboard().press("ArrowDown");
		page.keyboard().press("ArrowDown");
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");

		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Base Price"), ""+i+"000", "Enter Text:4000"); 
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Duration Value"), ""+i+"", "Enter Text:4"); 
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Usage Units"), ""+i+"000", "Enter Text:1000"); 
		WebActions.click(ObjectInitializer.contractMasterPage.get().All, "Click : All");
		WebActions.click(ObjectInitializer.contractMasterPage.get().Right_Arrow, "Click : Right Arrow >");
		WebActions.click(ObjectInitializer.contractMasterPage.get().savebtn, "Click : All");

		WebActions.click(ObjectInitializer.contractMasterPage.get().Created_ContractSKU_Data(ContractSKUName), "Click: "+ContractSKUName+"");
		//WebActions.selectFromDropdown(page.locator("(//*[@class=\"slds-listbox slds-listbox_vertical\"])[1]"), "All", "selected all");

		Waits.waitForGivenTime(3000);

		String Actual_ContractSKUName = WebActions.getText(ObjectInitializer.contractMasterPage.get().created_ContractMaster_Data("Contract SKU Name"));
		GenericAssertions.assertEquals(ContractSKUName, Actual_ContractSKUName, Actual_ContractSKUName);
	}
	/**
	 * @author Vasanth D 
	 *@param ADD SKU item Maintenance
	 */
	public void Add_SKUItem_Maintenance() {

		//	WebActions.click(ObjectInitializer.contractMasterPage.get().SKU_Item_Newbtn, "SKU_New button");
		String texts1 = WebActions.getText(ObjectInitializer.contractMasterPage.get().SKU_Item_Header);
		GenericAssertions.assertEquals("New SKU Item", texts1, "Popup Header ="+texts1+"");

		WebActions.click(ObjectInitializer.contractMasterPage.get().SKU_Item_List("Maintenance"),"click: Radio button=Add-On Maintenance");

		WebActions.click(ObjectInitializer.contractMasterPage.get().next_btn,"click:Next");
		Waits.waitForGivenTime(1000);

		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("SKU Item Name"), "SKUITEM", "Enter Text:SKUITEM"); 
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Description"), "SKUI_Maintenance", "Enter Text:SKUI_Maintenance"); 
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Start Duration Value"), "0", "Enter Text:0"); 
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("End Duration Value"), "5", "Enter Text:1"); 
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Start Usage"), "0", "Enter Text:0");
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("End Usage"), "500", "Enter Text:1000"); 
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Base Price"), "500", "Enter Text:4000"); 

		Waits.waitForGivenTime(1000);
		WebActions.click(ObjectInitializer.contractMasterPage.get().status_Button, "Click: Type Maintanance");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("ArrowDown");
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");
		System.out.println("************************************************Type Maintanance");

		WebActions.click(ObjectInitializer.contractMasterPage.get().duration_Type, "Click: Start Duration Type");
		page.keyboard().press("ArrowDown");
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");
		System.out.println("************************************************Start Duration Type");

		WebActions.click(ObjectInitializer.contractMasterPage.get().usage_UOM, "Click: Start Duration Type");
		page.keyboard().press("ArrowDown");
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");
		System.out.println("************************************************End Duration Type");

		WebActions.click(ObjectInitializer.contractMasterPage.get().Usage_UOM01, "Click: Usage UOM");
		Waits.waitForGivenTime(4000);
		page.keyboard().press("ArrowDown");
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(3000);
		page.keyboard().press("Enter");
		System.out.println("************************************************Usage UOM");

		WebActions.click("//*[text()='Claim Template']//parent::*//child::div//*[contains(@id,'combobox-input')]", "Click: Clame template");
		Waits.waitForGivenTime(1000);
		page.keyboard().type("Template");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("ArrowDown");
		page.keyboard().press("ArrowDown");
		page.keyboard().press("Enter");

		WebActions.click(ObjectInitializer.contractMasterPage.get().OEM_Parts, "Click : OEM_Parts");
		WebActions.click(ObjectInitializer.contractMasterPage.get().Right_Arrow, "Click : Right Arrow >");

		WebActions.click(ObjectInitializer.contractMasterPage.get().Travel_By_Hours, "Click : Travel_By_Hours");
		WebActions.click(ObjectInitializer.contractMasterPage.get().Right_Arrow, "Click : Right Arrow >");

		WebActions.click(ObjectInitializer.contractMasterPage.get().savebtn, "Click : All");

	}
	public void Add_SKUItem_AddonMaintenance() {
		//WebActions.click(ObjectInitializer.contractMasterPage.get().SKU_Item_Newbtn, "SKU_New button");
		String texts1 = WebActions.getText(ObjectInitializer.contractMasterPage.get().SKU_Item_Header);
		GenericAssertions.assertEquals("New SKU Item", texts1, "Popup Header ="+texts1+"");

		WebActions.click(ObjectInitializer.contractMasterPage.get().SKU_Item_List("Add-On Maintenance"),"click: Radio button=Add-On Maintenance");

		WebActions.click(ObjectInitializer.contractMasterPage.get().next_btn,"click:Next");
		Waits.waitForGivenTime(1000);

		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("SKU Item Name"), "SKUITEM", "Enter Text:SKUITEM"); 
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Description"), "SKUI_Add-On Maintenance", "Enter Text:SKUI_Add-On Maintenance"); 
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Start Duration Value"), "0", "Enter Text:0"); 
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("End Duration Value"), "1", "Enter Text:1"); 
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Start Usage"), "0", "Enter Text:0");
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("End Usage"), "1000", "Enter Text:1000"); 
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Base Price"), "4000", "Enter Text:4000"); 

		Waits.waitForGivenTime(1000);
		WebActions.click(ObjectInitializer.contractMasterPage.get().status_Button, "Click: Type Search box");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("ArrowDown");
		page.keyboard().press("ArrowDown");
		page.keyboard().press("ArrowDown");
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");
		System.out.println("************************************************Type Maintanance");

		WebActions.click(ObjectInitializer.contractMasterPage.get().duration_Type, "Click: Start Duration Type");
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");
		System.out.println("************************************************Start Duration Type");

		WebActions.click(ObjectInitializer.contractMasterPage.get().usage_UOM, "Click: End Duration Type");
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");
		System.out.println("************************************************End Duration Type");

		WebActions.click(ObjectInitializer.contractMasterPage.get().Usage_UOM01, "Click: Usage UOM");
		Waits.waitForGivenTime(3000);
		page.keyboard().press("ArrowDown");
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(3000);
		page.keyboard().press("Enter");
		System.out.println("************************************************Usage UOM");

		WebActions.click("//*[text()='Claim Template']//parent::*//child::div//*[contains(@id,'combobox-input')]", "Click: Clame template");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");

		WebActions.click(ObjectInitializer.contractMasterPage.get().OEM_Parts, "Click : OEM_Parts");
		WebActions.click(ObjectInitializer.contractMasterPage.get().Right_Arrow, "Click : Right Arrow >");

		WebActions.click(ObjectInitializer.contractMasterPage.get().Travel_By_Hours, "Click : Travel_By_Hours");
		WebActions.click(ObjectInitializer.contractMasterPage.get().Right_Arrow, "Click : Right Arrow >");

		WebActions.click(ObjectInitializer.contractMasterPage.get().savebtn, "Click : All");	
	}


	public void Add_SKUItem_ExtendedWarranty() {
		String texts1 = WebActions.getText(ObjectInitializer.contractMasterPage.get().SKU_Item_Header);
		GenericAssertions.assertEquals("New SKU Item", texts1, "Popup Header ="+texts1+"");
		WebActions.click(ObjectInitializer.contractMasterPage.get().SKU_Item_List("Extended Warranty"),"click: Radio button=Extended Warranty");

		WebActions.click(ObjectInitializer.contractMasterPage.get().next_btn,"click:Next");
		Waits.waitForGivenTime(1000);

		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("SKU Item Name"), "SKUITEM", "Enter Text:SKUITEM");

		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Start Duration Value"), "0", "Enter Text:0");

		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("End Duration Value"), "5", "Enter Text:2");

		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Start Usage"), "0", "Enter Text:500");

		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("End Usage"), "500", "Enter Text:1000");

		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Base Price"), "500", "Enter Text:5000");


		Waits.waitForGivenTime(1000);
		WebActions.click(ObjectInitializer.contractMasterPage.get().status_Button, "Click: Type Search box");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");
		System.out.println("************************************************Type Extended Warranty");

		WebActions.click(ObjectInitializer.contractMasterPage.get().duration_Type, "Click: Start Duration Type");
		page.keyboard().press("ArrowDown");
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");
		System.out.println("************************************************Start Duration Type");

		WebActions.click(ObjectInitializer.contractMasterPage.get().usage_UOM, "Click: End Duration Type");
		page.keyboard().press("ArrowDown");
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");
		System.out.println("************************************************End Duration Type");

		WebActions.click(ObjectInitializer.contractMasterPage.get().Usage_UOM01, "Click: Usage UOM");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");
		System.out.println("************************************************Usage UOM");

		WebActions.click("//*[text()='Coverage']//parent::*//child::div//*[contains(@id,'combobox-input')]", "Click: Clame template");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");

		WebActions.click(ObjectInitializer.contractMasterPage.get().OEM_Parts, "Click : OEM_Parts");
		WebActions.click(ObjectInitializer.contractMasterPage.get().Right_Arrow, "Click : Right Arrow >");

		WebActions.click(ObjectInitializer.contractMasterPage.get().Travel_By_Hours, "Click : Travel_By_Hours");
		WebActions.click(ObjectInitializer.contractMasterPage.get().Right_Arrow, "Click : Right Arrow >");

		WebActions.click(ObjectInitializer.contractMasterPage.get().savebtn, "Click : All");	

	}	

	//Add-On Extended Warranty

	public void Add_SKUItem_AddOnExtendedWarranty() {
		String texts1 = WebActions.getText(ObjectInitializer.contractMasterPage.get().SKU_Item_Header);
		GenericAssertions.assertEquals("New SKU Item", texts1, "Popup Header ="+texts1+"");
		WebActions.click(ObjectInitializer.contractMasterPage.get().SKU_Item_List("Add-On Extended Warranty"),"click: Radio button=Add-On Extended Warranty");

		WebActions.click(ObjectInitializer.contractMasterPage.get().next_btn,"click:Next");
		Waits.waitForGivenTime(1000);

		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("SKU Item Name"), "SKUITEM", "Enter Text:SKUITEM");

		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Start Duration Value"), "0", "Enter Text:0");

		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("End Duration Value"), "2", "Enter Text:2");

		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Start Usage"), "0", "Enter Text:500");

		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("End Usage"), "1000", "Enter Text:1000");

		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Base Price"), "2000", "Enter Text:5000");


		Waits.waitForGivenTime(1000);
		WebActions.click(ObjectInitializer.contractMasterPage.get().status_Button, "Click: Type Search box");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("ArrowDown");
		page.keyboard().press("ArrowDown");
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");
		System.out.println("************************************************Type Extended Warranty");

		WebActions.click(ObjectInitializer.contractMasterPage.get().duration_Type, "Click: Start Duration Type");
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");
		System.out.println("************************************************Start Duration Type");

		WebActions.click(ObjectInitializer.contractMasterPage.get().usage_UOM, "Click: End Duration Type");
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");
		System.out.println("************************************************End Duration Type");

		WebActions.click(ObjectInitializer.contractMasterPage.get().Usage_UOM01, "Click: Usage UOM");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");
		System.out.println("************************************************Usage UOM");

		WebActions.click("//*[text()='Coverage']//parent::*//child::div//*[contains(@id,'combobox-input')]", "Click: Clame template");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");

		WebActions.click(ObjectInitializer.contractMasterPage.get().OEM_Parts, "Click : OEM_Parts");
		WebActions.click(ObjectInitializer.contractMasterPage.get().Right_Arrow, "Click : Right Arrow >");

		WebActions.click(ObjectInitializer.contractMasterPage.get().Travel_By_Hours, "Click : Travel_By_Hours");
		WebActions.click(ObjectInitializer.contractMasterPage.get().Right_Arrow, "Click : Right Arrow >");

		WebActions.click(ObjectInitializer.contractMasterPage.get().savebtn, "Click : All");	

	}


	
	
	@Then("verify the Created contract master(.*)and(.*)is available in inventory Add skus list$")
	public void verify_the_created_contract_master_is_available_in_inventory_add_skus_list(String ContName,String ContType) {
		quotemthod.create_Quote(ContType);
		quotemthod.AddInventory("");
		WebActions.click(ObjectInitializer.quotePage.get().Add_SKUs_button, "Click AddSKUs button");
		String text = WebActions.getText(ObjectInitializer.quotePage.get().contract_Name(ContName));
		GenericAssertions.assertEquals(ContName, text, "Created contMaster is avaliable in the list");

		
	}
	
}
