package com.liberate.automation.main;

import com.liberate.automation.testcases.CommonLogin;
import com.liberate.automation.testcases.LimeLiteProvisioningTC;
import com.liberate.automation.testcases.QueryManagementTC;
import com.liberate.automation.testcases.SanityTestCases;
import com.liberate.automation.testcases.ServiceProvisioningTC;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		CommonLogin.login();
		SanityTestCases.newCustomerPCLPostpaid();
		SanityTestCases.assignFault();
		SanityTestCases.ceaseServiceNumberPCL();

	}

	public void test() {

	}
}