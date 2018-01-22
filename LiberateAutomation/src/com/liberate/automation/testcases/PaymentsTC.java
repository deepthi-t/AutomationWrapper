package com.liberate.automation.testcases;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.BrowseServiceOrder;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.CRDepositRequirement;
import com.liberate.automation.pom.PYBatchPayment;
import com.liberate.automation.pom.PYPOSPayment;
import com.liberate.automation.pom.PYSinglePayment;

public class PaymentsTC {
	static TestActions action = CommonLogin.action;

	@Test(priority = 3)
	public void batchPayment() {
		ArrayList<String> accountNumber = new ArrayList<String>();

		accountNumber.add("260002230000");
		accountNumber.add("260002260000");
		accountNumber.add("260002270000");

		PYBatchPayment bp = new PYBatchPayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);

		bso.navigate();
		action.getScreenShot("batchPayment");
		bso.selectDepartment("CASH4");
		action.getScreenShot("batchPayment");
		
		bp.navigate();
		action.getScreenShot("batchPayment");
		bp.providePaymentDetails(accountNumber);
		action.getScreenShot("batchPayment");
	}

	@Test(priority = 1)
	public void verifyCashDrawer() {
		PYSinglePayment sp = new PYSinglePayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);
		
		bso.navigate();
		action.getScreenShot("verifyCashDrawer");
		bso.selectDepartment("CASH6");
		action.getScreenShot("verifyCashDrawer");
		
		sp.navigate();
		action.getScreenShot("verifyCashDrawer");
		sp.verifyCashDrawer();
		action.getScreenShot("verifyCashDrawer");
	}

	@Test(priority = 2)
	public void singlePaymentAccountNumber() {
		PYSinglePayment sp = new PYSinglePayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);

		bso.navigate();
		action.getScreenShot("singlePaymentAccountNumber");
		bso.selectDepartment("CASH4");
		action.getScreenShot("singlePaymentAccountNumber");

		sp.navigate();
		action.getScreenShot("singlePaymentAccountNumber");
		sp.searchWithAccountNumber("260002230000");
		action.getScreenShot("singlePaymentAccountNumber");
		sp.doSinglePayment("10.00");
		action.getScreenShot("singlePaymentAccountNumber");
		sp.verifySuccessMessage();
		action.getScreenShot("singlePaymentAccountNumber");
	}

	@Test(enabled = false)
	public void depositPaymentAccountNumber() {
		PYSinglePayment sp = new PYSinglePayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);

		bso.navigate();
		action.getScreenShot("depositPaymentAccountNumber");
		bso.selectDepartment("CASH4");
		action.getScreenShot("depositPaymentAccountNumber");

		sp.navigate();
		action.getScreenShot("depositPaymentAccountNumber");
		sp.searchWithAccountNumber("260002230000");
		action.getScreenShot("depositPaymentAccountNumber");
		sp.doDepositPayment("10.00");
		action.getScreenShot("depositPaymentAccountNumber");
		sp.verifySuccessMessage();
		action.getScreenShot("depositPaymentAccountNumber");
	}

	@Test(priority = 3)
	public void singlePaymentServicetNumber() {
		PYSinglePayment sp = new PYSinglePayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);

		bso.navigate();
		action.getScreenShot("singlePaymentServicetNumber");
		bso.selectDepartment("CASH4");
		action.getScreenShot("singlePaymentServicetNumber");

		sp.navigate();
		action.getScreenShot("singlePaymentServicetNumber");
		sp.searchWithServiceNumber("4747623");
		action.getScreenShot("singlePaymentServicetNumber");
		sp.doSinglePayment("10.00");
		action.getScreenShot("singlePaymentServicetNumber");
		sp.verifySuccessMessage();
		action.getScreenShot("singlePaymentServicetNumber");
	}

	@Test(enabled = false)
	public void depositPaymentServiceNumber() {
		PYSinglePayment sp = new PYSinglePayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);

		bso.navigate();
		action.getScreenShot("depositPaymentServiceNumber");
		bso.selectDepartment("CASH4");
		action.getScreenShot("depositPaymentServiceNumber");

		sp.navigate();
		action.getScreenShot("depositPaymentServiceNumber");
		sp.searchWithServiceNumber("556166");
		action.getScreenShot("depositPaymentServiceNumber");
		sp.doDepositPayment("10.00");
		action.getScreenShot("depositPaymentServiceNumber");
		sp.verifySuccessMessage();
		action.getScreenShot("depositPaymentServiceNumber");
	}

	@Test(priority = 4)
	public void payAndRefundDeposit() {
		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRDepositRequirement cd = new CRDepositRequirement(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);
		PYSinglePayment sp = new PYSinglePayment(action);

		cr.navigate();
		action.getScreenShot("payAndRefundDeposit");
		cr.searchByAccountNumber("260002280000");
		action.getScreenShot("payAndRefundDeposit");

		cd.navigate();
		action.getScreenShot("payAndRefundDeposit");
		cd.verifyDepositRequirement();
		action.getScreenShot("payAndRefundDeposit");
		cd.addNewDepositRequirement("10.00");
		action.getScreenShot("payAndRefundDeposit");
		cd.verifyDepositRequirement();
		action.getScreenShot("payAndRefundDeposit");

		bso.navigate();
		action.getScreenShot("payAndRefundDeposit");
		bso.selectDepartment("CASH4");
		action.getScreenShot("payAndRefundDeposit");

		sp.navigate();
		action.getScreenShot("payAndRefundDeposit");
		sp.searchWithAccountNumber("260002280000");
		action.getScreenShot("payAndRefundDeposit");
		sp.doDepositPayment("10.00");
		action.getScreenShot("payAndRefundDeposit");
		sp.verifySuccessMessage();
		action.getScreenShot("payAndRefundDeposit");

		cr.navigate();
		action.getScreenShot("payAndRefundDeposit");
		cr.searchByAccountNumber("260002280000");
		action.getScreenShot("payAndRefundDeposit");


		cd.navigate();
		action.getScreenShot("payAndRefundDeposit");
		cd.verifyDepositRequirement();
		action.getScreenShot("payAndRefundDeposit");
		cd.refundDeposit("10.00");
		action.getScreenShot("payAndRefundDeposit");
	}

	@Test
	public void depostitPaymentPOS()
	{
		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRDepositRequirement cd = new CRDepositRequirement(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);
		PYPOSPayment pos = new PYPOSPayment(action);
		
		cr.navigate();
		action.getScreenShot("depostitPaymentPOS");
		cr.searchByAccountNumber("260002280000");
		action.getScreenShot("depostitPaymentPOS");

		cd.navigate();
		action.getScreenShot("depostitPaymentPOS");
		cd.verifyDepositRequirement();
		action.getScreenShot("depostitPaymentPOS");
		cd.addNewDepositRequirement("10.00");
		action.getScreenShot("depostitPaymentPOS");
		cd.verifyDepositRequirement();
		action.getScreenShot("depostitPaymentPOS");
		
		bso.navigate();
		action.getScreenShot("depostitPaymentPOS");
		bso.selectDepartment("CASH2");
		action.getScreenShot("depostitPaymentPOS");
		
		pos.navigate();
		action.getScreenShot("depostitPaymentPOS");
		pos.navigateToPOS();
		action.getScreenShot("depostitPaymentPOS");
		
		pos.closePOSWindow();
		action.getScreenShot("depostitPaymentPOS");
	}
	
	@Test
	public void paymentPOS()
	{
		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRDepositRequirement cd = new CRDepositRequirement(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);
		PYPOSPayment pos = new PYPOSPayment(action);
		
		bso.navigate();
		action.getScreenShot("depostitPaymentPOS");
		bso.selectDepartment("CASH");
		action.getScreenShot("depostitPaymentPOS");
		
		pos.navigate();
		action.getScreenShot("depostitPaymentPOS");
		pos.navigateToPOS();
		action.getScreenShot("depostitPaymentPOS");
		pos.searchWithAccountNumber("260002270000");
		action.getScreenShot("depostitPaymentPOS");
		pos.POSPayment();
		action.getScreenShot("depostitPaymentPOS");
		
//		pos.closePOSWindow();
//		action.getScreenShot("depostitPaymentPOS");
	}
}
