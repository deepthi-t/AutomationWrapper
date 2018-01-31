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
		String AccountNumber = "260002260000";

		InterimBillGeneration bill = new InterimBillGeneration(action);

		bill.navigate();
		action.getScreenShot("generateInterimBill");
		bill.searchWithCustomerAccount(AccountNumber);
		action.getScreenShot("generateInterimBill");
		bill.createInterimBill();
		action.getScreenShot("generateInterimBill");
	}

	@Test
	public static void transferService() {
		String FromAccountNumber = "260002290000";
		String ToAccountNumber = "260002270000";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);

		search.navigate();
		action.getScreenShot("transferService");
		search.searchByAccountNumber(FromAccountNumber);
		action.getScreenShot("transferService");

		service.navigate();
		action.getScreenShot("transferService");
		service.verifyServicesScreen();
		action.getScreenShot("transferService");
		service.transferService("260002270000");
		action.getScreenShot("transferService");

		service.verifyTransferService(ToAccountNumber);
		action.getScreenShot("transferService");
	}

	@Test
	public static void suspendService() {
		String AccountNumber = "260002250000";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);
		CRServiceOrder cso = new CRServiceOrder(action);

		search.navigate();
		action.getScreenShot("suspendService");
		search.searchByAccountNumber(AccountNumber);
		action.getScreenShot("suspendService");

		service.navigate();
		action.getScreenShot("suspendService");
		service.suspendService();
		action.getScreenShot("suspendService");
		service.verifyServicesScreen();
		action.getScreenShot("suspendService");

		cso.navigate();
		action.getScreenShot("suspendService");
		cso.filterByServiceOrder(service.RaisedServiceOrder);
		action.getScreenShot("suspendService");
		assertEquals(cso.getSOCommand(), "TOS");
		action.getScreenShot("suspendService");
	}

	@Test
	public static void restoreService() {
		String AccountNumber = "260002250000";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);
		CRServiceOrder serviceOrder = new CRServiceOrder(action);

		search.navigate();
		action.getScreenShot("restoreService");
		search.searchByAccountNumber(AccountNumber);
		action.getScreenShot("restoreService");

		service.navigate();
		action.getScreenShot("restoreService");
		service.searchByService("153725");
		action.getScreenShot("restoreService");
		service.restoreService();
		action.getScreenShot("restoreService");
		service.verifyServicesScreen();
		action.getScreenShot("restoreService");

		serviceOrder.navigate();
		action.getScreenShot("restoreService");
		serviceOrder.filterByServiceOrder(service.RaisedServiceOrder);
		action.getScreenShot("restoreService");
		assertEquals(serviceOrder.getSOCommand(), "ROS");
		action.getScreenShot("restoreService");
	}

	public static void alterServiceNumberPCL() {
		String AccountNumber = "270002280000";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);
		SalesSignOff sales = new SalesSignOff(action);
		CRServiceOrder serviceOrder = new CRServiceOrder(action);

		search.navigate();
		action.getScreenShot("alterServiceNumberPCL");
		search.searchByAccountNumber(AccountNumber);
		action.getScreenShot("alterServiceNumberPCL");

		service.navigate();
		action.getScreenShot("alterServiceNumberPCL");
		service.alterServiceNumber(false);
		action.getScreenShot("alterServiceNumberPCL");

		sales.verifySalesSignOff();
		action.getScreenShot("alterServiceNumberPCL");
		sales.signOff();
		action.getScreenShot("alterServiceNumberPCL");

		assertEquals(serviceOrder.getSOCommand(), "ASN");
		action.getScreenShot("alterServiceNumberPCL");

	}

	public static void alterServiceNumberPCLServiceCharge() {
		String AccountNumber = "270002280000";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);
		CRServiceOrder serviceOrder = new CRServiceOrder(action);

		search.navigate();
		action.getScreenShot("alterServiceNumberPCLServiceCharge");
		search.searchByAccountNumber(AccountNumber);
		action.getScreenShot("alterServiceNumberPCLServiceCharge");

		service.navigate();
		action.getScreenShot("alterServiceNumberPCLServiceCharge");
		service.alterServiceNumber(true);
		action.getScreenShot("alterServiceNumberPCLServiceCharge");
		service.raiseServiceCharge();
		action.getScreenShot("alterServiceNumberPCLServiceCharge");

		serviceOrder.navigate();
		action.getScreenShot("alterServiceNumberPCLServiceCharge");
		assertEquals(serviceOrder.getSOCommand(), "ASN");
		action.getScreenShot("alterServiceNumberPCLServiceCharge");

	}

	public static void ceaseServiceNumberPCL() {
		String AccountNumber = "280000180000";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);
		SalesSignOff sales = new SalesSignOff(action);
		CRServiceOrder serviceOrder = new CRServiceOrder(action);

		search.navigate();
		action.getScreenShot("ceaseServiceNumberPCL");
		search.searchByAccountNumber(AccountNumber);
		action.getScreenShot("ceaseServiceNumberPCL");

		service.navigate();
		action.getScreenShot("ceaseServiceNumberPCL");
		service.ceaseService();
		action.getScreenShot("ceaseServiceNumberPCL");

		sales.verifySalesSignOff();
		action.getScreenShot("alterServiceNumberPCL");
		sales.signOff();
		action.getScreenShot("alterServiceNumberPCL");

		assertEquals(serviceOrder.getSOCommand().substring(0, 3).trim(), "CCL");
		action.getScreenShot("alterServiceNumberPCL");
	}

	public static void ceaseServiceNumberPCLServiceCharge() {
		String AccountNumber = "280000080000";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);
		SalesSignOff sales = new SalesSignOff(action);
		CRServiceOrder serviceOrder = new CRServiceOrder(action);

		search.navigate();
		action.getScreenShot("ceaseServiceNumberPCL");
		search.searchByAccountNumber(AccountNumber);
		action.getScreenShot("ceaseServiceNumberPCL");

		service.navigate();
		action.getScreenShot("ceaseServiceNumberPCL");
		service.ceaseService();
		action.getScreenShot("ceaseServiceNumberPCL");

		sales.verifySalesSignOff();
		action.getScreenShot("alterServiceNumberPCL");
		sales.addServiceCharge();
		action.getScreenShot("alterServiceNumberPCL");
		sales.signOff();
		action.getScreenShot("alterServiceNumberPCL");

		assertEquals(serviceOrder.getSOCommand().substring(0, 3).trim(), "CCL");
		action.getScreenShot("alterServiceNumberPCL");
	}

	public static void verifyServiceProducts() {
		String AccountNumber = "280000080000";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);

		search.navigate();
		action.getScreenShot("verifyServiceProducts");
		search.searchByAccountNumber(AccountNumber);
		action.getScreenShot("verifyServiceProducts");

		service.navigate();
		action.getScreenShot("verifyServiceProducts");
		service.verifyProductsScreen();
		action.getScreenShot("verifyServiceProducts");
	}

	public static void provideProduct() {
		String screenShotName = "provideProduct";
		String ServiceNumber = "2581979";
		String Department = "BGSAL";
		String Site = "BUSG";
		String Command = "PCA";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);
		SalesSignOff sales = new SalesSignOff(action);

		search.navigate();
		action.getScreenShot(screenShotName);
		search.searchByServiceNumber(ServiceNumber);
		action.getScreenShot(screenShotName);

		service.navigate();
		action.getScreenShot(screenShotName);
		service.verifyProductsScreen();
		action.getScreenShot(screenShotName);
		service.provideProduct(Department, Site, Command);
		action.getScreenShot(screenShotName);

		sales.verifySalesSignOff();
		action.getScreenShot(screenShotName);
		sales.signOff();
		action.getScreenShot(screenShotName);
	}

	public static void ceaseProduct() {
		String screenShotName = "provideProduct";
		String ServiceNumber = "2581979";
		String Department = "BGSAL";
		String Site = "BUSG";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);
		SalesSignOff sales = new SalesSignOff(action);

		search.navigate();
		action.getScreenShot(screenShotName);
		search.searchByServiceNumber(ServiceNumber);
		action.getScreenShot(screenShotName);

		service.navigate();
		action.getScreenShot(screenShotName);
		service.verifyProductsScreen();
		action.getScreenShot(screenShotName);
		service.ceaseProduct(Department, Site);
		action.getScreenShot(screenShotName);

		sales.verifySalesSignOff();
		action.getScreenShot(screenShotName);
		sales.signOff();
		action.getScreenShot(screenShotName);
	}

	public static void cloneCustomer() {
		String AccountNumber = "260002270000";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRDashBoard dashboard = new CRDashBoard(action);
		CRAccountDetails accountDetails = new CRAccountDetails(action);

		search.navigate();
		action.getScreenShot("cloneCustomer");
		search.searchByAccountNumber(AccountNumber);
		action.getScreenShot("cloneCustomer");

		dashboard.verifyDashBoard(AccountNumber);
		action.getScreenShot("cloneCustomer");

		accountDetails.navigate();
		action.getScreenShot("cloneCustomer");
		accountDetails.cloneCustomer();
		action.getScreenShot("cloneCustomer");
		accountDetails.verifySuccessMessage();
		action.getScreenShot("cloneCustomer");
	}

	public static void cloneAccount() {
		String AccountNumber = "260002270000";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRDashBoard dashboard = new CRDashBoard(action);
		CRAccountDetails accountDetails = new CRAccountDetails(action);

		search.navigate();
		action.getScreenShot("cloneAccount");
		search.searchByAccountNumber(AccountNumber);
		action.getScreenShot("cloneAccount");

		dashboard.verifyDashBoard(AccountNumber);
		action.getScreenShot("cloneAccount");

		accountDetails.navigate();
		action.getScreenShot("cloneAccount");
		accountDetails.cloneAccount();
		action.getScreenShot("cloneAccount");
		accountDetails.verifySuccessMessage();
		action.getScreenShot("cloneAccount");
	}

	public static void createSubAccount() {
		String AccountNumber = "260002270000";

		CRCustomerSearch search = new CRCustomerSearch(action);
		CRDashBoard dashboard = new CRDashBoard(action);
		CRAccountDetails accountDetails = new CRAccountDetails(action);

		search.navigate();
		action.getScreenShot("createSubAccount");
		search.searchByAccountNumber(AccountNumber);
		action.getScreenShot("createSubAccount");

		dashboard.verifyDashBoard(AccountNumber);
		action.getScreenShot("createSubAccount");

		accountDetails.navigate();
		action.getScreenShot("createSubAccount");
		accountDetails.createSubAccount();
		action.getScreenShot("createSubAccount");
		accountDetails.verifySuccessMessage();
		action.getScreenShot("createSubAccount");
	}
}
