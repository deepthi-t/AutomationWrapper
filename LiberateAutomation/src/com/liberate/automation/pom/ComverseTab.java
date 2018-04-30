package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.core.TestActions;

public class ComverseTab {
	TestActions action = null;
	
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
}
