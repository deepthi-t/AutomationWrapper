package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.core.ReportGenerator;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestData;
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
	
	static String TestCase;
	static String TestStatus;
	
	static String accountNumber = "";
	static String salesDepartment = "";
	static String site = "";
	static String transferToAccount = "";
	static String transferFromAccount = "";
	static String suspendedService = "";
	static String serviceASNCease = "";
	static String serviceCease = "";

	@BeforeClass
	public static void loadData() {
		accountNumber = TestData.accountNumber;
		salesDepartment = TestData.salesDepartment;
		site = TestData.site;
		transferToAccount = TestData.transferToAccount;
		transferFromAccount = TestData.transferFromAccount;
		suspendedService = TestData.suspendedService;
		serviceASNCease = TestData.serviceASNCease;
		serviceCease = TestData.serviceCease;
	}

	@Test
	public static void generateInterimBill() {
		TestCase = "CustomerCareTC_generateInterimBill";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		InterimBillGeneration bill = new InterimBillGeneration(action);

		bill.navigate();
		action.getScreenShot(TestCase);
		bill.searchWithCustomerAccount(accountNumber);
		action.getScreenShot(TestCase);
		bill.createInterimBill();
		action.getScreenShot(TestCase);

		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void transferService() {
		TestCase = "CustomerCareTC_transferService";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByAccountNumber(transferFromAccount);
		action.getScreenShot(TestCase);

		service.navigate();
		action.getScreenShot(TestCase);
		service.verifyServicesScreen();
		action.getScreenShot(TestCase);
		service.transferService(transferToAccount);
		action.getScreenShot(TestCase);

		service.verifyTransferService(transferToAccount);
		action.getScreenShot(TestCase);

		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(priority = 1)
	public static void suspendService() {
		TestCase = "CustomerCareTC_suspendService";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		String ServiceOrderNumber = "";

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByServiceNumber(suspendedService);
		action.getScreenShot(TestCase);

		service.navigate();
		action.getScreenShot(TestCase);
		service.suspendService();
		action.getScreenShot(TestCase);
		service.verifyServicesScreen();
		action.getScreenShot(TestCase);

		cso.navigate();
		action.getScreenShot(TestCase);
		cso.filterByServiceOrder(service.RaisedServiceOrder);
		action.getScreenShot(TestCase);
		assertEquals(cso.getSOCommand(), "TOS");
		action.getScreenShot(TestCase);

		ServiceOrderNumber = cso.getSONumber();

		ManageServiceOrderTC.signOffCompletely(ServiceOrderNumber);
		action.getScreenShot(TestCase);

		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(priority = 2)
	public static void restoreService() {
		TestCase = "CustomerCareTC_restoreService";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		String ServiceOrderNumber = "";

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		CustomerServiceOrder serviceOrder = new CustomerServiceOrder(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByServiceNumber(suspendedService);
		action.getScreenShot(TestCase);

		service.navigate();
		action.getScreenShot(TestCase);
		service.restoreService();
		action.getScreenShot(TestCase);
		service.verifyServicesScreen();
		action.getScreenShot(TestCase);

		serviceOrder.navigate();
		action.getScreenShot(TestCase);
		serviceOrder.filterByServiceOrder(service.RaisedServiceOrder);
		action.getScreenShot(TestCase);
		assertEquals(serviceOrder.getSOCommand(), "ROS");
		action.getScreenShot(TestCase);

		ServiceOrderNumber = serviceOrder.getSONumber();

		ManageServiceOrderTC.signOffCompletely(ServiceOrderNumber);
		action.getScreenShot(TestCase);

		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(priority = 3)
	public static void alterServiceNumberPCL() {
		TestCase = "CustomerCareTC_alterServiceNumberPCL";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		AlterServiceNumber asn = new AlterServiceNumber(action);
		SalesSignOff sales = new SalesSignOff(action);
		CustomerServiceOrder serviceOrder = new CustomerServiceOrder(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByServiceNumber(serviceASNCease);
		action.getScreenShot(TestCase);

		service.navigate();
		action.getScreenShot(TestCase);
		service.clickOnAlterServiceNumber();
		action.getScreenShot(TestCase);

		asn.selectDepartmentSite(salesDepartment, site);
		action.getScreenShot(TestCase);
		asn.alterServiceNumber(false);
		action.getScreenShot(TestCase);

		sales.verifySalesSignOff();
		action.getScreenShot(TestCase);
		serviceASNCease = sales.ServiceNumber;
		sales.signOff();
		action.getScreenShot(TestCase);

		assertEquals(serviceOrder.getSOCommand(), "ASN");
		action.getScreenShot(TestCase);

		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(priority = 4)
	public static void alterServiceNumberPCLServiceCharge() {
		TestCase = "CustomerCareTC_alterServiceNumberPCLServiceCharge";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		AlterServiceNumber asn = new AlterServiceNumber(action);
		CustomerServiceOrder serviceOrder = new CustomerServiceOrder(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByServiceNumber(serviceASNCease);
		action.getScreenShot(TestCase);

		service.navigate();
		action.getScreenShot(TestCase);
		service.clickOnAlterServiceNumber();
		action.getScreenShot(TestCase);

		asn.selectDepartmentSite(salesDepartment, site);
		action.getScreenShot(TestCase);
		asn.alterServiceNumber(false);
		action.getScreenShot(TestCase);

		service.raiseServiceCharge();
		action.getScreenShot(TestCase);

		serviceOrder.navigate();
		action.getScreenShot(TestCase);
		assertEquals(serviceOrder.getSOCommand(), "ASN");
		action.getScreenShot(TestCase);
		serviceASNCease = serviceOrder.getServiceONumber();

		ManageServiceOrderTC.signOffCompletely(serviceOrder.getSONumber());

		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	// @Test(priority = 5)
	public static void ceaseServiceNumberPCL() {
		TestCase = "CustomerCareTC_ceaseServiceNumberPCL";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		CeaseService cease = new CeaseService(action);
		SalesSignOff sales = new SalesSignOff(action);
		CustomerServiceOrder serviceOrder = new CustomerServiceOrder(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByServiceNumber(serviceASNCease);
		action.getScreenShot(TestCase);

		service.navigate();
		action.getScreenShot(TestCase);
		service.clickOnCeaseService();
		action.getScreenShot(TestCase);

		cease.selectDepartmentSite(salesDepartment, site);
		action.getScreenShot(TestCase);
		cease.ceaseService();
		action.getScreenShot(TestCase);

		sales.verifySalesSignOff();
		action.getScreenShot(TestCase);
		sales.signOff();
		action.getScreenShot(TestCase);

		assertEquals(serviceOrder.getSOCommand().substring(0, 3).trim(), "CCL");
		action.getScreenShot(TestCase);

		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	// @Test(priority = 0)
	public static void ceaseServiceNumberPCLServiceCharge() {
		TestCase = "CustomerCareTC_ceaseServiceNumberPCLServiceCharge";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		SalesSignOff sales = new SalesSignOff(action);
		CustomerServiceOrder serviceOrder = new CustomerServiceOrder(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByServiceNumber(serviceCease);
		action.getScreenShot(TestCase);

		service.navigate();
		action.getScreenShot(TestCase);
		service.clickOnCeaseService();
		action.getScreenShot(TestCase);

		sales.verifySalesSignOff();
		action.getScreenShot(TestCase);
		sales.addServiceCharge();
		action.getScreenShot(TestCase);
		sales.signOff();
		action.getScreenShot(TestCase);

		assertEquals(serviceOrder.getSOCommand().substring(0, 3).trim(), "CCL");
		action.getScreenShot(TestCase);

		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(priority = 8)
	public static void verifyServiceProducts() {
		TestCase = "CustomerCareTC_verifyServiceProducts";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		ServiceProductsTab products = new ServiceProductsTab(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByAccountNumber(transferToAccount);
		action.getScreenShot(TestCase);

		service.navigate();
		action.getScreenShot(TestCase);
		service.navigateToProductsScreen();
		action.getScreenShot(TestCase);

		products.verifyProductsScreen();
		action.getScreenShot(TestCase);

		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(priority = 7)
	public static void provideProduct() {
		TestCase = "CustomerCareTC_provideProduct";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		String ServiceNumber = "2050587";
		String Department = "BGSAL";
		String Site = "BUSG";
		String Command = "PCA";

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		ServiceProductsTab products = new ServiceProductsTab(action);
		SalesSignOff sales = new SalesSignOff(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByServiceNumber(ServiceNumber);
		action.getScreenShot(TestCase);

		service.navigate();
		action.getScreenShot(TestCase);
		service.navigateToProductsScreen();
		action.getScreenShot(TestCase);

		products.verifyProductsScreen();
		action.getScreenShot(TestCase);
		products.provideProduct(Department, Site, Command);
		action.getScreenShot(TestCase);

		sales.verifySalesSignOff();
		action.getScreenShot(TestCase);
		sales.signOff();
		action.getScreenShot(TestCase);

		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(priority = 9)
	public static void ceaseProduct() {
		TestCase = "CustomerCareTC_ceaseProduct";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		String ServiceNumber = "2050587";
		String Department = salesDepartment;
		String Site = site;

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		ServiceProductsTab products = new ServiceProductsTab(action);
		SalesSignOff sales = new SalesSignOff(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByServiceNumber(ServiceNumber);
		action.getScreenShot(TestCase);

		service.navigate();
		action.getScreenShot(TestCase);
		service.navigateToProductsScreen();
		action.getScreenShot(TestCase);
		
		products.verifyProductsScreen();
		action.getScreenShot(TestCase);
		products.ceaseProduct(Department, Site);
		action.getScreenShot(TestCase);

		sales.verifySalesSignOff();
		action.getScreenShot(TestCase);
		sales.signOff();
		action.getScreenShot(TestCase);

		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	public static void cloneCustomer() {
		TestCase = "CustomerCareTC_cloneCustomer";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CRCustomerSearch search = new CRCustomerSearch(action);
		DashBoard dashboard = new DashBoard(action);
		CRAccountDetails accountDetails = new CRAccountDetails(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByAccountNumber(accountNumber);
		action.getScreenShot(TestCase);

		dashboard.verifyDashBoard(accountNumber);
		action.getScreenShot(TestCase);

		accountDetails.navigate();
		action.getScreenShot(TestCase);
		accountDetails.cloneCustomer();
		action.getScreenShot(TestCase);
		accountDetails.verifySuccessMessage();
		action.getScreenShot(TestCase);

		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void cloneAccount() {
		TestCase = "CustomerCareTC_cloneAccount";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CRCustomerSearch search = new CRCustomerSearch(action);
		DashBoard dashboard = new DashBoard(action);
		CRAccountDetails accountDetails = new CRAccountDetails(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByAccountNumber(accountNumber);
		action.getScreenShot(TestCase);

		dashboard.verifyDashBoard(accountNumber);
		action.getScreenShot(TestCase);

		accountDetails.navigate();
		action.getScreenShot(TestCase);
		accountDetails.cloneAccount();
		action.getScreenShot(TestCase);
		accountDetails.verifySuccessMessage();
		action.getScreenShot(TestCase);

		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void createSubAccount() {
		TestCase = "CustomerCareTC_createSubAccount";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		CRCustomerSearch search = new CRCustomerSearch(action);
		DashBoard dashboard = new DashBoard(action);
		CRAccountDetails accountDetails = new CRAccountDetails(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByAccountNumber(accountNumber);
		action.getScreenShot(TestCase);

		dashboard.verifyDashBoard(accountNumber);
		action.getScreenShot(TestCase);

		accountDetails.navigate();
		action.getScreenShot(TestCase);
		accountDetails.createSubAccount();
		action.getScreenShot(TestCase);
		accountDetails.verifySuccessMessage();
		action.getScreenShot(TestCase);

		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}
	
	@AfterMethod
	public static void logTestResult(ITestResult result) {
		ReportGenerator.generateReport(TestCase);
		TestStatus = result.getStatus()==ITestResult.SUCCESS?"PASSED":"FAILED";
		
		action.log("Test Status : " + TestStatus);
		action.log("*****COMPLETED '" + TestCase + "' EXECUTION***** \n");
	}
}
