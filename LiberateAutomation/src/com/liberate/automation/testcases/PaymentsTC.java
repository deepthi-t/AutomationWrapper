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
	public static void batchPayment() {
		String TestCase = "PaymentsTC_batchPayment";

		ArrayList<String> accountNumber = new ArrayList<String>();

		accountNumber.add("260002230000");
		accountNumber.add("260002260000");
		accountNumber.add("260002270000");

		PYBatchPayment bp = new PYBatchPayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);

		bso.navigate();
		action.getScreenShot(TestCase);
		bso.selectDepartment("CASH4");
		action.getScreenShot(TestCase);

		bp.navigate();
		action.getScreenShot(TestCase);
		bp.providePaymentDetails(accountNumber);
		action.getScreenShot(TestCase);
	}

	@Test(priority = 1)
	public static void verifyCashDrawer() {
		String TestCase = "PaymentsTC_verifyCashDrawer";

		PYSinglePayment sp = new PYSinglePayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);

		bso.navigate();
		action.getScreenShot(TestCase);
		bso.selectDepartment("CASH6");
		action.getScreenShot(TestCase);

		sp.navigate();
		action.getScreenShot(TestCase);
		sp.verifyCashDrawer();
		action.getScreenShot(TestCase);
	}

	@Test(priority = 2)
	public static void singlePaymentAccountNumber() {
		String TestCase = "PaymentsTC_singlePaymentAccountNumber";

		PYSinglePayment sp = new PYSinglePayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);

		bso.navigate();
		action.getScreenShot(TestCase);
		bso.selectDepartment("CASH4");
		action.getScreenShot(TestCase);

		sp.navigate();
		action.getScreenShot(TestCase);
		sp.searchWithAccountNumber("260002230000");
		action.getScreenShot(TestCase);
		sp.doSinglePayment("10.00");
		action.getScreenShot(TestCase);
		sp.verifySuccessMessage();
		action.getScreenShot(TestCase);
	}

	@Test(enabled = false)
	public static void depositPaymentAccountNumber() {
		String TestCase = "PaymentsTC_depositPaymentAccountNumber";

		PYSinglePayment sp = new PYSinglePayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);

		bso.navigate();
		action.getScreenShot(TestCase);
		bso.selectDepartment("CASH4");
		action.getScreenShot(TestCase);

		sp.navigate();
		action.getScreenShot(TestCase);
		sp.searchWithAccountNumber("260002230000");
		action.getScreenShot(TestCase);
		sp.doDepositPayment("10.00");
		action.getScreenShot(TestCase);
		sp.verifySuccessMessage();
		action.getScreenShot(TestCase);
	}

	@Test(priority = 3)
	public static void singlePaymentServicetNumber() {
		String TestCase = "PaymentsTC_singlePaymentServicetNumber";

		PYSinglePayment sp = new PYSinglePayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);

		bso.navigate();
		action.getScreenShot(TestCase);
		bso.selectDepartment("CASH4");
		action.getScreenShot(TestCase);

		sp.navigate();
		action.getScreenShot(TestCase);
		sp.searchWithServiceNumber("4747623");
		action.getScreenShot(TestCase);
		sp.doSinglePayment("10.00");
		action.getScreenShot(TestCase);
		sp.verifySuccessMessage();
		action.getScreenShot(TestCase);
	}

	@Test(enabled = false)
	public static void depositPaymentServiceNumber() {
		String TestCase = "PaymentsTC_depositPaymentServiceNumber";

		PYSinglePayment sp = new PYSinglePayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);

		bso.navigate();
		action.getScreenShot(TestCase);
		bso.selectDepartment("CASH4");
		action.getScreenShot(TestCase);

		sp.navigate();
		action.getScreenShot(TestCase);
		sp.searchWithServiceNumber("556166");
		action.getScreenShot(TestCase);
		sp.doDepositPayment("10.00");
		action.getScreenShot(TestCase);
		sp.verifySuccessMessage();
		action.getScreenShot(TestCase);
	}

	@Test(priority = 4)
	public static void payAndRefundDeposit() {
		String TestCase = "PaymentsTC_payAndRefundDeposit";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRDepositRequirement cd = new CRDepositRequirement(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);
		PYSinglePayment sp = new PYSinglePayment(action);

		cr.navigate();
		action.getScreenShot(TestCase);
		cr.searchByAccountNumber("260002280000");
		action.getScreenShot(TestCase);

		cd.navigate();
		action.getScreenShot(TestCase);
		cd.verifyDepositRequirement();
		action.getScreenShot(TestCase);
		cd.addNewDepositRequirement("10.00");
		action.getScreenShot(TestCase);
		cd.verifyDepositRequirement();
		action.getScreenShot(TestCase);

		bso.navigate();
		action.getScreenShot(TestCase);
		bso.selectDepartment("CASH4");
		action.getScreenShot(TestCase);

		sp.navigate();
		action.getScreenShot(TestCase);
		sp.searchWithAccountNumber("260002280000");
		action.getScreenShot(TestCase);
		sp.doDepositPayment("10.00");
		action.getScreenShot(TestCase);
		sp.verifySuccessMessage();
		action.getScreenShot(TestCase);

		cr.navigate();
		action.getScreenShot(TestCase);
		cr.searchByAccountNumber("260002280000");
		action.getScreenShot(TestCase);

		cd.navigate();
		action.getScreenShot(TestCase);
		cd.verifyDepositRequirement();
		action.getScreenShot(TestCase);
		cd.refundDeposit("10.00");
		action.getScreenShot(TestCase);
	}

	@Test
	public static void depostitPaymentPOS() {
		String TestCase = "PaymentsTC_depostitPaymentPOS";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRDepositRequirement cd = new CRDepositRequirement(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);
		PYPOSPayment pos = new PYPOSPayment(action);

		cr.navigate();
		action.getScreenShot(TestCase);
		cr.searchByAccountNumber("260002280000");
		action.getScreenShot(TestCase);

		cd.navigate();
		action.getScreenShot(TestCase);
		cd.verifyDepositRequirement();
		action.getScreenShot(TestCase);
		cd.addNewDepositRequirement("10.00");
		action.getScreenShot(TestCase);
		cd.verifyDepositRequirement();
		action.getScreenShot(TestCase);

		bso.navigate();
		action.getScreenShot(TestCase);
		bso.selectDepartment("CASH2");
		action.getScreenShot(TestCase);

		pos.navigate();
		action.getScreenShot(TestCase);
		pos.navigateToPOS();
		action.getScreenShot(TestCase);

		pos.closePOSWindow();
		action.getScreenShot(TestCase);
	}

	@Test
	public static void paymentPOS() {
		String TestCase = "PaymentsTC_paymentPOS";

		BrowseServiceOrder bso = new BrowseServiceOrder(action);
		PYPOSPayment pos = new PYPOSPayment(action);

		bso.navigate();
		action.getScreenShot(TestCase);
		bso.selectDepartment("CASH");
		action.getScreenShot(TestCase);

		pos.navigate();
		action.getScreenShot(TestCase);
		pos.navigateToPOS();
		action.getScreenShot(TestCase);
		pos.searchWithAccountNumber("260002270000");
		action.getScreenShot(TestCase);
		pos.POSPayment();
		action.getScreenShot(TestCase);

		// pos.closePOSWindow();
		// action.getScreenShot(TestCase);
	}
}
