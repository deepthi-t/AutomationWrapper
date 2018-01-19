package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.Login;
import com.liberate.automation.pom.ManageSwitchRequest;

public class SwitchRequest {

	static TestActions action = CommonLogin.action;

	@Test(enabled = false)
	public static void MonitorNewSwitchRequest() {

		ManageSwitchRequest msr = new ManageSwitchRequest(action);

		assertEquals(msr.navigate(), true);
		action.getScreenShot("MonitorNewSwitchRequest");
		assertEquals(msr.selectMonitorNewSwitchRequests(), true);
		action.getScreenShot("MonitorNewSwitchRequest");
		assertEquals(msr.monitorNewSwitchRequests_Search("99999", "23:30"), true);
		action.getScreenShot("MonitorNewSwitchRequest");
		assertEquals(msr.verifyResults(), true);
		action.getScreenShot("MonitorNewSwitchRequest");
	}

	@Test
	public static void SwitchRequestFailureQueries() {
		ManageSwitchRequest msr = new ManageSwitchRequest(action);
		Login login = new Login(action);

		assertEquals(login.login("libadmin", "Ic3cr34m!"), true);
		action.getScreenShot("SwitchRequestFailureQueries");
		assertEquals(msr.navigate(), true);
		action.getScreenShot("SwitchRequestFailureQueries");
		assertEquals(msr.selectFailureQueries(), true);
		action.getScreenShot("SwitchRequestFailureQueries");
		assertEquals(msr.failureQueries("FLOW-FLOW TV Gateway Interface", "CAY-Cayman Islands Region", "FLOW-FLOW", "",
				"31/05/2015 03:15", "31/05/2017 03:15"), true);
		action.getScreenShot("SwitchRequestFailureQueries");
		assertEquals(msr.verifyResults(), true);
		action.getScreenShot("SwitchRequestFailureQueries");

	}

	@Test
	public static void queryByCustomerDetails_AccountNumber() {
		ManageSwitchRequest msr = new ManageSwitchRequest(action);
		Login login = new Login(action);

		assertEquals(login.login("libadmin", "Ic3cr34m!"), true);
		action.getScreenShot("queryByCustomerDetails_AccountNumber");
		assertEquals(msr.navigate(), true);
		action.getScreenShot("queryByCustomerDetails_AccountNumber");
		assertEquals(msr.selectQuerybyAcctServiceOrderServiceCommand(), true);
		action.getScreenShot("queryByCustomerDetails_AccountNumber");
		assertEquals(msr.queryByCustomerDetails("260002430000", "", "", ""), true);
		action.getScreenShot("queryByCustomerDetails_AccountNumber");
		assertEquals(msr.verifyResults(), true);
		action.getScreenShot("queryByCustomerDetails_AccountNumber");
	}

	@Test
	public static void generatQueryOnSwitchRequest() {
		ManageSwitchRequest msr = new ManageSwitchRequest(action);
		Login login = new Login(action);

		assertEquals(login.login("libadmin", "Ic3cr34m!"), true);
		action.getScreenShot("MonitorNewSwitchRequest");
		assertEquals(msr.navigate(), true);
		action.getScreenShot("MonitorNewSwitchRequest");
		assertEquals(msr.selectGeneralQueryOnNewRequests(), true);
		action.getScreenShot("MonitorNewSwitchRequest");
		assertEquals(msr.generalQUery("C-Complete", "FLOW-FLOW TV Gateway Interface", "CAY-Cayman Islands Region",
				"FLOW-FLOW", "", "31/05/2015 03:15", "31/05/2017 03:15"), true);
		action.getScreenShot("MonitorNewSwitchRequest");
		assertEquals(msr.verifyResults(), true);
		action.getScreenShot("MonitorNewSwitchRequest");
	}
}
