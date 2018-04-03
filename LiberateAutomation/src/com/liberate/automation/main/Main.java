package com.liberate.automation.main;

import com.liberate.automation.testcases.AlterServiceTestCase;
import com.liberate.automation.testcases.CommonLogin;

public class Main {

	public static void main(String[] args) {
		CommonLogin.navigateToURL();
		AlterServiceTestCase.loadData();
		AlterServiceTestCase.alterSIMCard();
	}
}