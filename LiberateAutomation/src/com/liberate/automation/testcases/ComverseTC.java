package com.liberate.automation.testcases;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.core.ExcelDataDriver;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestResult;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.ComverseTab;
import com.liberate.automation.pom.DashBoard;
import com.liberate.automation.pom.ServiceOperations;

public class ComverseTC {
	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;
	static Map<String, String> data = new HashedMap<>();
	
	static String comverseServiceNumber = "9371147";
	
	@BeforeClass
	public static void loadData() {
		data = ExcelDataDriver.loadData();
		//comverseServiceNumber = data.get("comverseServiceNumber");
	}

	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result);
	}
	
	@Test
	public static void getComverseServiceDetails()
	{
		CRCustomerSearch search = new CRCustomerSearch(action);
		DashBoard dashboard = new DashBoard(action);
		ServiceOperations service = new ServiceOperations(action);
		ComverseTab comverse = new ComverseTab(action);
		
		search.navigate();
		search.searchByServiceNumber(comverseServiceNumber);
		dashboard.verifyDashBoard("");
		service.navigate();
		service.gotoComverseTab();
		comverse.verifyComverseEnquiry();
	}
}
