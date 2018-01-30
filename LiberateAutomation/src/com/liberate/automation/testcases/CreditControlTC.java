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
	public void serviceBAR() {
		String ServiceNumber = "9177243";
		
		CCCreditControlService creditControl = new CCCreditControlService(action);

		creditControl.navigate();
		action.getScreenShot("serviceBAR");
		creditControl.searchWithServiceNumber(ServiceNumber);
		action.getScreenShot("serviceBAR");
		creditControl.serviceBAR();
		action.getScreenShot("serviceBAR");
		creditControl.verifyServiceStatus();
		action.getScreenShot("serviceBAR");
	}

	@Test
	public void serviceTOS() {
		String ServiceNumber = "9177243";

		CCCreditControlService creditControl = new CCCreditControlService(action);

		creditControl.navigate();
		action.getScreenShot("serviceTOS");
		creditControl.searchWithServiceNumber(ServiceNumber);
		action.getScreenShot("serviceTOS");
		creditControl.serviceTOS();
		action.getScreenShot("serviceTOS");
		creditControl.verifyServiceStatus();
		action.getScreenShot("serviceTOS");
	}

	@Test
	public void serviceROS() {
		CCCreditControlService creditControl = new CCCreditControlService(action);

		creditControl.navigate();
		action.getScreenShot("serviceROS");
		creditControl.searchWithServiceNumber("9177243");
		action.getScreenShot("serviceROS");
		creditControl.serviceROS();
		action.getScreenShot("serviceROS");
		creditControl.verifyServiceStatus();
		action.getScreenShot("serviceROS");
	}

	@Test
	public void serviceTOSVerifyAudit() {
		/***
		 * Working service number that needs to be TOSed
		 */
		String ServiceNumber = "9177243";

		CCCreditControlService creditControl = new CCCreditControlService(action);
		CRCustomerSearch search = new CRCustomerSearch(action);
		CRDashBoard dashboard = new CRDashBoard(action);
		CRServiceOperations services = new CRServiceOperations(action);

		creditControl.navigate();
		action.getScreenShot("serviceTOSVerifyAudit");
		creditControl.searchWithServiceNumber(ServiceNumber);
		action.getScreenShot("serviceTOSVerifyAudit");
		creditControl.serviceTOS();
		action.getScreenShot("serviceTOSVerifyAudit");
		creditControl.verifyServiceStatus();
		action.getScreenShot("serviceTOSVerifyAudit");

		search.navigate();
		action.getScreenShot("serviceTOSVerifyAudit");
		search.searchByServiceNumber(ServiceNumber);
		action.getScreenShot("serviceTOSVerifyAudit");
		dashboard.verifyDashBoard("");
		action.getScreenShot("serviceTOSVerifyAudit");

		services.navigate();
		action.getScreenShot("serviceTOSVerifyAudit");
		services.verifyServicesScreen();
		action.getScreenShot("serviceTOSVerifyAudit");
		services.verifyAudit();
		action.getScreenShot("serviceTOSVerifyAudit");
		services.verifyAuditTOSHistory();
		action.getScreenShot("serviceTOSVerifyAudit");
		assertEquals(services.ServiceNumber, "T");
	}

	@Test
	public void serviceROSVerifyAudit() {
		/***
		 * Working service number that needs to be TOSed
		 */
		String ServiceNumber = "9177243";

		CCCreditControlService creditControl = new CCCreditControlService(action);
		CRCustomerSearch search = new CRCustomerSearch(action);
		CRDashBoard dashboard = new CRDashBoard(action);
		CRServiceOperations services = new CRServiceOperations(action);


		creditControl.navigate();
		action.getScreenShot("serviceROSVerifyAudit");
		creditControl.searchWithServiceNumber(ServiceNumber);
		action.getScreenShot("serviceROSVerifyAudit");
		creditControl.serviceROS();
		action.getScreenShot("serviceROSVerifyAudit");
		creditControl.verifyServiceStatus();
		action.getScreenShot("serviceROSVerifyAudit");
		
		search.navigate();
		action.getScreenShot("serviceROSVerifyAudit");
		search.searchByServiceNumber(ServiceNumber);
		action.getScreenShot("serviceROSVerifyAudit");
		dashboard.verifyDashBoard("");
		action.getScreenShot("serviceROSVerifyAudit");

		services.navigate();
		action.getScreenShot("serviceROSVerifyAudit");
		services.verifyServicesScreen();
		action.getScreenShot("serviceROSVerifyAudit");
		services.verifyAudit();
		action.getScreenShot("serviceROSVerifyAudit");
		services.verifyAuditTOSHistory();
		action.getScreenShot("serviceROSVerifyAudit");
		assertEquals(services.ServiceStatus, "W");
	}
}
