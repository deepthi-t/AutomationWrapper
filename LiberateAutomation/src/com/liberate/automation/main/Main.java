package com.liberate.automation.main;

import com.liberate.automation.testcases.CommonLogin;
import com.liberate.automation.testcases.LimeLiteProvisioningTC;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		CommonLogin.login();

		// ExchangeSignoffTC.exchangesignoff();
		LimeLiteProvisioningTC.limeLiteExistingCustomerPCLPostpaid();

	}

	public void test() {

	}
}