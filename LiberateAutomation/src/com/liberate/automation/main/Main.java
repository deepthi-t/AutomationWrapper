package com.liberate.automation.main;

import com.liberate.automation.testcases.CommonLogin;
import com.liberate.automation.testcases.QueryManagement;

public class Main {

	public static void main(String[] args) {
		QueryManagement bso = new QueryManagement();

		CommonLogin.navigateToURL();
		bso.raiseQueryAccount();
		CommonLogin.endTesting();
	}
}