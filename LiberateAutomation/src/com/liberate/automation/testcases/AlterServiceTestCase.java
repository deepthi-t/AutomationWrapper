package com.liberate.automation.testcases;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.core.ExcelDataDriver;
import com.liberate.automation.core.ReportGenerator;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.AlterSIMCard;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.CRServiceOperations;
import com.liberate.automation.pom.CRServiceOrder;
import com.liberate.automation.pom.SalesSignOff;

public class AlterServiceTestCase {
	static TestActions action = CommonLogin.action;
	static String TestCase;
	static String TestStatus;
	
	static String alterSIMService;
	static Map<String, String> data = new HashedMap<>();  
	
	@Test
	public static void alterSIMCard() {
		TestCase = "Alter SIM Card";
		
		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);
		AlterSIMCard alterSim = new AlterSIMCard(action);
		SalesSignOff sales = new SalesSignOff(action);
		CRServiceOrder order = new CRServiceOrder(action);

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
		
		alterSim.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot(TestCase);
		alterSim.updateSIMCard();
		action.getScreenShot(TestCase);
		
		sales.verifySalesSignOff();
		action.getScreenShot(TestCase);
		sales.signOff();
		action.getScreenShot(TestCase);

		order.getSONumber();
		action.getScreenShot(TestCase);
		order.getSOCommand();
		action.getScreenShot(TestCase);
	}
	
	@BeforeClass
	public static void loadData() {
		data = ExcelDataDriver.loadData();
		alterSIMService = data.get("alterSIMService");
	}
	
	@AfterMethod
	public static void logTestResult(ITestResult result) {
		ReportGenerator.generateReport(TestCase);
		TestStatus = result.getStatus()==ITestResult.SUCCESS?"PASSED":"FAILED";
		
		action.log("Test Status : " + TestStatus);
		action.log("*****COMPLETED '" + TestCase + "' EXECUTION***** \n");
	}
}
