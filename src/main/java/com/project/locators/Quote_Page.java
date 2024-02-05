package com.project.locators;

import static com.tavant.util.LocatorUtils.getFieldLabelInLanguage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.tavant.base.PageFactory;

public class Quote_Page {


	Page page = PageFactory.getPage();


	//Variable
	
	public Locator Quotes            = page.locator("//*[@role='menuitem']//span[text()='Quotes']");
	public Locator New_Quotes        = page.locator("(//*[@title='New'])[1]");
	public Locator Search_Box        = page.locator("//*[@class='slds-grid slds-wrap slds-grow']//*[text()='Select']");
	public Locator Quote_Type        = page.locator("//*[@class='label'][text()='Guaranteed Maintenance Plan']");
	public Locator Save_button       = page.locator("//*[@class='slds-p-top_small slds-p-bottom_small']//button[text()='Save']"); 
	public Locator Latest_Quote      = page.locator("(//*[@role='grid']//tbody//th//a)[1]");
	public Locator Add_button	     = page.locator("//button[text()='Add'] ");
	public Locator Add_SKUs_button   = page.locator("//button[text()='Add SKUs'] ");
	public Locator Skip_Addons_button= page.locator("//button[text()='Skip Add-ons'] ");
//	public String Table_body         ="//*[@class='slds-table']//tbody ";
	public Locator Save_and_Submit   = page.locator("//button[text()='Save & Submit']");
//	public Locator Related_botton    = page.locator("//*[text()='Related'] ");
	public Locator Quote_Unit_Name   = page.locator("//*[text()='Quote Unit Name']//ancestor::thead//following-sibling::tbody//child::th//*[@class='slds-truncate'] ");
	public Locator Status            = page.locator("//*[text()='Status']//parent::div//following-sibling::div");
    public Locator proceed_btn       = page.locator("//button[text()='Proceed']");//"//*[@class='slds-m-left_x-small']//button[text()='Proceed']");
    public Locator acceptAll_btn     = page.locator("//button[text()='Accept All']");
    public Locator service_Contracts = page.locator(" //*[text()='Service Contracts']//ancestor::lst-list-view-manager-header//following-sibling::div//child::*[@class='slds-card__body slds-wrap slds-grid']");

    
//method
    public Locator AddSKUButton(String inventory) {
		 return page.locator("//*[text()='"+inventory+"']//ancestor::*[@class='slds-grid slds-wrap']//child::button[text()='Add SKUs']");
	}
    public Locator button(String Name) {
		return page.locator("//button[text()='"+Name+"']");
	}
    public Locator select_DropdownValue(String data) {
    	return page.locator("//*[@class='label'][text()='"+data+"']");
    }
	public Locator searchBox_Click(String value) {
		return page.locator("//*[text()='"+value+"']//parent::div//following-sibling::div//div//span[text()='Select']");
	}
	public String searchBox_Input(String Value) {
		return "//*[text()='"+Value+"']//parent::div//following-sibling::div//div//input";
	}
	public Locator Created_Quote_data(String data) {
		return page.locator("//*[text()='"+data+"']//parent::Lightning-output-field//*[@class='slds-form-element__static']");
	}
	public Locator Selectbtn_Contract_Name(String Name) {//CMDEMO_27DEC
		return page.locator("(//div[text()='"+Name+"']//ancestor::td//following-sibling::td)[5]//button[text()='Select'] ");
	}
	public Locator Quote_Details(String data) {
		return page.locator("//*[text()='"+data+"']//parent::div//following-sibling::div//child::a");
	}
	public Locator Status_Change_button(String status) {
		return page.locator("//*[@class='slds-button-group-list']//child::button[text()='"+status+"'] ");
	}
    public Locator contract_Name(String data) {
    	return page.locator("//div[text()='"+data+"']");
    }
    public Locator StatusChange(String value) {
    	return page.locator("//div[text()='"+value+"']");
    }

}
