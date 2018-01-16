package com.liberate.automation.testcases;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.BrowseServiceOrder;
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

	public void verifyCashDrawer() {
		PYSinglePayment sp = new PYSinglePayment(action);

		sp.navigate();
		action.getScreenShot("verifyCashDrawer");
		sp.verifyCashDrawer();
		action.getScreenShot("verifyCashDrawer");
	}

	public void singlePaymentAccountNumber() {
		PYSinglePayment sp = new PYSinglePayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);
		
		bso.navigate();
		bso.selectDepartment("CASH");
		
		sp.navigate();
		sp.searchWithAccountNumber("260002230000");
		sp.doSinglePayment("10.00");
		sp.verifySuccessMessage();
	}

	public void depositPaymentAccountNumber() {
		PYSinglePayment sp = new PYSinglePayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);
		
		bso.navigate();
		bso.selectDepartment("CASH");
		
		sp.navigate();
		sp.searchWithAccountNumber("260002230000");
		sp.doDepositPayment("10.00");
		sp.verifySuccessMessage();
	}
	
	public void singlePaymentServicetNumber() {
		PYSinglePayment sp = new PYSinglePayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);
		
		bso.navigate();
		bso.selectDepartment("CASH");
		
		sp.navigate();
		sp.searchWithServiceNumber("556166");
		sp.doSinglePayment("10.00");
		sp.verifySuccessMessage();
	}

	public void depositPaymentServiceNumber() {
		PYSinglePayment sp = new PYSinglePayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);
		
		bso.navigate();
		bso.selectDepartment("CASH");
		
		sp.navigate();
		sp.searchWithServiceNumber("556166");
		sp.doDepositPayment("10.00");
		sp.verifySuccessMessage();
	}
}
