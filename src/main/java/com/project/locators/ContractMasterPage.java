package com.project.locators;

import static com.tavant.util.LocatorUtils.getFieldLabelInLanguage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.tavant.base.PageFactory;

public class ContractMasterPage {

	Page page = PageFactory.getPage();
	
	public Locator SKU_Item_Header =page.locator("//*[@class='forceChangeRecordType']//h2");
	public Locator SKU_Item_Newbtn= page.locator("(//*[@title='New'])[3]");
	public Locator PopUpHeader =page.locator("//*[contains(@class,'slds-modal__header')]//h2");
	public Locator status_Button =page.locator("(//button[contains(@id,'combobox-button')])[1]");
	public Locator duration_Type =page.locator("(//button[contains(@id,'combobox-button')])[2]");
	public Locator usage_UOM =page.locator("(//button[contains(@id,'combobox-button')])[3]");
	public Locator Usage_UOM01=page.locator("(//button[contains(@id,'combobox-button')])[4]");
	public Locator savebtn =page.locator("//button[text()='Save']");
	public Locator CS_New_button =page.locator("//*[@class='slds-button slds-button_neutral'][text()='New']");
	public Locator next_btn = page.locator("//*[text()='Next']");
	public Locator left_Arrow =page.locator("(//*[@class='slds-dueling-list__column']//button)[2]");
	public Locator Right_Arrow =page.locator("(//*[@class='slds-dueling-list__column']//button)[1]");
	public Locator All =page.locator("//*[text()='All']");
	public Locator _SKU =page.locator("(//*[text()='CONT_SKU_AUTO03'])[1]");
	public Locator OEM_Parts=page.locator("//*[text()='OEM Parts']");
	public Locator Travel_By_Hours=page.locator("//*[text()='Travel By Hours']");
	public Locator selectbtn =page.locator("(//*[text()='Select'])[2]");
	
	//public Locator Travel=page.locator("//*[text()='Travel By Hours']");
	public Locator contract_Master_Feilds(String Label) {
		return page.locator(" //*[text()='"+Label+"']//following-sibling::div//*[contains(@id,'input')]");
	}
	//= page.locator("//*[text()='Contract Master Name']//following-sibling::div//input");
	
	public Locator created_ContractMaster_Data(String data) {
		return page.locator("(//*[text()='"+data+"']//parent::div//following-sibling::div//span)[1]");
	}
	
	public Locator Created_ContractSKU_Data(String data) {
		return page.locator("(//*[text()='"+data+"'])[1]");
	}
	public Locator SKU_Item_List(String data) {
		return page.locator("//div[contains(@class,'changeRecordType')]//*[text()='"+data+"']");
	}
}
