package com.liberate.automation.main;

import com.liberate.automation.testcases.CommonLogin;
import com.liberate.automation.testcases.ServiceProvisioningTC;

public class Main {

	public static void main(String[] args) {
		ServiceProvisioningTC bso = new ServiceProvisioningTC();

		CommonLogin.navigateToURL();
		bso.newCustomerPEL();
//		CommonLogin.endTesting();
	}
}