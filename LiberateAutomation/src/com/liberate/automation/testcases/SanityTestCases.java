package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.common.CommonData;
import com.liberate.automation.core.ExcelDataDriver;
import com.liberate.automation.core.RandomData;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestResult;
import com.liberate.automation.pom.AlterServiceNumber;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.CustomerServiceOrder;
import com.liberate.automation.pom.ExistingCustomer;
import com.liberate.automation.pom.MaintainDepositReason;
import com.liberate.automation.pom.NewCustomer;
import com.liberate.automation.pom.SalesSignOff;
import com.liberate.automation.pom.ServiceOperations;

public class SanityTestCases 
{
	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;

	
	static Map<String, String> dataMap = new HashedMap<>();
	static String serviceASNCease;
	
	
	@BeforeClass
	public static void loadData() {
		dataMap = ExcelDataDriver.loadData();
		
	/**
	 * Private constructor to disable creation of object
	 */
	private SanityTestCases() {
	}

	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result);
	}

	@Test
	public static void newCustomerPCLPostpaid() {
		testCase = "Sanity_NewCustomerPCLPostpaid";

		NewCustomer cp = new NewCustomer(action);
		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		cp.navigate();
		action.getScreenShot(testCase);
		cp.fillApplicationDetails(CommonData.ApplicationForm.FixedResidential, CommonData.CustomerType.Residential,	"PCL", "LIME_POST");
		action.getScreenShot(testCase);
		cp.fillResidentialCustomerDetails();
		action.getScreenShot(testCase);
		cp.fillStandardAddress();
		action.getScreenShot(testCase);
		cp.fillCustomerClassification();
		action.getScreenShot(testCase);
		cp.fillBillingDetails();
		action.getScreenShot(testCase);
		cp.fillCustomerID();
		action.getScreenShot(testCase);
		cp.fillContactDetails();
		action.getScreenShot(testCase);
		assertTrue(cp.verifyCreatedAccount());

		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot(testCase);
		ce.selectServicePackage("PCL", "LIME_POST");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("MSCA", "SMPO");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
		action.getScreenShot(testCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(testCase);
		sso.signOff();
		action.getScreenShot(testCase);

		cso.getSONumber();
		action.getScreenShot(testCase);
		cso.getSOCommand();
		action.getScreenShot(testCase);
	}
	
	public static void newCustomerPELandPDL() {
		testCase = "Sanity_PELandPDL";

		NewCustomer cp = new NewCustomer(action);
		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		cp.navigate();
		action.getScreenShot(testCase);
		cp.fillApplicationDetails(CommonData.ApplicationForm.FixedResidential, CommonData.CustomerType.Residential,	"PEL", "ETFT");
		action.getScreenShot(testCase);
		cp.fillResidentialCustomerDetails();
		action.getScreenShot(testCase);
		cp.fillStandardAddress();
		action.getScreenShot(testCase);
		cp.fillCustomerClassification();
		action.getScreenShot(testCase);
		cp.fillBillingDetails();
		action.getScreenShot(testCase);
		cp.fillCustomerID();
		action.getScreenShot(testCase);
		cp.fillContactDetails();
		action.getScreenShot(testCase);
		assertTrue(cp.verifyCreatedAccount());
		action.getScreenShot(testCase);

		ce.selectDepartmentSite("BGSAL", "BUSG");
		action.getScreenShot(testCase);
		ce.selectServicePackage("PEL", "ETFT");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
		action.getScreenShot(testCase);
		ce.provideADSL();
		action.getScreenShot(testCase);

		// PDL Part
		ce.selectServicePackage("PDL", "ADSL_PACK");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
		action.getScreenShot(testCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(testCase);
		sso.signOff();
		action.getScreenShot(testCase);

		cso.getSONumber();
		action.getScreenShot(testCase);
		cso.getSOCommand();
		action.getScreenShot(testCase);
	}
	
	public static void alterServiceNumberPCL() {
		testCase = "CustomerCareTC_alterServiceNumberPCL";

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		AlterServiceNumber asn = new AlterServiceNumber(action);
		SalesSignOff sales = new SalesSignOff(action);
		CustomerServiceOrder serviceOrder = new CustomerServiceOrder(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByServiceNumber(serviceASNCease);
		action.getScreenShot(testCase);

		service.navigate();
		action.getScreenShot(testCase);
		service.clickOnAlterServiceNumber();
		action.getScreenShot(testCase);

		asn.selectDepartmentSite(salesDepartment, site);
		action.getScreenShot(testCase);
		asn.alterServiceNumber(false);
		action.getScreenShot(testCase);

		sales.verifySalesSignOff();
		action.getScreenShot(testCase);
		serviceASNCease = sales.ServiceNumber;
		sales.signOff();
		action.getScreenShot(testCase);

		assertEquals(serviceOrder.getSOCommand(), "ASN");
		action.getScreenShot(testCase);
	}
	
	@Test
	public static void createNewDepositReason() {
		testCase = "DepositReason_createNewDepositReason";

		RandomData random = new RandomData();
		MaintainDepositReason mdr = new MaintainDepositReason(action);

		action.getScreenShot(testCase);
		assertEquals(mdr.navigate(), true);
		action.getScreenShot(testCase);
		assertEquals(mdr.clickNewButton(), true);
		action.getScreenShot(testCase);
		assertEquals(mdr.provideDepositReasonDetailsNewCreation(random.nextString().substring(4), "TestingAutomation",
				"Y", "4"), true);
		action.getScreenShot(testCase);
		assertEquals(mdr.clickAcceptButton(), true);
		action.getScreenShot(testCase);
		action.waitFor(By.xpath("//span[@class='iceMsgInfo']"), 2, true);
		String x = action.getTextFromPage(By.xpath("//span[@class='iceMsgInfo']"));
		action.getScreenShot(testCase);
		System.out.println(x);
	}

}
