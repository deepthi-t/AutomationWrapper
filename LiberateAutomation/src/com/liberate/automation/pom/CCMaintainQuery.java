package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.common.TestData;
import com.liberate.automation.core.TestActions;

public class CCMaintainQuery {
	TestActions action = null;
	
	String QueryCode = "";
	String QueryStatus = "";
	String SelectedQueryStatus = "";
	
	By SearchBy_Select = By.xpath("//*[text()='Search By:']/following::select[1]");
	By SearchText_Input = By.xpath("//*[text()='Search By:']/following::input[1]");
	By Search_Button = By.xpath("//input[@value='Search']");

	By NewQueryAccount_ActionButton = By.xpath("//span[text()[contains(.,'New Query-Account ')]]");
	By NewQueryNonAccount_ActionButton = By.xpath("//span[text()='New Query-Non Account']");
	
	By Exchange_Input = By.xpath("//*[text()[contains(.,'Exchange:')]]/following::input[1]");
	By ExchangeAutoFill_Input = By.xpath("//div[@class='iceSelInpTxtList seliceSelInpTxtList']/descendant::div[1]");
	
	By ContactName = By.xpath("//*[text()[contains(.,'Contact Name')]]/following::input[1]");
	By ContactMethod = By.xpath("//*[text()[contains(.,'Contact Method')]]/following::select[1]");
	By ContactDetails = By.xpath("//*[text()[contains(.,'Contact Details')]]/following::input[2]");
	
	By QueryInformation_PanelHeader = By.xpath("//*[text()='Query Information']");

	By QueryType1_Select = By.xpath("//*[text()='Query Type1:']/following::select[1]");
	By QueryType2Disabled_Select = By.xpath("//*[text()='Query Type3:']/preceding::select[@disabled='disabled'][1]");
	By QueryType2_Select = By.xpath("//*[text()='Query Type2:']/following::select[1]");

	By QueryNotes_Input = By.xpath("//*[text()='Notes:']/following::textarea");

	By Accept_Button = By.xpath("//input[@value='Accept']");

	By QueryDetails_PanelHeader = By.xpath("//*[text()='Query Details']");
	By QueryNumber_Value = By.xpath("//*[text()='Query Number:']/following::span[1]");
	By QueryType_Value = By.xpath("//*[text()='Query Type:']/following::span[1]");
	By QueryStatus_Value = By.xpath("(//*[text()='Status:'])[1]/following::span[1]");
	
	By Query_Row = By.xpath("//tr[@id='manageQueryForm:querySearchResults_row_0']");

	By Amend_ActionButton = By.xpath("//span[text()='Amend']");
	By Notes_ActionButton = By.xpath("//span[text()='Notes']");
	
	By Add_Button = By.xpath("//input[@value='Add']");
	By Back_Button = By.xpath("//input[@value='<< Back']");
	By Cancel_Button = By.xpath("Cancel_Button");
	
	By Progress_ActionButton = By.xpath("//span[text()='Progress']");
	By ProgressStatus_PanelHeader = By.xpath("//*[text()='Change Progress Status']");
	By ProgressStatus_Select = By.xpath("(//*[text()='Status:'])[last()]/following::select[1]");
	
	By Bills_ActionButton = By.xpath("//span[text()='Bills']");
	By ListOfBills_PanelHeader = By.xpath("//*[text()='List of Bills']");
	By Bills_Row = By.xpath("//*[text()='List of Bills']/following::tr[@class='ui-datatable-even']");
	By BillView_Panel = By.xpath("//*[text()='ViewBill']");
	
	public CCMaintainQuery(TestActions action) {
		this.action = action;
	}
	public boolean navigate() {
		boolean passed = false;

		passed = action.waitFor(LiberateCommon.LevelOne.CustomerCare, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.CustomerCare);
		passed = action.waitFor(LiberateCommon.CustomerCare.MaintainQuery, 4, true);
		passed = action.clickOn(LiberateCommon.CustomerCare.MaintainQuery);

		return passed;
	}

	public boolean searchByAccount(String AccountNumber) {
		action.scrollUp();

		boolean passed = false;

		passed = action.waitFor(SearchBy_Select, 4, true);
		passed = action.selectByPartialText(SearchBy_Select, "ACC");

		passed = action.waitFor(2);

		passed = action.sendDataTo(SearchText_Input, AccountNumber);

		passed = action.clickOn(Search_Button);

		return passed;
	}

	public boolean searchByQueryNumber(String QueryNumber) {
		action.scrollUp();

		boolean passed = false;

		passed = action.waitFor(SearchBy_Select, 4, true);
		passed = action.selectByPartialText(SearchBy_Select, "QUN");

		passed = action.waitFor(2);

		passed = action.sendDataTo(SearchText_Input, QueryNumber);

		passed = action.clickOn(Search_Button);

		passed = action.waitFor(Query_Row, 4, true);
		passed = action.clickOn(Query_Row);

		return passed;
	}

	public boolean raiseAccountQuery() {
		action.scrollUp();

		boolean passed = false;

		passed = action.waitFor(NewQueryAccount_ActionButton, 4, true);
		passed = action.clickOn(NewQueryAccount_ActionButton);

		passed = action.waitFor(QueryInformation_PanelHeader, 4, true);

		passed = action.waitFor(QueryType1_Select, 2, true);
		passed = action.selectBy(QueryType1_Select, 3);
		passed = action.waitFor(QueryType2Disabled_Select, 4, false);
		passed = action.selectBy(QueryType2_Select, 1);

		action.waitFor(2);

		this.QueryCode = action.getSelectedOption(QueryType1_Select).substring(0, 2)
				+ action.getSelectedOption(QueryType2_Select).substring(0, 2);

		passed = action.sendDataTo(QueryNotes_Input, "Testing");

		passed = action.clickOn(Accept_Button);

		return passed;
	}

	
	public boolean raiseNonAccountQuery(String Name, String Method, String Details) {
		action.scrollUp();

		boolean passed = false;
		
		passed = action.waitFor(NewQueryNonAccount_ActionButton, 4, true);
		passed = action.clickOn(NewQueryNonAccount_ActionButton);

		passed = action.waitFor(QueryInformation_PanelHeader, 4, true);

		passed = action.waitFor(Exchange_Input, 4, true);
		passed = action.waitFor(1);
		passed = action.typeDataTo(Exchange_Input, "BOT");
		
		passed = action.waitFor(ExchangeAutoFill_Input, 6, true);
		passed = action.clickOn(ExchangeAutoFill_Input);
		
		passed = action.waitFor(QueryType1_Select, 2, true);
		passed = action.selectBy(QueryType1_Select, 3);
		passed = action.waitFor(QueryType2Disabled_Select, 4, false);
		passed = action.selectBy(QueryType2_Select, 1);

		action.waitFor(2);

		this.QueryCode = action.getSelectedOption(QueryType1_Select).substring(0, 2)
				+ action.getSelectedOption(QueryType2_Select).substring(0, 2);

		passed = action.sendDataTo(QueryNotes_Input, "Testing");

		passed = action.sendDataTo(ContactName, Name);
		passed = action.selectByPartialText(ContactMethod, Method);
		passed = action.sendDataTo(ContactDetails, Details);
		
		passed = action.clickOn(Accept_Button);

		return passed;
	}
	
	public boolean verifyQuery() {
		action.scrollUp();

		boolean passed = false;

		passed = action.waitFor(QueryDetails_PanelHeader, 4, true);

		TestData.QueryNumber = action.getTextFromPage(QueryNumber_Value);
		passed = TestData.QueryNumber.equals("") ? false : true;

		passed = action.getTextFromPage(QueryType_Value).substring(0, 4).equals(QueryCode);

		action.log("Raised Query Code    : " + QueryCode);
		
		action.log("Query Code in Screen : " + action.getTextFromPage(QueryType_Value).substring(0, 4));
		
		this.QueryStatus = action.getTextFromPage(QueryStatus_Value).trim();
		
		return passed;
	}

	public boolean amendQuery() {
		action.scrollUp();

		boolean passed = false;

		passed = action.waitFor(Amend_ActionButton, 4, true);
		action.waitFor(1);
		passed = action.clickOn(Amend_ActionButton);

		passed = action.waitFor(QueryType1_Select, 2, true);
		passed = action.selectBy(QueryType1_Select, 4);
		action.waitFor(3);
		passed = action.selectBy(QueryType2_Select, 1);

		this.QueryCode = action.getSelectedOption(QueryType1_Select).substring(0, 2)
				+ action.getSelectedOption(QueryType2_Select).substring(0, 2);

		action.waitFor(3);
		passed = action.clickOn(Accept_Button);

		return passed;
	}
	
	public boolean addNote(String Note) {
		action.scrollUp();
		boolean passed = false;
		
		action.waitFor(1);
		passed = action.clickOn(Notes_ActionButton);
		
		passed = action.waitFor(QueryNotes_Input, 4, true);
		passed = action.sendDataTo(QueryNotes_Input, Note);
		
		passed = action.clickOn(Add_Button);
		
		passed = action.waitFor(By.xpath("//*[text()='"+Note+"']"), 4, true);
		
		passed = action.clickOn(Back_Button);
		
		return passed;
	}
	
	public boolean progressQuery(String Status) {
		action.scrollUp();
		boolean passed = false;
		
		action.waitFor(1);
		passed = action.clickOn(Progress_ActionButton);
		
		passed = action.waitFor(ProgressStatus_PanelHeader, 4, true);
		
		action.scrollDown();
		
		passed = action.selectByPartialText(ProgressStatus_Select, Status);
		
		this.SelectedQueryStatus = action.getSelectedOption(ProgressStatus_Select);
		
		action.waitFor(2);
		
		passed = action.clickOn(Accept_Button);
		
		return passed;
	}
	
	public boolean verifyBills()
	{
		action.scrollUp();
		boolean passed = false;
		
		passed = action.clickOn(Bills_ActionButton);
		passed = action.waitFor(ListOfBills_PanelHeader, 4, true);
		
		passed = action.waitFor(Bills_Row, 2, true);
		passed = action.clickOn(Bills_Row);
		
		passed = action.waitFor(BillView_Panel, 4, true);
		
		return passed;
	}
	
	public boolean navigateBackFromBillView()
	{
		boolean passed = false;

		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);
		passed = action.waitFor(CommonPanel.popUp.popUpOK_Button, 4, false);
		
		passed = action.clickOn(Cancel_Button);
		
		return passed;
	}
}
