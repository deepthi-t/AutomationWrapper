package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class PYPOSPayment {
	TestActions action = null;
	
	By NewTransaction_Tab = By.xpath("//*[text()='New Transaction']");
	By ServiceNumber_Input = By.xpath("//*[text()='Service Number:']/following::input[1]");
	By AccountNumber_Input = By.xpath("//*[text()='Account Number:']/following::input[1]");
	By BillInvoiceNumber_Input = By.xpath("//*[text()='Bill Invoice No.:']/following::input[1]");
	
	By AllocateAmountDisabled_Input = By.xpath("//*[text()='Allocate Amount:']//following::td[1]//child::input[@disabled='true']");
	By AllocateAmount_Input = By.xpath("//*[text()='Allocate Amount:']//following::td[1]//child::input[1]");
	
	By ManualAllocate_Button = By.xpath("//input[@value='Manual Allocate']");
	
	By Payment_Row = By.xpath("//tr[@id='newTransactionForm:statictab:0:dynamictabs:1:billsTable:0']");
	
	By PaymentMethod_Select = By.xpath("//*[text()='Select Payment Method:']//following::select[1]");
	
	By Close_Button = By.xpath("//input[@value='Close']");
	By OK_Button = By.xpath("//input[@value='OK']");

	public PYPOSPayment(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);
		
		action.scrollUp();

		boolean passed = false;

		passed = action.waitFor(LiberateCommon.LevelOne.Payments, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.Payments);
		passed = action.waitFor(LiberateCommon.Payments.POS, 4, true);
		passed = action.clickOn(LiberateCommon.Payments.POS);
		passed = action.waitFor(LeftLink.POS.NewTransaction, 4, true);
		passed = action.clickOn(LeftLink.POS.NewTransaction);
		
		return passed;
	}

	public boolean navigateToPOS() {
		boolean passed = false;

		action.waitFor(4);
		action.switchToNewWindow();
		
		passed = action.waitFor(NewTransaction_Tab, 4, true);
		
		if(action.countOf(Close_Button)>0)
		{
			action.clickOn(Close_Button);
			passed = action.waitFor(Close_Button, 4, false);
		}

		return passed;
	}
	
	public boolean searchWithAccountNumber(String AccountNumber) {
		boolean passed = false;
		
		passed = action.waitFor(NewTransaction_Tab, 4, true);
		passed = action.clickOn(NewTransaction_Tab);
		
		passed = action.waitFor(AccountNumber_Input, 4, true);
		passed = action.sendDataTo(AccountNumber_Input, AccountNumber);
		
		passed = action.clickOn(CommonPanel.Search_Button);
		passed = action.waitFor(AllocateAmountDisabled_Input, 4, false);
		
		return passed;
	}
	
	public boolean POSPayment() {
		boolean passed = false;
		
		passed = action.waitFor(AllocateAmountDisabled_Input, 4, false);
		action.waitFor(1);
		passed = action.sendDataTo(AllocateAmount_Input, "10.00");
		
		passed = action.clickOn(ManualAllocate_Button);
		
		passed = action.waitFor(Payment_Row, 4, false);
		passed = action.clickOn(CommonPanel.Accept_Button);
		
		passed = action.waitFor(PaymentMethod_Select, 4, true);
		
		if(action.countOf(OK_Button)>0)
		{
			action.clickOn(OK_Button);
			passed = action.waitFor(OK_Button, 4, false);
		}
		
		passed = action.selectByPartialText(PaymentMethod_Select, "C ");
		
		
		return passed;
	}

	public boolean closePOSWindow() {
		boolean passed = false;

		action.waitFor(2);
		action.closeTab();

		action.switchToNewWindow();

		action.waitFor(2);
		passed = action.waitFor(LiberateCommon.LevelOne.Payments, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.Payments);

		return passed;
	}
}
