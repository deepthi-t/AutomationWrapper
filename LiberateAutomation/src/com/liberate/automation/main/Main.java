package com.liberate.automation.main;

import com.liberate.automation.testcases.BulkSOProcessing;
import com.liberate.automation.testcases.CommonLogin;

public class Main {

	public static void main(String[] args) {
		BulkSOProcessing bso = new BulkSOProcessing();

		CommonLogin.navigateToURL();
		bso.bulkAccountSignOff();
		CommonLogin.endTesting();
	}
}