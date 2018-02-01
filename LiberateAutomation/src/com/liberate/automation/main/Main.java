package com.liberate.automation.main;

import com.liberate.automation.testcases.CommonLogin;
import com.liberate.automation.testcases.CustomerEnquiryTC;

public class Main {

	public static void main(String[] args) {
//		while (true) {
			CommonLogin.navigateToURL();
			CustomerEnquiryTC.verifyCustomerEnquiry();
//			CommonLogin.endTesting();
//		}
	}
}