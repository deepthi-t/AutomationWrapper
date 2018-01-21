package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.CRServiceOperations;
import com.liberate.automation.pom.CRServiceOrder;
import com.liberate.automation.pom.InterimBillGeneration;

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
		CRServiceOrder cso = new CRServiceOrder(action);

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

		cso.navigate();
		action.getScreenShot("restoreService");
		cso.filterByServiceOrder(cs.RaisedServiceOrder);
		action.getScreenShot("restoreService");
		assertEquals(cso.getSOCommand(), "ROS");
		action.getScreenShot("restoreService");
	}
}