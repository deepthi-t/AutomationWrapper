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
		InterimBillGeneration bill = new InterimBillGeneration(action);

		bill.navigate();
		action.getScreenShot("generateInterimBill");
		bill.searchWithCustomerAccount("260002260000");
		action.getScreenShot("generateInterimBill");
		bill.createInterimBill();
		action.getScreenShot("generateInterimBill");
	}

	@Test
	public static void transferService() {
		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);

		search.navigate();
		action.getScreenShot("transferService");
		search.searchByAccountNumber("260002290000");
		action.getScreenShot("transferService");

		service.navigate();
		action.getScreenShot("transferService");
		service.verifyServicesScreen();
		action.getScreenShot("transferService");
		service.transferService("260002270000");
		action.getScreenShot("transferService");

		service.verifyTransferService("260002270000");
		action.getScreenShot("transferService");
	}

	@Test
	public static void suspendService() {
		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);
		CRServiceOrder cso = new CRServiceOrder(action);

		search.navigate();
		action.getScreenShot("suspendService");
		search.searchByAccountNumber("260002250000");
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
		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);
		CRServiceOrder serviceOrder = new CRServiceOrder(action);

		search.navigate();
		action.getScreenShot("restoreService");
		search.searchByAccountNumber("260002250000");
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
		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);
		SalesSignOff sales = new SalesSignOff(action);
		CRServiceOrder serviceOrder = new CRServiceOrder(action);

		search.navigate();
		action.getScreenShot("alterServiceNumberPCL");
		search.searchByAccountNumber("270002280000");
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
		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);
		CRServiceOrder serviceOrder = new CRServiceOrder(action);

		search.navigate();
		action.getScreenShot("alterServiceNumberPCLServiceCharge");
		search.searchByAccountNumber("270002280000");
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
		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);
		SalesSignOff sales = new SalesSignOff(action);
		CRServiceOrder serviceOrder = new CRServiceOrder(action);

		search.navigate();
		action.getScreenShot("ceaseServiceNumberPCL");
		search.searchByAccountNumber("280000180000");
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
		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);
		SalesSignOff sales = new SalesSignOff(action);
		CRServiceOrder serviceOrder = new CRServiceOrder(action);

		search.navigate();
		action.getScreenShot("ceaseServiceNumberPCL");
		search.searchByAccountNumber("280000080000");
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
		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations service = new CRServiceOperations(action);

		search.navigate();
		action.getScreenShot("verifyServiceProducts");
		search.searchByAccountNumber("280000080000");
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
		CRCustomerSearch search = new CRCustomerSearch(action);
		CRDashBoard dashboard = new CRDashBoard(action);
		CRAccountDetails accountDetails = new CRAccountDetails(action);
		
		search.navigate();
		action.getScreenShot("cloneCustomer");
		search.searchByAccountNumber("260002270000");
		action.getScreenShot("cloneCustomer");
		
		dashboard.verifyDashBoard("260002270000");
		action.getScreenShot("cloneCustomer");

		accountDetails.navigate();
		action.getScreenShot("cloneCustomer");
		accountDetails.cloneCustomer();
		action.getScreenShot("cloneCustomer");
		accountDetails.verifySuccessMessage();
		action.getScreenShot("cloneCustomer");
	}
	
	public static void cloneAccount() {
		CRCustomerSearch search = new CRCustomerSearch(action);
		CRDashBoard dashboard = new CRDashBoard(action);
		CRAccountDetails accountDetails = new CRAccountDetails(action);
		
		search.navigate();
		action.getScreenShot("cloneAccount");
		search.searchByAccountNumber("260002270000");
		action.getScreenShot("cloneAccount");
		
		dashboard.verifyDashBoard("260002270000");
		action.getScreenShot("cloneAccount");

		accountDetails.navigate();
		action.getScreenShot("cloneAccount");
		accountDetails.cloneAccount();
		action.getScreenShot("cloneAccount");
		accountDetails.verifySuccessMessage();
		action.getScreenShot("cloneAccount");
	}
	
	public static void createSubAccount() {
		CRCustomerSearch search = new CRCustomerSearch(action);
		CRDashBoard dashboard = new CRDashBoard(action);
		CRAccountDetails accountDetails = new CRAccountDetails(action);
		
		search.navigate();
		action.getScreenShot("createSubAccount");
		search.searchByAccountNumber("260002270000");
		action.getScreenShot("createSubAccount");
		
		dashboard.verifyDashBoard("260002270000");
		action.getScreenShot("createSubAccount");

		accountDetails.navigate();
		action.getScreenShot("createSubAccount");
		accountDetails.createSubAccount();
		action.getScreenShot("createSubAccount");
		accountDetails.verifySuccessMessage();
		action.getScreenShot("createSubAccount");
	}
}
