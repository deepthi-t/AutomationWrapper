package com.liberate.automation.testcases;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.BrowseServiceOrder;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.CRDepositRequirement;
import com.liberate.automation.pom.PYBatchPayment;
import com.liberate.automation.pom.PYSinglePayment;

public class PaymentsTC {
	static TestActions action = CommonLogin.action;

	@Test
	public void batchPayment() {
		ArrayList<String> accountNumber = new ArrayList<String>();

		accountNumber.add("260002230000");
		accountNumber.add("260002260000");
		accountNumber.add("260002270000");

		PYBatchPayment bp = new PYBatchPayment(action);

		bp.navigate();
		action.getScreenShot("batchPayment");
		bp.providePaymentDetails(accountNumber);
		action.getScreenShot("batchPayment");
	}

	@Test
	public void verifyCashDrawer() {
		PYSinglePayment sp = new PYSinglePayment(action);

		sp.navigate();
		action.getScreenShot("verifyCashDrawer");
		sp.verifyCashDrawer();
		action.getScreenShot("verifyCashDrawer");
	}

	@Test
	public void singlePaymentAccountNumber() {
		PYSinglePayment sp = new PYSinglePayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);

		bso.navigate();
		action.getScreenShot("singlePaymentAccountNumber");
		bso.selectDepartment("CASH");
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

	@Test
	public void depositPaymentAccountNumber() {
		PYSinglePayment sp = new PYSinglePayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);

		bso.navigate();
		action.getScreenShot("depositPaymentAccountNumber");
		bso.selectDepartment("CASH");
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

	@Test
	public void singlePaymentServicetNumber() {
		PYSinglePayment sp = new PYSinglePayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);

		bso.navigate();
		action.getScreenShot("singlePaymentServicetNumber");
		bso.selectDepartment("CASH");
		action.getScreenShot("singlePaymentServicetNumber");

		sp.navigate();
		action.getScreenShot("singlePaymentServicetNumber");
		sp.searchWithServiceNumber("556166");
		action.getScreenShot("singlePaymentServicetNumber");
		sp.doSinglePayment("10.00");
		action.getScreenShot("singlePaymentServicetNumber");
		sp.verifySuccessMessage();
		action.getScreenShot("singlePaymentServicetNumber");
	}

	@Test
	public void depositPaymentServiceNumber() {
		PYSinglePayment sp = new PYSinglePayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);

		bso.navigate();
		action.getScreenShot("depositPaymentServiceNumber");
		bso.selectDepartment("CASH");
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

	@Test
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
		bso.selectDepartment("CASH1");
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
}
