package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class ManageSwitchRequest {
	TestActions action = null;

	// Data
	public String monitorSwitchReq_Status = "";

	// Page Elements : Column Headers
	By ManageSwitchRequest_ColumnHeader = By
			.xpath("//div[@class='icePnlClpsbl icePnlClpsblDM']/descendant::*[text()='Query Switch Request']");
	By MonitorNewSwitchRequests_ColumnHeader = By
			.xpath("//div[@class='icePnlClpsbl icePnlClpsblDM']/descendant::*[text()='Monitor New Switch Requests']");
	By FailureQueries_ColumnHeader = By
			.xpath("//div[@class='icePnlClpsbl icePnlClpsblDM']/descendant::*[text()='Failure Queries']");
	By SwitchRequestSummary_ColumnHeader = By
			.xpath("//div[@class='icePnlClpsbl icePnlClpsblDM']/descendant::*[text()='Switch Request Summary']");
	By SwitchRequestSummaryDetails_ColumnHeader = By.xpath(
			"//div[@class='icePnlClpsbl icePnlClpsblDM']/descendant::*[text()='Switch Request Summary Details']");

	// Page Elements : Input Fields
	By QuerySwitchRequestDropdown = By.xpath("//*[text()='Query Switch Request:']/following::select");

	// Page Elements : Monitor New Switch Request
	By EmployeeNameID_Input = By.xpath("//*[text()='Employee Name / ID:']/following::input[1]");
	By EmployeeNameID_SearchButton = By.xpath("//*[text()='Employee Name / ID:']/following::input[@type='image']");
	By EmployeeNameID_DropDown = By.xpath("//*[text()='Employee Name / ID:']/following::select[1]");
	By UpdatedWithinLast_Input = By.xpath("//*[text()='Updated within last:']/following::input[1]");
	By Status_DropDown = By.xpath("//*[text()='Status:']/following::select[1]");

	// Page Elements : Failure Queries
	By SwitchID_DropDown = By.xpath("//*[text()='Switch ID:']/following::select[1]");
	By Region_DropDown = By.xpath("//*[text()='Region:']/following::select[1]");
	By DepartmentCode_DropDown = By.xpath("//*[text()='Department Code:']/following::select[1]");
	By TargetExchangeID_DropDown = By.xpath("//*[text()='Target Exch ID :']/following::select[1]");
	By StartDate_Input = By.xpath("//*[text()='Start Date:']/following::input[1]");
	By EndDate_Input = By.xpath("//*[text()='End Date:']/following::input[1]");

	// Page Elements : Command Buttons
	By SearchButton = By.xpath("//input[@value='Search']");
	By ResetButon = By.xpath("//input[@value='Reset']");
	
	/***
	 * Default constructor that takes TestAction object as argument.
	 * @param action The TestAction class object, which will be used to run test steps
	 */
	public ManageSwitchRequest(TestActions action) {
		this.action = action;
	}
	
	/***
	 * The method that is called to navigate to Manage Switch Request screen
	 * @return Returns true if able to navigate, else will return false.
	 */
	public boolean navigate() {
		boolean passed = false;

		passed = action.clickOn(LiberateCommon.LevelOne.Orders);
		passed = action.waitFor(LiberateCommon.Orders.SwitchRequests, 4, true);
		passed = action.clickOn(LiberateCommon.Orders.SwitchRequests);
		passed = action.waitFor(LeftLink.SwitchRequests.ManageSwitchRequest, 4, true);
		passed = action.clickOn(LeftLink.SwitchRequests.ManageSwitchRequest);

		return passed;
	}
	
	/***
	 * Method that is called to select Monitor New Switch Requests Functionality
	 * @return True, if able to select; false if not able to select.
	 */
	public boolean select_MonitorNewSwitchRequests() {
		boolean passed = false;

		passed = action.waitFor(QuerySwitchRequestDropdown, 4, true);
		passed = action.SelectBy(QuerySwitchRequestDropdown, "Monitor New Switch Requests");

		return passed;
	}
	
	/***
	 * Method that is called to select Failure Queries Functionality
	 * @return True, if able to select; false if not able to select.
	 */
	public boolean select_FailureQueries() {
		boolean passed = false;

		passed = action.waitFor(QuerySwitchRequestDropdown, 4, true);
		passed = action.SelectBy(QuerySwitchRequestDropdown, "Failure Queries");

		return passed;
	}
	
	/***
	 * Method that is called to select Query by Acct, Service Order, Service or Command Functionality
	 * @return True, if able to select; false if not able to select.
	 */
	public boolean select_QuerybyAcctServiceOrderServiceCommand() {
		boolean passed = false;

		passed = action.waitFor(QuerySwitchRequestDropdown, 4, true);
		passed = action.SelectBy(QuerySwitchRequestDropdown, "Query by Acct, Service Order, Service or Command");

		return passed;
	}
	
	/***
	 * Method that is called to select General Query on New Requests Functionality
	 * @return True, if able to select; false if not able to select.
	 */
	public boolean select_GeneralQueryOnNewRequests() {
		boolean passed = false;

		passed = action.waitFor(QuerySwitchRequestDropdown, 4, true);
		passed = action.SelectBy(QuerySwitchRequestDropdown, "General Query on New Requests");

		return passed;
	}

	/***
	 * Method that is called to select Generate Switch Request Functionality
	 * @return True, if able to select; false if not able to select.
	 */
	public boolean select_GenerateSwitchRequest() {
		boolean passed = false;

		passed = action.waitFor(QuerySwitchRequestDropdown, 4, true);
		passed = action.SelectBy(QuerySwitchRequestDropdown, "Generate Switch Request");

		return passed;
	}
	
	/***
	 * Method that is called to test Monitor New Switch Requests Functionality
	 * @param employeeID The employee ID that needs to be selected
	 * @param updatedWithinLast Update Within Last filter in hours:minutes format. '00:00'
	 * @return
	 */
	public boolean MonitorNewSwitchRequests_Search(String employeeID, String updatedWithinLast) {
		boolean passed = false;

		passed = action.waitFor(MonitorNewSwitchRequests_ColumnHeader, 4, true);
		if (action.getSelectedOption(EmployeeNameID_DropDown).contains("Select")) {
			passed = action.sendDataTo(EmployeeNameID_Input, employeeID);
			passed = action.clickOn(EmployeeNameID_SearchButton);
			passed = action.waitFor(2);
			passed = action.SelectBy(EmployeeNameID_DropDown, 1);
		}

		if (!monitorSwitchReq_Status.equals(""))
			passed = action.SelectBy(Status_DropDown, monitorSwitchReq_Status);

		passed = action.sendDataTo(UpdatedWithinLast_Input, updatedWithinLast);
		passed = action.clickOn(SearchButton);

		// TODO verification of result

		return passed;
	}
}
