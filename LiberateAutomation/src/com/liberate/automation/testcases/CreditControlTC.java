package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestData;
import com.liberate.automation.pom.CCCreditControlService;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.CRDashBoard;
import com.liberate.automation.pom.CRServiceOperations;

public class CreditControlTC {
	static TestActions action = CommonLogin.action;

	static String creditControlServiceNumber = "";

	@BeforeClass
	public static void loadData() {
		creditControlServiceNumber = TestData.creditControlServiceNumber;
	}

	@Test(priority = 0)
	public static void serviceBAR() {
		String TestCase = "CreditControlTC_serviceBAR";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CCCreditControlService creditControl = new CCCreditControlService(action);

		creditControl.navigate();
		action.getScreenShot(TestCase);
		creditControl.searchWithServiceNumber(creditControlServiceNumber);
		action.getScreenShot(TestCase);
		creditControl.serviceBAR();
		action.getScreenShot(TestCase);
		creditControl.verifyServiceStatus();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(enabled = false)
	public static void serviceTOS() {
		String TestCase = "CreditControlTC_serviceTOS";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CCCreditControlService creditControl = new CCCreditControlService(action);

		creditControl.navigate();
		action.getScreenShot(TestCase);
		creditControl.searchWithServiceNumber(creditControlServiceNumber);
		action.getScreenShot(TestCase);
		creditControl.serviceTOS();
		action.getScreenShot(TestCase);
		creditControl.verifyServiceStatus();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(enabled = false)
	public static void serviceROS() {
		String TestCase = "CreditControlTC_serviceROS";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CCCreditControlService creditControl = new CCCreditControlService(action);

		creditControl.navigate();
		action.getScreenShot(TestCase);
		creditControl.searchWithServiceNumber(creditControlServiceNumber);
		action.getScreenShot(TestCase);
		creditControl.serviceROS();
		action.getScreenShot(TestCase);
		creditControl.verifyServiceStatus();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(priority = 1)
	public static void serviceTOSVerifyAudit() {
		String TestCase = "CreditControlTC_serviceTOSVerifyAudit";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CCCreditControlService creditControl = new CCCreditControlService(action);
		CRCustomerSearch search = new CRCustomerSearch(action);
		CRDashBoard dashboard = new CRDashBoard(action);
		CRServiceOperations services = new CRServiceOperations(action);

		creditControl.navigate();
		action.getScreenShot(TestCase);
		creditControl.searchWithServiceNumber(creditControlServiceNumber);
		action.getScreenShot(TestCase);
		creditControl.serviceTOS();
		action.getScreenShot(TestCase);
		creditControl.verifyServiceStatus();
		action.getScreenShot(TestCase);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByServiceNumber(creditControlServiceNumber);
		action.getScreenShot(TestCase);
		dashboard.verifyDashBoard("");
		action.getScreenShot(TestCase);

		services.navigate();
		action.getScreenShot(TestCase);
		services.verifyServicesScreen();
		action.getScreenShot(TestCase);
		services.verifyAudit();
		action.getScreenShot(TestCase);
		services.verifyAuditTOSHistory();
		action.getScreenShot(TestCase);
		assertEquals(services.ServiceStatus, "T");
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(priority = 2)
	public static void serviceROSVerifyAudit() {
		String TestCase = "CreditControlTC_serviceROSVerifyAudit";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CCCreditControlService creditControl = new CCCreditControlService(action);
		CRCustomerSearch search = new CRCustomerSearch(action);
		CRDashBoard dashboard = new CRDashBoard(action);
		CRServiceOperations services = new CRServiceOperations(action);

		creditControl.navigate();
		action.getScreenShot(TestCase);
		creditControl.searchWithServiceNumber(creditControlServiceNumber);
		action.getScreenShot(TestCase);
		creditControl.serviceROS();
		action.getScreenShot(TestCase);
		creditControl.verifyServiceStatus();
		action.getScreenShot(TestCase);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByServiceNumber(creditControlServiceNumber);
		action.getScreenShot(TestCase);
		dashboard.verifyDashBoard("");
		action.getScreenShot(TestCase);

		services.navigate();
		action.getScreenShot(TestCase);
		services.verifyServicesScreen();
		action.getScreenShot(TestCase);
		services.verifyAudit();
		action.getScreenShot(TestCase);
		services.verifyAuditTOSHistory();
		action.getScreenShot(TestCase);
		assertEquals(services.ServiceStatus, "W");
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}
}
