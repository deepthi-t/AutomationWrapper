package com.liberate.automation.testcases;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.PYBatchPayment;

public class PaymentsTC {
	static TestActions action = CommonLogin.action;
	
	@Test
	public void batchPayment()
	{
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
}
