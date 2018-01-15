package com.liberate.automation.testcases;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.BatchPayment;

public class PaymentsTC {
	static TestActions action = CommonLogin.action;
	
	@Test
	public void batchPayment()
	{
		ArrayList<String> accountNumber = new ArrayList<String>();
		
		accountNumber.add("260002230000");
		accountNumber.add("260002260000");
		accountNumber.add("260002270000");

		BatchPayment bp = new BatchPayment(action);

		bp.navigate();
		bp.providePaymentDetails(accountNumber);
	}
}
