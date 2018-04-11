package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.core.ReportGenerator;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestData;
import com.liberate.automation.pom.CreditControlService;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.DashBoard;
import com.liberate.automation.pom.ServiceOperations;

/***
 * Class with Credit Control Test Case
 * @author Nikhil
 *
 */
public class CreditControlTC {
	static TestActions action = CommonLogin.action;

	static String TestCase;
	static String TestStatus;
	
	static String creditControlServiceNumber = "";

	@BeforeClass
	public static void loadData() {
		creditControlServiceNumber = TestData.creditControlServiceNumber;
	}
	
	@AfterMethod
	public static void logTestResult(ITestResult result) {
		ReportGenerator.generateReport(TestCase);
		TestStatus = result.getStatus()==ITestResult.SUCCESS?"PASSED":"FAILED";
		
		action.log("Test Status : " + TestStatus);
		action.log("*****COMPLETED '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(priority = 0)
	public static void serviceBAR() {
		TestCase = "CreditControlTC_serviceBAR";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CreditControlService creditControl = new CreditControlService(action);

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
		TestCase = "CreditControlTC_serviceTOS";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CreditControlService creditControl = new CreditControlService(action);

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
		TestCase = "CreditControlTC_serviceROS";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CreditControlService creditControl = new CreditControlService(action);

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

	@Test(priority = 11)
	public static void serviceTOSVerifyAudit() {
		TestCase = "CreditControlTC_serviceTOSVerifyAudit";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CreditControlService creditControl = new CreditControlService(action);
		CRCustomerSearch search = new CRCustomerSearch(action);
		DashBoard dashboard = new DashBoard(action);
		ServiceOperations services = new ServiceOperations(action);

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

	@Test(priority = 12)
	public static void serviceROSVerifyAudit() {
		TestCase = "CreditControlTC_serviceROSVerifyAudit";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CreditControlService creditControl = new CreditControlService(action);
		CRCustomerSearch search = new CRCustomerSearch(action);
		DashBoard dashboard = new DashBoard(action);
		ServiceOperations services = new ServiceOperations(action);

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
