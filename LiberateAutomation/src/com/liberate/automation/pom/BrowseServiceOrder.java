package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class BrowseServiceOrder {
	private TestActions action = null;

	public String ServiceOrderNumber = "";
	By serviceOrder_Value = By.xpath("(//*[text()='Service Order:'])[2]/following::span[1]");

	public BrowseServiceOrder(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		boolean passed = false;

		passed = action.waitFor(LiberateCommon.LevelOne.Orders, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.Orders);

		return passed;
	}

	public boolean searchServiceOrder(String department, String ServiceOrderNumber) {

		action.scrollUp();

		boolean passed = false;

		this.ServiceOrderNumber = ServiceOrderNumber;

		passed = CommonPanel.ServiceOrder.Search(action, department, ServiceOrderNumber);

		return passed;
	}

	public boolean verifyServiceOrdeDetails(String ServiceOrderNumber) {
		boolean passed = false;

		passed = action.waitFor(serviceOrder_Value, 3, true);
		passed = action.getTextFromPage(serviceOrder_Value).trim().equals(ServiceOrderNumber) ? true : false;

		return passed;
	}
	
	public boolean selectMultipleServiceOrder(String Department, int count)
	{
		boolean passed = false;
		
		
		
		return passed;
	}
}
