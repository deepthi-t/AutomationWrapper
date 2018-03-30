package com.liberate.automation.testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.core.ReportGenerator;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.CRServiceOperations;

public class AlterServiceTestCase {
	static TestActions action = CommonLogin.action;
	static String TestCase;
	static String TestStatus;
	
	static String alterSIMService = "1116341";
	
	@Test
	public void alterSIMCard() {
		TestCase = "Alter SIM Card";
		
		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);
		
		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByServiceNumber(alterSIMService);
		action.getScreenShot(TestCase);

		service.navigate();
		action.getScreenShot(TestCase);
		service.verifyServicesScreen();
		action.getScreenShot(TestCase);
		service.alterSIMCard();
		action.getScreenShot(TestCase);
	}
	
	@BeforeClass
	public static void loadData() {
		
	}
	
	@AfterMethod
	public static void logTestResult(ITestResult result) {
		ReportGenerator.generateReport(TestCase);
		TestStatus = result.getStatus()==ITestResult.SUCCESS?"PASSED":"FAILED";
		
		action.log("Test Status : " + TestStatus);
		action.log("*****COMPLETED '" + TestCase + "' EXECUTION***** \n");
	}
}
