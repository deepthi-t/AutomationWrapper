package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class CCMaintainQuery {
	TestActions action = null;
	String QueryCode = "";
	
	public CCMaintainQuery(TestActions action)
	{
		this.action = action;
	}
	
	By SearchBy_Select = By.xpath("//*[text()='Search By:']/following::select[1]");
	By SearchText_Input = By.xpath("//*[text()='Search By:']/following::input[1]");
	By Search_Button = By.xpath("//input[@value='Search']");
	
	By NewQueryAccount_ActionButton = By.xpath("//span[text()[contains(.,'New Query-Account ')]]");
	
	By QueryInformation_PanelHeader = By.xpath("//*[text()='Query Information']");
	
	By QueryType1_Select = By.xpath("//*[text()='Query Type1:']/following::select[1]");
	By QueryType2Disabled_Select = By.xpath("//*[text()='Query Type3:']/preceding::select[@disabled='disabled'][1]");
	By QueryType2_Select = By.xpath("//*[text()='Query Type2:']/following::select[1]");
	
	By QueryNotes_Input = By.xpath("//*[text()='Notes:']/following::textarea");
	
	By Accept_Button = By.xpath("//input[@value='Accept']");
	
	By QueryDetails_PanelHeader = By.xpath("//*[text()='Query Details']");
	By QueryNumber_Value = By.xpath("//*[text()='Query Number:']/following::span[1]");
	
	public boolean navigate() {
		boolean passed = false;

		passed = action.waitFor(LiberateCommon.LevelOne.CustomerCare, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.CustomerCare);
		passed = action.waitFor(LiberateCommon.CustomerCare.MaintainQuery, 4, true);
		passed = action.clickOn(LiberateCommon.CustomerCare.MaintainQuery);

		return passed;
	}
	
	public boolean searchByAccount(String AccountNumber)
	{
		boolean passed = false;

		passed = action.waitFor(SearchBy_Select, 4, true);
		passed = action.selectByPartialText(SearchBy_Select, "ACC");
		
		passed = action.waitFor(2);
		
		passed = action.sendDataTo(SearchText_Input, AccountNumber);
		
		passed = action.clickOn(Search_Button);
		
		return passed;
	}
	
	public boolean raiseAccountQuery()
	{
		boolean passed = false;

		passed = action.waitFor(NewQueryAccount_ActionButton, 4, true);
		passed = action.clickOn(NewQueryAccount_ActionButton);
		
		passed = action.waitFor(QueryInformation_PanelHeader, 4, true);
		
		passed = action.waitFor(QueryType1_Select, 2, true);
		passed = action.selectBy(QueryType1_Select, 3);
		passed = action.waitFor(QueryType2Disabled_Select, 4, false);
		passed = action.selectBy(QueryType2_Select, 1);
		
		action.waitFor(2);
		
		this.QueryCode = action.getSelectedOption(QueryType1_Select).substring(0, 2) + action.getSelectedOption(QueryType2_Select).substring(0, 2);
		
		passed = action.sendDataTo(QueryNotes_Input, "Testing");
		
		passed = action.clickOn(Accept_Button);
		
		return passed;
	}
	
	public boolean verifyQuery()
	{
		boolean passed = false;
		
		passed = action.waitFor(QueryDetails_PanelHeader, 4, true);
		passed = action.getTextFromPage(QueryNumber_Value).equals("")?false:true;
		
		return passed;
	}
}
