package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.LeftLink;
import com.liberate.automation.core.TestActions;

public class CRDashBoard {
	TestActions action = null;
	
	By ExcludeCeaseClosed_CheckBox = By.xpath("//*[text()='Exclude Closed/Ceased Accounts:']");
	
	By CustomerAccountDetails_PanelHeader = By.xpath("//*[text()='Customer Account Details']");
	
	public CRDashBoard(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		boolean passed = false;

		if (action.countOf(ExcludeCeaseClosed_CheckBox) > 0) {
			action.waitFor(ExcludeCeaseClosed_CheckBox, 4, false);
		}
		
		if(!(action.countOf(CustomerAccountDetails_PanelHeader)>0))
			passed = action.clickOn(LeftLink.Search.Dashboard);

		return passed;
	}
}
