package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.liberate.automation.core.ReportGenerator;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.Login;
import com.liberate.automation.pom.ManageSwitchRequest;

public class SwitchRequest {

	static TestActions action = CommonLogin.action;

	@Test(enabled = false)
	public static void MonitorNewSwitchRequest() {
		String TestCase = "SwitchRequest_MonitorNewSwitchRequest";

		ManageSwitchRequest msr = new ManageSwitchRequest(action);

		assertEquals(msr.navigate(), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.selectMonitorNewSwitchRequests(), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.monitorNewSwitchRequests_Search("99999", "23:30"), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.verifyResults(), true);
		action.getScreenShot(TestCase);

		ReportGenerator.generateReport(TestCase);
	}

	@Test
	public static void SwitchRequestFailureQueries() {
		String TestCase = "SwitchRequest_SwitchRequestFailureQueries";

		ManageSwitchRequest msr = new ManageSwitchRequest(action);
		Login login = new Login(action);

		assertEquals(login.login("libadmin", "Ic3cr34m!"), true);
		action.getScreenShot(TestCase);
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
	}

	@Test
	public static void queryByAccountNumber() {
		String TestCase = "SwitchRequest_queryByAccountNumber";

		ManageSwitchRequest msr = new ManageSwitchRequest(action);
		Login login = new Login(action);

		assertEquals(login.login("libadmin", "Ic3cr34m!"), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.navigate(), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.selectQuerybyAcctServiceOrderServiceCommand(), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.queryByCustomerDetails("260002430000", "", "", ""), true);
		action.getScreenShot(TestCase);
		assertEquals(msr.verifyResults(), true);
		action.getScreenShot(TestCase);

		ReportGenerator.generateReport(TestCase);
	}

	@Test
	public static void generateSwitchRequest() {
		String TestCase = "SwitchRequest_generateSwitchRequest";

		ManageSwitchRequest msr = new ManageSwitchRequest(action);
		Login login = new Login(action);

		assertEquals(login.login("libadmin", "Ic3cr34m!"), true);
		action.getScreenShot(TestCase);
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
	}
}
