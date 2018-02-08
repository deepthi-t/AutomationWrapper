package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.CRDashBoard;
import com.liberate.automation.pom.CRServiceOperations;
import com.liberate.automation.pom.CCCreditControlService;

public class CreditControlTC {
	static TestActions action = CommonLogin.action;
	
	static String serviceNumber = "9174085";
	
	@Test(priority = 0)
	public static void serviceBAR() {
		String TestCase = "CreditControlTC_serviceBAR";
		
		CCCreditControlService creditControl = new CCCreditControlService(action);

		creditControl.navigate();
		action.getScreenShot(TestCase);
		creditControl.searchWithServiceNumber(serviceNumber);
		action.getScreenShot(TestCase);
		creditControl.serviceBAR();
		action.getScreenShot(TestCase);
		creditControl.verifyServiceStatus();
		action.getScreenShot(TestCase);
	}

	@Test(enabled = false)
	public static void serviceTOS() {
		String TestCase = "CreditControlTC_serviceTOS";

		CCCreditControlService creditControl = new CCCreditControlService(action);

		creditControl.navigate();
		action.getScreenShot(TestCase);
		creditControl.searchWithServiceNumber(serviceNumber);
		action.getScreenShot(TestCase);
		creditControl.serviceTOS();
		action.getScreenShot(TestCase);
		creditControl.verifyServiceStatus();
		action.getScreenShot(TestCase);
	}

	@Test(enabled = false)
	public static void serviceROS() {
		String TestCase = "CreditControlTC_serviceROS";

		CCCreditControlService creditControl = new CCCreditControlService(action);

		creditControl.navigate();
		action.getScreenShot(TestCase);
		creditControl.searchWithServiceNumber(serviceNumber);
		action.getScreenShot(TestCase);
		creditControl.serviceROS();
		action.getScreenShot(TestCase);
		creditControl.verifyServiceStatus();
		action.getScreenShot(TestCase);
	}

	@Test(priority = 1)
	public static void serviceTOSVerifyAudit() {
		String TestCase = "CreditControlTC_serviceTOSVerifyAudit";

		CCCreditControlService creditControl = new CCCreditControlService(action);
		CRCustomerSearch search = new CRCustomerSearch(action);
		CRDashBoard dashboard = new CRDashBoard(action);
		CRServiceOperations services = new CRServiceOperations(action);

		creditControl.navigate();
		action.getScreenShot(TestCase);
		creditControl.searchWithServiceNumber(serviceNumber);
		action.getScreenShot(TestCase);
		creditControl.serviceTOS();
		action.getScreenShot(TestCase);
		creditControl.verifyServiceStatus();
		action.getScreenShot(TestCase);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByServiceNumber(serviceNumber);
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
	}

	@Test(priority = 2)
	public static void serviceROSVerifyAudit() {
		String TestCase = "CreditControlTC_serviceROSVerifyAudit";

		CCCreditControlService creditControl = new CCCreditControlService(action);
		CRCustomerSearch search = new CRCustomerSearch(action);
		CRDashBoard dashboard = new CRDashBoard(action);
		CRServiceOperations services = new CRServiceOperations(action);

		creditControl.navigate();
		action.getScreenShot(TestCase);
		creditControl.searchWithServiceNumber(serviceNumber);
		action.getScreenShot(TestCase);
		creditControl.serviceROS();
		action.getScreenShot(TestCase);
		creditControl.verifyServiceStatus();
		action.getScreenShot(TestCase);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByServiceNumber(serviceNumber);
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
	}
}
