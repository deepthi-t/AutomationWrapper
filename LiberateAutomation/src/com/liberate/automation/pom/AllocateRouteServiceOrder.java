package com.liberate.automation.pom;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class AllocateRouteServiceOrder { // order
	// Route Allocation page
	By AllocateAuto_ActionButton = By.xpath("//*[text ( ) = 'Allocate Auto']");
	
	By ReleaseRoute_ActionButton = By.xpath("//span[text()='Release Route']");
	
	// Allocate Route - Auto
	By ExchangeArea_Select = By.xpath("//*[text ( ) = 'Exchange Area :']/following::select[1]");
	By PlantItemType_Select = By.xpath("//*[text ( ) = 'Exchange Area :']/following::select[2]");
	By PlantItemNo_Input = By.xpath("//*[text ( ) = 'Plant Item No:']/following::input[1]");
	By Accept_Button = By.xpath("//input[@value = 'Accept']");
	By Release_Button = By.xpath("//input[@value='Release']");
	
	By ServiceNumber_Value = By
			.xpath("//tbody[@class='ui-datatable-data ui-widget-content']/descendant::tr[1]/td[3]//span");
	By RouteAllocatedState_Value = By.xpath("//tbody[@class='ui-datatable-data ui-widget-content']/descendant::tr[1]/td[5]//span");
	By selected_Row = By.xpath("//tr[contains(@class,'ui-selected')]");
	
	By RoutingTableTerminal_Header = By.xpath("//*[text()='Terminal']");
	
	TestActions action = null;
	public String ServiceOrderNumber = "";
	public String ServiceNumber = "";

	public AllocateRouteServiceOrder(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		boolean passed = false;

		passed = action.waitFor(LiberateCommon.LevelOne.Orders, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.Orders);
		passed = action.waitFor(LiberateCommon.Orders.RouteMaintenance, 4, true);
		passed = action.clickOn(LiberateCommon.Orders.RouteMaintenance);
		passed = action.clickOn(LeftLink.RouteMaintenance.AllocateRouteServiceOrder);
		passed = action.waitFor(LeftLink.RouteMaintenance.AllocateRouteServiceOrder, 4, true);

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

	public boolean releaseRoute() {
		boolean passed = false;
		
		passed = action.waitFor(ReleaseRoute_ActionButton, 4, true);
		passed = action.clickOn(ReleaseRoute_ActionButton);
		
		passed = action.waitFor(Release_Button, 4, true);
		passed = action.clickOn(Release_Button);
		
		passed = action.waitFor(CommonPanel.popUp.popUpWindow, 4, true);
		passed = action.clickOn(CommonPanel.popUp.popUpYes_Button);
		
		return passed;
	}
	
	public boolean verifyRelease()
	{
		action.scrollUp();
		action.scrollUp();
		
		boolean passed = false;
		
		if(action.countOf(CommonPanel.popUp.popUpYes_Button)>0)
			action.waitFor(2);
		
		passed = action.waitFor(CommonPanel.popUp.popUpWindow, 4, true);
		passed = (action.getTextFromPage(CommonPanel.popUp.popUpMessage_Value).trim().equals("Route released Successfully")?true:false);
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);
		
		return passed;
	}
	
	public boolean allocateAuto(String PlantItemType, String PlantItemNumber) {
		boolean passed = false;
		
		passed = action.waitFor(selected_Row, 4, true);
		if(!action.getTextFromPage(RouteAllocatedState_Value).trim().equals("N"))
		{
			releaseRoute();
			verifyRelease();
		}
		
		action.scrollUp();
		action.waitFor(2);
		
		passed = action.clickOn(AllocateAuto_ActionButton);
		passed = action.waitFor(ExchangeArea_Select, 4, true);
		
		passed = action.selectByPartialText(ExchangeArea_Select, "BOT");
		passed = action.waitFor(2);
		passed = action.selectByPartialText(PlantItemType_Select, PlantItemType);
		
		passed = action.sendDataTo(PlantItemNo_Input, PlantItemNumber);
		
		passed = action.clickOn(Accept_Button);
		
		passed = action.waitFor(RoutingTableTerminal_Header, 4, true);
		passed = action.clickOn(Accept_Button);
		
		return passed;
	}
	
	public boolean verifyAutoAllocateRoute()
	{
		boolean passed = false;
		
		passed = action.waitFor(CommonPanel.popUp.popUpWindow, 4, true);
		passed = (action.getTextFromPage(CommonPanel.popUp.popUpMessage_Value).trim().equals("Auto route created Successfully.")?true:false);
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);
				
		return passed;
	}
	
	public boolean allocateManual() {
//		boolean passed = false;
		throw new NotImplementedException("This method is not implemented");
//		return passed;
	}
}
