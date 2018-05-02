package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.core.TestActions;

public class ComverseTab {
	TestActions action = null;
	
	String currentBalance;
	int currentBalanceInt;
	
	public ComverseTab(TestActions action) {
		this.action = action;
	}
	
	public void verifyComverseEnquiry() {
		By accountID = By.xpath("//*[contains(text(),'Account id')]/following::span[1]");
		By subscriberID = By.xpath("//*[contains(text(),'Subscriber id')]/following::span[1]");
		By currentState = By.xpath("//*[contains(text(),'Current State')]/following::span[1]");
		By previousState = By.xpath("//*[contains(text(),'Previous State')]/following::span[1]");
		
		action.waitFor(accountID, 10, true);
		
		TestActions.log("Account ID : "+action.getTextFromPage(accountID));
		TestActions.log("Subscriber ID : "+action.getTextFromPage(subscriberID));
		TestActions.log("Current State : "+action.getTextFromPage(currentState));
		TestActions.log("Previous State : "+action.getTextFromPage(previousState));
	}

	public boolean getHistoricalData() {
		By audits_Tab = By.xpath("//td[text()='Comverse Details']/following::td[text()='Audits']");
		By balanceAudit_Tab = By.xpath("//td[text()='Balance Audit']");
		
		boolean passed = false;
		
		passed = action.waitFor(audits_Tab, 5, true);
		passed = action.clickOn(audits_Tab);
		
		passed = action.waitFor(balanceAudit_Tab, 5, true);
		passed = action.waitFor(CommonPanel.Search_Button, 10, true);
		passed = action.clickOn(CommonPanel.Search_Button);
		action.waitFor(4);
		
		return passed;
	}
	
	public boolean changeBalance() {
		By balances_Tab = By.xpath("//td[text()='Comverse Details']/following::td[text()='Balances']");
//		By balanceDetails_Tab = By.xpath("//td[text()='Balance Details']");
		
		By balance_Row = By.xpath("//tr[@id='customerServicesForm:serviceEnquiryTabs:0:comverseOneTab:comverseTabs:0:balancesComverseOne:balancesSumaryList:0']");
		By balance_Cell = By.xpath("//tr[@id='customerServicesForm:serviceEnquiryTabs:0:comverseOneTab:comverseTabs:0:balancesComverseOne:balancesSumaryList:0']/descendant::td[2]");
		
		By adjustBalance_ActionButton = By.xpath("//span[text()='Adjust Balance']");
		
		boolean passed = false;
		
		passed = action.waitFor(balances_Tab, 5, true);
		passed = action.clickOn(balances_Tab);
				
		passed = action.waitFor(balance_Row, 10, true);
		passed = action.clickOn(balance_Row);
		
		passed = action.waitFor(adjustBalance_ActionButton, 5, true);
		
		currentBalance = action.getTextFromPage(balance_Cell);
		TestActions.log("Balance : " + currentBalance);

		currentBalance = currentBalance.split("\\.")[0];		
		TestActions.log("Balance for processing :" + currentBalance);
		
		currentBalanceInt = Integer.parseInt(currentBalance);
		TestActions.log("Balance in Integer :" + currentBalanceInt);

		return passed;
	}
	
	public boolean setBalance() {
		boolean passed = false;
		return passed;
	}
	
	public boolean adjustBalance() {
		boolean passed = false;
		return passed;
	}
}
