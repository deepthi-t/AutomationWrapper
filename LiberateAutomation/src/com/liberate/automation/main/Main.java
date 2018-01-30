package com.liberate.automation.main;

import com.liberate.automation.testcases.CommonLogin;
import com.liberate.automation.testcases.CreditControlTC;

public class Main {

	public static void main(String[] args) {
		CreditControlTC testCase = new CreditControlTC();

		CommonLogin.navigateToURL();
		testCase.serviceTOSVerifyAudit();
//		CommonLogin.endTesting();
	}
}