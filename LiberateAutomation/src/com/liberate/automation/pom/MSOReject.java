package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class MSOReject {
	private TestActions action = null;

	public String ServiceOrderNumber = "";
	
	By serviceOrder_Value = By.xpath("(//*[text()='Service Order:'])[2]/following::span[1]");
	
	By rejectDepartment_DropDown = By.xpath("//*[text()='Reject Details']/following::*[text()='Department:']/following::select[1]");
	By reasonOfRejection_DropDown = By.xpath("//*[text()='Reason of Rejection:']//following::select[1]");
	By accpet_Button = By.xpath("//input[@value='Accept']");

	public MSOReject(TestActions action) {
		this.action = action;
	}
	
	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);
		
		boolean passed = false;

		passed = action.waitFor(LiberateCommon.LevelOne.Orders, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.Orders);
		passed = action.waitFor(LiberateCommon.Orders.ManageServiceOrder, 4, true);
		passed = action.clickOn(LiberateCommon.Orders.ManageServiceOrder);
		passed = action.waitFor(LeftLink.ManageServiceOrder.Reject, 4, true);
		passed = action.clickOn(LeftLink.ManageServiceOrder.Reject);

		return passed;
	}
	
	public boolean searchServiceOrder(String department, String ServiceOrderNumber) {
		boolean passed = false;
		if (!department.trim().equals("") && !ServiceOrderNumber.trim().equals("")) {
			this.ServiceOrderNumber = ServiceOrderNumber;
			passed = CommonPanel.ServiceOrder.Search(action, department, ServiceOrderNumber);
		}

		else {
			passed = action.clickOn(CommonPanel.ServiceOrder.serviceOrderList_Header);
			passed = action.waitFor(CommonPanel.ServiceOrder.ServiceOrderList_Row("[1]"), 4, true);
			this.ServiceOrderNumber = action
					.getTextFromPage(CommonPanel.ServiceOrder.ServiceOrderList_Row("[1]/descendant::td[1]"));
			passed = action.clickOn(CommonPanel.ServiceOrder.ServiceOrderList_Row("[1]"));
		}
		return passed;
	}
	
	public boolean verifyServiceOrdeDetails(String ServiceOrderNumber) {
		boolean passed = false;

		passed = action.waitFor(serviceOrder_Value, 3, true);
		passed = action.getTextFromPage(serviceOrder_Value).trim().equals(ServiceOrderNumber) ? true : false;

		return passed;
	}
	
	public boolean reject()
	{
		boolean passed = false;
		
		passed = action.waitFor(rejectDepartment_DropDown, 4, true);
		passed = action.selectBy(rejectDepartment_DropDown, 1);

		action.waitFor(1);
		
		passed = action.selectBy(reasonOfRejection_DropDown, 1);
		
		action.waitFor(accpet_Button, 2, true);
		action.clickOn(accpet_Button);
		
		action.waitFor(CommonPanel.popUp.popUpWindow, 4, true);
		action.clickOn(CommonPanel.popUp.popUpOK_Button);
		
		return passed;
	}
}
