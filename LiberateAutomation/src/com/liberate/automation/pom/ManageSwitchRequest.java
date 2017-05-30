package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class ManageSwitchRequest
{
	TestActions action = null;
	
	//Page Elements : Column Headers
	By ManageSwitchRequestColumnHeader		= By.xpath("//div[@class='icePnlClpsbl icePnlClpsblDM']/descendant::*[text()='Query Switch Request']");
	By MonitorNewSwitchRequestsColumnHeader = By.xpath("//div[@class='icePnlClpsbl icePnlClpsblDM']/descendant::*[text()='Monitor New Switch Requests']");
	
	//Page Elements : Input Fields
	By QuerySwitchRequestDropdown	= By.xpath("//*[text()='Query Switch Request:']/following::select");
	By EmployeeNameIDDropDown		= By.xpath("//*[text()='Employee Name / ID:']/following::select[1]");
	By EmployeeNameIDSearchBox		= By.xpath("//*[text()='Employee Name / ID:']/following::input[1]");
	By UpdatedWithinLast			= By.xpath("//*[text()='Updated within last:']/following::input[1]");
	
	//Page Elements : Command Buttons
	By SearchButton	= By.xpath("//input[@value='Search']");
	By ResetButon	= By.xpath("//input[@value='Reset']");
	
	public ManageSwitchRequest(TestActions action)
	{
		this.action = action;
	}
	
	public boolean navigate()
	{
		boolean passed = false;
		
		passed = action.clickOn(LiberateCommon.LevelOne.Orders);
		passed = action.waitFor(LiberateCommon.Orders.SwitchRequests, 4, true);
		passed = action.clickOn(LiberateCommon.Orders.SwitchRequests);
		passed = action.waitFor(LeftLink.SwitchRequests.ManageSwitchRequest,4,true);
		passed = action.clickOn(LeftLink.SwitchRequests.ManageSwitchRequest);
		
		return passed;
	}
	
	public boolean select_MonitorNewSwitchRequests()
	{
		boolean passed = false;
		
		passed = action.waitFor(QuerySwitchRequestDropdown, 4, true);
		passed = action.SelectBy(QuerySwitchRequestDropdown, "Monitor New Switch Requests");
		
		return passed;
	}
	
	public boolean select_FailureQueries()
	{
		boolean passed = false;
		
		passed = action.waitFor(QuerySwitchRequestDropdown, 4, true);
		passed = action.SelectBy(QuerySwitchRequestDropdown, "Failure Queries");
		
		return passed;
	}
	
	public boolean select_QuerybyAcctServiceOrderServiceCommand()
	{
		boolean passed = false;
		
		passed = action.waitFor(QuerySwitchRequestDropdown, 4, true);
		passed = action.SelectBy(QuerySwitchRequestDropdown, "Query by Acct, Service Order, Service or Command");
		
		return passed;
	}
	
	public boolean select_GeneralQueryOnNewRequests()
	{
		boolean passed = false;
		
		passed = action.waitFor(QuerySwitchRequestDropdown, 4, true);
		passed = action.SelectBy(QuerySwitchRequestDropdown, "General Query on New Requests");
		
		return passed;
	}
	
	public boolean select_GenerateSwitchRequest()
	{
		boolean passed = false;
		
		passed = action.waitFor(QuerySwitchRequestDropdown, 4, true);
		passed = action.SelectBy(QuerySwitchRequestDropdown, "Generate Switch Request");
		
		return passed;
	}

	public boolean MonitorNewSwitchRequests_Search(String employeeID, String updatedWithinLast)
	{
		boolean passed = false;
		
		passed = action.waitFor(MonitorNewSwitchRequestsColumnHeader, 4, true);
		if(action.getSelectedOption(EmployeeNameIDDropDown).contains("Select"))
		{
			passed = action.sendDataTo(EmployeeNameIDSearchBox, employeeID);
			passed = action.waitFor(2);
			passed = action.SelectBy(EmployeeNameIDDropDown, 1);
		}
		
		passed = action.sendDataTo(UpdatedWithinLast, updatedWithinLast);
		
		return passed;
	}
}
