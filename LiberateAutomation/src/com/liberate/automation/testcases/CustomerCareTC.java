package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.CRAccountDetails;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.CRDashBoard;
import com.liberate.automation.pom.CRServiceOperations;
import com.liberate.automation.pom.CRServiceOrder;
import com.liberate.automation.pom.InterimBillGeneration;
import com.liberate.automation.pom.SalesSignOff;

public class CustomerCareTC {
	static TestActions action = CommonLogin.action;

	@Test
	public static void generateInterimBill() {
		String TestCase = "CustomerCareTC_generateInterimBill";

		InterimBillGeneration bill = new InterimBillGeneration(action);

		bill.navigate();
		action.getScreenShot(TestCase);
		bill.searchWithCustomerAccount("260002260000");
		action.getScreenShot(TestCase);
		bill.createInterimBill();
		action.getScreenShot(TestCase);
	}

	@Test
	public static void transferService() {
		String TestCase = "CustomerCareTC_transferService";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByAccountNumber("260002290000");
		action.getScreenShot(TestCase);

		service.navigate();
		action.getScreenShot(TestCase);
		service.verifyServicesScreen();
		action.getScreenShot(TestCase);
		service.transferService("260002270000");
		action.getScreenShot(TestCase);

		service.verifyTransferService("260002270000");
		action.getScreenShot(TestCase);
	}

	@Test
	public static void suspendService() {
		String TestCase = "CustomerCareTC_suspendService";

		String ServiceOrderNumber = "";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);
		CRServiceOrder cso = new CRServiceOrder(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByAccountNumber("260002250000");
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

		ManageServiceOrder.signOffCompletely(ServiceOrderNumber);
		action.getScreenShot(TestCase);
	}

	@Test
	public static void restoreService() {
		String TestCase = "CustomerCareTC_restoreService";

		String ServiceOrderNumber = "";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);
		CRServiceOrder serviceOrder = new CRServiceOrder(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByAccountNumber("260002250000");
		action.getScreenShot(TestCase);

		service.navigate();
		action.getScreenShot(TestCase);
		service.searchByService("153725");
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

		ManageServiceOrder.signOffCompletely(ServiceOrderNumber);
		action.getScreenShot(TestCase);
	}

	@Test
	public static void alterServiceNumberPCL() {
		String TestCase = "CustomerCareTC_alterServiceNumberPCL";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);
		SalesSignOff sales = new SalesSignOff(action);
		CRServiceOrder serviceOrder = new CRServiceOrder(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByAccountNumber("270002280000");
		action.getScreenShot(TestCase);

		service.navigate();
		action.getScreenShot(TestCase);
		service.alterServiceNumber(false);
		action.getScreenShot(TestCase);

		sales.verifySalesSignOff();
		action.getScreenShot(TestCase);
		sales.signOff();
		action.getScreenShot(TestCase);

		assertEquals(serviceOrder.getSOCommand(), "ASN");
		action.getScreenShot(TestCase);

	}

	@Test
	public static void alterServiceNumberPCLServiceCharge() {
		String TestCase = "CustomerCareTC_alterServiceNumberPCLServiceCharge";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);
		CRServiceOrder serviceOrder = new CRServiceOrder(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByAccountNumber("270002280000");
		action.getScreenShot(TestCase);

		service.navigate();
		action.getScreenShot(TestCase);
		service.alterServiceNumber(true);
		action.getScreenShot(TestCase);
		service.raiseServiceCharge();
		action.getScreenShot(TestCase);

		serviceOrder.navigate();
		action.getScreenShot(TestCase);
		assertEquals(serviceOrder.getSOCommand(), "ASN");
		action.getScreenShot(TestCase);

	}

	@Test
	public static void ceaseServiceNumberPCL() {
		String TestCase = "CustomerCareTC_ceaseServiceNumberPCL";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);
		SalesSignOff sales = new SalesSignOff(action);
		CRServiceOrder serviceOrder = new CRServiceOrder(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByAccountNumber("280000180000");
		action.getScreenShot(TestCase);

		service.navigate();
		action.getScreenShot(TestCase);
		service.ceaseService();
		action.getScreenShot(TestCase);

		sales.verifySalesSignOff();
		action.getScreenShot(TestCase);
		sales.signOff();
		action.getScreenShot(TestCase);

		assertEquals(serviceOrder.getSOCommand().substring(0, 3).trim(), "CCL");
		action.getScreenShot(TestCase);
	}

	@Test
	public static void ceaseServiceNumberPCLServiceCharge() {
		String TestCase = "CustomerCareTC_ceaseServiceNumberPCLServiceCharge";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);
		SalesSignOff sales = new SalesSignOff(action);
		CRServiceOrder serviceOrder = new CRServiceOrder(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByAccountNumber("280000080000");
		action.getScreenShot(TestCase);

		service.navigate();
		action.getScreenShot(TestCase);
		service.ceaseService();
		action.getScreenShot(TestCase);

		sales.verifySalesSignOff();
		action.getScreenShot(TestCase);
		sales.addServiceCharge();
		action.getScreenShot(TestCase);
		sales.signOff();
		action.getScreenShot(TestCase);

		assertEquals(serviceOrder.getSOCommand().substring(0, 3).trim(), "CCL");
		action.getScreenShot(TestCase);
	}

	public static void verifyServiceProducts() {
		String TestCase = "CustomerCareTC_verifyServiceProducts";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByAccountNumber("280000080000");
		action.getScreenShot(TestCase);

		service.navigate();
		action.getScreenShot(TestCase);
		service.verifyProductsScreen();
		action.getScreenShot(TestCase);
	}

	@Test
	public static void provideProduct() {
		String TestCase = "CustomerCareTC_provideProduct";

		String ServiceNumber = "2581979";
		String Department = "BGSAL";
		String Site = "BUSG";
		String Command = "PCA";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);
		SalesSignOff sales = new SalesSignOff(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByServiceNumber(ServiceNumber);
		action.getScreenShot(TestCase);

		service.navigate();
		action.getScreenShot(TestCase);
		service.verifyProductsScreen();
		action.getScreenShot(TestCase);
		service.provideProduct(Department, Site, Command);
		action.getScreenShot(TestCase);

		sales.verifySalesSignOff();
		action.getScreenShot(TestCase);
		sales.signOff();
		action.getScreenShot(TestCase);
	}

	@Test
	public static void ceaseProduct() {
		String TestCase = "CustomerCareTC_ceaseProduct";

		String ServiceNumber = "2581979";
		String Department = "BGSAL";
		String Site = "BUSG";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);
		SalesSignOff sales = new SalesSignOff(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByServiceNumber(ServiceNumber);
		action.getScreenShot(TestCase);

		service.navigate();
		action.getScreenShot(TestCase);
		service.verifyProductsScreen();
		action.getScreenShot(TestCase);
		service.ceaseProduct(Department, Site);
		action.getScreenShot(TestCase);

		sales.verifySalesSignOff();
		action.getScreenShot(TestCase);
		sales.signOff();
		action.getScreenShot(TestCase);
	}

	public static void cloneCustomer() {
		String TestCase = "CustomerCareTC_cloneCustomer";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRDashBoard dashboard = new CRDashBoard(action);
		CRAccountDetails accountDetails = new CRAccountDetails(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByAccountNumber("260002270000");
		action.getScreenShot(TestCase);

		dashboard.verifyDashBoard("260002270000");
		action.getScreenShot(TestCase);

		accountDetails.navigate();
		action.getScreenShot(TestCase);
		accountDetails.cloneCustomer();
		action.getScreenShot(TestCase);
		accountDetails.verifySuccessMessage();
		action.getScreenShot(TestCase);
	}

	@Test
	public static void cloneAccount() {
		String TestCase = "CustomerCareTC_cloneAccount";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRDashBoard dashboard = new CRDashBoard(action);
		CRAccountDetails accountDetails = new CRAccountDetails(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByAccountNumber("260002270000");
		action.getScreenShot(TestCase);

		dashboard.verifyDashBoard("260002270000");
		action.getScreenShot(TestCase);

		accountDetails.navigate();
		action.getScreenShot(TestCase);
		accountDetails.cloneAccount();
		action.getScreenShot(TestCase);
		accountDetails.verifySuccessMessage();
		action.getScreenShot(TestCase);
	}

	@Test
	public static void createSubAccount() {
		String TestCase = "CustomerCareTC_createSubAccount";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRDashBoard dashboard = new CRDashBoard(action);
		CRAccountDetails accountDetails = new CRAccountDetails(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByAccountNumber("260002270000");
		action.getScreenShot(TestCase);

		dashboard.verifyDashBoard("260002270000");
		action.getScreenShot(TestCase);

		accountDetails.navigate();
		action.getScreenShot(TestCase);
		accountDetails.createSubAccount();
		action.getScreenShot(TestCase);
		accountDetails.verifySuccessMessage();
		action.getScreenShot(TestCase);
	}
}
