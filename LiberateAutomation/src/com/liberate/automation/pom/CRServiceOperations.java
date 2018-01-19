package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.core.TestActions;

public class CRServiceOperations {
	TestActions action = null;
	
	String ServiceNumber = "";
	
	By ExcludeCeaseClosed_CheckBox = By.xpath("//*[text()='Exclude Closed/Ceased Accounts:']");
	
	By FirstServiceNumber_Value = By.xpath("//tr[@id='customerServicesForm:serviceEnquiryTabs:0:summaryTab:resultTable_row_0']//td[1]//span");
	
	// Services Action Buttons
	By ServiceDetails_ActionButton = By
			.xpath("//span[contains(@class,'actionButtonHeadingSpaceLabel')][text()[contains(.,'Service Details')]]");
	By Provide_ActionButton = By
			.xpath("//span[contains(@class,'actionButtonHeadingSpaceLabel')][text()[contains(.,'Provide')]]");
	By Change_ActionButton = By
			.xpath("//span[contains(@class,'actionButtonHeadingSpaceLabel')][text()[contains(.,'Change')]]");
	By CopyMove_ActionButton = By
			.xpath("//span[contains(@class,'actionButtonHeadingSpaceLabel')][text()[contains(.,'Copy/Move')]]");
	By Products_ActionButton = By
			.xpath("//span[contains(@class,'actionButtonHeadingSpaceLabel')][text()[contains(.,'Products')]]");
	By Cease_ActionButton = By
			.xpath("//span[contains(@class,'actionButtonHeadingSpaceLabel')][text()[contains(.,'Cease')]]");
	By RaiseFault_ActionButton = By
			.xpath("//span[contains(@class,'actionButtonHeadingSpaceLabel')][text()[contains(.,'Raise fault')]]");
	By Suspend_ActionButton = By
			.xpath("//span[contains(@class,'actionButtonHeadingSpaceLabel')][text()[contains(.,'Suspend')]]");

	By TransferService_ActionButton = By.xpath(
			"//span[contains(@class,'actionButtonHeadingSpaceLabel')]/preceding::span[contains(@class,'actionButton')][text()[contains(.,'Transfer Service')]]");
	By ASN_ActionButton = By.xpath(
			"//span[contains(@class,'actionButtonHeadingSpaceLabel')]/preceding::span[contains(@class,'actionButton')][text()[contains(.,'ASN')]]");

	By Summary_Tab = By.xpath("//*[text()='Summary']");

	By SelectedService_Value = By.xpath(
			"//tr[@id='customerServicesForm:serviceEnquiryTabs:0:summaryTab:resultTable_row_0']//td[1]//span[1]");

	By TransferService_PanelHeader = By.xpath("//*[text()='Transfer Service']");
	By TargetAccountNumber_input = By.xpath("//*[text()[contains(.,'Target Account No')]]//following::input[1]");
	By Validate_Button = By.xpath("//input[@value='Validate']");
	By TransferServiceConfirmation_Message = By.xpath("//*[text()='Transferring service to']");
	By TrasnferCompletoin_Message = By.xpath("//*[text()='Account data has been transfered.']");

	public CRServiceOperations(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		boolean passed = false;

		if (action.countOf(ExcludeCeaseClosed_CheckBox) > 0) {
			action.waitFor(ExcludeCeaseClosed_CheckBox, 4, false);
		}

		if (!(action.countOf(Summary_Tab) > 0))
			passed = action.clickOn(LeftLink.Search.Services);

		return passed;
	}

	public boolean verifyServicesScreen() {
		boolean passed = false;

		return passed;
	}

	public boolean transferService(String TargetAccount) {
		boolean passed = false;

		passed = action.waitFor(CopyMove_ActionButton, 4, true);
		if (!passed)
			return passed;

		action.moveMouseAwayFromScreen();
		
		this.ServiceNumber = action.getTextFromPage(FirstServiceNumber_Value);
		
		passed = action.clickOn(CopyMove_ActionButton);
		passed = action.waitForClickable(TransferService_ActionButton, 2);
		passed = action.clickOn(TransferService_ActionButton);

		passed = action.waitFor(TargetAccountNumber_input, 4, true);

		passed = action.sendDataTo(TargetAccountNumber_input, TargetAccount);
		action.waitFor(1);
		passed = action.clickOn(Validate_Button);

		passed = action.waitFor(CommonPanel.AcceptDisable_Button, 4, false);
		passed = action.clickOn(CommonPanel.Accept_Button);

		passed = action.waitFor(TransferServiceConfirmation_Message, 4, true);
		passed = action.clickOn(CommonPanel.popUp.popUpYes_Button);

		passed = action.waitFor(TrasnferCompletoin_Message, 4, true);
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);

		return passed;
	}

	public boolean verifyTransferService(String TargetAccount) {
		boolean passed = false;
		
		passed = action.waitFor(ServiceDetails_ActionButton, 4, true);
		
		passed = action.isTextAvailable(TargetAccount);
		passed = action.isTextAvailable(this.ServiceNumber);
		
		this.ServiceNumber = "";
		
		return passed;
	}
}
