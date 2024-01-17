package com.project.CommonModules;

import static com.tavant.util.LocatorUtils.getFieldLabelInLanguage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.tavant.base.PageFactory;

public class CommonLocators {

	public Locator SaveButton_CreationPage() {
		if (PageFactory.getPage().getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save").setExact(true))
				.isVisible())
			return PageFactory.getPage().getByRole(AriaRole.BUTTON,
					new Page.GetByRoleOptions().setName("Save").setExact(true));
		else
			return PageFactory.getPage().locator("lightning-button")
					.filter(new Locator.FilterOptions().setHasText("Save"));
	}

	public Locator SaveButton_CreationPage = PageFactory.getPage()
			.locator("//button[text()='" + getFieldLabelInLanguage("CommomFields", "SaveButton") + "']").last();
	public Locator SaveAndNext = PageFactory.getPage().locator("//button[text()='Save and Next']");
	public Locator DeleteButton_DetailPage = PageFactory.getPage()
			.locator("//*[@apiname='Delete' and @title='Delete']");
	public Locator DeleteButton_DeletePopup = PageFactory.getPage()
			.locator("//*[@title='Delete' and @aria-live='off']");
	public Locator DeleteButton_Reletedtab = PageFactory.getPage().locator("//a[@title='Delete' and @role='menuitem']");
	public Locator CancelButton_DeleteConfirmationScreen = PageFactory.getPage().getByRole(AriaRole.BUTTON,
			new Page.GetByRoleOptions().setName("Cancel"));
	public Locator ValidateButton = PageFactory.getPage().getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
			.setName(getFieldLabelInLanguage("CommomFields", "ValidateButton")).setExact(true));
	public Locator ValidateAndSubmitButton = PageFactory.getPage().getByRole(AriaRole.BUTTON,
			new Page.GetByRoleOptions().setName(getFieldLabelInLanguage("CommomFields", "ValidateAndSubmitButton"))
					.setExact(true));

	public Locator toastTitle = PageFactory.getPage().locator("//span[text()='Success']");
	public Locator toast = PageFactory.getPage().locator("(//div[@role='alertdialog'])[1]");
	public Locator SuccessToast = PageFactory.getPage().locator(
			"(//*[@icon-name='utility:success'])[1]//following-sibling::div//span[contains(@class,'toastMessage')]");
	public Locator ErrorToast = PageFactory.getPage()
			.locator("//*[@icon-name='utility:error']//following-sibling::div//span");
	public Locator InfoToast = PageFactory.getPage().locator(
			"//*[@icon-name='utility:info']//following-sibling::div//div//div//span[contains(@class,'toastMessage')]");
	public Locator WarnToast = PageFactory.getPage().locator(
			"(//*[@icon-name='utility:warning'])[1]//following-sibling::div//span[contains(@class,'toastMessage')]");
	public Locator CloseToastMessage = PageFactory.getPage()
			.locator("(//div[@role='alertdialog'])[1]/button[@title='Close']");
	public Locator NextButton = PageFactory.getPage().getByRole(AriaRole.BUTTON,
			new Page.GetByRoleOptions().setName(getFieldLabelInLanguage("CommomFields", "NextButton")).setExact(true));
	public Locator UploadFilesButton = PageFactory.getPage().locator("//input[@type='file']");

	public Locator FieldLabel_DetailPage(int i) {
		if (ObjectInitializer.commonMethods.get().getUser().contains("DealerUser"))
			return PageFactory.getPage().locator("(//*[contains(@class, 'field-label')]/span)[" + i + "]");
		else
			return PageFactory.getPage()
					.locator("(//div[contains(@class,'active')]//*[contains(@class, 'field-label')]/span)[" + i + "]");

	}

	public Locator FieldLabel_DetailPage_Count() {
		if (ObjectInitializer.commonMethods.get().getUser().contains("DealerUser"))
			return PageFactory.getPage().locator("//*[contains(@class, 'field-label')]/span");
		else
			return PageFactory.getPage()
					.locator("//div[contains(@class,'active')]//*[contains(@class, 'field-label')]/span");
	}

	public Locator FieldValue_DetailPage(String fieldLabel) {

		if (PageFactory.getPage().locator("//div[contains(@class,'active')]//*[@field-label= '" + fieldLabel
				+ "']//*[@name='outputField']/child::*//div//a//span").isVisible()) {
			return PageFactory.getPage().locator("//div[contains(@class,'active')]//*[@field-label= '" + fieldLabel
					+ "']//*[@name='outputField']/child::*//div//a//span");
		} else {
			return PageFactory.getPage().locator("//div[contains(@class,'active')]//*[@field-label= '" + fieldLabel
					+ "']//*[@name='outputField']/child::*");
		}

	}

	public Locator FieldValueWithHyperLinks_DetailPage(String fieldLabel) {
		return PageFactory.getPage().locator("//div[contains(@class, 'active')]//*[text()= '" + fieldLabel
				+ "']/parent::*//following-sibling::*//a");
	}

	public Locator FieldValue_DetailPage_dealer_portal(String fieldLabel) {

		if (PageFactory.getPage()
				.locator("//span[text()='" + fieldLabel + "']//parent::div//following-sibling::div//span//span").first()
				.isVisible()) {
			return PageFactory.getPage()
					.locator("//span[text()='" + fieldLabel + "']//parent::div//following-sibling::div//span//span")
					.first();
		} else {

			return PageFactory.getPage()
					.locator("//span[text()='" + fieldLabel + "']//parent::div//following-sibling::div//span//div//a");
		}

	}

	public Locator selectDate(String date) {
//		if (PageFactory.getPage().getByRole(AriaRole.GRIDCELL, new Page.GetByRoleOptions().setName(date)).isVisible())
//			return PageFactory.getPage().getByRole(AriaRole.GRIDCELL, new Page.GetByRoleOptions().setName(date));
//		else
//			return PageFactory.getPage().locator(".slds-day_adjacent-month").first();

		return PageFactory.getPage().getByRole(AriaRole.GRIDCELL, new Page.GetByRoleOptions().setName(date));
	}

	public Locator ShowMoreActionItems_DetailPage = PageFactory.getPage().getByRole(AriaRole.BUTTON,
			new Page.GetByRoleOptions().setName("more actions"));
	public Locator RecordTypeTitle = PageFactory.getPage()
			.locator("//div[contains(@class, 'active')]//h1/div[contains(@class, 'entityNameTitle')]");
	public Locator RecordName = PageFactory.getPage()
			.locator("//div[contains(@class, 'active')]//div/parent::h1//lightning-formatted-text");
	public Locator RecordName_Dealer = PageFactory.getPage().locator("//div/parent::h1//span");
	public Locator SubmitButton = PageFactory.getPage().getByRole(AriaRole.BUTTON,
			new Page.GetByRoleOptions().setName("Submit"));

	public Locator SetupButton = PageFactory.getPage()
			.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Setup"))
			.getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Setup").setExact(true))
			.filter(new Locator.FilterOptions().setHasText("Setup"));
	public Locator HelpButton = PageFactory.getPage().getByRole(AriaRole.BUTTON,
			new Page.GetByRoleOptions().setName("Salesforce Help"));
	public Locator ViewProfileButton = PageFactory.getPage().getByRole(AriaRole.BUTTON,
			new Page.GetByRoleOptions().setName("View profile"));
	public Locator LogoutButton = PageFactory.getPage().locator("//a[text()='Settings']//following-sibling::a");

	public Locator RelatedTab = PageFactory.getPage().getByRole(AriaRole.TAB,
			new Page.GetByRoleOptions().setName("Related"));
	public Locator ActiveFrom_ActiveUntil_Date = PageFactory.getPage().locator(".slds-day_adjacent-month");

	public Locator recordNameFromListView(String recordName) {
		return PageFactory.getPage().locator("//*[text()='" + recordName + "']");
	}

	public Locator dropDownClick(String fieldName) {
		return PageFactory.getPage().locator("//label[text()='" + fieldName + "']//following-sibling::div//button");
	}

	public Locator moveToChosen(String fieldLabel) {
		return PageFactory.getPage().locator(
				"//*[text()='" + fieldLabel + "']//following-sibling::*//*[@title='Move selection to Chosen']");
	}

	public Locator getFieldLocator(String fieldName) {
		if (ObjectInitializer.commonMethods.get().getUser().contains("DealerUser")) {
			if (PageFactory.getPage()
					.locator("//span[text()='" + fieldName + "']//parent::div//following-sibling::div//span//a")
					.isVisible()) {
				return PageFactory.getPage()
						.locator("//span[text()='" + fieldName + "']//parent::div//following-sibling::div//span//a");
			} else {
				return PageFactory.getPage()
						.locator("//span[text()='" + fieldName + "']//parent::div//following-sibling::div//span//span");
			}
		} else
			return PageFactory.getPage().locator("//div[contains(@class,'active')]//*[@field-label= '" + fieldName
					+ "']//*[@name='outputField']/child::*");
	}

	public Locator getCheckBoxLocator2(String fieldName) {

//		if(PageFactory.getPage().locator("//span[text()='"+fieldName+"']//preceding-sibling::span").isVisible()) {

		return PageFactory.getPage().locator("//span[text()='" + fieldName + "']//preceding-sibling::span");
//		}
//		else {
//			
//			return PageFactory.getPage().locator("//*[contains(text(),'" + fieldName
//					+ "') and contains(@class,'label')]//ancestor::lightning-input//input[@type='checkbox']");
//		}
	}

	public Locator getFileUploadSuccessLocator(String fileName) {
		return PageFactory.getPage().locator("//p[text()='" + fileName + "']");
	}

	public Locator yesLocator = PageFactory.getPage().locator("//button[text()='Yes']");

	public Locator register = PageFactory.getPage().locator("//button[text()='Register']");

	public Locator showMoreActions = PageFactory.getPage()
			.locator("//*[@class='menu-button-item slds-dropdown-trigger slds-dropdown-trigger_click']//button");

	public Locator getDropdownPlaceHolderLocator(String fieldLabel) {
		return PageFactory.getPage().locator("(//*[contains(text(),'" + fieldLabel
				+ "') and contains(@class,'label')]//parent::*//button[contains(@aria-controls, 'dropdown-element')])[1]/span");
	}

	public Locator getTabLocator_DetailPage(String tabName) {
		return PageFactory.getPage().getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName(tabName));
	}

	public Locator getTableValueLocator_Generic(String tableHeader) {
		return PageFactory.getPage().getByRole(AriaRole.GRID, new Page.GetByRoleOptions().setName(tableHeader))
				.getByRole(AriaRole.LINK);
	}

	public Locator getTableValueLocator(String tableHeader, String value) {
		return PageFactory.getPage().getByRole(AriaRole.GRID, new Page.GetByRoleOptions().setName(tableHeader))
				.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName(value));
	}

	public Locator getTableHeaderLocator(String header) {
		return PageFactory.getPage().locator("//h2//*[contains(text(), '" + header + "')]");
	}

	public Locator getTableRowHeaderValueLocator_Generic(String tableHeader) {
		return PageFactory.getPage()
				.locator("//h2//*[contains(text(), '" + tableHeader + "')]//ancestor::article//table/tbody//th");
	}

	public Locator getTableColumnHeaderLocator_Generic(String header) {
		return PageFactory.getPage().locator("//h2//*[contains(text(), '" + header
				+ "')]//ancestor::article//table/thead//th[text() and (@aria-label!='Action')]");
	}

	public Locator getTableRowHeaderValueLocator(String tableHeader, String value) {
//		return PageFactory.getPage().locator("//h2//*[contains(text(), '" + tableHeader
//				+ "')]//ancestor::article//table/tbody//th//a[contains(., '" + value + "')]");

		String locatorXpath = "//h2//*[contains(text(), '" + tableHeader + "')]//ancestor::article//table/tbody//th//a";
		if (value.length() > 0)
			locatorXpath = locatorXpath + "[contains(., '" + value + "')]";

		return PageFactory.getPage().locator(locatorXpath);

	}

	public Locator getTableRowValueLocator_Generic(String tableHeader, int index) {
		return PageFactory.getPage().locator("//h2//*[contains(text(), '" + tableHeader
				+ "')]//ancestor::article//table/tbody//tr[" + index + "]//td/child::*[text()]");
	}

	public Locator getLookupFieldLocator(String fieldName) {

//		if (PageFactory.getPage().locator("(//label[text()='" + fieldName + "']//following-sibling::div//input)[1]").isVisible()) {

//		}
//		else {
//			
//			return PageFactory.getPage().locator("//span[text()='"+fieldName+"']//parent::div//following-sibling::div//span").first();
//		}

		if (!ObjectInitializer.commonMethods.get().getUser().equals("DealerUser")
				|| !ObjectInitializer.commonMethods.get().getUser().equals("GD_DealerUser")) {

			return PageFactory.getPage()
					.locator("(//label[text()='" + fieldName + "']//following-sibling::div//input)[1]");
		} else {

			return PageFactory.getPage()
					.locator("(//label[text()='" + fieldName + "']//following-sibling::div//input)[2]");
		}
	}

	public Locator selectLookupFieldValue(String option) {
		return PageFactory.getPage().locator("//lightning-base-combobox-formatted-text[@title= '" + option + "']")
				.first();
	}

	public Locator getSelectLookupFieldFirstSuggestionLoc(String option) {
		return PageFactory.getPage().locator("//span[@role='option']//*[contains(text(), '" + option + "')]");
	}

	public Locator getLookUpFieldWithValueLocator(String fieldLabel) {
		return PageFactory.getPage()
				.locator("(//label[text()='" + fieldLabel + "']//following-sibling::div//input[@type='text'])");
	}

//	public Locator getStandardDropDownLocator(String fieldName) {
//		return PageFactory.getPage().getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName(fieldName));
//	}

	public Locator getStandardDropDownLocator(String fieldName) {

//		if (PageFactory.getPage()
//				.locator("//span[text()='" + fieldName + "']//parent::label//following-sibling::div//select").isVisible()) {

		return PageFactory.getPage()
				.locator("//span[text()='" + fieldName + "']//parent::label//following-sibling::div//select");
		// }

//		else {
//			
//			return PageFactory.getPage()
//					.locator("//label[text()='"+fieldName+"']//following-sibling::div//button");
//		}
	}

	public Locator getDropDownLocator(String fieldName) {
		return PageFactory.getPage().locator("//*[text() = '" + fieldName
				+ "' and contains(@class,'label')]//parent::*//button[contains(@aria-controls, 'dropdown-element')]")
				.last();
	}

	public Locator getDateFieldLocator(String fieldName) {
		return PageFactory.getPage().locator("//label[text()='" + fieldName
				+ "']//parent::div//parent::lightning-datepicker//preceding-sibling::input");
	}

	public Locator getCheckBoxLocator(String fieldName) {
		return PageFactory.getPage().locator(
				"//span[text()='" + fieldName + "']//parent::*//following-sibling::*//input[@type='checkbox']");
	}

	public Locator selectValueFromDropdown(String fieldName, String option) {
		return PageFactory.getPage().locator("(//*[contains(text(),'" + fieldName
				+ "') and contains(@class,'label')]//parent::*//*[@role='option']//span[text()='" + option + "'])[1]");
		// return PageFactory.getPage().locator("//*[@title='"+option+"']");
	}

	public Locator getRadioButtonLocator(String fieldName, String option) {
		return PageFactory.getPage().locator(
				"//*[text()='" + fieldName + "']//following-sibling::div//div//label//span[text()='" + option + "']");
	}

	public Locator getTextFieldLocator(String fieldName) {
//		
//		if(PageFactory.getPage()
//				.locator("//label[text()='" + fieldName + "']//following-sibling::div//*[contains(@id, 'input')]").last().isVisible()) {

		return PageFactory.getPage()
				.locator("//label[text()='" + fieldName + "']//following-sibling::div//*[contains(@id, 'input')]")
				.last();
//		}
//		else {
//			
//			return PageFactory.getPage()
//					.locator("//span[text()='"+fieldName+"']//parent::div//following-sibling::div//span").first();
//		}
	}

	public Locator getPickListLocator(String fieldName, String option) {
		return PageFactory.getPage()
				.locator("//*[contains(text(),'" + fieldName + "')]//parent::*//span//span[text()='" + option + "']");
	}

	public Locator getQuickActionLocator(String optionName) {
		return PageFactory.getPage()
				.locator("//*[contains(@class, 'actionsContainer')]//*[@title='" + optionName + "']").first();
	}

	public Locator getQuickActionMenuItemLocator(String optionName) {

		if (ObjectInitializer.commonMethods.get().getUser().contains("DealerUser")) {

			return PageFactory.getPage().locator("//a[@title='" + optionName + "']");
		} else {

			return PageFactory.getPage().locator("//a[@role='menuitem']//span[text()='" + optionName + "']");
		}
	}

	public Locator getCommonButtonLocator(String buttonName) {
		return PageFactory.getPage().locator("//button[text()='" + buttonName + "']").last();
	}

	public Locator getMultiPickLiskOptionLocator(String fieldLabel, String option) {
		return PageFactory.getPage().locator("//*[text()='" + fieldLabel
				+ "']//following-sibling::*//*[text()='Available' or text()='Chosen']//parent::*/div//*[text()='"
				+ option + "']");
	}

	public Locator FieldMandatoryErrorMessage = PageFactory.getPage()
			.locator("//*[contains(@class, 'element__help')]//parent::*//label");

	public Locator FieldLabelMandatoryErrorMessage(String fieldLabel) {
		return PageFactory.getPage()
				.locator("//*[contains(@class, 'element__help')]//parent::*//label[text()='" + fieldLabel + "']");
	}

	public Locator FieldLabelMandatoryErrorMessage(String fieldLabel, String message) {
//		return PageFactory.getPage()
//				.locator("//*[text()='"+message+"']//parent::*//label[text()='"+fieldLabel+"]");

		return PageFactory.getPage().locator(
				"//label[text()='" + fieldLabel + "']//parent::*//following-sibling::div[text()='" + message + "']");
	}

	public String UploadFile = "//input[@type='file']";
	public String BulkUpload_UploadFile = "//div[contains(@class, 'active')]//input[@type='file']";

	public Locator selectFirstObject() {
		if (ObjectInitializer.commonMethods.get().getUser().equals("DealerUser"))
			return PageFactory.getPage().locator("(//table//tbody//tr//th//a)[1]");
		else
			return PageFactory.getPage().locator(
					"(//div[contains(@class, 'active')]//div[contains(@class, 'listView')]//table//tbody//tr//th//a)[1]");
	}

	public Locator EditPageHeader = PageFactory.getPage().getByRole(AriaRole.HEADING,
			new Page.GetByRoleOptions().setName("Edit"));

	public Locator profileMenuDropdown = PageFactory.getPage()
			.locator("//div[@data-aura-class='uiMenu selfServiceUserProfileMenu']//span[2]");

	public Locator dealerLogout = PageFactory.getPage().locator("//a[text()='Logout']");

	public Locator accountLocator = PageFactory.getPage()
			.locator("//label[text()='Account']//following-sibling::div//input[@placeholder='Search..']");

	public Locator getLabelLocator(String fieldName) {
		return PageFactory.getPage().locator("//span[text()='" + fieldName + "']").last();
	}

	public Locator getTabLocatorDealerPortal(String tabName) {
		return PageFactory.getPage().locator("//span[text()='" + tabName + "']");
	}

	public Locator getObjectLinkDealerPortal(String objectName) {
		return PageFactory.getPage().locator("//a[text()='" + objectName + "']");
	}

	public Locator seeAllResults_LookupField(String option) {
		return PageFactory.getPage().locator("//*[text()='Show All Results for \"" + option + "\"']");
	}

	public Locator getLinkLocator_Generic(String recordName) {
		return PageFactory.getPage().getByRole(AriaRole.LINK,
				new Page.GetByRoleOptions().setName(recordName).setExact(true));
	}

	public Locator getNewButtonLocator_RelatedTab(String sectionName) {
		if (ObjectInitializer.commonMethods.get().getUser().contains("DealerUser"))
			return PageFactory.getPage().locator("//h2[contains(., '" + sectionName
					+ "')]//ancestor::*[contains(@class, 'firstHeaderRow') or contains(@class, 'flexi-truncate')]//following-sibling::*//*[@title='New']");
		else
			return PageFactory.getPage().locator("//div[contains(@class, 'active')]//h2[contains(., '" + sectionName
					+ "')]//ancestor::*[contains(@class, 'firstHeaderRow') or contains(@class, 'flexi-truncate')]//following-sibling::*//*[@title='New']");
	}

	public Locator getSnagMessageLocator(String expectedSnagMessage) {
		if (PageFactory.getPage().locator("//a[text()='" + expectedSnagMessage + "']").isVisible()) {
			return PageFactory.getPage().locator("//a[text()='" + expectedSnagMessage + "']");
		} else {
			return PageFactory.getPage().locator("//li[contains(text(),'" + expectedSnagMessage + "')]");
		}
	}

	public Locator SnagMessageHeader = PageFactory.getPage()
			.locator("//*[@role='dialog']//header//h2[text()='We hit a snag.']");
	public Locator SnagMessageBody = PageFactory.getPage()
			.locator("//*[@role='dialog']//*[contains(@class, 'LevelErrors')]");

	public Locator closeSnagMessage = PageFactory.getPage().locator("//button[@title='Close error dialog']");

	public Locator getActionLocator(String action) {

		return PageFactory.getPage().locator("//button[text()='" + action + "']");
	}

	public Locator closeMessage = PageFactory.getPage().locator("//span[text()='Close this window']");

	public Locator closeSnagMessage2 = PageFactory.getPage().locator("//*[@title='Error']");

	public Locator getObjectNameLink(String objectName) {

		return PageFactory.getPage().locator("//a[text()='" + objectName + "']");
	}

	public Locator getDropdownOptionLocator(String fieldName, String option) {

		return PageFactory.getPage().locator("//label[text()='" + fieldName
				+ "']//following-sibling::div//*//div//div//*//span//span[@title='" + option + "']");
	}

	public Locator clearSelectionField(String fieldName) {

		return PageFactory.getPage()
				.locator("//label[text()='" + fieldName + "']//following-sibling::div//*[@data-key='close']");
	}

	public Locator getExceptionMessageLocator(String message) {

		return PageFactory.getPage().locator("//p[text()='" + message + "']");
	}

	public Locator cancelLocator = PageFactory.getPage().locator("//button[@title='Cancel']");

	public Locator expandOrCollaspeSection(String sectionName) {

		return PageFactory.getPage().locator("//span[text()='" + sectionName + "']//parent::*[@aria-expanded]");
	}

	public Locator getFieldLabelLocator(String fieldName) {

		if (PageFactory.getPage().locator("//span[text()='" + fieldName + "']").last().isVisible()) {

			return PageFactory.getPage().locator("//span[text()='" + fieldName + "']").last();
		} else {

			return PageFactory.getPage().locator("//label[text()='" + fieldName + "']");
		}

	}

	public Locator externalCommentsLocator = PageFactory.getPage().locator("//textarea");

	public Locator send = PageFactory.getPage().locator("//button[text()='Send']");

	public Locator getDeleteFileLocator(String fileName) {

		return PageFactory.getPage().locator(
				"//p[text()='" + fileName + "']//parent::div//parent::div//parent::td//following-sibling::td//button");
	}

	public Locator fieldMeasurePopup = PageFactory.getPage()
			.locator("//b[text()='Checking for Field Measures on this Vehicle failed, to proceed click yes.']");

	public Locator warrantyRegistrationPopup = PageFactory.getPage()
			.locator("//b[text()='Do you want to perform warranty registration?']");

	public Locator getBreadCrumbLabelLoc(String status) {
		return PageFactory.getPage().locator("//div[text()='" + status + "']").last();
	}

	public Locator getUploadedFileLocator(String fileName) {
		return PageFactory.getPage().locator("//p[text()='" + fileName + "']");
	}

	public Locator listViewDropdown = PageFactory.getPage().locator("//*[@data-aura-class='forceListViewPicker']");

	public Locator listViewDropdownOption(String option) {
		return PageFactory.getPage().locator("(//div[@class='listContent']//li//*[text()='" + option + "'])[1]");
	}

	public Locator getShowMoreOption() {
		return PageFactory.getPage().locator("((//tbody)[3]//tr//td[5]//button)[1]");
	}

	public Locator deleteOption() {
		return PageFactory.getPage().locator("//span[text()='Delete']");
	}

	public Locator deletePopup() {
		return PageFactory.getPage().locator("//button[text()='Delete']");

	}

	public Locator getCampaignTemplate() {
		return PageFactory.getPage().locator("//span[text()='Campaign Template']/../..//select");
	}

	public Locator editOption(String parts) {
		return PageFactory.getPage()
				.locator("//td[contains(@data-label,'" + parts + "')]/..//button[@name='editRecord']");
	}

	public Locator deleteOption(String parts) {
		return PageFactory.getPage().locator("//td[contains(@data-label,'" + parts + "')]/..//button[@title='delete']");
	}

	public Locator getThePrice(String parts) {
		return PageFactory.getPage().locator("(//td[contains(@data-label,'Cults')]/..//td)[4]");
	}
//    public Locator proceed() 
//    {
//        return PageFactory.getPage().locator("//button[text()='Proceed']");
//    }
}
