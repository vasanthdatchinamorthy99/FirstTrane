package com.project.CustomModules;

import static org.junit.Assert.assertTrue;

import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import org.apache.groovy.parser.antlr4.GroovyParser.IfElseStatementContext;
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

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
		Add_ContractMaster("CONT_MAST_AUTOSingle1008", "Guaranteed Maintenance Plan");
		RuleConfiguration();
		Waits.waitForGivenTime(2000);

		WebActions.click(ObjectInitializer.loginPage.get().Related_botton,"click: Related button");
		Add_Contract_SKU("CONT_SKU_AUTOSingle1008", 1);
		for (int j =1; j <=2; j++) {
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
		for (int i=1; i <=4; i++) {
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


	@Then("verify the Created contract master(.*)and(.*)is available in inventory Add skus list$")
	public void verify_the_created_contract_master_is_available_in_inventory_add_skus_list(String ContName,String ContType) {
		quotemthod.create_Quote(ContType);
		quotemthod.AddInventory("");
		WebActions.click(ObjectInitializer.quotePage.get().Add_SKUs_button, "Click AddSKUs button");
		String text = WebActions.getText(ObjectInitializer.quotePage.get().contract_Name(ContName));
		GenericAssertions.assertEquals(ContName, text, "Created contMaster is avaliable in the list");

	}


	@When("Create ContractMaster {string},{string}")
	public void create_contract_master(String ContractMasterName, String ContractType) {
		WebActions.click(ObjectInitializer.loginPage.get().More_arrow, "ViewProfileButton");
		WebActions.click(ObjectInitializer.loginPage.get().More_List("Contract Masters"), "Click: Contract Master");

		Waits.waitForGivenTime(3000);

		WebActions.click(ObjectInitializer.loginPage.get().New_Button, "Click: New");
		String text = WebActions.getText(ObjectInitializer.contractMasterPage.get().PopUpHeader);
		GenericAssertions.assertEquals("New Contract Master", text, "Popup Header ="+text+"");

		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Contract Master Name"), ContractMasterName, "EnterText: CONT_MAST_AUTO04 ");
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Description"), "Description_"+ContractMasterName+"", "Enter Text:Description_"+ContractMasterName+"");
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Contract Master Code"), ""+ContractMasterName+"CODE", "Enter Code ");

		WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2("Status"), "status search box");
		WebActions.click(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value("Active"), "Edit: Active");

		TodayDate = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("M/d/yyyy"));
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Active From"), TodayDate, "Enter Text:1/5/2027"); 
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Active Until"), "1/5/2027", "Enter Text:1/5/2027"); 

		WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2("Contract Type"), "Contract type search box");
		WebActions.click(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value(ContractType), "Contract Typeselected: Guaranteed Maintenance Plan");

		WebActions.click(ObjectInitializer.contractMasterPage.get().savebtn, "Click :Save Button");

		String Actual_ContractMasterName = WebActions.getText(ObjectInitializer.contractMasterPage.get().created_ContractMaster_Data("Contract Master Name"));
		GenericAssertions.assertEquals(ContractMasterName, Actual_ContractMasterName, Actual_ContractMasterName);

		String Actual_ContractType = WebActions.getText(ObjectInitializer.contractMasterPage.get().created_ContractMaster_Data("Contract Type"));
		GenericAssertions.assertEquals(ContractType, Actual_ContractType, Actual_ContractType);

	}

	@When("Add RuleConfigurations {string},{string},{string},{string}")
	public void add_rule_configurations(String selected_Createria, String Warranty_Product_Fields,String Operator, String Value) {
		//		selected_Createria="Record";
		//		Warranty_Product_Fields="Item Type";
		//		Operator="equals";
		//		Value="Machine";
		WebActions.click(ObjectInitializer.contractMasterPage.get().AddConditionbtn, "click : Add Condition");
		WebActions.click(ObjectInitializer.contractMasterPage.get().CreateNewCondition, "Click : New Condition");
		WebActions.click(ObjectInitializer.contractMasterPage.get().PleaseSelectCriteria, "Click : Please select Creatria inputbox");
		WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue(selected_Createria), "selected Createria"+selected_Createria+"");
		WebActions.click(ObjectInitializer.contractMasterPage.get().WarrantyProductFields, "Click : Warranty Product Fields");
		WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue(Warranty_Product_Fields), "Warranty Product Fields="+Warranty_Product_Fields+"");


		WebActions.click(ObjectInitializer.contractMasterPage.get().selectbtn, "Click: Status dropdownList");
		WebActions.click(ObjectInitializer.contractMasterPage.get().Operator, "Click : Operator inputbox");
		WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue(Operator), "Record selected="+Operator+"");


		WebActions.click(ObjectInitializer.contractMasterPage.get().Value, "Click : Value inputbox");
		WebActions.click(ObjectInitializer.quotePage.get().select_DropdownValue(Value), "Record selected Createria");
		WebActions.click(ObjectInitializer.contractMasterPage.get().savebtn, "Click :Save Button");
		WebActions.click(ObjectInitializer.contractMasterPage.get().Close, "close button");
		page.dragAndDrop("//*[contains(text(),'"+Value+"')]//ancestor::div[@draggable='true']", "//*[@class='droppablestyle']");
		// page.dragAndDrop("//*[contains(text(),'"+Warranty_Product_Fields+"  Equals  Machine')]", Value)
		WebActions.click("(//*[@class='slds-size_4-of-12']//button)[1]", "Click Save Button");
		System.out.println("*********************************"+page.url());
		//		page.reload();
	}



	@When("Edit ContractMaster Datas {string},{string},{string}")
	public void Edit_ContractMaster_Datas(String ContMaster,String LabelName,String Value) {
		Waits.waitForGivenTime(2000);
		String pagetitle = page.title();
		if (!pagetitle.contains("Contract Master | Salesforce")) {
			WebActions.click(ObjectInitializer.loginPage.get().SearchBox, "");
			WebActions.enterText(ObjectInitializer.loginPage.get().InputSearchBox, ContMaster, "Enter Text"+ContMaster+"");
			WebActions.click(ObjectInitializer.loginPage.get().SearchBox_Value(ContMaster), "");
		}
		String text ="";
		switch (LabelName) {
		case "Contract Master Name":
			WebActions.click(ObjectInitializer.contractMasterPage.get().EditInfo_button(LabelName), ""+Value+"Edit Button clicked");
			WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Contract Master Name"), Value, "Edit: "+Value+"");
			WebActions.click(ObjectInitializer.contractMasterPage.get().savebtn, "Click :Save Button");
			text = WebActions.getText(ObjectInitializer.contractMasterPage.get().created_ContractMaster_Data(LabelName));
			GenericAssertions.assertEquals(Value, text, "Value Edited successfully");
			break;
		case "Description":
			WebActions.click(ObjectInitializer.contractMasterPage.get().EditInfo_button(LabelName), ""+Value+"Edit Button clicked");
			WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Description"), Value, "Edit: "+Value+"");
			WebActions.click(ObjectInitializer.contractMasterPage.get().savebtn, "Click :Save Button");
			text = WebActions.getText(ObjectInitializer.contractMasterPage.get().created_ContractMaster_Data(LabelName));
			GenericAssertions.assertEquals(Value, text, "Value Edited successfully");
			break;
		case "Contract Master Code":
			WebActions.click(ObjectInitializer.contractMasterPage.get().EditInfo_button(LabelName), ""+Value+"Edit Button clicked");
			WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Contract Master Code"), Value, "Edit: "+Value+"");
			WebActions.click(ObjectInitializer.contractMasterPage.get().savebtn, "Click :Save Button");
			text = WebActions.getText(ObjectInitializer.contractMasterPage.get().created_ContractMaster_Data(LabelName));
			GenericAssertions.assertEquals(Value, text, "Value Edited successfully");
			break;
		case "Active From":
			WebActions.click(ObjectInitializer.contractMasterPage.get().EditInfo_button(LabelName), ""+Value+"Edit Button clicked");
			WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Active From"), Value, "Edit: "+Value+"");
			WebActions.click(ObjectInitializer.contractMasterPage.get().savebtn, "Click :Save Button");
			text = WebActions.getText(ObjectInitializer.contractMasterPage.get().created_ContractMaster_Data(LabelName));
			GenericAssertions.assertEquals(Value, text, "Value Edited successfully");
			break;
		case "Active Until":
			WebActions.click(ObjectInitializer.contractMasterPage.get().EditInfo_button(LabelName), ""+Value+"Edit Button clicked");
			WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Active Until"), Value, "Edit: "+Value+"");
			WebActions.click(ObjectInitializer.contractMasterPage.get().savebtn, "Click :Save Button");
			text = WebActions.getText(ObjectInitializer.contractMasterPage.get().created_ContractMaster_Data(LabelName));
			GenericAssertions.assertEquals(Value, text, "Value Edited successfully");
			break;
		case "Contract Type":
			WebActions.click(ObjectInitializer.contractMasterPage.get().EditInfo_button(LabelName), ""+Value+"Edit Button clicked");
			WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2(LabelName), "Contract type search box");
			WebActions.click(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value(Value), "Edit: "+Value+"");
			WebActions.click(ObjectInitializer.contractMasterPage.get().savebtn, "Click :Save Button");
			text = WebActions.getText(ObjectInitializer.contractMasterPage.get().created_ContractMaster_Data(LabelName));
			GenericAssertions.assertEquals(Value, text, "Value Edited successfully");
			break;
		case"Status":
			WebActions.click(ObjectInitializer.contractMasterPage.get().EditInfo_button(LabelName), ""+Value+"Edit Button clicked");
			WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2(LabelName), "status search box");
			WebActions.click(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value(Value), "Edit: "+Value+"");
			WebActions.click(ObjectInitializer.contractMasterPage.get().savebtn, "Click :Save Button");
			text = WebActions.getText(ObjectInitializer.contractMasterPage.get().created_ContractMaster_Data(LabelName));
			GenericAssertions.assertEquals(Value, text, "Value Edited successfully");

		default:
			System.out.println("+++++++++++++++++++++++++++++++++++++++++default case");
			break;
		}
	}

	@When("Edit RuleConfigurations {string}")
	public void edit_rule_configurations(String Value) {

		Waits.waitForGivenTime(5000);
		page.locator("//*[text()='Filter Logic']//ancestor::lightning-layout-item//child::*[@data-key='edit']").click();
		page.locator("//*[text()='Filter Logic']//parent::div//child::input").clear();
		page.locator("//*[text()='Filter Logic']//parent::div//child::input").type(Value);
		//		Locator locator = page.locator("//*[@class='slds-m-left_medium']");
		//		List<Locator> all = locator.all();
		//String Value1="";
		//
		//for (int i = 1; i <=all.size(); i++) {
		//	Value1 = all.get(i).innerText();
		//	
		//	
		//}
	}

	@And("Deactivate the ContractMaster {string}")
	public void deactivate_the_contract_master(String string) {
		String pagetitle = page.title();
		if (!pagetitle.contains("Contract Master | Salesforce")) {
			WebActions.click(ObjectInitializer.loginPage.get().SearchBox, "");
			WebActions.enterText(ObjectInitializer.loginPage.get().InputSearchBox, string, "Enter Text"+string+"");
			WebActions.click(ObjectInitializer.loginPage.get().SearchBox_Value(string), "");
		}
		WebActions.click(ObjectInitializer.quotePage.get().Status_Change_button("Deactivate Contract"), "Click: Deactivate Contract");

		Waits.optionalWaitUntilElementIsVisible(ObjectInitializer.quotePage.get().proceed_btn, 5 , "Wait for element");
		
		String innerText = ObjectInitializer.contractMasterPage.get().DeactivateContract_Header.innerText();
		GenericAssertions.assertEquals("Deactivate Contract", innerText, "popupHeader:"+innerText+"");
		
		WebActions.click(ObjectInitializer.quotePage.get().proceed_btn, "Click: Proceed button");
		BrowserActions.reload();
		Waits.waitForPageLoad();
		String Status = WebActions.getText(ObjectInitializer.contractMasterPage.get().created_ContractMaster_Data("Status"));
		GenericAssertions.assertEquals("Inactive", Status, "Assert pass status= "+Status+"");
		logger.info("   sucessfully Deactivated the ContractMaster   ");
		

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

		WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2("Status"), "status search box");
		WebActions.click(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value("Active"), "Edit: Active");

		TodayDate = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("M/d/yyyy"));
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Active From"), TodayDate, "Enter Text:1/5/2027"); 
		WebActions.enterText(ObjectInitializer.contractMasterPage.get().contract_Master_Feilds("Active Until"), "1/5/2027", "Enter Text:1/5/2027"); 

		WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2("Contract Type"), "Contract type search box");
		WebActions.click(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value(ContractType), "Contract Typeselected: Guaranteed Maintenance Plan");

		WebActions.click(ObjectInitializer.contractMasterPage.get().savebtn, "Click :Save Button");

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
		WebActions.click("(//*[@class='slds-size_4-of-12']//button)[1]", "Click Save Button");
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

		WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2("Status"), "Status");
		WebActions.click(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value("Active"), "dropdown selected=Active");

		WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2("Duration Type"), "Duration Type");
		WebActions.click(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value("Year"), "dropdown selected= Year");

		WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2("Usage UOM"), "Usage UOM");
		WebActions.click(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value("Minutes"), "dropdown selected= Minutes");

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


		WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2("Type"), "Status");
		WebActions.click(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value("Maintenance"), "dropdown selected= Add-On Maintenance");

		WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2("Start Duration Type"), "Start Duration Type");
		WebActions.click(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value("Months"), "dropdown selected= Months");

		WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2("Usage UOM"), "Usage UOM");
		WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2("Usage UOM"), "Usage UOM");
		ObjectInitializer.contractMasterPage.get().SelectDropdown_Value("KM").click();

		WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2("End Duration Type"), "End Duration Type");
		Waits.waitForGivenTime(3000);
		//		Waits.waitUntilElementIsVisible(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value(""), "6" );
		//		WebActions.click(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value("Year"), "dropdown selected= Days");
		//		ObjectInitializer.contractMasterPage.get().SelectDropdown_Value("Year").first().click();

		//	page.getByTitle("Year").first().click();

		page.keyboard().press("ArrowDown");
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");

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


		WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2("Type"), "Status");
		WebActions.click(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value("Add-On Maintenance"), "dropdown selected= Add-On Maintenance");

		WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2("Start Duration Type"), "Start Duration Type");
		WebActions.click(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value("Months"), "dropdown selected= Months");


		WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2("Usage UOM"), "Usage UOM");
		WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2("Usage UOM"), "Usage UOM");
		ObjectInitializer.contractMasterPage.get().SelectDropdown_Value("KM").click();


		WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2("End Duration Type"), "End Duration Type");
		Waits.waitForGivenTime(5000);
		//Waits.waitUntilElementIsVisible(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value("Days"), "6" );
		//WebActions.click(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value("Days"), "dropdown selected= Days");
		page.keyboard().press("ArrowDown");
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");


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


		WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2("Type"), "Status");
		WebActions.click(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value("Extended Warranty"), "dropdown selected= Extended Warranty");

		WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2("Start Duration Type"), "Start Duration Type");
		WebActions.click(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value("Months"), "dropdown selected= Months");

		WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2("Usage UOM"), "Usage UOM");
		WebActions.click(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value("KM"), "dropdown selected= Months");

		WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2("End Duration Type"), "End Duration Type");
		Waits.waitForGivenTime(5000);
		//Waits.waitUntilElementIsVisible(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value("Days"), "6" );
		//WebActions.click(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value("Days"), "dropdown selected= Days");
		page.keyboard().press("ArrowDown");
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");


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

		WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2("Type"), "Status");
		WebActions.click(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value("Add-On Extended Warranty"), "dropdown selected= Add-On Extended Warranty");

		WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2("Start Duration Type"), "Start Duration Type");
		WebActions.click(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value("Months"), "dropdown selected= Months");

		WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2("Usage UOM"), "Usage UOM");
		WebActions.click(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value("KM"), "dropdown selected= Months");

		WebActions.click(ObjectInitializer.contractMasterPage.get().Contract_Master_Feild2("End Duration Type"), "End Duration Type");
		//		WebActions.click(ObjectInitializer.contractMasterPage.get().SelectDropdown_Value("Months"), "dropdown selected= Months");

		page.keyboard().press("ArrowDown");
		page.keyboard().press("ArrowDown");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");

		WebActions.click("//*[text()='Coverage']//parent::*//child::div//*[contains(@id,'combobox-input')]", "Click: Clame template");
		Waits.waitForGivenTime(1000);
		page.keyboard().press("Enter");

		WebActions.click(ObjectInitializer.contractMasterPage.get().OEM_Parts, "Click : OEM_Parts");
		WebActions.click(ObjectInitializer.contractMasterPage.get().Right_Arrow, "Click : Right Arrow >");

		WebActions.click(ObjectInitializer.contractMasterPage.get().Travel_By_Hours, "Click : Travel_By_Hours");
		WebActions.click(ObjectInitializer.contractMasterPage.get().Right_Arrow, "Click : Right Arrow >");

		WebActions.click(ObjectInitializer.contractMasterPage.get().savebtn, "Click : All");	

	}




}
