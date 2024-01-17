package com.project.CommonModules;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.Logger;

import com.microsoft.playwright.TimeoutError;
import com.project.utils.TestDataInputMethods;
import com.tavant.actions.BrowserActions;
import com.tavant.actions.WebActions;
import com.tavant.assertions.AssertionLibrary;
import com.tavant.assertions.GenericAssertions;
import com.tavant.listeners.CustomLogger;
import com.tavant.util.LocatorUtils;
import com.tavant.util.PropertiesUtils;
import com.tavant.waits.Waits;
import com.twod.CommonModules.CommonActions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CommonMethods {

	private final Logger logger = new CustomLogger(CommonMethods.class);

	static ThreadLocal<Integer> testDataIndex = new ThreadLocal<Integer>();

	@Given("Register TestData Index-(.*)$")
	public void registerTestDataIndex(int testDataID) {
		logger.debug("Entered " + Thread.currentThread().getStackTrace()[1].getMethodName());
		testDataIndex.set(testDataID);
		logger.debug("Exited " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public String getUser() {
		logger.info("Logged In User: " + Thread.currentThread().getName());
		return Thread.currentThread().getName();
	}

	public int getTestDataIndex() {
		return testDataIndex.get();
	}

	/**
	 * Navigate To Login Page and Login to Application as Different Users
	 * 
	 * @param user
	 * @throws InterruptedException
	 */
	@Given("Navigate To Login Page and Login to Application as (.*)$")
	public void loginToApplication(String user) throws InterruptedException {
		logger.debug("Entered " + Thread.currentThread().getStackTrace()[1].getMethodName());
		switch (user) {
		case "Internal":
			BrowserActions.navigateTo(PropertiesUtils.getInternalUserURL());
			loginToApplicationAsInternalUser(user);
			Thread.currentThread().setName("Internal");
//			break;
//		case "SystemAdmin":
//			BrowserActions.navigateTo(PropertiesUtils.getInternalUserURL());
//			loginToApplicationAsInternalUser(user);
//			Thread.currentThread().setName("SystemAdmin");
//			break;
//		case "DealerUser":
//			BrowserActions.navigateTo(PropertiesUtils.getExternalUserURL());
//			loginToApplicationAsExternalUser(user);
//			Thread.currentThread().setName("DealerUser");
//			break;
//		case "GD_DealerUser":
//			BrowserActions.navigateTo(PropertiesUtils.getExternalUserURL());
//			loginToApplicationAsExternalUser(user);
//			Thread.currentThread().setName("GD_DealerUser");
//			break;
//		case "GD_Retailer":
//			BrowserActions.navigateTo(PropertiesUtils.getExternalUserURL());
//			loginToApplicationAsExternalUser(user);
//			Thread.currentThread().setName("GD_DealerUser_Retailer");
//			break;
//		case "ActiveAccountDealerUser":
//			BrowserActions.navigateTo(PropertiesUtils.getExternalUserURL());
//			loginToApplicationAsExternalUser(user);
//			Thread.currentThread().setName("ActiveAccountDealerUser");
//			break;
//		case "ClaimProcessor":
//			BrowserActions.navigateTo(PropertiesUtils.getInternalUserURL());
//			loginToApplicationAsInternalUser(user);
//			Thread.currentThread().setName("ClaimProcessor");
//			break;
//		case "FieldMeasureAdmin":
//			BrowserActions.navigateTo(PropertiesUtils.getInternalUserURL());
//			loginToApplicationAsInternalUser(user);
//			Thread.currentThread().setName("FieldMeasureAdmin");
			break;
		default:
			GenericAssertions.assertTrue(false, "Assertion Failed: Given User " + user
					+ " is not a Valid User, Accepted Users are SystemAdmin/WarrantyAdmin/DealerUser/ClaimProcessor/ActiveAccountDealerUser",
					"");
			break;
		}
		Waits.waitForPageLoad();
		getUser();
		logger.debug("Exited " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@And("Logout from Dealer Portal")
	public void logoutFromDealerUser() {

		WebActions.click(ObjectInitializer.commonLocators.get().profileMenuDropdown, "Profile menu dropdown");
		Waits.waitUntilElementIsVisible(ObjectInitializer.commonLocators.get().dealerLogout, "Dealer User Logout");
		WebActions.click(ObjectInitializer.commonLocators.get().dealerLogout, "Dealer User Logout");
		Waits.waitForPageLoad();
	}

	@Given("Login To Existing Dealer User Session")
	public void LoginIntoExistingDealerSession() {

		BrowserActions.navigateTo(PropertiesUtils.getExternalUserURL());
		Thread.currentThread().setName("DealerUser");
		Waits.waitForPageLoad();
	}

	/**
	 * Login To Application As Internal User
	 * 
	 * @param user
	 */
	private void loginToApplicationAsInternalUser(String user) {
		String userRefField = user + "_UserName";
		String pwdRefField = user + "_Password";
//		WebActions.enterText(ObjectInitializer.loginPage.get().username, PropertiesUtils.getProperty(userRefField),
//				"username");
//		WebActions.enterText(ObjectInitializer.loginPage.get().password, PropertiesUtils.getProperty(pwdRefField),
//				"password");
     //   TestDataInputMethods.getTestData(userRefField, pwdRefField)
		LocatorUtils.enterDataIntoField("LoginPage", "Username", getTestDataIndex());
		LocatorUtils.enterDataIntoField("LoginPage", "Password", getTestDataIndex());

		WebActions.click(ObjectInitializer.loginPage.get().loginButton, "loginButton");
	}

	/**
	 * Login To Application As External User
	 * 
	 * @param user
	 */
	private void loginToApplicationAsExternalUser(String user) {
		String userRefField = user + "_UserName";
		String pwdRefField = user + "_Password";
		WebActions.enterText(ObjectInitializer.loginPage.get().DealerPortal_username,
				PropertiesUtils.getProperty(userRefField), "username");
		WebActions.enterText(ObjectInitializer.loginPage.get().DealerPortal_password,
				PropertiesUtils.getProperty(pwdRefField), "password");
		WebActions.click(ObjectInitializer.loginPage.get().loginButton, "loginButton");
	}

	/**
	 * @author Vikram.Nadella Logout from Internal User
	 */
	@And("Logout From Application as Internal User")
	public void logoutOfApplicatioAsInternalUser() {
		Waits.waitForPageLoad();
		if (!getUser().contains("DealerUser")) {
			WebActions.click(ObjectInitializer.commonLocators.get().ViewProfileButton, "ViewProfileButton");
			WebActions.click(ObjectInitializer.commonLocators.get().LogoutButton, "LogoutButton");
		}
		Waits.waitForPageLoad();
	}

	public void logoutFromApplication_Generic() {
		String user = getUser();
		if (user.contains("DealerUser"))
			logoutFromDealerUser();
		else
			logoutOfApplicatioAsInternalUser();
	}

	/**
	 * @author Vikram.Nadella
	 * @return Current Time
	 */
	public String getcurrentTime(String format) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
		LocalDateTime now = LocalDateTime.now();
		logger.info("Current Time is " + dateTimeFormatter.format(now));
		return dateTimeFormatter.format(now);
	}

	/**
	 * @author Vikram.Nadella
	 * @param num
	 * @param format
	 * @return Formatted Date
	 */
	public String getPreviousFutureDate(int num, String format) {
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat(format);
		cal.add(Calendar.DATE, num);
		logger.info(num + " days Previous Date is " + dateFormat.format(cal.getTime()));
		return dateFormat.format(cal.getTime());
	}

	public static String changeDateFormat(String date, String currentFormat, String expectedfFormat)
			throws ParseException {
		Date dt = new SimpleDateFormat(currentFormat).parse(date);
		return new SimpleDateFormat(expectedfFormat).format(dt);
	}

	@And("Click on Submit Button")
	public void clickOnSubmitButton() {
		WebActions.click(ObjectInitializer.commonLocators.get().SubmitButton, "Submit button");
	}

	@And("Click on Next Button")
	public void clickOnNextButton() {
		WebActions.click(ObjectInitializer.commonLocators.get().NextButton.first(), "Next Button");
	}

	@And("Validate the (.*)$")
	public void clickOnValidate(String recordName) {
		WebActions.click(ObjectInitializer.commonLocators.get().ValidateButton, "ValidateButton");
		ObjectInitializer.commonMethods.get().verifyToastMessage();
	}

	@And("Submit the (.*)$")
	public void clickOnSubmit(String recordName) {
		ObjectInitializer.commonMethods.get().clickOnSubmitButton();
		ObjectInitializer.commonMethods.get().verifyToastMessage();
	}

	@And("Verify Success Message")
	public void verifyToastMessage() {
		for (int i = 1; i <= 2; i++) {
			try {
				Waits.waitUntilElementIsVisible(ObjectInitializer.commonLocators.get().toast.first(), "Toast Message");
				if (ObjectInitializer.commonLocators.get().SuccessToast.isVisible()
						&& ObjectInitializer.commonLocators.get().ErrorToast.isVisible()) {
					logger.info("Success Toast Message: "
							+ WebActions.getText(ObjectInitializer.commonLocators.get().SuccessToast));
					logger.info("Error Toast Message: "
							+ WebActions.getText(ObjectInitializer.commonLocators.get().ErrorToast));
					GenericAssertions.assertTrue(false,
							"Assertion Failed: Success Toast Message along with Error Toast Message are Displayed", "");
				}
				if (ObjectInitializer.commonLocators.get().SuccessToast.isVisible()) {
					logger.info("Success Toast Message: "
							+ WebActions.getText(ObjectInitializer.commonLocators.get().SuccessToast));
					closeToastMessage();
					GenericAssertions.assertTrue(true, "Assertion Successful: Success Toast is Displayed");
					break;
				}
				if (ObjectInitializer.commonLocators.get().ErrorToast.isVisible()) {
					logger.info("Error Toast Message: "
							+ WebActions.getText(ObjectInitializer.commonLocators.get().ErrorToast));
					GenericAssertions.assertTrue(false, "Assertion Failed: Error Toast "
							+ ObjectInitializer.commonLocators.get().ErrorToast + "is Displayed", "");
				}
				if (ObjectInitializer.commonLocators.get().InfoToast.isVisible()) {
					logger.info("Info Toast Message: "
							+ WebActions.getText(ObjectInitializer.commonLocators.get().InfoToast));
					GenericAssertions.assertTrue(true, "Assertion Successful: Info Toast is Displayed");
					break;
				}

			} catch (IllegalStateException exp) {
				continue;
			}
		}
	}

	@And("Validate Expected (.*) Toast$")
	public void validateExpectedToast(String toastType) {
		switch (toastType) {
		case "Success":
			AssertionLibrary.locatorIsVisible(ObjectInitializer.commonLocators.get().SuccessToast, "SuccessToast");
			break;
		case "Warn":
			AssertionLibrary.locatorIsVisible(ObjectInitializer.commonLocators.get().WarnToast, "WarnToast");
			break;
		case "Info":
			AssertionLibrary.locatorIsVisible(ObjectInitializer.commonLocators.get().InfoToast, "InfoToast");
			break;
		case "Error":
			AssertionLibrary.locatorIsVisible(ObjectInitializer.commonLocators.get().ErrorToast, "ErrorToast");
			break;

		default:
			logger.info("Invalid Toast Type, Allowed Types are Success/Warn/Error/Info");
			break;
		}
		closeToastMessage();
	}

	public void closeToastMessage() {
		if (ObjectInitializer.commonLocators.get().CloseToastMessage.isVisible()) {
			try {
				WebActions.click(ObjectInitializer.commonLocators.get().CloseToastMessage, "CloseToastMessage");
			} catch (TimeoutError e) {
			}
		}
	}

	@And("Validate (.*) Field value as (.*)$")
	public void validateFieldValue(String fieldLabel, String expectedValue) {
		Waits.waitForPageLoad();
		Waits.waitUntilElementIsVisible(ObjectInitializer.commonLocators.get().getFieldLocator(fieldLabel), fieldLabel);
		GenericAssertions.assertEquals(expectedValue, getFieldValue(fieldLabel),
				"Field Value of " + fieldLabel + " is " + expectedValue + ", Validated Successfully");
	}

	public String getFieldValue(String fieldLabel) {
		if (getUser().contains("DealerUser"))
			return WebActions
					.getText(ObjectInitializer.commonLocators.get().FieldValue_DetailPage_dealer_portal(fieldLabel));
		else
			return WebActions.getText(ObjectInitializer.commonLocators.get().FieldValue_DetailPage(fieldLabel));
	}

//	public void uploadFile(String selector, String fileName, String filePath) {
//		CommonActions.uploadFile(selector, fileName, filePath);
//		ObjectInitializer.commonMethods.get().verifyToastMessage();
//	}

	public void deleteFile(String fileName) {

		WebActions.click(ObjectInitializer.commonLocators.get().getDeleteFileLocator(fileName), "Delete file");
		ObjectInitializer.commonMethods.get().verifyToastMessage();
	}
}
