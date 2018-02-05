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

	@Test
	public static void serviceBAR() {
		String TestCase = "CreditControlTC_serviceBAR";
		
		String ServiceNumber = "9177243";

		CCCreditControlService creditControl = new CCCreditControlService(action);

		creditControl.navigate();
		action.getScreenShot(TestCase);
		creditControl.searchWithServiceNumber(ServiceNumber);
		action.getScreenShot(TestCase);
		creditControl.serviceBAR();
		action.getScreenShot(TestCase);
		creditControl.verifyServiceStatus();
		action.getScreenShot(TestCase);
	}

	@Test
	public static void serviceTOS() {
		String TestCase = "CreditControlTC_serviceTOS";

		String ServiceNumber = "9177243";

		CCCreditControlService creditControl = new CCCreditControlService(action);

		creditControl.navigate();
		action.getScreenShot(TestCase);
		creditControl.searchWithServiceNumber(ServiceNumber);
		action.getScreenShot(TestCase);
		creditControl.serviceTOS();
		action.getScreenShot(TestCase);
		creditControl.verifyServiceStatus();
		action.getScreenShot(TestCase);
	}

	@Test
	public static void serviceROS() {
		String TestCase = "CreditControlTC_serviceROS";

		CCCreditControlService creditControl = new CCCreditControlService(action);

		creditControl.navigate();
		action.getScreenShot(TestCase);
		creditControl.searchWithServiceNumber("9177243");
		action.getScreenShot(TestCase);
		creditControl.serviceROS();
		action.getScreenShot(TestCase);
		creditControl.verifyServiceStatus();
		action.getScreenShot(TestCase);
	}

	@Test
	public static void serviceTOSVerifyAudit() {
		String TestCase = "CreditControlTC_serviceTOSVerifyAudit";

		/***
		 * Working service number that needs to be TOSed
		 */
		String ServiceNumber = "9177243";

		CCCreditControlService creditControl = new CCCreditControlService(action);
		CRCustomerSearch search = new CRCustomerSearch(action);
		CRDashBoard dashboard = new CRDashBoard(action);
		CRServiceOperations services = new CRServiceOperations(action);

		creditControl.navigate();
		action.getScreenShot(TestCase);
		creditControl.searchWithServiceNumber(ServiceNumber);
		action.getScreenShot(TestCase);
		creditControl.serviceTOS();
		action.getScreenShot(TestCase);
		creditControl.verifyServiceStatus();
		action.getScreenShot(TestCase);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByServiceNumber(ServiceNumber);
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
		assertEquals(services.ServiceNumber, "T");
	}

	@Test
	public static void serviceROSVerifyAudit() {
		String TestCase = "CreditControlTC_serviceROSVerifyAudit";

		/***
		 * Working service number that needs to be TOSed
		 */
		String ServiceNumber = "9177243";

		CCCreditControlService creditControl = new CCCreditControlService(action);
		CRCustomerSearch search = new CRCustomerSearch(action);
		CRDashBoard dashboard = new CRDashBoard(action);
		CRServiceOperations services = new CRServiceOperations(action);

		creditControl.navigate();
		action.getScreenShot(TestCase);
		creditControl.searchWithServiceNumber(ServiceNumber);
		action.getScreenShot(TestCase);
		creditControl.serviceROS();
		action.getScreenShot(TestCase);
		creditControl.verifyServiceStatus();
		action.getScreenShot(TestCase);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByServiceNumber(ServiceNumber);
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
