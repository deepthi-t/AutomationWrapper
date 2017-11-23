package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.core.TestActions;

public class MSOAddRemoveServiceCharge
{
	TestActions action = null;
	
	By Department_Select = null;
	By ServiceOrder_Input = null;
	By ServiceOrderList_PanelHeader = null;
	
	/***
	 * Append '[<i><b>count</b></i>]' to select that row.
	 * 
	 * <br>Append '/descendant::td[1]' after adding count, for Service Order
	 * <br>Append '/descendant::td[2]' after adding count, for Customer Name
	 * <br>Append '/descendant::td[1]' after adding count, for SO Priority
	 * <br>Append '/descendant::td[1]' after adding count, for Exchange
	 * <br>Append '/descendant::td[1]' after adding count, for Status
	 */
	By ServiceOrder_Row = CommonPanel.ServiceOrderList.ServiceOrderList_Row;
	
}
