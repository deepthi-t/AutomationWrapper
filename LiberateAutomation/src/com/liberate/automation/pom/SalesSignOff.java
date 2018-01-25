package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.core.TestActions;

public class SalesSignOff {
	TestActions action = null;

	public String AccountNumber = "";
	public String ServiceOrderNumber = "";
	public String ServiceNumber = "";

	By AccountNumber_Value = By.xpath("//*[text()='Account Number:']//following::span[1]");
	By ServiceNumber_Value = By.xpath("//*[text()='Service No:']//following::span[1]");
	By ServiceOrderNumber_Value = By.xpath("//*[text()='Service Order No:']//following::span[1]");

	By ServiceOrderLines_PanelHeader = By.xpath("//*[text()='Service Order Lines']");
	By Provisioned_Message = By.xpath("//*[text()[contains(.,'Service Package successfully provisioned')]]");
	
	By MunicipalityCode_Select = By.xpath("//*[text()='Municipality Code:']//following::select[1]");
	
	By ContactName_Input = By.xpath("//*[text()='Contact Name:']//following::input[1]");
	By ContactNumber_Input = By.xpath("//*[text()='Contact No :']//following::input[1]");

	By SubmitOrder_Button = By.xpath("//input[@value='Submit Order']");
	By SignOff_Button = By.xpath("//input[@value='Sign Off']");
	
	By AddMore_Button = By.xpath("//input[@value='Add More']");
	
	public SalesSignOff(TestActions action) {
		this.action = action;
	}

	public boolean verifySalesSignOff() {
		boolean passed = false;
		
		action.waitFor(2);
		if(action.countOf(CommonPanel.popUp.popUpOK_Button)>0)
			CommonPanel.popUp.clickOK(action);
		
		passed = action.waitFor(ServiceOrderLines_PanelHeader, 4, true);

		passed = action.waitFor(Provisioned_Message, 4, true);

		CommonPanel.popUp.clickOK(action);

		this.AccountNumber = action.getTextFromPage(AccountNumber_Value).trim();
		this.ServiceNumber = action.getTextFromPage(ServiceNumber_Value).trim();
		this.ServiceOrderNumber = action.getTextFromPage(ServiceOrderNumber_Value).trim();

		return passed;
	}

	public boolean signOff() {
		boolean passed = false;
		
		By PymentItem_CheckBox = By.xpath("//*[text()='Payment Summary']//following::tbody[2]//descendant::input[checked='checked']");
		By ConfirmPayment_Button = By.xpath("//input[@value='Confirm Payment Amounts']");
		
		By AccountEbilling_input = By.xpath("//*[text()='Account eBilling Email Address Entry']//following::input[1]");
		
		By MacAddressConfirmation_Message = By.xpath("//*[text()='Do you wish to allocate MAC Addresses and Smart Card references?']");
		
		if (action.countOf(PymentItem_CheckBox) > 0) {
			for(int i = 0; i < action.countOf(PymentItem_CheckBox); i++)
			{
				action.clickOn(By.xpath("("+action.getXpath(PymentItem_CheckBox)+")["+(i+1)+"]"));
				action.waitFor(1);
			}
			action.clickOn(ConfirmPayment_Button);
			
			action.waitFor(CommonPanel.popUp.popUpOK_Button, 4, true);
			CommonPanel.popUp.clickOK(action);
		}		
		
		if (action.countOf(MunicipalityCode_Select) == 1) {
			action.selectBy(MunicipalityCode_Select, 1);
		}
		if (action.countOf(ContactName_Input) == 1) {
			action.sendDataTo(ContactName_Input, "Test Name");
		}
		if (action.countOf(ContactNumber_Input) == 1) {
			action.sendDataTo(ContactNumber_Input, "22663");
		}

		passed = action.clickOn(SubmitOrder_Button);
		
		while (true) {
			action.waitFor(4);
			if(action.countOf(AccountEbilling_input) > 0)
			{
				action.sendDataTo(AccountEbilling_input, "automation@cwc.com");
				action.clickOn(CommonPanel.Accept_Button);
				action.waitFor(CommonPanel.Accept_Button, 4, false);
				action.waitFor(1);
				passed = action.clickOn(SubmitOrder_Button);
				action.waitFor(2);
			}
			if (action.countOf(SignOff_Button) > 0) {
				passed = action.clickOn(SignOff_Button);
				action.waitFor(2);
			}
			if (action.countOf(CommonPanel.Accept_Button) > 0) {
				passed = action.clickOn(CommonPanel.Accept_Button);
				action.waitFor(2);
			}
			if (action.countOf(CommonPanel.popUp.popUpOK_Button) > 0) {
				CommonPanel.popUp.clickOK(action);
				break;
			}
		}
		if (action.countOf(MacAddressConfirmation_Message) > 0) {
			action.waitFor(2);
			passed = action.clickOn(CommonPanel.popUp.popUpNo_Button);
			action.waitFor(2);
		}
		
		return passed;
	}

	public boolean addMore() {
		boolean passed = false;
		
		passed = action.clickOn(AddMore_Button);
		
		return passed;
	}
}
