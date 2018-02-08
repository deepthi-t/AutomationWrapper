package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.core.ReportGenerator;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestData;
import com.liberate.automation.pom.ManageSwitchRequest;

public class SwitchRequest {
	static TestActions action = CommonLogin.action;

	static String employeeID = "";
	static String switchRequestTime = "";
	static String switchRequestAccountNumber = "";

	@BeforeClass
	public static void loadTestData()
	{
		SwitchRequest.employeeID = TestData.getData("employeeID");;
		SwitchRequest.switchRequestTime = TestData.getData("switchRequestTime");
		SwitchRequest.switchRequestAccountNumber = TestData.getData("switchRequestAccountNumber");
	}
	
	@Test
	public static void MonitorNewSwitchRequest() {
		String TestCase = "SwitchRequest_MonitorNewSwitchRequest";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		ManageSwitchRequest msr = new ManageSwitchRequest(action);

		assertEquals(msr.navigate(), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.selectMonitorNewSwitchRequests(), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.monitorNewSwitchRequests_Search(employeeID, switchRequestTime), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.verifyResults(), true);
		action.getScreenShot(TestCase);

		ReportGenerator.generateReport(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void SwitchRequestFailureQueries() {
		String TestCase = "SwitchRequest_SwitchRequestFailureQueries";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		ManageSwitchRequest msr = new ManageSwitchRequest(action);

		assertEquals(msr.navigate(), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.selectFailureQueries(), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.failureQueries("FLOW-FLOW TV Gateway Interface", "CAY-Cayman Islands Region", "FLOW-FLOW", "",
				"31/05/2015 03:15", "31/05/2017 03:15"), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.verifyResults(), true);
		action.getScreenShot(TestCase);

		ReportGenerator.generateReport(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void queryByAccountNumber() {
		String TestCase = "SwitchRequest_queryByAccountNumber";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		ManageSwitchRequest msr = new ManageSwitchRequest(action);

		assertEquals(msr.navigate(), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.selectQuerybyAcctServiceOrderServiceCommand(), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.queryByCustomerDetails(switchRequestAccountNumber, "", "", ""), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.verifyResults(), true);
		action.getScreenShot(TestCase);

		ReportGenerator.generateReport(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void generateSwitchRequest() {
		String TestCase = "SwitchRequest_generateSwitchRequest";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		ManageSwitchRequest msr = new ManageSwitchRequest(action);

		assertEquals(msr.navigate(), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.selectGeneralQueryOnNewRequests(), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.generalQUery("C-Complete", "FLOW-FLOW TV Gateway Interface", "CAY-Cayman Islands Region",
				"FLOW-FLOW", "", "31/05/2015 03:15", "31/05/2017 03:15"), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.verifyResults(), true);
		action.getScreenShot(TestCase);

		ReportGenerator.generateReport(TestCase);

		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}
}
