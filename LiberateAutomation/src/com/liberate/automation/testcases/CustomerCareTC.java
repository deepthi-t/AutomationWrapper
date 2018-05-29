package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.core.ExcelDataDriver;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestData;
import com.liberate.automation.core.TestResult;
import com.liberate.automation.pom.AlterServiceNumber;
import com.liberate.automation.pom.CRAccountDetails;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.CeaseService;
import com.liberate.automation.pom.CustomerServiceOrder;
import com.liberate.automation.pom.DashBoard;
import com.liberate.automation.pom.InterimBillGeneration;
import com.liberate.automation.pom.SalesSignOff;
import com.liberate.automation.pom.ServiceOperations;
import com.liberate.automation.pom.ServiceProductsTab;

/***
 * Class with Customer Care Test Case
 * 
 * @author Nikhil
 *
 */
public class CustomerCareTC {
	static TestActions action = CommonLogin.action;

	static String testCase;
	static String testStatus;

	static Map<String, String> dataMap = new HashedMap<>();

	static String accountNumber;
	static String salesDepartment;
	static String site;
	static String transferToAccount;
	static String transferFromAccount;
	static String suspendedService;
	static String serviceASNCease;
	static String serviceCease;
	static String ceaseServiceWithCharge;
	static String verifyProductsAccountNumber;
	static String CloneCustaccountNumber;
	static String serviceASNCeaseServCharge;
	
	/**
	 * Private constructor to disable creation of object
	 */
	private CustomerCareTC() {
	}

	
	@BeforeClass
	public static void loadData() {
		dataMap = ExcelDataDriver.loadData();
		accountNumber = dataMap.get("accountNumber");
		salesDepartment = dataMap.get("salesDepartment");
		site = dataMap.get("Site");
		transferToAccount = dataMap.get("transferToAccount");
		transferFromAccount = dataMap.get("transferFromAccount");
		suspendedService = dataMap.get("suspendedService");
		serviceASNCease = dataMap.get("serviceASNCease");
		serviceCease = dataMap.get("serviceCease");
		ceaseServiceWithCharge = dataMap.get("ceaseServiceWithCharge");
		verifyProductsAccountNumber = dataMap.get("verifyProductsAccountNumber");
		CloneCustaccountNumber = dataMap.get("CloneCustaccountNumber");
		serviceASNCeaseServCharge = dataMap.get("serviceASNCeaseServCharge");
		
		
		
	}

	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result);
	}

	@Test(priority = 0)
	public static void generateInterimBill() {
		testCase = "CustomerCareTC_generateInterimBill";

		InterimBillGeneration bill = new InterimBillGeneration(action);

		bill.navigate();
		action.getScreenShot(testCase);
		bill.searchWithCustomerAccount(accountNumber);
		action.getScreenShot(testCase);
		bill.createInterimBill();
		action.getScreenShot(testCase);
	}

	@Test(priority = 1)
	public static void transferService() {
		testCase = "CustomerCareTC_transferService";

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByAccountNumber(transferFromAccount);
		action.getScreenShot(testCase);

		service.navigate();
		action.getScreenShot(testCase);
		service.verifyServicesScreen();
		action.getScreenShot(testCase);
		service.transferService(transferToAccount);
		action.getScreenShot(testCase);

		service.verifyTransferService(transferToAccount);
		action.getScreenShot(testCase);
	}

	@Test(priority = 2)
	public static void suspendService() {
		testCase = "CustomerCareTC_suspendService";

		String serviceOrderNumber = "";

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByServiceNumber(suspendedService);
		action.getScreenShot(testCase);

		service.navigate();
		action.getScreenShot(testCase);
		service.suspendService();
		action.getScreenShot(testCase);
		service.verifyServicesScreen();
		action.getScreenShot(testCase);

		cso.navigate();
		action.getScreenShot(testCase);
		cso.filterByServiceOrder(service.RaisedServiceOrder);
		action.getScreenShot(testCase);
		assertEquals(cso.getSOCommand(), "TOS");
		action.getScreenShot(testCase);

		serviceOrderNumber = cso.getSONumber();

		ManageServiceOrderTC.signOffCompletely(serviceOrderNumber);
		action.getScreenShot(testCase);

	}

	@Test(priority = 3)
	public static void restoreService() {
		testCase = "CustomerCareTC_restoreService";

		String ServiceOrderNumber = "";

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		CustomerServiceOrder serviceOrder = new CustomerServiceOrder(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByServiceNumber(suspendedService);
		action.getScreenShot(testCase);

		service.navigate();
		action.getScreenShot(testCase);
		service.restoreService();
		action.getScreenShot(testCase);
		service.verifyServicesScreen();
		action.getScreenShot(testCase);

		serviceOrder.navigate();
		action.getScreenShot(testCase);
		serviceOrder.filterByServiceOrder(service.RaisedServiceOrder);
		action.getScreenShot(testCase);
		assertEquals(serviceOrder.getSOCommand(), "ROS");
		action.getScreenShot(testCase);

		ServiceOrderNumber = serviceOrder.getSONumber();

		ManageServiceOrderTC.signOffCompletely(ServiceOrderNumber);
		action.getScreenShot(testCase);
	}

	@Test(priority = 4)
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

	@Test(priority = 5)
	public static void alterServiceNumberPCLServiceCharge() {
		testCase = "CustomerCareTC_alterServiceNumberPCLServiceCharge";

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		AlterServiceNumber asn = new AlterServiceNumber(action);
		CustomerServiceOrder serviceOrder = new CustomerServiceOrder(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByServiceNumber(serviceASNCeaseServCharge);
		action.getScreenShot(testCase);

		service.navigate();
		action.getScreenShot(testCase);
		service.clickOnAlterServiceNumber();
		action.getScreenShot(testCase);

		asn.selectDepartmentSite(salesDepartment, site);
		action.getScreenShot(testCase);
		asn.alterServiceNumber(false);
		action.getScreenShot(testCase);

		service.raiseServiceCharge();
		action.getScreenShot(testCase);

		serviceOrder.navigate();
		action.getScreenShot(testCase);
		assertEquals(serviceOrder.getSOCommand(), "ASN");
		action.getScreenShot(testCase);
		serviceASNCease = serviceOrder.getServiceONumber();

		ManageServiceOrderTC.signOffCompletely(serviceOrder.getSONumber());
	}

	@Test(priority = 6)
	public static void ceaseServiceNumberPCL() {
		testCase = "CustomerCareTC_ceaseServiceNumberPCL";

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		CeaseService cease = new CeaseService(action);
		SalesSignOff sales = new SalesSignOff(action);
		CustomerServiceOrder serviceOrder = new CustomerServiceOrder(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByServiceNumber(serviceCease);
		action.getScreenShot(testCase);

		service.navigate();
		action.getScreenShot(testCase);
		service.clickOnCeaseService();
		action.getScreenShot(testCase);

		cease.selectDepartmentSite(salesDepartment, site);
		action.getScreenShot(testCase);
		cease.ceaseService();
		action.getScreenShot(testCase);

		sales.verifySalesSignOff();
		action.getScreenShot(testCase);
		sales.signOff();
		action.getScreenShot(testCase);

		assertEquals(serviceOrder.getSOCommand().substring(0, 3).trim(), "CCL");
		action.getScreenShot(testCase);
	}

	@Test(priority = 7)
	public static void ceaseServiceNumberPCLServiceCharge() {
		testCase = "CustomerCareTC_ceaseServiceNumberPCLServiceCharge";

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		SalesSignOff sales = new SalesSignOff(action);
		CustomerServiceOrder serviceOrder = new CustomerServiceOrder(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByServiceNumber(ceaseServiceWithCharge);
		action.getScreenShot(testCase);

		service.navigate();
		action.getScreenShot(testCase);
		service.clickOnCeaseService();
		action.getScreenShot(testCase);

		sales.verifySalesSignOff();
		action.getScreenShot(testCase);
		sales.addServiceCharge();
		action.getScreenShot(testCase);
		sales.signOff();
		action.getScreenShot(testCase);

		assertEquals(serviceOrder.getSOCommand().substring(0, 3).trim(), "CCL");
		action.getScreenShot(testCase);
	}

	@Test(priority = 8)
	public static void verifyServiceProducts() {
		testCase = "CustomerCareTC_verifyServiceProducts";

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		ServiceProductsTab products = new ServiceProductsTab(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByAccountNumber(verifyProductsAccountNumber);
		action.getScreenShot(testCase);

		service.navigate();
		action.getScreenShot(testCase);
		service.navigateToProductsScreen();
		action.getScreenShot(testCase);

		products.verifyProductsScreen();
		action.getScreenShot(testCase);
	}

	@Test(priority = 9)
	public static void provideProduct() {
		testCase = "CustomerCareTC_provideProduct";

		String serviceNumber = "2050587";
		String department = "BGSAL";
		String site = "BUSG";
		String command = "PCA";

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		ServiceProductsTab products = new ServiceProductsTab(action);
		SalesSignOff sales = new SalesSignOff(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByServiceNumber(serviceNumber);
		action.getScreenShot(testCase);

		service.navigate();
		action.getScreenShot(testCase);
		service.navigateToProductsScreen();
		action.getScreenShot(testCase);

		products.verifyProductsScreen();
		action.getScreenShot(testCase);
		products.provideProduct(department, site, command);
		action.getScreenShot(testCase);

		sales.verifySalesSignOff();
		action.getScreenShot(testCase);
		sales.signOff();
		action.getScreenShot(testCase);
	}

	@Test(priority = 10)
	public static void ceaseProduct() {
		testCase = "CustomerCareTC_ceaseProduct";

		String serviceNumber = "2050587";

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		ServiceProductsTab products = new ServiceProductsTab(action);
		SalesSignOff sales = new SalesSignOff(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByServiceNumber(serviceNumber);
		action.getScreenShot(testCase);

		service.navigate();
		action.getScreenShot(testCase);
		service.navigateToProductsScreen();
		action.getScreenShot(testCase);

		products.verifyProductsScreen();
		action.getScreenShot(testCase);
		products.ceaseProduct(salesDepartment, site);
		action.getScreenShot(testCase);

		sales.verifySalesSignOff();
		action.getScreenShot(testCase);
		sales.signOff();
		action.getScreenShot(testCase);
	}

	@Test(priority = 11)
	public static void cloneCustomer() {
		testCase = "CustomerCareTC_cloneCustomer";

		CRCustomerSearch search = new CRCustomerSearch(action);
		DashBoard dashboard = new DashBoard(action);
		CRAccountDetails accountDetails = new CRAccountDetails(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByAccountNumber(CloneCustaccountNumber);
		action.getScreenShot(testCase);

		dashboard.verifyDashBoard(CloneCustaccountNumber);
		action.getScreenShot(testCase);

		accountDetails.navigate();
		action.getScreenShot(testCase);
		accountDetails.cloneCustomer();
		action.getScreenShot(testCase);
		accountDetails.verifySuccessMessage();
		action.getScreenShot(testCase);
	}

	@Test(priority = 12)
	public static void cloneAccount() {
		testCase = "CustomerCareTC_cloneAccount";

		CRCustomerSearch search = new CRCustomerSearch(action);
		DashBoard dashboard = new DashBoard(action);
		CRAccountDetails accountDetails = new CRAccountDetails(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByAccountNumber(CloneCustaccountNumber);
		action.getScreenShot(testCase);

		dashboard.verifyDashBoard(CloneCustaccountNumber);
		action.getScreenShot(testCase);

		accountDetails.navigate();
		action.getScreenShot(testCase);
		accountDetails.cloneAccount();
		action.getScreenShot(testCase);
		accountDetails.verifySuccessMessage();
		action.getScreenShot(testCase);
	}

	@Test(priority = 13)
	public static void createSubAccount() {
		testCase = "CustomerCareTC_createSubAccount";

		CRCustomerSearch search = new CRCustomerSearch(action);
		DashBoard dashboard = new DashBoard(action);
		CRAccountDetails accountDetails = new CRAccountDetails(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByAccountNumber(CloneCustaccountNumber);
		action.getScreenShot(testCase);

		dashboard.verifyDashBoard(CloneCustaccountNumber);
		action.getScreenShot(testCase);

		accountDetails.navigate();
		action.getScreenShot(testCase);
		accountDetails.createSubAccount();
		action.getScreenShot(testCase);
		accountDetails.verifySuccessMessage();
		action.getScreenShot(testCase);
	}
}
