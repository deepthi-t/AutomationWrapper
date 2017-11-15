package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.core.TestActions;

public class CustomerSearch {
	TestActions action = null;
	
	public CustomerSearch(TestActions action)
	{
		this.action = action;
	}
	
	//Quick Search Panel
	By AccountNumber_Input = By.xpath("//*[text()='Account No.:']/following::input[1]");
	By LocalAccountNumber_Input = By.xpath("//*[text()='Local Account No.:']/following::input[1]");
	By ServiceNumber_Input = By.xpath("//*[text()='Service No.:']/following::input[1]");
	By ServiceOrderNumber_Input = By.xpath("//*[text()='Service Order No.:']/following::input[1]");
	By CustomerID_Select = By.xpath("//*[text()='Customer ID:']/following::select[1]");
	By CustomerID_Input = By.xpath("//*[text()='Customer ID:']/following::input[1]");
	By BillInvoice_Input = By.xpath("//*[text()='Bill Invoice No.:']/following::input[1]");
	
	By ExcludeClosedAccount_CheckBox = By.xpath("//*[text()='Exclude Closed/Ceased Accounts:']/following::input[1]");
	By ShowFullStructure_Input = By.xpath("//*[text()='Show Full Structure:']/following::input[1]");
	By WorkingServiceOnly_input = By.xpath("//*[text()='Working Service Only:']/following::input[1]");
	
	//Buttons
	By Search_Button = By.xpath("//input[@value='Search']");
	By Reset_Button = By.xpath("//input[@value='Reset']");
	
	public boolean searchByAccountNumber(String accountNumber)
	{
		boolean passed = false;
		
		passed = action.waitFor(AccountNumber_Input, 4, true);
		passed = action.sendDataTo(AccountNumber_Input, accountNumber);
		passed = action.waitFor(1);
		passed = action.clickOn(Search_Button);
		
		return passed;
	}
	
	public boolean searchByServiceNumber(String serviceNumber)
	{
		boolean passed = false;
		
		passed = action.waitFor(ServiceNumber_Input, 4, true);
		passed = action.sendDataTo(ServiceNumber_Input, serviceNumber);
		passed = action.waitFor(1);
		passed = action.clickOn(Search_Button);
		
		return passed;
	}
}
