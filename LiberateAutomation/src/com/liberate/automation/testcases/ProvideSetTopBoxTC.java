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
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.CustomerServiceOrder;
import com.liberate.automation.pom.ProvideSetTopBox;
import com.liberate.automation.pom.SalesSignOff;
import com.liberate.automation.pom.ServiceOperations;

public class ProvideSetTopBoxTC 
{
	static TestActions action = CommonLogin.action;
	
	static String TestCase;
	static String TestStatus;
	static String setTopBoxService;
	static String setTopBoxProduct;
	static String SalesDepartment;
	static String Site;

	static Map<String, String> data = new HashedMap<>();
	
	
	@BeforeClass
	public void loadData() 
	{
		data = ExcelDataDriver.loadData();
		
		setTopBoxService = data.get("setTopBoxService");
		setTopBoxProduct = data.get("setTopBoxProduct");
		SalesDepartment = data.get("SalesDepartment");
		Site = data.get("Site");
	}

	@AfterMethod
	public static void logTestResult(ITestResult result) 
	{
		ReportGenerator.generateReport(TestCase);
		TestStatus = result.getStatus() == ITestResult.SUCCESS ? "PASSED" : "FAILED";

		action.log("Test Status : " + TestStatus);
		action.log("*****COMPLETED '" + TestCase + "' EXECUTION***** \n");
	}
	
	@Test
	public static void provideSetTopBox() 
	{
		TestCase = "provideSetTopBox";
		
		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		ProvideSetTopBox setTopBox = new ProvideSetTopBox(action);
		SalesSignOff sales = new SalesSignOff(action);
		CustomerServiceOrder order = new CustomerServiceOrder(action);
		
		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByServiceNumber(setTopBoxService);
		action.getScreenShot(TestCase);
		
		service.navigate();
		action.getScreenShot(TestCase);
		service.verifyServicesScreen();		
		action.getScreenShot(TestCase);
		service.clickOnProvideSetTopBox();
		action.getScreenShot(TestCase);
		
		setTopBox.selectDeptSite(SalesDepartment, Site);
		action.getScreenShot(TestCase);
		setTopBox.clickonProceed();
		action.getScreenShot(TestCase);
		setTopBox.allocateMACAddress(setTopBoxProduct);
		action.getScreenShot(TestCase);
		setTopBox.clickonAccept();
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
}
