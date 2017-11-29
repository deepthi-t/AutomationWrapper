package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class MSOAddRemoveServiceCharge {
	TestActions action = null;

	String ServiceOrderNumber = "";
	String ServiceCharge = "";
	int initialSCcount = 0;
	
	By Department_Select = By.xpath("//*[text()='Department:']/following::select[1]");
	By DepartmentDisabled_Select = By.xpath("//*[text()='Department:']/following::select[@disabled=\"disabled\"]");
	By DepartmentChange_Button = By.xpath("//input[@value='Change']");
	By ServiceOrder_Input = By.xpath("//*[text()='Service Order:']/following::input[1]");
	By Search_Button = By.xpath("//input[@value='Search']");
	By Reset_Button = By.xpath("//input[@value='Reset']");

	By ServiceOrderList_PanelHeader = By.xpath("//*[text()='Service Order List']");

	/***
	 * Append '[<i><b>count</b></i>]' to select that row.
	 * 
	 * <br>
	 * Append '/descendant::td[1]' after adding count, for Service Order <br>
	 * Append '/descendant::td[2]' after adding count, for Customer Name <br>
	 * Append '/descendant::td[3]' after adding count, for SO Priority <br>
	 * Append '/descendant::td[4]' after adding count, for Exchange <br>
	 * Append '/descendant::td[5]' after adding count, for Status
	 */
	By ServiceOrder_Row = CommonPanel.ServiceOrderList.ServiceOrderList_Row;

	By New_ActionButton = By.xpath("//span[text()='New']");
	By Delete_ActionButton = By.xpath("//span[text()='Delete']");

	By ServiceOrderDetails_PanelHeader = By.xpath("//*[text()='Service Order Details']");
	By ServiceOrderNumber_Value = By.xpath("(//*[text()='Service Order:'])[2]/following::span[1]");

	By ServiceChargeDetails_ColumnHeader = By.xpath("//*[text()='Service Charge Details']");

	// New Service Charge
	By ServiceChargeSearchBox_Input = By.xpath("//*[text()='ServiceChargeType:']/following::input[1]");
	By ServiceChargeSearch_Button = By.xpath("//*[text()='ServiceChargeType:']/following::input[@type=\"image\"]");
	By ServiceCharge_Select = By.xpath("//*[text()='ServiceChargeType:']/following::select[1]");

	By ServiceChargeAmount_Input = By.xpath("//*[text()='Amount:']/following::input[1]");

	By Accept_Button = By.xpath("//input[@value='Accept']");
	By Cancel_Button = By.xpath("//input[@value='Cancel']");
	By Back_Button = By.xpath("//input[@value='Back']");
	
	By ServiceChargeCreateSuccessMessage = By.xpath("//*[text()='Service charge created successfully.']");

	/***
	 * Append '[<i><b>count</b></i>]' to select that row.
	 * Or '<i>[last()]</i>'
	 * 
	 * <br>
	 * Append '/descendant::td[1]' after adding count, for Service Number <br>
	 * Append '/descendant::td[2]' after adding count, for Mandatory <br>
	 * Append '/descendant::td[3]' after adding count, for Service Charge Type <br>
	 * Append '/descendant::td[4]' after adding count, for Amount <br>
	 * Append '/descendant::td[5]' after adding count, for Payment Period <br>
	 * Append '/descendant::td[6]' after adding count, for Date Added
	 */
	By ServiceCharge_Row = By.xpath(
			"//div[@id='manageSOAddRemoveServiceChargeForm:addRemoveServiceChargeDetailsList']/descendant::tbody/descendant::tr");
	By SelectedRow = By.xpath("//tr[contains(@class,'ui-selected')]");
	
	//Delete Service Charge
	By AddRemoveServiceCharge_ColumnHeader = By.xpath("//*[text()[contains(.,'Add/Remove Service Charge ')]]");
	By ServiceChargeDeleteConfirmation_Text = By.xpath("//*[text()[contains(.,'Selected Service Charge will be Deleted.')]]");
	
	By DeleteYes_Button = By.xpath("//input[@value='Yes']");
	By DeleteNo_Button = By.xpath("//input[@value='No']");
	
	
	By DeleteSuccessMessage = By.xpath("//*[text()='Service charge deleted successfully.']");
	By MessageOK_Button = By.xpath("//input[@value='OK']");
	
	public MSOAddRemoveServiceCharge(TestActions action)
	{
		this.action = action;
	}
	
	public boolean navigate()
	{
		boolean passed = false;
		
		passed = action.waitFor(LiberateCommon.LevelOne.Orders,4,true);
		passed = action.clickOn(LiberateCommon.LevelOne.Orders);
		passed = action.waitFor(LiberateCommon.Orders.ManageServiceOrder,4,true);
		passed = action.clickOn(LiberateCommon.Orders.ManageServiceOrder);
		passed = action.waitFor(LeftLink.ManageServiceOrder.AddRemoveServiceCharge,4,true);
		passed = action.clickOn(LeftLink.ManageServiceOrder.AddRemoveServiceCharge);
		
		return passed;
	}
	
	public boolean searchByServiceOrder(String Department, String SONumber)
	{
		this.ServiceOrderNumber = SONumber;
		
		boolean passed = false;

		passed = action.waitFor(DepartmentDisabled_Select,4,true);
		String department = action.getSelectedOption(Department_Select);
		
		if(Department.trim().equals(""))
		{
			//DO Nothing
		}
		else if(!department.contains(Department))
		{
			passed = action.clickOn(DepartmentChange_Button);
			passed = action.waitFor(DepartmentDisabled_Select, 4, false);
			
			passed = action.selectByPartialText(Department_Select, Department);
			passed = action.waitFor(DepartmentDisabled_Select, 4, true);
			
			passed = action.waitFor(1);
		}
		
		passed = action.sendDataTo(ServiceOrder_Input, this.ServiceOrderNumber);
		passed = action.waitFor(1);
		passed = action.clickOn(Search_Button);
		
		return passed;
	}
	
	public boolean verifyServiceOrderDetails()
	{
		boolean passed = false;
		
		passed = action.waitFor(ServiceOrderDetails_PanelHeader, 4, true);
		passed = action.getTextFromPage(ServiceOrderNumber_Value).trim().equals(this.ServiceOrderNumber);
				
		return passed;
	}
	
	public boolean addServiceCharge()
	{
		boolean passed = false;
		
		this.initialSCcount = action.countOf(ServiceCharge_Row);
		
		passed = action.waitFor(New_ActionButton, 4, true);
		passed = action.clickOn(New_ActionButton);
		
		passed = action.waitFor(ServiceCharge_Select, 4, true);
		passed = action.selectBy(ServiceCharge_Select, 1);
		
		passed = action.waitFor(2);
		
		this.ServiceCharge = action.getSelectedOption(ServiceCharge_Select).replace("-", "");
		
		passed = action.clickOn(Accept_Button);
		passed = action.waitFor(ServiceChargeCreateSuccessMessage, 4, true);
		passed = action.clickOn(MessageOK_Button);
		passed = action.waitFor(MessageOK_Button, 3, false);
				
		return passed;
	}
	
	public boolean deleteServiceCharge()
	{
		boolean passed = false;
		
		this.initialSCcount = action.countOf(ServiceCharge_Row);
		
		passed = action.waitFor(Delete_ActionButton, 4, true);
		passed = action.clickOn(Delete_ActionButton);
		
		passed = action.waitFor(DeleteYes_Button,4,true);
		passed = action.clickOn(DeleteYes_Button);
		
		passed = action.waitFor(DeleteSuccessMessage, 4, true);
		passed = action.clickOn(MessageOK_Button);
		passed = action.waitFor(MessageOK_Button, 3, false);
		
		return passed;
	}
	
	public boolean verifyServiceCharge(String sc, boolean scExist)
	{
		boolean passed = false;
		
		if(!scExist)
		{
			passed = action.countOf(ServiceCharge_Row)==this.initialSCcount-1;
			passed = action.countOf(By.xpath("/*[text()='"+this.ServiceCharge+"']"))==0;
		}
		else
		{
			passed = action.countOf(ServiceCharge_Row)==initialSCcount+1;
			passed = action.countOf(By.xpath("/*[text()='"+this.ServiceCharge+"']"))!=0;
		}
		
		return passed;
	}
}
