package com.liberate.automation.main;

import com.liberate.automation.testcases.CommonLogin;
import com.liberate.automation.testcases.PaymentsTC;

public class Main {

	public static void main(String[] args) {
		PaymentsTC bso = new PaymentsTC();

		CommonLogin.navigateToURL();
		bso.paymentPOS();
//		CommonLogin.endTesting();
	}
}