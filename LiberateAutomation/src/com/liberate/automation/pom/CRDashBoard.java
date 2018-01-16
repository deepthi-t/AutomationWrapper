package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.core.TestActions;

public class CRDashBoard {
	TestActions action = null;

	String MarketingCategory = "";

	By ExcludeCeaseClosed_CheckBox = By.xpath("//*[text()='Exclude Closed/Ceased Accounts:']");

	// Dashboard
	By CustomerAccountDetails_PanelHeader = By.xpath("//*[text()='Customer Account Details']");

	By AccountNumber_Value = By.xpath("//*[text()='Number:']//following::td[1]");
	By AccountStatus_Value = By.xpath("//*[text()='Status:']//following::td[1]");
	By AccountID_Value = By.xpath("//*[text()='ID:']//following::td[1]");
	By CustomerType_Value = By.xpath("//*[text()='Customer Type:']//following::td[1]");
	By MarketingCategory_Value = By.xpath("//*[text()='Marketing Category:']//following::td[1]");

	// Account Details
	By AccountDetails_Tab = By.xpath("//*[text()='Account Details']");
	By Amend_ActionButton = By.xpath("//span[text()='Amend']");

	By Location_Select = By.xpath("//*[text()='Location:']/following::select[1]");
	By MarketingCategory_Select = By.xpath("//*[text()='Marketing Category:']/following::select[1]");

	public CRDashBoard(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		boolean passed = false;

		if (action.countOf(ExcludeCeaseClosed_CheckBox) > 0) {
			action.waitFor(ExcludeCeaseClosed_CheckBox, 4, false);
		}

		if (!(action.countOf(CustomerAccountDetails_PanelHeader) > 0))
			passed = action.clickOn(LeftLink.Search.Dashboard);

		return passed;
	}

	public boolean verifyDashBoard(String AccountNumber) {
		boolean passed = false;

		passed = action.getTextFromPage(AccountNumber_Value).trim().equals(AccountNumber);
		passed = !action.getTextFromPage(AccountStatus_Value).trim().equals("");
		passed = !action.getTextFromPage(AccountID_Value).trim().equals("");
		passed = !action.getTextFromPage(CustomerType_Value).trim().equals("");
		passed = !action.getTextFromPage(MarketingCategory_Value).trim().equals("");
		
		if(this.MarketingCategory.equals(""))
			this.MarketingCategory = action.getTextFromPage(MarketingCategory_Value).trim();
		else
			passed = action.getTextFromPage(MarketingCategory_Value).trim().equals(MarketingCategory);
		
		return passed;
	}

	public boolean amendAccount() {
		boolean passed = false;

		passed = action.clickOn(AccountDetails_Tab);
		passed = action.waitFor(Amend_ActionButton, 4, true);
		passed = action.clickOn(Amend_ActionButton);
		passed = action.waitFor(Amend_ActionButton, 4, false);

		passed = action.waitFor(Location_Select, 4, true);
		passed = action.selectBy(Location_Select, 1);

		int index = action.getIndexOfSelect(MarketingCategory_Select, MarketingCategory);

		passed = action.selectBy(MarketingCategory_Select, index + 1);

		MarketingCategory = action.getSelectedOption(MarketingCategory_Select);

		passed = action.clickOn(CommonPanel.Accept_Button);

		passed = action.waitFor(CommonPanel.popUp.popUpOK_Button, 4, true);
		passed = action.isTextAvailable("Account details updated successfully.");
		
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);
		passed = action.waitFor(CommonPanel.popUp.popUpOK_Button, 4, false);
		
		action.scrollUp();
		action.scrollUp();
		
		passed = action.clickOn(LeftLink.Search.Dashboard);

		return passed;
	}
}
