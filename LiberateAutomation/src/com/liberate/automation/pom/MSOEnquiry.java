package com.liberate.automation.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class MSOEnquiry 
{
	TestActions action = null;
	
	public MSOEnquiry(TestActions action)
	{
		this.action = action;
	}
	
	//Search Panel
	By ServiceOrder_Input = By.xpath("//*[text()='Service Order:']/following::input[1]");
	By Search_Button = By.xpath("//input[@value='Search']");
	
	//Service Order Details
	By ServiceOrderDetails_PanelHeader = By.xpath("//*[text()='Service Order Details']");
	
	By ServiceOrderNumber_Value = By.xpath("(//*[text()='Service Order:'])[last()]/following::span[1]");
	By ServiceNumber_Value = By.xpath("(//*[text()='Service Number:'])[last()]/following::span[1]");
	
	//Summary Details
	By SummaryDetails_Tab = By.xpath("(//td[text()='Summary Details'])[1]");
	By AccountNumber_Value = By.xpath("(//*[text()='Account Number:'])[last()]/following::span[1]");
	
	
	//Department Circulation
	By DepartmentCirculation_Tab = By.xpath("(//td[text()='Department Circulation'])[1]");
	/***
	 * Can Be used to get the count of row of Department Circulation. Can Append '[<i>count</i>]' for a particular row.
	 * After 'count' append 
	 * <br>'/descendant::td[1]' for Department
	 * <br>'/descendant::td[2]' for From Date
	 * <br>'/descendant::td[3]' for To Date
	 * <br>'/descendant::td[4]' for Status
	 * <br>'/descendant::td[5]' for Created By
	 * <br>'/descendant::td[6]' for Actioned By
	 * <br>'/descendant::td[7]' for Signed Off By
	 * <br>'/descendant::td[8]' for Status Reason
	 */
	By Circulation_Row = By.xpath("//tr[contains(@id,'serviceOrderEnquiryForm:serviceOrderEnquiryTabs:')]");	
	
	/***
	 * Method called to navigate to manage Service Order Enquiry
	 * @return	True  : If able to Navigate.
	 * 			<br>False : If failed to Navigate.
	 */
	public boolean navigate()
	{
		boolean passed = false;
		
		passed = action.waitFor(LiberateCommon.LevelOne.Orders, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.Orders);
		passed = action.waitFor(LiberateCommon.Orders.ManageServiceOrder,4,true);
		passed = action.clickOn(LiberateCommon.Orders.ManageServiceOrder);
		passed = action.waitFor(LeftLink.ManageServiceOrder.Enquiry,4,true);
		passed = action.clickOn(LeftLink.ManageServiceOrder.Enquiry);
		
		return passed;
	}
	
	public boolean searchServiceOrder(String serviceOrderNumber)
	{
		boolean passed = false;
		
		passed = action.waitFor(ServiceOrder_Input,4,true);
		passed = action.sendDataTo(ServiceOrder_Input, serviceOrderNumber);
		passed = action.waitFor(1);
		passed = action.clickOn(Search_Button);
		
		return passed;
	}
	
	public boolean verifyServiceOrderDetails(String serviceOrderNumber)
	{
		boolean passed = false;
		
		passed = action.waitFor(ServiceOrderDetails_PanelHeader,4,true);
		passed = action.getTextFromPage(ServiceNumber_Value).trim().equals(serviceOrderNumber)?true:false;
		
		if(!passed)
		{
			return passed;
		}
		
		System.out.println("Service Order Number : " + action.getTextFromPage(ServiceOrderNumber_Value));
		System.out.println("Service Number : " + action.getTextFromPage(ServiceNumber_Value));
		System.out.println("Account Number : " + action.getTextFromPage(AccountNumber_Value));
		
		return passed;
	}
	
	public boolean verifyDepartmentCirculation()
	{
		boolean passed = false;
		
		passed = action.clickOn(DepartmentCirculation_Tab);
		
		passed = action.waitFor(Circulation_Row, 4, true);
		
		return passed;
	}
	
	/***
	 * Method used to get all the departments the Service Order Currently belongs to.
	 * @return The List of Departments the Service ORder currently belongs to.
	 */
	public List<String> getCurrentDepartments()
	{
		List<String> CurrentDepartments = new ArrayList<String>();
		
		int count = action.countOf(Circulation_Row);
		for(int i = 0; i < count; i++)
		{
			//Checking if action date is blank. If Date is blank, then Service order belongs to that department.
			String actionDate = action.getTextFromPage(By.xpath((action.getXpath(Circulation_Row)+"["+(i+1)+"]"+"/descendant::td[3]"))).trim();
			if(!actionDate.equals(""))
			{
				//Getting the department name (cell value) where the action date is blank.
				CurrentDepartments.add(action.getTextFromPage(By.xpath((action.getXpath(Circulation_Row)+"["+(i+1)+"]"+"/descendant::td[1]"))).trim());
			}
		}
				
		return CurrentDepartments;
	}
}
