package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.RandomData;
import com.liberate.automation.core.TestActions;

public class ExistingCustomer {
	TestActions action = null;
	RandomData random = new RandomData();

	public String AccountNumber = "";
	public String ServiceOrderNumber = "";
	public String ServiceNumber = "";

	By Proceed_Button = By.xpath("//input[@value='Proceed']");

	By ServiceOrder_Value = By.xpath("//*[text()='Service Order No:']//following::span[1]");

	// Existing Customer Screen
	By AccountNumber_Value = By.xpath("//*[text()='Account Number:']//following::span[1]");
	By AccountNumber_Input = By.xpath("//*[text()='Account No:']//following::input[1]");
	By AccountStatus_Value = By.xpath("//*[text()='Status:']//following::span[1]");

	// By Service Order Panel
	By Department_Select = By.xpath("//*[text()='Department:']//following::select[1]");
	By SiteDisabled_Select = By.xpath("//*[text()='Site:']//following::select[@disabled='disabled'][1]");
	By Site_Select = By.xpath("//*[text()='Site:']//following::select[1]");

	// Package Based Provisioning Panel
	By ServiceType_Select = By.xpath("//*[text()='Service Type:']//following::select[1]");
	By ServicePackage_Select = By.xpath("//*[text()='Service Package:']//following::select[1]");

	// Panel
	By Panel_Header = By.xpath("//span[@class='iceOutTxt blackBold']");
	By PricingPlan_PanelHeader = By.xpath("//span[@class = 'iceOutTxt blackBold' and text()='Pricing Plans']");
	By ServiceProduct_PanelHeader = By.xpath("//span[@class = 'iceOutTxt blackBold' and text()='Service Product']");
	By ProductFields_PanelHeader = By.xpath("//span[@class = 'iceOutTxt blackBold' and text()='Product Fields']");
	By ISPField_PanelHeader = By.xpath("//span[@class = 'iceOutTxt blackBold' and text()='ISP Fields']");
	By PaymentItem_PanelHeader = By.xpath("//span[@class = 'iceOutTxt blackBold' and text()='Payment Item']");

	// ISP Field
	By ISPUserName_Input = By.xpath("//*[text()='ISP User Name']//following::input[1]");
	By Email_Input = By.xpath("//*[text()='Email Address']//following::input[1]");
	By GeneratePassword_Button = By.xpath("//input[@value='Generate Password']");

	// Service Details
	By ServiceDetails_PanelHeader = By.xpath("//span[@class = 'iceOutTxt blackBold' and text()='Service Details']");
	By StoppedService_Input = By.xpath("//*[text()='Stopped Service Number:']//following::input[1]");
	By Region_Select = By.xpath("//*[text()='Region:']//following::select[1]");
	By Exchange_Select = By.xpath("//*[text()='Exchange:']//following::select[1]");
	By NumberArea_Select = By.xpath("//*[text()='Number Area:']//following::select[1]");
	By NumberAreaDisabled_Select = By.xpath("//*[text()='Number Area:']//following::select[@disabled='disabled'][1]");

	By ServiceNumberAllocation_Select = By.xpath("//*[text()='Service Number Allocation:']//following::select[1]");
	By ServiceNumber_Select = By.xpath("//*[text()='Service Number:']//following::select[1]");
	By ServiceNumber_Input = By.xpath("//*[text()='Service Number:']//following::input[1]");

	By Deallocate_Button = By.xpath("//input[@value='Deallocate' and @class='iceCmdBtn cmdBtn']");
	By Find_Button = By.xpath("//input[@value='Find']");

	By ServiceUsage_Select = By.xpath("//*[text()='Service Usage:']//following::select[1]");
	By ChargeOption_Select = By.xpath("//*[text()='Charge Option:']//following::select[1]");
	By SameAccountAddress_CheckBox = By.xpath("//*[text()='Same as Account Address:']//following::input[1]");
	By AddressType_Label = By.xpath("//*[text()='Address Type:']");

	// Contract Details
	By ContractDetails_PanelHeader = By.xpath("//span[@class = 'iceOutTxt blackBold' and text()='Contract Details']");
	By ContractNumber_Input = By.xpath("//*[text()='Contract Number:']//following::input[1]");
	By ContractDescription_Input = By.xpath("//*[text()='Contract Description:']//following::textarea[1]");
	By ContractDuration_Select = By.xpath("//*[text()='Contract Duration:']//following::select[1]");

	// Non Package Service Number Panel
	By ServiceNo_PanelHeader = By.xpath("//span[@class = 'iceOutTxt blackBold' and text()='Service No']");
	By ServiceNo_Input = By.xpath("//*[text() = 'Current Service No.:']//following::input[1]");

	By Submit_Button = By.xpath("//input[@value='Submit']");

	public ExistingCustomer(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);

		boolean passed = false;

		passed = action.waitFor(LiberateCommon.LevelOne.CustomerCare, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.CustomerCare);

		passed = action.waitFor(LiberateCommon.CustomerCare.ServiceProvisioning, 4, true);
		passed = action.clickOn(LiberateCommon.CustomerCare.ServiceProvisioning);

		passed = action.waitFor(LeftLink.ServiceProvisioning.ExistingCustomer, 4, true);
		passed = action.clickOn(LeftLink.ServiceProvisioning.ExistingCustomer);

		return passed;
	}

	public boolean verifyCreatedAccount() {
		boolean passed = false;

		passed = action.waitFor(AccountNumber_Value, 4, true);
		this.AccountNumber = action.getTextFromPage(AccountNumber_Value);
		action.log("Account Number created : " + this.AccountNumber);

		passed = !this.AccountNumber.trim().equals("");

		passed = !action.getTextFromPage(ServicePackage_Select).contains("Select");

		return passed;
	}

	public boolean searchWithAccount(String AccountNumber) {
		boolean passed = false;

		passed = action.waitFor(AccountNumber_Input, 4, true);
		passed = action.sendDataTo(AccountNumber_Input, AccountNumber);
		this.AccountNumber = AccountNumber;

		passed = action.clickOn(CommonPanel.Search_Button);

		passed = action.waitFor(AccountStatus_Value, 4, true);
		action.log("Account Status : " + action.getTextFromPage(AccountStatus_Value));

		return passed;
	}

	public boolean selectDepartmentSite(String Department, String Site) {
		boolean passed = false;

		passed = action.waitFor(Department_Select, 4, true);
		passed = action.selectByPartialText(Department_Select, Department);

		passed = action.waitFor(SiteDisabled_Select, 4, false);
		passed = action.selectByPartialText(Site_Select, Site);

		return passed;
	}

	public boolean selectNonPackage(String NonPackage) {
		By nonPackage_Radio = By.xpath("(//label[text()='Non Package Based Provisioning']//preceding::input)[last()]");

		boolean passed = false;

		passed = action.clickOn(nonPackage_Radio);
		passed = action.waitFor(ServiceType_Select, 4, false);
		passed = action.selectByPartialText(ServicePackage_Select, NonPackage);

		action.waitFor(1);
		passed = action.clickOn(Proceed_Button);

		return passed;
	}

	public boolean selectServicePackage(String ServiceType, String ServicePackage) {
		boolean passed = false;

		if (action.getSelectedOption(ServicePackage_Select).contains("Select")) {
			passed = action.selectByPartialText(ServiceType_Select, ServiceType);
			action.waitFor(2);
			passed = action.selectByPartialText(ServicePackage_Select, ServicePackage);
		}

		action.waitFor(1);
		passed = action.clickOn(Proceed_Button);

		return passed;
	}

	public boolean processPricingPlanScreen() {
		boolean passed = false;

		By PlanAuthorizedBy_Input = By.xpath("//*[text()='To be Authorised By:']//input[1]");
		By PlanAuthorizedBy_Button = By.xpath("//*[text()='To be Authorised By:']//input[2]");
		By PlanAuthorizedBy_Select = By.xpath("//*[text()='To be Authorised By:']//select[1]");

		passed = action.waitFor(PricingPlan_PanelHeader, 4, true);
		action.scrollUp();
		action.getTextFromPage(Panel_Header);

		if (action.countOf(PlanAuthorizedBy_Input) == 1) {
			action.sendDataTo(PlanAuthorizedBy_Input, "99999");
			action.clickOn(PlanAuthorizedBy_Button);

			action.waitFor(2);

			action.selectBy(PlanAuthorizedBy_Select, 1);
		}

		action.clickOn(Proceed_Button);

		return passed;
	}

	public boolean processServiceNoScreen(String ServiceNo) {
		boolean passed = false;

		passed = action.waitFor(ServiceNo_PanelHeader, 4, true);
		action.scrollUp();
		action.getTextFromPage(Panel_Header);

		passed = action.sendDataTo(ServiceNo_Input, ServiceNo);

		action.clickOn(Proceed_Button);

		return passed;
	}

	public boolean processServiceProductsScreen() {
		boolean passed = false;

		passed = action.waitFor(ServiceProduct_PanelHeader, 4, true);
		action.scrollUp();
		action.getTextFromPage(Panel_Header);
		action.clickOn(Proceed_Button);

		return passed;
	}

	public boolean processProductFieldsScreen() {
		boolean passed = false;

		passed = action.waitFor(ProductFields_PanelHeader, 4, true);
		action.scrollUp();
		action.getTextFromPage(Panel_Header);
		action.clickOn(Proceed_Button);

		return passed;
	}

	public boolean processISPFieldsScreen() {
		By EmailDomain_Select = By.xpath("//*[text()='Email Address']//following::select[1]");

		boolean passed = false;

		passed = action.waitFor(ISPField_PanelHeader, 4, true);
		action.scrollUp();
		action.getTextFromPage(Panel_Header);

		this.ServiceOrderNumber = action.getTextFromPage(ServiceOrder_Value);

		if (action.countOf(Email_Input) == 1)
			passed = action.sendDataTo(Email_Input, this.ServiceOrderNumber);
		if (action.countOf(EmailDomain_Select) == 1) {
			if (action.getSelectedOption(EmailDomain_Select).contains("Select")) {
				action.selectBy(EmailDomain_Select, 1);
			}
		}
		if (action.countOf(ISPUserName_Input) == 1)
			passed = action.sendDataTo(ISPUserName_Input, this.ServiceOrderNumber);
		passed = action.clickOn(GeneratePassword_Button);

		action.waitFor(2);

		action.clickOn(Proceed_Button);

		return passed;
	}

	public boolean processPaymentItemsScreen() {
		boolean passed = false;

		passed = action.waitFor(PaymentItem_PanelHeader, 4, true);
		action.scrollUp();

		action.getTextFromPage(Panel_Header);
		action.clickOn(Proceed_Button);

		return passed;
	}

	public boolean provideServiceDetailsScreen(String Exchange, String NumberArea) {
		boolean passed = false;

		By SIM_Select = By.xpath("//*[text()='SIM:']//following::select[1]");
		By LookUp_Button = By.xpath("//input[@value='Look Up']");
		By SIMSearch_Message = By.xpath("//*[text()='More Numbers exist matching the details entered']");
		By UserName_Input = By.xpath("(//*[text()='User Name:']//following::input)[1]");
		By PIN_Input = By.xpath("(//*[text()='PIN:']//following::input)[1]");

		passed = action.waitFor(ServiceDetails_PanelHeader, 4, true);

		if (action.countOf(Deallocate_Button) == 0) {
			passed = action.selectByPartialText(Exchange_Select, Exchange);
			passed = action.waitFor(NumberAreaDisabled_Select, 4, false);
			action.waitFor(1);
			passed = action.selectByPartialText(NumberArea_Select, NumberArea);

			if (!action.getSelectedOption(ServiceNumberAllocation_Select).contains("Auto")) {
				passed = action.selectByPartialText(ServiceNumberAllocation_Select, "Auto");
			} else {
				passed = action.clickOn(Find_Button);
			}
		}

		passed = action.waitFor(Deallocate_Button, 4, true);

		if (action.countOf(LookUp_Button) == 1) {
			action.clickOn(LookUp_Button);
			action.waitFor(SIMSearch_Message, 4, true);
			action.waitFor(1);
			action.selectBy(SIM_Select, 8);
			action.waitFor(2);
		}

		if (action.countOf(UserName_Input) == 1) {
			passed = action.sendDataTo(UserName_Input, random.nextString().substring(0, 8).toUpperCase());
		}
		if (action.countOf(PIN_Input) == 1) {
			action.clickOn(PIN_Input);
			action.waitFor(2);
			passed = action.sendDataTo(PIN_Input, "4545");
		}
		if (action.countOf(ServiceUsage_Select) == 1) {
			passed = action.selectByPartialText(ServiceUsage_Select, "V-");
		}
		if (action.countOf(ChargeOption_Select) == 1) {
			passed = action.selectBy(ChargeOption_Select, 2);
		}

		action.waitFor(1);

		passed = action.clickOn(SameAccountAddress_CheckBox);
		passed = action.waitFor(AddressType_Label, 4, false);

		action.waitFor(1);

		addCreditLimit();

		action.waitFor(1);
		action.clickOn(Proceed_Button);

		return passed;
	}

	private void addCreditLimit() {
		By CreditLimit_Input = By.xpath("//*[text()='Credit Limit:']//following::input[1]");
		By CallLimit_Input = By.xpath("//*[text()='Call Limit:']//following::input[1]");
		By CustomerSelectedLimit_Radio = By
				.xpath("//*[text()='Use Customer-Selected Credit Limit:']//following::input[1]");

		By CustomerSelectedCreditLimit_Input = By
				.xpath("//*[text()='Customer-Selected Credit Limit:']//following::input[1]");
		By CustomerSelectedUpdateType_Select = By
				.xpath("//*[text()='Customer-Selected Update Type:']//following::select[1]");
		By CustomerSelectedBarType_Select = By.xpath("//*[text()='Customer-Selected Bar Type:']//following::select[1]");

		if (action.countOf(CreditLimit_Input) == 1) {
			action.sendDataTo(CreditLimit_Input, "100");
		}
		if (action.countOf(CallLimit_Input) == 1) {
			action.sendDataTo(CallLimit_Input, "100");
		}
		if (action.countOf(CustomerSelectedLimit_Radio) == 1) {
			action.clickOn(CustomerSelectedLimit_Radio);
		}
		if (action.countOf(CustomerSelectedCreditLimit_Input) == 1) {
			action.sendDataTo(CustomerSelectedCreditLimit_Input, "90");
		}
		if (action.countOf(CustomerSelectedUpdateType_Select) == 1) {
			action.selectByPartialText(CustomerSelectedUpdateType_Select, "Phone");
		}
		if (action.countOf(CustomerSelectedBarType_Select) == 1) {
			action.selectByPartialText(CustomerSelectedBarType_Select, "All");
		}
	}

	public boolean provideContractDetails() {
		boolean passed = false;

		passed = action.waitFor(ContractDetails_PanelHeader, 4, true);
		passed = action.sendDataTo(ContractNumber_Input, "22663");
		passed = action.sendDataTo(ContractDescription_Input, "Test Automation Contract");
		passed = action.selectBy(ContractDuration_Select, 2);

		passed = action.clickOn(Submit_Button);

		return passed;
	}

	public boolean provideADSL() {
		By ProvideADSL_Message = By.xpath("//*[text()='Do you want to provide Broadband on the same service order']");

		boolean passed = false;

		passed = action.waitFor(ProvideADSL_Message, 4, true);
		passed = action.clickOn(CommonPanel.popUp.popUpYes_Button);

		return passed;
	}

	public boolean skipADSL() {
		By ProvideADSL_Message = By.xpath("//*[text()='Do you want to provide Broadband on the same service order']");

		boolean passed = false;

		passed = action.waitFor(ProvideADSL_Message, 4, true);
		passed = action.clickOn(CommonPanel.popUp.popUpNo_Button);

		return passed;
	}
}