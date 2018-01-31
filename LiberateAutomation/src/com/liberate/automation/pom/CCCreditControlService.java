package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonData;
import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class CCCreditControlService {
	TestActions action = null;
	String RecentAction = "";

	By ServiceNumberSearch_Input = By.xpath("//*[text()[contains(.,'Service Number')]]/following::input[1]");
	By Search_Button = By.xpath("//input[@value='Search']");

	By ServiceStatusHitory_PanelHeader = By.xpath("//*[text()='Service Status History']");

	By BAR_Button = By.xpath("//input[@value='BAR']");
	By TOS_Button = By.xpath("//input[@value='TOS']");
	By ROS_Button = By.xpath("//input[@value='ROS']");

	By Accept_Button = By.xpath("//input[@value='Accept']");

	By UpdateServiceStatus_PanelHeader = By.xpath("//*[text()='Update Service Status']");

	By ServiceStatus_Value = By.xpath(
			"//tbody[@id='maintainccservicestatus:tosHistoryGrpOutDetails:tbody']/descendant::tr[1]//td[2]//span[1]");

	public CCCreditControlService(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);
		
		boolean passed = false;

		passed = action.waitFor(LiberateCommon.LevelOne.CreditControl, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.CreditControl);
		passed = action.waitFor(LeftLink.CreditControl.MaintainCreditControlServiceStatus, 4, true);
		passed = action.clickOn(LeftLink.CreditControl.MaintainCreditControlServiceStatus);

		return passed;
	}

	public boolean searchWithServiceNumber(String ServiceNumber) {
		boolean passed = false;

		passed = action.waitFor(ServiceNumberSearch_Input, 4, true);
		passed = action.sendDataTo(ServiceNumberSearch_Input, ServiceNumber);

		passed = action.clickOn(Search_Button);

		return passed;
	}

	public boolean serviceBAR() {
		this.RecentAction = CommonData.CreditControlServiceStatus.BAR;

		boolean passed = false;

		passed = action.waitFor(ServiceStatusHitory_PanelHeader, 4, true);

		action.waitFor(1);
		if (action.countOf(CommonPanel.popUp.popUpOK_Button) > 0) {
			action.clickOn(CommonPanel.popUp.popUpOK_Button);
			passed = action.waitFor(CommonPanel.popUp.popUpOK_Button, 4, false);
		}

		action.clickOn(BAR_Button);

		action.waitFor(UpdateServiceStatus_PanelHeader, 4, true);

		action.clickOn(Accept_Button);

		return passed;
	}

	public boolean serviceTOS() {
		this.RecentAction = CommonData.CreditControlServiceStatus.TOS;

		boolean passed = false;

		passed = action.waitFor(ServiceStatusHitory_PanelHeader, 4, true);

		action.waitFor(1);
		if (action.countOf(CommonPanel.popUp.popUpOK_Button) > 0) {
			action.clickOn(CommonPanel.popUp.popUpOK_Button);
			passed = action.waitFor(CommonPanel.popUp.popUpOK_Button, 4, false);
		}

		action.clickOn(TOS_Button);

		action.waitFor(UpdateServiceStatus_PanelHeader, 4, true);

		action.clickOn(Accept_Button);

		return passed;
	}

	public boolean serviceROS() {
		this.RecentAction = CommonData.CreditControlServiceStatus.ROS;

		boolean passed = false;

		passed = action.waitFor(ServiceStatusHitory_PanelHeader, 4, true);

		action.waitFor(1);
		if (action.countOf(CommonPanel.popUp.popUpOK_Button) > 0) {
			action.clickOn(CommonPanel.popUp.popUpOK_Button);
			passed = action.waitFor(CommonPanel.popUp.popUpOK_Button, 4, false);
		}

		action.clickOn(ROS_Button);

		action.waitFor(UpdateServiceStatus_PanelHeader, 4, true);

		action.clickOn(Accept_Button);

		return passed;
	}

	public boolean verifyServiceStatus() {
		action.scrollUp();

		boolean passed = false;

		passed = action.waitFor(Accept_Button, 4, false);

		if (RecentAction.equals(CommonData.CreditControlServiceStatus.ROS)) {
			passed = action.getTextFromPage(ServiceStatus_Value).trim().equals("W") ? true : false;
		} else if (RecentAction.equals(CommonData.CreditControlServiceStatus.TOS)) {
			passed = action.getTextFromPage(ServiceStatus_Value).trim().equals("T") ? true : false;
		} else if (RecentAction.equals(CommonData.CreditControlServiceStatus.BAR)) {
			passed = action.getTextFromPage(ServiceStatus_Value).trim().equals("B") ? true : false;
		}

		return passed;
	}
}