package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.CRServiceOperations;
import com.liberate.automation.pom.CRServiceOrder;
import com.liberate.automation.pom.InterimBillGeneration;
import com.liberate.automation.pom.SalesSignOff;

public class CustomerCareTC {
	static TestActions action = CommonLogin.action;

	@Test
	public void generateInterimBill() {
		InterimBillGeneration ir = new InterimBillGeneration(action);

		ir.navigate();
		action.getScreenShot("generateInterimBill");
		ir.searchWithCustomerAccount("260002260000");
		action.getScreenShot("generateInterimBill");
		ir.createInterimBill();
		action.getScreenShot("generateInterimBill");
	}

	@Test
	public void transferService() {
		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRServiceOperations sc = new CRServiceOperations(action);

		cr.navigate();
		action.getScreenShot("transferService");
		cr.searchByAccountNumber("260002290000");
		action.getScreenShot("transferService");

		sc.navigate();
		action.getScreenShot("transferService");
		sc.verifyServicesScreen();
		action.getScreenShot("transferService");
		sc.transferService("260002270000");
		action.getScreenShot("transferService");

		sc.verifyTransferService("260002270000");
		action.getScreenShot("transferService");
	}

	@Test
	public void suspendService() {
		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRServiceOperations cs = new CRServiceOperations(action);
		CRServiceOrder cso = new CRServiceOrder(action);

		cr.navigate();
		action.getScreenShot("suspendService");
		cr.searchByAccountNumber("260002250000");
		action.getScreenShot("suspendService");

		cs.navigate();
		action.getScreenShot("suspendService");
		cs.suspendService();
		action.getScreenShot("suspendService");
		cs.verifyServicesScreen();
		action.getScreenShot("suspendService");

		cso.navigate();
		action.getScreenShot("suspendService");
		cso.filterByServiceOrder(cs.RaisedServiceOrder);
		action.getScreenShot("suspendService");
		assertEquals(cso.getSOCommand(), "TOS");
		action.getScreenShot("suspendService");
	}

	@Test
	public void restoreService() {
		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRServiceOperations cs = new CRServiceOperations(action);
		CRServiceOrder serviceOrder = new CRServiceOrder(action);

		cr.navigate();
		action.getScreenShot("restoreService");
		cr.searchByAccountNumber("260002250000");
		action.getScreenShot("restoreService");

		cs.navigate();
		action.getScreenShot("restoreService");
		cs.searchByService("153725");
		action.getScreenShot("restoreService");
		cs.restoreService();
		action.getScreenShot("restoreService");
		cs.verifyServicesScreen();
		action.getScreenShot("restoreService");

		serviceOrder.navigate();
		action.getScreenShot("restoreService");
		serviceOrder.filterByServiceOrder(cs.RaisedServiceOrder);
		action.getScreenShot("restoreService");
		assertEquals(serviceOrder.getSOCommand(), "ROS");
		action.getScreenShot("restoreService");
	}

	public void alterServiceNumberPCL()
	{
		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRServiceOperations cs = new CRServiceOperations(action);
		SalesSignOff sales = new SalesSignOff(action);
		CRServiceOrder serviceOrder = new CRServiceOrder(action);
		
		cr.navigate();
		action.getScreenShot("alterServiceNumberPCL");
		cr.searchByAccountNumber("270002280000");
		action.getScreenShot("alterServiceNumberPCL");
		
		cs.navigate();
		action.getScreenShot("alterServiceNumberPCL");
		cs.alterServiceNumber(false);
		action.getScreenShot("alterServiceNumberPCL");
		
		sales.verifySalesSignOff();
		action.getScreenShot("alterServiceNumberPCL");
		sales.signOff();
		action.getScreenShot("alterServiceNumberPCL");
		
		assertEquals(serviceOrder.getSOCommand(), "ASN");
		action.getScreenShot("alterServiceNumberPCL");

	}
	
	public void alterServiceNumberPCLServiceCharge()
	{
		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRServiceOperations cs = new CRServiceOperations(action);
		CRServiceOrder serviceOrder = new CRServiceOrder(action);
		
		cr.navigate();
		action.getScreenShot("alterServiceNumberPCLServiceCharge");
		cr.searchByAccountNumber("270002280000");
		action.getScreenShot("alterServiceNumberPCLServiceCharge");
		
		cs.navigate();
		action.getScreenShot("alterServiceNumberPCLServiceCharge");
		cs.alterServiceNumber(true);
		action.getScreenShot("alterServiceNumberPCLServiceCharge");
		cs.raiseServiceCharge();
		action.getScreenShot("alterServiceNumberPCLServiceCharge");
		
		serviceOrder.navigate();
		action.getScreenShot("alterServiceNumberPCLServiceCharge");
		assertEquals(serviceOrder.getSOCommand(), "ASN");
		action.getScreenShot("alterServiceNumberPCLServiceCharge");

	}
	
	public void ceaseServiceNumberPCL()
	{
		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRServiceOperations cs = new CRServiceOperations(action);
		SalesSignOff sales = new SalesSignOff(action);
		CRServiceOrder serviceOrder = new CRServiceOrder(action);
		
		cr.navigate();
		action.getScreenShot("ceaseServiceNumberPCL");
		cr.searchByAccountNumber("280000180000");
		action.getScreenShot("ceaseServiceNumberPCL");
		
		cs.navigate();
		action.getScreenShot("ceaseServiceNumberPCL");
		cs.ceaseService();
		action.getScreenShot("ceaseServiceNumberPCL");

		sales.verifySalesSignOff();
		action.getScreenShot("alterServiceNumberPCL");
		sales.signOff();
		action.getScreenShot("alterServiceNumberPCL");
		
		assertEquals(serviceOrder.getSOCommand().substring(0, 3).trim(), "CCL");
		action.getScreenShot("alterServiceNumberPCL");
	}
	
	public void ceaseServiceNumberPCLServiceCharge()
	{
		CRCustomerSearch search = new CRCustomerSearch(action);
		CRServiceOperations cs = new CRServiceOperations(action);
		SalesSignOff sales = new SalesSignOff(action);
		CRServiceOrder serviceOrder = new CRServiceOrder(action);
		
		search.navigate();
		action.getScreenShot("ceaseServiceNumberPCL");
		search.searchByAccountNumber("280000080000");
		action.getScreenShot("ceaseServiceNumberPCL");
		
		cs.navigate();
		action.getScreenShot("ceaseServiceNumberPCL");
		cs.ceaseService();
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
	
	public void verifyServiceProducts()
	{
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
}
