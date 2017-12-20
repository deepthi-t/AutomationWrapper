package com.liberate.automation.main;

import com.liberate.automation.testcases.CommonLogin;
import com.liberate.automation.testcases.ManageServiceOrder;

public class Main {

	public static void main(String[] args) {
		ManageServiceOrder mso = new ManageServiceOrder();

		CommonLogin.navigateToURL();
		mso.cancelServiceOrder();
	}
}